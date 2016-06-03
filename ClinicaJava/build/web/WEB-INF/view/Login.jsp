<%-- 
    Document   : Login
    Created on : Jun 3, 2016, 2:48:50 AM
    Author     : Latyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="Imports.jspf" %>
    </head>
    <body ng-app ng-controller="ManagerAdministradoresController">
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-lg-offset-4">
                    <form class="form-signin text-center" ng-show="mode == 'log'">
                        <h2 class="form-signin-heading">Proyecto Clinica</h2>

                        <label for="inputEmail" class="sr-only">Correo</label>
                        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus ng-model="user.correo">
                        <label for="inputPassword" class="sr-only ">Contraseña</label>
                        <input type="password" id="inputPassword" class="form-control MargingTop" placeholder="Password" required ng-model="user.clave">

                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="remember-me"> Recordar contraseña
                            </label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit" ng-click="search();">Ingresar</button>
                    </form>
                </div>
                <div class="col-sm-12 text-center">
                    <div class="jumbotron" ng-show="valido == 'true'">
                        <div class="container">
                            <h1 ng-model="user.nombre"></h1>
                            <p>Bienvenido al projecto Clinica U</p>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- /container -->
        <script>
                    function ManagerAdministradoresController($scope) {

                        $scope.user = new Usuario("", "", "", "", "", "", "");
                        $scope.mode = 'log';
                        $scope.valido = 'false';

                        if (sessionStorage.getItem('role')!= null) {
                            $scope.mode = sessionStorage.getItem('role');
                        }

                        $scope.search = function (e) {
                            Proxy.login($scope.user,
                                    function (result) {
                                        $scope.$apply(function () {
                                            $scope.user = result;
                                        });
                                    });  

                                if ($scope.user.categoria === '0') {
                                    $scope.valido = 'true';
                                    $scope.mode = 'adm';
                                    sessionStorage.setItem("role", "adm");
                                }
                                
                                if ($scope.user.categoria === '1') {
                                    $scope.valido = 'true';
                                    $scope.mode = 'med';
                                    sessionStorage.setItem("role", "med");
                                }
                                
                                if ($scope.user.categoria === '2') {
                                    $scope.valido = 'true';
                                    $scope.mode = 'exp';
                                    sessionStorage.setItem("role", "exp");
                                }
                        };
                    }
        </script>
    </body>
</html>
