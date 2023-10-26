package com.catalogo.catalogobackend.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.catalogo.catalogobackend.Exception.CatalogoNotFoundException;
import com.catalogo.catalogobackend.Repositories.CatalogoRepository;
import com.catalogo.catalogobackend.models.Catalogo;

/**
 * La clase de catalogo servicio es un servicio que interactúa con el catalogo repositorio para realizar CRUD
 * Operaciones en un catálogo.
 */
@Service
@Transactional

public class CatalogoService {
    private final CatalogoRepository catalogoRepository;

  // La anotación `@autowired` se usa para conectar automáticamente el 'Catalogo reposepository` Bean en el
   // Clase de Catalogo service`.
    @Autowired
    public CatalogoService(CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;

    }
/**
     * La función addCatalgo guarda un objeto Catalogo al catalogo repository.
     *
     * @param catalogo El parámetro "Catalogo" es un objeto de tipo "Catalogo".
     * @return El método está devolviendo un objeto de catalogo.
     */
    public Catalogo addCatalogo(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }

    /**
     * La función devuelve una lista de todos los objetos de catalogo del catalogo repository.
     *
     * @return El método es devolver una lista de objetos de catalogo.
     */
    public List<Catalogo> findALLCatalogo() {
        return catalogoRepository.findAll();
    }

   /**
    * La función actualiza un objeto de catálogo en el repositorio de catálogo.
    *
    * @param catalogo El parámetro "catalogo" es un objeto de tipo catalogo, que representa un
    * Catálogo.
    * @return El método está devolviendo un objeto Catalogo actualizado.
    */
    public Catalogo updateCatalogo(Catalogo catalogo) {
        return this.catalogoRepository.save(catalogo);
    }

    public List<Catalogo> findCatalogosByGrupo(String grupo, Long id) {
        return catalogoRepository.findByGrupo(grupo);

    }

    public void deleteCatalogo(Long id) {
        catalogoRepository.deleteCatalogoById(id);
    }

   /**
     * La función obtiene la URL de la imagen para una ID de catálogo dada.
     *
     * @param ID La identificación del catalogo (producto) para el cual desea obtener la URL de la imagen.
     * @return El método está devolviendo una cadena, que es la URL de la imagen asociada con el
     * Artículo del catálogo identificado por la ID dada.
     */
    public String obtenerUrlImagen(Long id) {
        Catalogo catalogo = catalogoRepository.findById(id)
                .orElseThrow(() -> new CatalogoNotFoundException("Producto no encontrado"));

        return catalogo.getImagenUrl();
    }
/**
     * La función FindById (ID Long) devuelve un objeto de catalogo con la ID especificada desde el
     * Catalogorepositorio, o nulo si no existe.
     *
     * @param id El parámetro "id" es de tipo largo y representa el identificador único de un catálogo
     * En el repositorio del catálogo.
     * @return El método es devolver un objeto de tipo catalogo.
     */
    public Catalogo findById(Long id) {
        return catalogoRepository.findById(id).orElse(null);
    }

    /**
     * La función guarda un objeto de catalogo al catalogorepositorio.
     *
     * @param catalogo El parámetro "catalogo" es un objeto de tipo catalogo que representa el
     * Catálogo para ser salvado.
     * @return El método está devolviendo un objeto de catalogo.
     */
    public Catalogo save(Catalogo catalogo) {
        return this.catalogoRepository.save(catalogo);
    }
    
}
