/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.controller;

import com.cad.dao.AlumnoDAO;
import com.cad.model.Alumno;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Event;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.apache.catalina.tribes.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jhordy
 */
public class AlumnoController extends HttpServlet {

    private AlumnoDAO alumDAO = new AlumnoDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String op = request.getParameter("op");
        String id_alum = request.getParameter("id_alum");
        PrintWriter out = response.getWriter();
        
        if (op.equals("edit")) {
            try {
                Alumno al = alumDAO.buscar(Integer.parseInt(id_alum)); // llamamos al DAO
                JSONObject obj = new JSONObject();// creamos un ObjetoJSON
                obj.put("id", al.getId_alumno());      //
                obj.put("nombre", al.getNombre());     //
                obj.put("apellido", al.getApellido()); //   --> añadimos campos al json
                obj.put("ciclo", al.getCiclo());       //
                obj.put("telefono", al.getTelefono()); //
                obj.put("correo", al.getCorreo());     //
                out.println(obj); // imprimiemos el json en un response

            } catch (JSONException ex) {
                ex.printStackTrace();
            }

        }
        if(op.equals("crear")){
                    Alumno al = new Alumno();
                    al.setNombre(request.getParameter("nombre"));
                    al.setApellido(request.getParameter("apellido"));
                    al.setCiclo(request.getParameter("ciclo"));
                    al.setTelefono(request.getParameter("telefono"));
                    al.setCorreo(request.getParameter("correo"));
                    alumDAO.create(al);
                    response.sendRedirect("hc?op=5");
        }
        if(op.equals("modificar")){
            Alumno al = new Alumno();
                    al.setNombre(request.getParameter("nombre"));
                    al.setApellido(request.getParameter("apellido"));
                    al.setCiclo(request.getParameter("ciclo"));
                    al.setTelefono(request.getParameter("telefono"));
                    al.setCorreo(request.getParameter("correo"));
                    al.setId_alumno(Integer.parseInt(request.getParameter("id_alum")));
                    alumDAO.update(al);
                    response.sendRedirect("hc?op=5");
        }
        if(op.equals("eliminar")){
                    alumDAO.delete(Integer.parseInt(id_alum));
                    response.sendRedirect("hc?op=5");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
