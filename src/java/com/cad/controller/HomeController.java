/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.controller;

import com.cad.dao.AlumnoDAO;
import com.cad.dao.CursoDAO;
import com.cad.dao.DetalleCursoDAO;
import com.cad.dao.DocenteDAO;
import com.cad.model.Docente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author UPEU
 */
public class HomeController extends HttpServlet {

    private DocenteDAO aO = new DocenteDAO();
    private List<Docente> lista = new ArrayList<>();
    private AlumnoDAO alumDAO = new AlumnoDAO();
    private CursoDAO curDAO = new CursoDAO();
    private DetalleCursoDAO dcurDAO = new DetalleCursoDAO();

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        RequestDispatcher rd;
        String x = "";
        int op = Integer.parseInt(request.getParameter("op"));
        switch (op) {
            case 1:
                x = "/index.jsp";
                rd = request.getRequestDispatcher(x);
                rd.include(request, response);
                break;
            case 2:
                x = "vista/docente/crear.jsp";
                rd = request.getRequestDispatcher(x);
                rd.include(request, response);
                break;
            case 3:
                x = "vista/docente/lista.jsp";
                request.setAttribute("lista", aO.listar());
                rd = request.getRequestDispatcher(x);
                rd.include(request, response);
                break;
            case 4:
                x = "vista/docente/editar.jsp";
                rd = request.getRequestDispatcher(x);
                rd.include(request, response);
                break;
            case 5:
                x = "vista/alumno/index.jsp";
                request.setAttribute("lista", alumDAO.listar());
                rd = request.getRequestDispatcher(x);
                rd.include(request, response);
                break;
            case 6:
                x = "vista/curso/index.jsp";
                rd = request.getRequestDispatcher(x);
                request.setAttribute("lista", curDAO.listar());
                rd.include(request, response);
                break;
            case 7:
                x = "vista/detallecurso/index.jsp";
                request.setAttribute("lista", dcurDAO.listar());
                rd = request.getRequestDispatcher(x);
                rd.include(request, response);
                break;

        }

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
