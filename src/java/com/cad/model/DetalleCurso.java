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
public class DetalleCurso {

    private int id_alumno;
    private int id_curso;
    private float nota1;
    private float nota2;
    private float promedio;
// -------------alumnos---------------
    private String nombre;
    private String apellido;
    private String ciclo;
    private String telefono;
    private String correo;
    // -------- curso ----------
    private String nombre_curso;
    private int id_docente;

    public DetalleCurso() {
    }

    public DetalleCurso(int id_alumno, int id_curso, float nota1, float nota2, float promedio, String nombre, String apellido, String ciclo, String telefono, String correo, String nombre_curso, int id_docente) {
        this.id_alumno = id_alumno;
        this.id_curso = id_curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.promedio = promedio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciclo = ciclo;
        this.telefono = telefono;
        this.correo = correo;
        this.nombre_curso = nombre_curso;
        this.id_docente = id_docente;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
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
    
    

}
