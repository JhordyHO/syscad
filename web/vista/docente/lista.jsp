<%-- 
    Document   : lista
    Created on : 12-oct-2016, 16:14:32
    Author     : UPEU
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../../WEB-INF/jspf/head.jspf" %>
    </head>
    <body>        
        <%@include file="../../WEB-INF/jspf/header.jspf" %>
        <div class="container"style="max-width: 500px; margin: 0 auto;">            
            <h2>Listar Docentes</h2>
            <hr>
            <a href="<%= request.getContextPath()%>/hc?op=2" class="btn btn-mini btn-primary" role="button">New</a>            
            <table class="table" >                
            <thead>
                <tr>
                    <th>Nombres</th>
                    <th>Apelllidos</th>
                    <th>Grado</th>
                    <th colspan="2">Opcion</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="docente" begin="0" items="${lista}">                
            <tr>
                <td><c:out value="${docente.nombres}"></c:out></td>
                <td><c:out value="${docente.apellidos}"></c:out></td>
                <td><c:out value="${docente.grado}"></c:out></td>
                <td><a href="hc?op=4&id=<c:out value="${docente.iddocente}"></c:out>" class="btn btn-success">Edit</a></td>
                <td><a href="hc?op=5&id=<c:out value="${docente.iddocente}"></c:out>" class="btn btn-danger">Delete</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
        <%@include file="../../WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
