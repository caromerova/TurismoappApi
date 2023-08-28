package com.example.TurismoApp.modelos;


import jakarta.persistence.*;

@Entity
@Table(name="empresas")

public class Compañia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column (name = "idempresa", nullable = false, length = )
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    private String nit;
    private Integer ubicacion;
    private String descripcion;

    public Compañia() {
    }

    public Compañia(Integer id, String nombre, String nit, Integer ubicacion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Integer ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
