package com.catalogo.catalogobackend.Resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.catalogobackend.models.Catalogo;
import com.catalogo.catalogobackend.service.CatalogoService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoResources {
    private final CatalogoService catalogoService;

    public CatalogoResources(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;

    }

    @GetMapping("/all")
    public ResponseEntity<List<Catalogo>> getAllCatalogos() {
        List<Catalogo> catalogos = catalogoService.findALLCatalogo();
        return new ResponseEntity<>(catalogos, HttpStatus.OK);
    }

    @GetMapping("/catalogo/audi")
    public ResponseEntity<List<Catalogo>> getAllAudi() {
        List<Catalogo> catalogos = catalogoService.findALLAudi();
        return new ResponseEntity<>(catalogos, HttpStatus.OK);
    }
    @GetMapping("/catalogo/bmw")
    public ResponseEntity<List<Catalogo>> getAllBmw() {
        List<Catalogo> catalogos = catalogoService.findALLBmw();
        return new ResponseEntity<>(catalogos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Catalogo> addCatalogo(@RequestBody Catalogo catalogo) {
        Catalogo newCatalogo = catalogoService.addCatalogo(catalogo);
        return new ResponseEntity<>(newCatalogo, HttpStatus.CREATED);
    }

}
