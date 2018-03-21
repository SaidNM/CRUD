package com.example.is.model;

/**
 * Created by saidn on 20/03/2018.
 */
public class SocioModel {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String descripcion;

    public SocioModel(String nombre, String apellidoP, String apellidoM, String descripcion) {
        super();
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.descripcion = descripcion;
    }
    public SocioModel(){
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
