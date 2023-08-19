package com.catalogo.catalogobackend.Exception;

public class CatalogoNotFoundException extends RuntimeException {
    public CatalogoNotFoundException(String message) {
        super(message);
    }
}
