package com.catalogo.catalogobackend.Repositories;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.catalogobackend.models.Catalogo;

// El fragmento de código está definiendo una interfaz de repositorio llamada `catalogorepospository` que extiende la
// interfaz jParepository`.
@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
    List<Catalogo> findByGrupo(String grupo);

    void deleteCatalogoById(long id);

    Optional<Catalogo> findCatalogoById(Long id);

}
