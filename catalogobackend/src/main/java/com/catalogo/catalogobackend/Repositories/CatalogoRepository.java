package com.catalogo.catalogobackend.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogo.catalogobackend.models.Catalogo;

public interface CatalogoRepository extends JpaRepository<Catalogo,Long> {
    void deleteCatalogoById(long id);

    Optional<Catalogo> findCatalogoById(Long id);
}
