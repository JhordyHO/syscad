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
public class Curso{
 private int id_curso; 
 private String nombre_curso; 
 private int id_docente;
 
 //---- campos de la entidad Docente ---
    private String nombres_D;
    private String apellidos_D;
    private String grado_D;

    public Curso() {
    }

    public Curso(int id_curso, String nombre_curso, int id_docente, String nombres_D, String apellidos_D, String grado_D) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.id_docente = id_docente;
        this.nombres_D = nombres_D;
        this.apellidos_D = apellidos_D;
        this.grado_D = grado_D;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public String getNombres_D() {
        return nombres_D;
    }

    public void setNombres_D(String nombres_D) {
        this.nombres_D = nombres_D;
    }

    public String getApellidos_D() {
        return apellidos_D;
    }

    public void setApellidos_D(String apellidos_D) {
        this.apellidos_D = apellidos_D;
    }

    public String getGrado_D() {
        return grado_D;
    }

    public void setGrado_D(String grado_D) {
        this.grado_D = grado_D;
    }

    
}
