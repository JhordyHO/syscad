/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.dao;

import com.cad.interfaces.Operaciones;
import com.cad.model.Alumno;
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
public class AlumnoDAO implements Operaciones<Alumno> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    private final String SQL_LISTAR = "SELECT * FROM ALUMNO";
    private final String SQL_GUARDAR = "INSERT INTO alumno (nombres,apellidos,ciclo,telefono,correo) VALUES (?,?,?,?,?);";
    private final String SQL_BUSCAR = "SELECT * FROM alumno WHERE idAlumno = ?";
    private final String SQL_UPDATE = "UPDATE alumno SET nombres = ?,apellidos = ?, ciclo = ?, telefono = ?, correo = ? WHERE  idAlumno = ?";
    private final String SQL_ELIMINAR = "DELETE FROM alumno WHERE idAlumno = ?";

    @Override
    public int create(Alumno p) {
        int op = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_GUARDAR);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getCiclo());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getCorreo());
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
    public int update(Alumno p) {
        int op = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_UPDATE);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getCiclo());
            ps.setString(4, p.getTelefono());
            ps.setString(5, p.getCorreo());
            ps.setInt(6, p.getId_alumno());

            op = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return op;
    }

    @Override
    public Alumno buscar(int id) {
        Alumno a = new Alumno();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_BUSCAR);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.setId_alumno(rs.getInt("idAlumno"));
                a.setNombre(rs.getString("nombres"));
                a.setApellido(rs.getString("apellidos"));
                a.setCiclo(rs.getString("ciclo"));
                a.setTelefono(rs.getString("telefono"));
                a.setCorreo(rs.getString("correo"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return a;
    }

    @Override
    public List<Alumno> listar() {
        List<Alumno> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setId_alumno(rs.getInt("idAlumno"));
                a.setNombre(rs.getString("nombres"));
                a.setApellido(rs.getString("apellidos"));
                a.setCiclo(rs.getString("ciclo"));
                a.setTelefono(rs.getString("telefono"));
                a.setCorreo(rs.getString("correo"));
                lista.add(a);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

}
