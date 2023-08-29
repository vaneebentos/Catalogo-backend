package com.catalogo.catalogobackend.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.catalogobackend.models.Catalogo;
import com.catalogo.catalogobackend.service.CatalogoService;

@RestController
@RequestMapping("/api/v1/")

public class CatalogoResources {
    private final CatalogoService catalogoService;

    public CatalogoResources(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;

    }

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
            .collect (Collectors.toList());
        
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
    public ResponseEntity<Catalogo> updateCatalogo(@RequestBody Catalogo catalogo) {
        Catalogo updateCatalogo = catalogoService.updateCatalogo(catalogo);
        return new ResponseEntity<>(updateCatalogo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCatalogo(@PathVariable("id") Long id) {
        catalogoService.deleteCatalogo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
