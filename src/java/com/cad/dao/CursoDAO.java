/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.dao;

import com.cad.interfaces.Operaciones;
import com.cad.model.Curso;
import com.cad.model.Docente;
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
public class CursoDAO implements Operaciones<Curso> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    private final String SQL_LISTAR = "select * from curso c, docente d where c.idDocente = d.idDocente";
    private final String SQL_GUARDAR = "INSERT INTO curso (nombre_curso,idDocente) VALUES (?,?);";
    private final String SQL_BUSCAR = "select * from curso c, docente d where c.idDocente = d.idDocente and c.idCurso = ?";
    private final String SQL_UPDATE = "UPDATE curso SET nombre_curso = ?, idDocente = ? WHERE  idCurso = ?";
    private final String SQL_ELIMINAR = "DELETE FROM curso WHERE idCurso = ?";

    @Override
    public int create(Curso p) {
        int op = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_GUARDAR);
            ps.setString(1, p.getNombre_curso());
            ps.setInt(2, p.getId_docente());
            op = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
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
            System.out.println("Error: " + e);
        }
        return op;
    }

    @Override
    public int update(Curso p) {
        int op = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_UPDATE);
            ps.setString(1, p.getNombre_curso());
            ps.setInt(2, p.getId_docente());
            ps.setInt(3, p.getId_curso());
            op = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return op;
    }

    @Override
    public Curso buscar(int id) {
        Curso c = new Curso();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_BUSCAR);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId_curso(rs.getInt("idCurso"));
                c.setNombre_curso(rs.getString("nombre_curso"));
                c.setId_docente(rs.getInt("idDocente"));
                //------------------------------
                c.setNombres_D(rs.getString("nombres"));
                c.setApellidos_D(rs.getString("apellidos"));
                c.setGrado_D(rs.getString("grado"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return c;
    }

    @Override
    public List<Curso> listar() {
        List<Curso> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            while (rs.next()) {
                Curso c = new Curso();
                Docente d = new Docente();
                c.setId_curso(rs.getInt("idCurso"));
                c.setNombre_curso(rs.getString("nombre_curso"));
                c.setId_docente(rs.getInt("idDocente"));
                //---------------------------------------
                c.setNombres_D(rs.getString("nombres"));
                c.setApellidos_D(rs.getString("apellidos"));
                c.setGrado_D(rs.getString("grado"));
                
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

}
