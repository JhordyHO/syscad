/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.test;

import com.cad.dao.AlumnoDAO;
import com.cad.dao.CursoDAO;
import com.cad.dao.DetalleCursoDAO;
import com.cad.dao.DocenteDAO;
import com.cad.model.Alumno;
import com.cad.model.Curso;
import com.cad.model.DetalleCurso;
import com.cad.model.Docente;
import com.cad.util.Conexion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UPEU
 */
public class Test01 {
    private static AlumnoDAO aO = new AlumnoDAO();
    private static CursoDAO ac = new CursoDAO();
    private static DetalleCursoDAO acc = new DetalleCursoDAO();
  // private static DocenteDAO aO = new DocenteDAO();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // listar_dc();
        crear();
    }
    public static void conex(){
        if(Conexion.getConexion()!=null){
            System.out.println("si");
        }else{
            System.out.println("no");
        }    
    }
//    public static void crear(){
//        Docente d = new Docente("Salomon", "yapu", "Doctor");
//        if(aO.create(d)>0){
//            System.out.println("si");
//        }else{
//            System.out.println("no");
//        }
//    }
//    public static void update(){
//        Docente d = new Docente("Salomon", "yapu", "Magister");
//        d.setIddocente(1);
//         if(aO.update(d)>0){
//            System.out.println("si");
//        }else{
//            System.out.println("no");
//        }
//    }
//    public static void eliminar(){
//        int id = 1;
//         if(aO.delete(id)>0){
//            System.out.println("si");
//        }else{
//            System.out.println("no");
//        }
//    }
//    public static void buscar(){
//        Docente x = new Docente();
//        x = aO.buscar(5);
//        System.out.println("Nombres y Apellidos: "+x.getNombres()+" "+x.getApellidos());
//        
//    }
//    public static void listar(){
//    List<Docente> lista = new ArrayList<>();
//    lista = aO.listar();
//    for(int i=0;i<lista.size();i++){
//        System.out.println(lista.get(i).getNombres());
//    }
//    }
    //--------- test -- alumno
    public static void listar_A(){
    List<Alumno> lista = new ArrayList<>();
    lista = aO.listar();
    for(int i=0;i<lista.size();i++){
        System.out.println(lista.get(i).getNombre());
    }
    }
    public static void listar_dc(){
    List<DetalleCurso> lista = new ArrayList<>();
    lista = acc.listar();
    for(int i=0;i<lista.size();i++){
        System.out.println(lista.get(i).getNombre());
    }
    }
        public static void crear(){
        DetalleCurso dc = new DetalleCurso();
            dc.setId_curso(Integer.parseInt("2"));
            dc.setId_alumno(Integer.parseInt("22"));
            float n1 = Float.parseFloat("20"); 
            dc.setNota1(n1);
            float n2 = Float.parseFloat("20");        
            dc.setNota1(n2);
            dc.setPromedio(n1+n2/2);
        if(acc.create(dc)>0){
            System.out.println("si");
        }else{
            System.out.println("no");
        }
    }
        
            public static void update(){
                Curso c = new Curso();
                      c.setId_curso(5);
                      c.setId_docente(6);
                      c.setNombre_curso("lololool");
         if(ac.update(c)>0){
            System.out.println("si");
        }else{
            System.out.println("no");
        }
    }
}
