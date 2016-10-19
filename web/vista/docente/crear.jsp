<%-- 
    Document   : crear
    Created on : 12-oct-2016, 16:14:42
    Author     : UPEU
--%>

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
            <h2>Registro de Docentes</h2>
            <hr>
            <form method="post" action="hc">
                <div class="form-group">
                    <label>Nombres:</label>
                    <input type="text" name="nombres" placeholder="Nombres.." class="form-control">
                </div>
                <div class="form-group">
                    <label>Apellidos:</label>
                    <input type="text" name="apellidos" placeholder="Nombres.." class="form-control">
                    <input type="hidden" name="op" value="1">
                </div>
                <div class="form-group">
                    <label>Grado:</label>
                    <select name="grado" class="form-control">
                        <option value="">Seleccionar Grado</option>
                        <option value="Doctor">Doctor</option>
                        <option value="Magister">Magister</option>
                        <option value="Licenciado">Bachiller</option>                            
                        </option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" name="boton" value="Enviar" class="btn btn-primary">
                </div>
            </form>
        </div>
        
        <%@include file="../../WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
