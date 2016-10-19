/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.model;


/**
 *
 * @author Jhordy
 */
public class Alumno {
    private int id_alumno;
    private String nombre;
    private String apellido;
    private String ciclo;
    private String telefono;
    private String correo;

    public Alumno() {
    }

    public Alumno(int id_alumno, String nombre, String apellido, String ciclo, String telefono, String correo) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciclo = ciclo;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

}
