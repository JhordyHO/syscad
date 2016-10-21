/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.dao;

import com.cad.interfaces.Operaciones;
import com.cad.model.DetalleCurso;
import com.cad.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhordy
 */
public class DetalleCursoDAO implements Operaciones<DetalleCurso> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    private final String SQL_LISTAR = "select * from detalle_curso d , alumno a,curso c where d.idAlumno = a.idAlumno and  d.idCurso = c.idCurso";
    private final String SQL_GUARDAR = "";
    private final String SQL_UPDATE = "";
    private final String SQL_ELIMINAR = "";

    @Override
    public int create(DetalleCurso p) {
          int op = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_GUARDAR);
            ps.setInt(1, p.getId_alumno());
            ps.setInt(2, p.getId_curso());
            ps.setFloat(3, p.getNota1());
            ps.setFloat(3, p.getNota2());
            ps.setFloat(3, p.getPromedio());
            op = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return op; 
    }

    @Override
    public int delete(int id) {
                int op = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_ELIMINAR);
            ps.setInt(1, id);
            op = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return op;  
    }

    @Override
    public int update(DetalleCurso p) {
        int op = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_UPDATE);
            ps.setInt(1, p.getId_alumno());
            ps.setFloat(2, p.getId_curso());
            ps.setFloat(3, p.getNota1());
            ps.setFloat(4, p.getNota2());
            ps.setFloat(5, p.getPromedio());
            op = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return op;
    }

    @Override
    public DetalleCurso buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleCurso> listar() {
       List<DetalleCurso> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            while(rs.next()){
                DetalleCurso d = new DetalleCurso();
           d.setId_alumno(rs.getInt("idAlumno"));
           d.setId_curso(rs.getInt("idCurso"));
           d.setNota1((float) rs.getDouble("nota1"));
           d.setNota2((float) rs.getDouble("nota2"));
           d.setPromedio((float) rs.getDouble("promedio"));
           ///--------------------datos curso --------------
           d.setId_curso(rs.getInt("idCurso"));
           d.setNombre_curso(rs.getString("nombre_curso"));
           //---------------------datos alumno-------------
           d.setNombre(rs.getString("nombres"));
           d.setApellido(rs.getString("apellidos"));
           d.setCorreo(rs.getString("correo"));
           d.setCiclo(rs.getString("ciclo"));
           d.setTelefono(rs.getString("telefono"));
               lista.add(d);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }

   

}
