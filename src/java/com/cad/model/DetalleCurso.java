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
public class DetalleCurso{
 private int id_alumno;
 private int id_curso;
 private float nota1;
 private float nota2;
 private float promedio;

    public DetalleCurso() {
    }

    public DetalleCurso(int id_alumno, int id_curso, float nota1, float nota2, float promedio) {
        this.id_alumno = id_alumno;
        this.id_curso = id_curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.promedio = promedio;
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
  
    
}
