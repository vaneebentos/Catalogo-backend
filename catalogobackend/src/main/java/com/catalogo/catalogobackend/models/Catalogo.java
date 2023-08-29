package com.catalogo.catalogobackend.models;

import java.io.Serializable;

import org.hibernate.sql.Insert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "catalogos")

public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "marca", length = 150, nullable = true)
    private String marca;

    @Column(name = "modelo", length = 150, nullable = true)
    private String modelo;

    @Column(name = "detalle", length = 350, nullable = true)
    private String detalle;

    @Column(name = "precio", length = 100, nullable = true)
    private Double precio;

    @Column(name = "grupo", length = 100, nullable = true)
    private String grupo;
  
    private String imagenUrl;

    

    public Catalogo(Long id, String marca, String modelo, String detalle, Double precio, String imagenUrl, String grupo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.detalle = detalle;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.grupo = grupo;
    }

    public Catalogo() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }




}
