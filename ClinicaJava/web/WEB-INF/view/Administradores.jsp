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
        <%@ include file="Imports.jspf" %>
    </head>
    <body ng-app ng-controller="ManagerAdministradoresController">
        <div class="row">

            <div class="col-sm-5 col-sm-offset-1">

                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" ng-click="search();">Buscar</button>
                    </span>
                    <input type="text" ng-model="filter" class="form-control" placeholder="Criterio de busqueda...">
                </div>
                <div class="panel panel-success MargingTop">
                    <div class="panel-heading">Usuarios</div>
                    <div class="panel-body">
                    <table id ="UsuariosTable" class="GRID"> 
                        <thead><tr><th>Nombre</th><th>Categoria</th></tr></thead>
                        <tbody>
                            <tr ng-repeat="object in list" ng-class="{'selectedRow':$index == selectedRow}" ng-click="setClickedRow($index);edit(object);" >
                                <td>{{object.codigo}}</td>
                                <td>{{object.clave}}</td>
                            </tr>
                        </tbody>
                    </table>
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
        <script>
        function ManagerAdministradoresController($scope){
            $scope.filter ="";
            $scope.list = new Array();
            reset($scope);

            $scope.setClickedRow = function(index){
                    $scope.selectedRow = index;
            };
            
            $scope.search = function (e){
                Proxy.usuariosListSearch($scope.filter,
                    function(result){
                        $scope.$apply(function(){
                            $scope.list=result;
                        });
                    });
                reset($scope);
            };

            $scope.new = function (e){
                $scope.current = new Usuario("","");
                $scope.mode='add';
            };
        
            $scope.edit = function (selected){
                $scope.current = selected.clone();
                $scope.mode='update';
            };

            $scope.add = function (e){
                if (!$scope.userForm.$valid){ alert("Error en Datos!"); return;};
                Proxy.usuariosAdd()($scope.current,
                    function(status){
                        switch(status){
                            case 0: // ok
                                alert("Registro Agregado!");
                                $scope.$apply(function(){
                                    $scope.list= new Array($scope.current.clone());
                                    reset($scope);
                                });                                
                                break;
                            case 1: // ya existe
                                alert("Registro Duplicado!");
                                break;
                        };
                    });            
                };        
                
            $scope.update = function (e){
                if (!$scope.userForm.$valid){ alert("Error en Datos!"); return;};
                Proxy.usuariosUpdate()($scope.current,
                    function(status){
                        switch(status){
                            case 0: // ok
                                alert("Registro Modificado!");
                                $scope.$apply(function(){
                                    $scope.list[$scope.selectedRow]= $scope.current.clone();
                                });
                                break;
                            case 1: // no existe
                                alert("Registro No Existe");
                                break;
                        };
                    });
            };                    

            $scope.delete = function (e){
                Proxy.usuariosDelete()($scope.current,
                    function(status){
                        switch(status){
                            case 0: // ok
                                alert("Registro Borrado!");
                                $scope.$apply(function(){
                                    $scope.list.splice($scope.selectedRow,1);
                                    reset($scope);
                                });
                                break;
                            case 1: // no existe
                                alert("Registro No se puede Borrar!");
                                break;
                        };
                    });
            };                    

    };
        
        function reset($scope){
            $scope.current = new Usuario("","");
            $scope.mode=null;
            $scope.selectedRow = null;            
        }
        </script>
    </body>
</html>
