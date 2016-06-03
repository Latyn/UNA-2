/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import service.Jsonable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Usuario;
import service.Model;

/**
 *
 * @author Latyn
 */
//se adicionan los urls de las vistas
@WebServlet(name = "ControllerServlet",
            loadOnStartup = 1, 
            urlPatterns = {"/ControllerServlet","/Medicos", "/Expediente","/Administradores","/ListarMedicos","/UsuarioListSearch","/UsuarioListAll"})
public class ControllerServlet extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            response.setContentType("text/xml");
            RuntimeTypeAdapterFactory<Jsonable> rta = RuntimeTypeAdapterFactory.of(Jsonable.class,"_class")
             .registerSubtype(Usuario.class,"Usuario");
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(rta).setDateFormat("dd/MM/yyyy").create();
            String json;
            String accion = request.getParameter("action");
            List<Usuario> usuarios;
            
            switch (accion) {
                case "UsuarioListAll":
                    usuarios = Model.usuariosConsultarTodos();
                    json = gson.toJson(usuarios); 
                    out.write(json);
                    break;
                case "UsuarioListSearch":
                    String criteria;
                    criteria = request.getParameter("criteria");
                    usuarios = Model.usuarioListSearch(criteria);
                    json = gson.toJson(usuarios); 
                    out.write(json);
                break;
                case "UsuarioAdd":
                    json = request.getParameter("product");
                    Usuario productoJava= gson.fromJson(json, Usuario.class);
                    int added = Model.UsuarioAdd(productoJava);
                    if (productoJava.getCategoria()!=null && added == 1) {
                         added = Model.UsuarioCategoriaAdd(productoJava.getCodigo(),productoJava.getCategoria());
                    }
                    
                    if(added==1){
                        json = gson.toJson(0); // ok
                    }
                    else{
                        json = gson.toJson(1); // ya existe
                    }
                    out.write(json);   
                break;
                case "UsuarioDelete":
                    json = request.getParameter("product");
                    Usuario usuarioJava= gson.fromJson(json, Usuario.class);
                    int deleted = Model.UsuarioDelete(usuarioJava);
                    
                    if(deleted==1){
                        json = gson.toJson(0); // ok
                    }
                    else{
                        json = gson.toJson(1); // ya existe
                    }
                    out.write(json); 
                break;
                case "UsuarioUpdate":
                    json = request.getParameter("product");
                    Usuario updateUsuario= gson.fromJson(json, Usuario.class);
                    int updated = Model.UsuarioUpdate(updateUsuario);
                    
                    if(updated==1){
                        json = gson.toJson(0); // ok
                    }
                    else{
                        json = gson.toJson(1); // ya existe
                    }
                    out.write(json); 
                break;
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
        
       String userPath = request.getServletPath();

        // if category page is requested
        if (userPath.equals("/Medicos")) {
            // TODO: Implement category request

        // if cart page is requested
        } else if (userPath.equals("/Administradores")) {
            // TODO: Implement cart page request

        // if checkout page is requested
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
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
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userPath = request.getServletPath();

        // if addToCart action is called
        if (userPath.equals("/ListarMedicos")) {
            // TODO: Implement add product to cart action

        // if updateCart action is called
        } else if (userPath.equals("/ListarAdministradores")) {
            // TODO: Implement update cart action

        // if purchase action is called
        } else if (userPath.equals("/ListarExpedientes")) {
            // TODO: Implement purchase action

            // userPath = "/confirmation";
        }else if (userPath.equals("/ClinicaJava/ControllerServlet?action=UsuarioListSearch")){
           try {
               processRequest(request, response);
           } catch (Exception ex) {
               Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
