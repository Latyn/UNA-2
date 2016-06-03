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
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-lg-offset-4">
                    <form class="form-signin text-center">
                        <h2 class="form-signin-heading">Proyecto Clinica</h2>
                        
                        <label for="inputEmail" class="sr-only">Correo</label>
                        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                        <label for="inputPassword" class="sr-only ">Contraseña</label>
                        <input type="password" id="inputPassword" class="form-control MargingTop" placeholder="Password" required>
                        
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="remember-me"> Recordar contraseña
                            </label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
                    </form>
                </div>
            </div>
        </div> <!-- /container -->
    </body>
</html>
