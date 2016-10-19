/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.model;

/**
 *
 * @author UPEU
 */
public class Docente {
    private int iddocente;
    private String nombres;
    private String apellidos;
    private String grado;

    public Docente() {
    }

    public Docente(String nombres, String apellidos, String grado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.grado = grado;
    }

    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
}
