package com.catalogo.catalogobackend.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Catalogo implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String marca;
    private String modelo;
    private String descripcion;
    private Double precio;
    private String imagenUrl;

    @Column (nullable = false, updatable = false)

    private String catalogoCode;
    public Catalogo (){}

    public Catalogo(String marca,String modelo,String descripcion,Double precio,String imagenUrl){
        
    }

    public Catalogo(Long id, String marca, String modelo, String descripcion, Double precio, String imagenUrl,
            String catalogoCode) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.catalogoCode = catalogoCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getCatalogoCode() {
        return catalogoCode;
    }

    public void setCatalogoCode(String catalogoCode) {
        this.catalogoCode = catalogoCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ",precio='" +precio + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +
                '}';

    }

    
}
