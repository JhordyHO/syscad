<%-- 
    Document   : index
    Created on : 17-oct-2016, 22:29:05
    Author     : Jhordy
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../WEB-INF/jspf/head.jspf" %>
        <script src="js/alumno/alumno.js" type="text/javascript"></script>
        <title>Alumno</title>
    </head>
    <body>
        <%@include file="../../WEB-INF/jspf/header.jspf" %>
        <div class="container"style="min-height: 400px; margin: 0 auto;">            
            <h4 class="header"><i class="material-icons medium">perm_identity</i> Listar de Alumnos </h4>
            <div class="row">
                <div class="card">
                    <div class="card-image waves-effect waves-block waves-light" style="height: 350px;">
                        <img class="activator" src="img/fondo1.jpg" alt=""/>
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">Lista de Alumnos<i class="material-icons right">more_vert</i></span>
                        <p>Lista de los estudiantes del la escuela de Ingenieria y arquitectura</p>
                    </div>
                    <div class="card-reveal">
                        <span class="card-title grey-text text-darken-4">Lista de Alumnos<i class="material-icons right">close</i></span>
                        <div >
                    <a class="btn-floating btn-large waves-effect waves-light color_emerald modal-trigger" href="#modal1"><i class="material-icons">add</i></a>
                    <table class="table" >                
                        <thead>
                            <tr>
                                <th>Nombres</th>
                                <th>Apelllidos</th>
                                <th>Ciclo</th>
                                <th>Telefono</th>
                                <th>Correo</th>
                                <th colspan="2">Opcion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="alumno" begin="0" items="${lista}">                
                                <tr>
                                    <td><c:out value="${alumno.nombre}"></c:out></td>
                                    <td><c:out value="${alumno.apellido}"></c:out></td>
                                    <td><c:out value="${alumno.ciclo}"></c:out></td>
                                    <td><c:out value="${alumno.telefono}"></c:out></td>
                                    <td><c:out value="${alumno.correo}"></c:out></td>
                                    <td><a onclick="edit_alum('<c:out value="${alumno.id_alumno}"></c:out>')" class="btn xs color_river"><i class="material-icons">mode_edit</i></a></td>
                                    <td><a onclick="eliminar_alum('<c:out value="${alumno.id_alumno}"></c:out>')" class="btn xs color_alizarin"><i class="material-icons">delete</i></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                    </div>
                </div>
                
            </div>

            <!-- Modal para crear nuevo alumno -->
            <div id="modal1" class="modal bottom-sheet">
                <div class="modal-content">
                    <h6 class="header"><i class="material-icons prefix">account_circle</i> Nuevo Alumno</h6>
                    <div class="row">
                        <form id="form-registrar" method="POST" action="ac?op=crear">
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <input id="nombre" name="nombre" type="text" class="validate">
                                    <label for="nombre">Nombre</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="apellido" type="text" name="apellido" class="validate">
                                    <label for="apellido">Apellido</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s4">
                                    <i class="material-icons prefix">assessment</i>
                                    <input id="ciclo" type="text" name="ciclo" class="validate">
                                    <label for="ciclo">Ciclo</label>
                                </div>
                                <div class="input-field col s4">
                                    <i class="material-icons prefix">settings_phone</i>
                                    <input id="telefono" type="text" name="telefono" class="validate">
                                    <label for="telefono">telefono</label>
                                </div>
                                <div class="input-field col s4">
                                    <i class="material-icons prefix">supervisor_account</i>
                                    <input id="correo" type="text" name="correo" class="validate">
                                    <label for="correo">Correo</label>
                                </div>

                            </div>
                        </form>
                        <a id="crear" class=" modal-action modal-close waves-effect waves-green btn color_amethyst">Crear</a>

                    </div>

                </div>
            </div>
            <!-- Modal para editar alumno -->
            <div id="modaledit" class="modal">
                <div class="modal-content">
                    <h6 class="header"><i class="material-icons prefix">account_circle</i> Editar Alumno</h6>
                    <div class="row" style="padding: 15px;">
                        <form id="form-edit" method="POST"  action="ac?op=modificar">
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <input  id="txtid" type="hidden" name="id_alum" value=""/>
                                    <input id="txtnombre" name="nombre" type="text" class="validate">
                                    <label for="txtnombre">Nombre</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="txtapellido" type="text" name="apellido" class="validate">
                                    <label for="txtapellido">Apellido</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s4">
                                    <i class="material-icons prefix">assessment</i>
                                    <input id="txtciclo" type="text" name="ciclo" class="validate">
                                    <label for="txtciclo">Ciclo</label>
                                </div>
                                <div class="input-field col s4">
                                    <i class="material-icons prefix">settings_phone</i>
                                    <input id="txttelefono" type="text" name="telefono" class="validate">
                                    <label for="txttelefono">telefono</label>
                                </div>
                                <div class="input-field col s4">
                                    <i class="material-icons prefix">supervisor_account</i>
                                    <input id="txtcorreo" type="text" name="correo" class="validate">
                                    <label for="txtcorreo">Correo</label>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <a id="modificar" class=" modal-action modal-close waves-effect waves-green btn color_amethyst">Modificar</a>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../../WEB-INF/jspf/footer.jspf" %>
</body>
</html>
