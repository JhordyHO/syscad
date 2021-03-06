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
        <script src="js/detallecurso/detallecurso.js" type="text/javascript"></script>
        <title>Alumno</title>
    </head>
    <body>
        <%@include file="../../WEB-INF/jspf/header.jspf" %>
        <div class="container"style="min-height: 400px; margin: 0 auto;">            
            <h4 class="header"><i class="material-icons medium">library_books</i> Listar de Cursos </h4>
            <div class="row">
                <div class="card">
                    <div class="card-image waves-effect waves-block waves-light" style="height: 350px;">
                        <img class="activator" src="img/fondo2.png" alt=""/>
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">Lista de Cursos<i class="material-icons right">more_vert</i></span>
                        <p>Lista de cursos , y profesores quienes lo dictan </p>
                    </div>
                    <div class="card-reveal">
                        <span class="card-title grey-text text-darken-4">Lista de Cursos<i class="material-icons right">close</i></span>
                        <div >
                            <a  id="crear_n" class="btn-floating btn-large waves-effect waves-light color_emerald modal-trigger" href="#modalcrear"><i class="material-icons">add</i></a>
                            <table class="table" >                
                                <thead>
                                    <tr>
                                        <th>Nombre Curso</th>
                                        <th>Nota 01</th>
                                        <th>Nota 02</th>
                                        <th>Promedio</th>
                                        <th>Alumno</th>
                                        <th colspan="2">Opcion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="dcurso" begin="0" items="${lista}">                
                                        <tr>
                                            <td><c:out value="${dcurso.nombre_curso}"></c:out></td>
                                            <td><c:out value="${dcurso.nota1}"></c:out></td>
                                            <td><c:out value="${dcurso.nota2}"></c:out></td>
                                            <td><c:out value="${dcurso.promedio}"></c:out></td>
                                            <td><c:out value="${dcurso.nombre}"></c:out> <c:out value="${dcurso.apellido}"></c:out></td>
                                            <td><a id="edit" onclick="edit('<c:out value="${curso.id_curso}"></c:out>', '<c:out value="${curso.id_docente}"></c:out>')" class="btn xs color_river modal-trigger" href="#modaledit"><i class="material-icons">mode_edit</i></a></td>
                                            <td><a onclick="eliminar('<c:out value="${curso.id_curso}"></c:out>')" class="btn xs color_alizarin"><i class="material-icons">delete</i></a></td>
                                            </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>

            <!-- Modal para crear nuevo curso -->
            <div id="modalcrear" class="modal">
                <div class="modal-content" >
                    <h6 class="header"><i class="material-icons small">date_range</i> detalles curso</h6>
                    <div class="row">
                        <form id="form-registrar" method="POST" action="dcc?op=crear">
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <select name="id_c" id="select_curso">
                                        <option value="1">Option 1</option>
                                        <option value="2">Option 2</option>
                                        <option value="3">Option 3</option>
                                    </select>
                                    <label>Curso  </label>
                                </div>
                                <div class="input-field col s3">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <input id="nota1" name="nota1" type="text" class="validate">
                                    <label for="nota1">Nota 1</label>
                                </div>
                                <div class="input-field col s3">
                                    <input id="nota2" name="nota2" type="text" class="validate">
                                    <label for="nota2">Nota 1</label>
                                </div>

                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <select name="id_a" id="select_alumno">
                                        <option value="1">Option 1</option>
                                        <option value="2">Option 2</option>
                                        <option value="3">Option 3</option>
                                    </select>
                                    <label>Alumno</label>
                                </div>
                            </div>
                            <a id="crear" class=" modal-action modal-close waves-effect waves-green btn color_amethyst">Crear</a>
                        </form>
                    </div>

                </div>
            </div>
            <!-- Modal para editar alumno -->
            <div id="modaledit" class="modal">
                <div class="modal-content">
                    <h6 class="header"><i class="material-icons prefix">account_circle</i> Editar Curso</h6>
                    <div class="row" style="padding: 15px;">
                        <form id="form-edit" method="POST" action="cc?op=modificar">
                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <select name="id_2" id="docent_select">
                                        <option value="1">Option 1</option>
                                        <option value="2">Option 2</option>
                                        <option value="3">Option 3</option>
                                    </select>
                                    <label>Curso  </label>
                                </div>
                                <div class="input-field col s3">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <input id="nombre_cur" name="nombre_c" type="text" class="validate">
                                    <label for="nombre_c">Nota 1</label>
                                </div>
                                <div class="input-field col s3">
                                    <input id="nombre_cur" name="nombre_c" type="text" class="validate">
                                    <label for="nombre_c">Nota 1</label>
                                </div>

                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <select name="id_d_2" id="docent_select">
                                        <option value="1">Option 1</option>
                                        <option value="2">Option 2</option>
                                        <option value="3">Option 3</option>
                                    </select>
                                    <label>Alumno</label>
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
