/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import Database.Database;

/**
 *
 * @author jsanchez
 */
public class Model {
    static Database usuarios;
    
    static {
        initUsuarios();
    }
    private static void initUsuarios(){
       usuarios= new Database(null, null, null);        
    }

    public static List<Usuario> usuariosConsultarTodos() throws Exception{
       List<Usuario> users;
       users= new ArrayList();
        try {
            String sql="select * "+
                    "from usuario";
            ResultSet rs =  usuarios.executeQuery(sql);
            while (rs.next()) {
                users.add(toUsuario(rs));
            }
        } catch (SQLException ex) {
        }
       return users;
   }
   public static List<Usuario> usuarioListSearch(String criteria) throws Exception{
       List<Usuario> users;
       users= new ArrayList();
        try {
            String sql="select * from usuario p  inner join usuario_categoria pc on pc.usuario = p.codigo inner join categoria c on pc.categoria = c.codigo "+
                       "where p.codigo like '%%%s%%'";
            
            sql=String.format(sql,criteria);
            
            ResultSet rs =  usuarios.executeQuery(sql);
            while (rs.next()) {
                users.add(toUsuario(rs));
            }
        } catch (SQLException ex) {
        }
       return users;
   }
   /*public static List<Producto> productListCategory(int category){
       List<Producto> prods;
       prods= new ArrayList();
        try {
            String sql="select * "+
                    "from producto  p inner join producto_categoria pc on pc.producto=p.codigo "+
                    "where pc.categoria = '%s'";
            sql=String.format(sql,category);
            
            ResultSet rs =  productos.executeQuery(sql);
            while (rs.next()) {
                prods.add(toProduct(rs));
            }
        } catch (SQLException ex) {
        }
       return prods;
   }

   public static int ProductUpdate(Producto product) throws Exception{
            String sql="update Producto "+
                    "set descripcion='%s', precio=%s "+
                    "where codigo='%s'";
            sql=String.format(sql,
                    product.getDescripcion(),
                    product.getPrecio(),
                    product.getCodigo());
            return productos.executeUpdate(sql);
    }

   public static int ProductDelete(Producto product) throws Exception{
            String sql="delete from Producto "+
                    "where codigo='%s'";
            sql=String.format(sql,
                    product.getCodigo());
            return productos.executeUpdate(sql);
    }   
   
   public static int ProductAdd(Producto product) throws Exception{
            String sql="insert into Producto "+
                    "(codigo, descripcion, precio) "+
                    "values ('%s','%s',%s)";
            sql=String.format(sql,
                    product.getCodigo(),                    
                    product.getDescripcion(),
                    product.getPrecio());
            return productos.executeUpdate(sql);
    }
   
   public static Usuario userLogin(Usuario usuario) throws Exception{
        try {
            String sql="select * from "+
                    "Usuario  u  "+
                    "where u.id = '%s' and u.clave='%s'";
            sql=String.format(sql,usuario.id,usuario.clave);
            
            ResultSet rs =  productos.executeQuery(sql);
            if (rs.next()) {
                return toUser(rs);
            }
            else{
                return new Usuario(usuario.id,usuario.clave,0);
            }
        } catch (SQLException ex) {
        }
        return null;
   }
   
   
   public static void productDelete(Producto p){
       
    }

   public static int purchaseConfirm(Compra purchase,List<Producto> products) throws Exception{
    //  return 1;

            String sql="insert into Compra "+
                    "(cliente, fecha, direccion_envio,total,tarjeta,vencimiento) "+
                    "values ('%s','%s','%s',%.2f,'%s','%s')";
            sql=String.format(sql,purchase.getCliente().getId(),
                    new SimpleDateFormat("yyyy-MM-dd").format(purchase.getFecha()),
                    purchase.getDireccion_envio(),
                    purchase.getTotal(),
                    purchase.getTarjeta(),
                    new SimpleDateFormat("yyyy-MM-dd").format(purchase.getVencimiento()));
            ResultSet rs =  productos.executeUpdateWithKeys(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
            else{
                return 0;
            }
    }


public static Cliente clientGet(String id) throws Exception{
    String sql="select * from "+
            "Cliente  c  "+
            "where c.id = '%s'";
    sql=String.format(sql,id);

    ResultSet rs =  productos.executeQuery(sql);
    if (rs.next()) {
        return toClient(rs);
    }
    else{
        throw new Exception("Cliente no existe");
    }
}   


public static  List<Compra> compraConsultarTodos() throws Exception{
       List<Compra> purchs;
       purchs= new ArrayList();
        try {
            String sql="select * "+
                    "from compra  co inner join cliente cl on co.cliente=cl.id "+
                    "order by co.numero";
            ResultSet rs =  productos.executeQuery(sql);
            while (rs.next()) {
                purchs.add(toPurchase(rs));
            }
        } catch (SQLException ex) {
        }
       return purchs;

}
*/                
   private static Usuario toUsuario(ResultSet rs) throws Exception{
        Usuario obj= new Usuario();
        obj.setCodigo(rs.getString("codigo"));
        obj.setClave(rs.getString("clave"));
        obj.setCodigoCategoria(rs.getString("categoria"));
        return obj;
    }
/*
   private static Producto toProduct(ResultSet rs){
        try {
            Producto obj= new Producto();
            obj.codigo=rs.getString("codigo");
            obj.descripcion=rs.getString("descripcion");
            obj.precio=rs.getInt("precio");
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }

   private static Cliente toClient(ResultSet rs) throws Exception{
        Cliente obj= new Cliente();
        obj.setId(rs.getString("id"));
        obj.setNombre(rs.getString("nombre"));
        obj.setCorreo(rs.getString("correo"));
        obj.setDireccion_envio(rs.getString("direccion_envio"));
        obj.setTelefono(rs.getString("telefono"));
        return obj;
    }

   private static Compra toPurchase(ResultSet rs) throws Exception{
        Compra obj= new Compra();
        obj.setNumero(rs.getInt("numero"));
        obj.setFecha(rs.getDate("fecha"));
        obj.setDireccion_envio(rs.getString("direccion_envio"));
        obj.setTotal(rs.getFloat("total"));
        obj.setTarjeta(rs.getString("tarjeta"));
        obj.setVencimiento(rs.getDate("vencimiento"));
        obj.setCliente(toClient(rs));
        return obj;
    }*/
   
}

