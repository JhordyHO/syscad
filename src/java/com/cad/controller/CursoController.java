/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.controller;

import com.cad.dao.CursoDAO;
import com.cad.model.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jhordy
 */
public class CursoController extends HttpServlet {

    private CursoDAO curDAO = new CursoDAO();

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
        //response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        String op = request.getParameter("op");
        String id_cur = request.getParameter("id_c");
        String id_doc = request.getParameter("id_d");
        PrintWriter out = response.getWriter();
        if (op.equals("edit")) {
            try {
                Curso cur = curDAO.buscar(Integer.parseInt(id_cur)); // llamamos al DAO
                JSONObject obj = new JSONObject();// creamos un ObjetoJSON
                obj.put("id_curso", cur.getId_curso());
                obj.put("nombre_curso", cur.getNombre_curso());
                obj.put("id_docente", cur.getId_docente());
                obj.put("nombre_d", cur.getNombres_D());
                obj.put("apellido_d", cur.getApellidos_D());
                obj.put("grado_d", cur.getGrado_D());
                out.println(obj); // imprimiemos el json en un response

            } catch (JSONException ex) {
                ex.printStackTrace();
            }

        }
        if (op.equals("crear")) {
            Curso cur = new Curso();
            cur.setNombre_curso(request.getParameter("nombre_c"));
            cur.setId_docente(Integer.parseInt(id_doc));
            curDAO.create(cur);
            response.sendRedirect("hc?op=6");
        }
        if (op.equals("modificar")) {
            Curso cur = new Curso();
            cur.setNombre_curso(request.getParameter("nombre_c"));
            cur.setId_docente(Integer.parseInt(id_doc));
            cur.setId_curso(Integer.parseInt(id_cur));
             curDAO.update(cur);
            response.sendRedirect("hc?op=6");
        }
        if (op.equals("eliminar")) {
            curDAO.delete(Integer.parseInt(id_cur));
            response.sendRedirect("hc?op=6");
        }
        if(op.equals("list_json")){
            try {
                JSONObject obj = new JSONObject();
                obj.put("curso",curDAO.listar());
                out.print(obj);
            } catch (JSONException ex) {
               
            }
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
