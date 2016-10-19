/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.dao;

import com.cad.interfaces.Operaciones;
import com.cad.model.Docente;
import com.cad.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UPEU
 */
public class DocenteDAO implements Operaciones<Docente>{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    private final String SQL_LISTAR="SELECT *FROM docente";
    private final String SQL_GUARDAR="INSERT INTO docente(iddocente, nombres, apellidos, grado) VALUES(null,?,?,?)";
    private final String SQL_UPDATE="UPDATE docente SET nombres=?, apellidos=?, grado=? WHERE iddocente=?";
    private final String SQL_BUSCAR="SELECT *FROM docente WHERE iddocente=?";
    private final String SQL_ELIMINAR="DELETE FROM docente WHERE iddocente=?";
    @Override
    public int create(Docente p) {
        int op = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_GUARDAR);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getApellidos());
            ps.setString(3, p.getGrado());
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
    public int update(Docente p) {
        int op = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_UPDATE);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getApellidos());
            ps.setString(3, p.getGrado());
            ps.setInt(4, p.getIddocente());
            op = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return op;
        
    }

    @Override
    public Docente buscar(int id) {
        Docente d = new Docente();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_BUSCAR);
            ps.setInt(1, id);
           rs = ps.executeQuery();
           while(rs.next()){
           d.setNombres(rs.getString("nombres"));
           d.setApellidos(rs.getString("apellidos"));
           d.setGrado(rs.getString("grado"));
           d.setIddocente(rs.getInt("iddocente"));
           }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return d;
        
    }

    @Override
    public List<Docente> listar() {
        List<Docente> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            while(rs.next()){
                Docente x = new Docente();
               x.setNombres(rs.getString("nombres"));
               x.setApellidos(rs.getString("apellidos"));
               x.setGrado(rs.getString("grado"));
               x.setIddocente(rs.getInt("iddocente"));
               lista.add(x);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return lista;
        
    }
    
}
