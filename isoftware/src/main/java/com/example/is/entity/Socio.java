package com.example.is.entity;

import javax.persistence.*;

/**
 * Created by saidn on 20/03/2018.
 */
@Entity
@Table(name="socio")
public class Socio {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidoP")
    private String apellidoP;
    @Column(name="apellidoM")
    private String apellidoM;
    @Column(name="descripcion")
    private String descripcion;

    public Socio(String nombre, String apellidoP, String apellidoM, String descripcion) {
        super();
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.descripcion = descripcion;
    }
    public Socio(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
