<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Administradores
    Created on : May 28, 2016, 1:55:48 AM
    Author     : Latyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
    </head>
    <body>
        <div class="row">

            <div class="col-sm-5 col-sm-offset-1">

                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Buscar</button>
                    </span>
                    <input type="text" class="form-control" placeholder="Criterio de busqueda...">
                </div>
                <div class="panel panel-success MargingTop">
                    <div class="panel-heading">Usuarios</div>
                    <div class="panel-body">
                        Panel content
                        <sql:query var="result" dataSource="jdbc/clinica">
                            SELECT *  FROM Usuario
                        </sql:query>
                            <c:forEach var="results" items="${result.rows}">
                            <a href="#" id="${results.codigo}">
                            <span class="categoryLabelText">${results.nombre}</span>
                        </a>
                        </c:forEach>   

                    </div>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="panel panel-danger">
                    <div class="panel-heading">Detalles</div>
                    <div class="panel-body">
                        <div class="col-sm-12">

                        </div>
                        <div class="row">
                            <div class="col-sm-12 MargingTop">
                                <a href="#" class="btn btn-success">Salvar</a>
                                <a href="#" class="btn btn-success">Editar</a>
                                <a href="#" class="btn btn-success">Agregar</a>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
    </body>
</html>
