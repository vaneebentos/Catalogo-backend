package com.catalogo.catalogobackend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catalogo.catalogobackend.Exception.CatalogoNotFoundException;
import com.catalogo.catalogobackend.Repositories.CatalogoRepository;
import com.catalogo.catalogobackend.models.Catalogo;

@Service
@Transactional
public class CatalogoService {
    private final CatalogoRepository catalogo;

    @Autowired
    public CatalogoService(CatalogoRepository catalogoRepository) {
        this.catalogo = catalogoRepository;

    }

    public Catalogo addCatalogo(Catalogo catalogo) {
        catalogo.setCatalogoCode(UUID.randomUUID().toString());
        return this.catalogo.save(catalogo);
    }

    public List<Catalogo> findALLCatalogo() {
        return catalogo.findAll();
    }

    public Catalogo updateCatalogo(Catalogo catalogo) {
        return this.catalogo.save(catalogo);
    }

    public Catalogo findCatalogoById(Long id) {
        return catalogo.findCatalogoById(id)
                .orElseThrow(() -> new CatalogoNotFoundException("User by id" + id + "was not found"));
    }

    public void deleteCatalogo(Long id) {
        catalogo.deleteCatalogoById(id);
    }

}
