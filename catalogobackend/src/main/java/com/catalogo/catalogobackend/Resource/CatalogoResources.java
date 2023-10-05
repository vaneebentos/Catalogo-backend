package com.catalogo.catalogobackend.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.catalogo.catalogobackend.models.Catalogo;
import com.catalogo.catalogobackend.service.CatalogoService;

import org.springframework.util.StringUtils;

@RestController
@RequestMapping("/api/v1")

public class CatalogoResources {
    private final CatalogoService catalogoService;

    public CatalogoResources(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;

    }

    /*
     * @Value("${image.upload.dir}")
     * private String uploadDir;
     */
    @GetMapping("/catalogos")
    public ResponseEntity<List<Catalogo>> getAllCatalogos() {
        List<Catalogo> catalogos = catalogoService.findALLCatalogo();
        return new ResponseEntity<>(catalogos, HttpStatus.OK);
    }

    @GetMapping("/catalogos/{grupo}")
    public ResponseEntity<List<Catalogo>> getCatalogosByGrupo(@PathVariable("grupo") String grupo) {
        List<Catalogo> catalogos = catalogoService.findALLCatalogo();
        List<Catalogo> catalogosResult = catalogos.stream()
                .filter(catalogo -> catalogo.getGrupo().contains(grupo))
                .collect(Collectors.toList());

        if (catalogosResult.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(catalogosResult, HttpStatus.OK);
    }

    @GetMapping("/{id}/imagen")
    public ResponseEntity<String> obtenerUrlImagen(@PathVariable Long id) {
        String imagenUrl = catalogoService.obtenerUrlImagen(id);
        return ResponseEntity.ok(imagenUrl);
    }

    @PostMapping("/add")
    public ResponseEntity<Catalogo> addCatalogo(@RequestBody Catalogo catalogo) {
        Catalogo newCatalogo = catalogoService.addCatalogo(catalogo);
        return new ResponseEntity<>(newCatalogo, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<List<Catalogo>> updateCatalogo(@RequestBody Catalogo[] catalogos) {
        for (Catalogo catalogo : catalogos) {
            catalogoService.updateCatalogo(catalogo);
        }
        return new ResponseEntity<>(catalogoService.findALLCatalogo(), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCatalogo(@PathVariable("id") Long id) {
        catalogoService.deleteCatalogo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    String uploadDir = "C:\\Users\\usuario\\OneDrive - frvt.utn.edu.ar\\Escritorio\\Documentos\\GIT\\PPES\\Catalogo-backend\\catalogobackend\\src\\imagen"; // carpeta donde se almacenan las imágenes

    @GetMapping("/catalogos/imagen/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {

        // Define la ruta completa de la imagen en tu sistema de archivos
        Path imagePath = Paths.get(uploadDir, imageName);
        // Verifica si el archivo existe
        if (Files.exists(imagePath)) {
            try {
                // Carga el archivo en un recurso
                Resource resource = new UrlResource(imagePath.toUri());

                // Devuelve la imagen como respuesta
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // Cambia el tipo de contenido según el formato de tus
                                                           // imágenes
                        .body(resource);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();

        }
    }
}