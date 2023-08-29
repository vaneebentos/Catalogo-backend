package com.catalogo.catalogobackend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.catalogo.catalogobackend.Exception.CatalogoNotFoundException;
import com.catalogo.catalogobackend.Repositories.CatalogoRepository;
import com.catalogo.catalogobackend.models.Catalogo;

@Service
@Transactional

public class CatalogoService {
    private final CatalogoRepository catalogoRepository;

    @Autowired
    public CatalogoService(CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;

    }

    public Catalogo addCatalogo(Catalogo catalogo) {
        //Catalogo producto = new Catalogo();


        return catalogoRepository.save(catalogo);
    }

    public List<Catalogo> findALLCatalogo() {
        return catalogoRepository.findAll();
    }

    public Catalogo updateCatalogo(Catalogo catalogo) {
        return this.catalogoRepository.save(catalogo);
    }

   

    public List<Catalogo> findCatalogosByGrupo(String grupo, Long id) {
        return catalogoRepository.findByGrupo(grupo);
        
    }
              
    

    public void deleteCatalogo(Long id) {
        catalogoRepository.deleteCatalogoById(id);
    }
    public String obtenerUrlImagen(Long id) {
        Catalogo catalogo = catalogoRepository.findById(id)
                .orElseThrow(() -> new CatalogoNotFoundException("Producto no encontrado"));

        return catalogo.getImagenUrl();
    }

}
