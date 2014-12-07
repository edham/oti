/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import COM.clsGestor;
import entidades.clsEmpresa;
import entidades.clsProducto;
import entidades.clsProductoEmpresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author EdHam
 */
public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           JSONObject obj=new JSONObject();
           if(request.getParameter("usuario") != null && request.getParameter("usuario") != "" &&
            request.getParameter("clave") != null && request.getParameter("clave") != "")
            {
                clsEmpresa objEmpresa=clsGestor.loginUsuario(request.getParameter("usuario"), request.getParameter("clave"));
                
                if(objEmpresa!=null)
                { 
                    obj.put("int_id_empresa",objEmpresa.getInt_id_empresa());
                    obj.put("str_nombre_usuario",objEmpresa.getStr_nombre_usuario());
                    obj.put("str_apellidos_usuario",objEmpresa.getStr_apellidos_usuario());
                    obj.put("str_email",objEmpresa.getStr_email());
                    obj.put("str_telefono",objEmpresa.getStr_telefono());
                    obj.put("str_celular",objEmpresa.getStr_celular());
                    obj.put("str_razon_social",objEmpresa.getStr_razon_social());
                    obj.put("str_ruc",objEmpresa.getStr_ruc());
                    obj.put("str_direccion",objEmpresa.getStr_direccion());
                    obj.put("int_estado",objEmpresa.getInt_estado());
                    obj.put("bool_empresa",objEmpresa.isBool_empresa());
                    obj.put("dat_fecha_creacion",objEmpresa.getDat_fecha_creacion().getTime());
                    obj.put("dat_fecha_actualizacion",objEmpresa.getDat_fecha_actualizacion().getTime());
                    obj.put("int_id_distrito",objEmpresa.getObjDistrito().getInt_id_distrito());                    
                    obj.put("error",0); 
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaProductoJSON">
                    JSONObject objListaProductoJSON=new JSONObject();           
                    List<clsProducto> listaProducto=clsGestor.ListarProducto();
                    if(listaProducto!=null)
                    { 
                        JSONArray listProductoJSON = new JSONArray();
                        for(clsProducto entidad : listaProducto)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_producto",entidad.getInt_id_producto());
                            entidadJSON.put("str_nombre",entidad.getStr_nombre());
                            entidadJSON.put("dat_fecha_creacion",entidad.getDat_fecha_creacion().getTime());
                            entidadJSON.put("dat_fecha_actualizacion",entidad.getDat_fecha_actualizacion().getTime());
                            entidadJSON.put("int_estado",entidad.getInt_estado());

                            entidadJSON.put("int_id_tipo_producto",entidad.getObjTipoProducto().getInt_id_tipo_producto());
                            entidadJSON.put("str_nombre_tipo_producto",entidad.getObjTipoProducto().getStr_nombre());
                            entidadJSON.put("str_detalle_tipo_producto",entidad.getObjTipoProducto().getStr_detalle());
                            entidadJSON.put("bool_estado_tipo_producto",entidad.getObjTipoProducto().isBool_estado());

                            entidadJSON.put("int_id_marca",entidad.getObjMarca().getInt_id_marca());
                            entidadJSON.put("str_nombre_marca",entidad.getObjMarca().getStr_nombre());
                            entidadJSON.put("bool_estado_marca",entidad.getObjMarca().isBool_estado());
                            listProductoJSON.add(entidadJSON);
                        }


                        objListaProductoJSON.put("lista",listProductoJSON);
                        objListaProductoJSON.put("error",0);
                    }
                    else
                         objListaProductoJSON.put("error",1);    
                    
                    obj.put("listaProducto",objListaProductoJSON); 
                    
                    // </editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaProductoEmpresaJSON">
                    JSONObject objListaProductoEmpresaJSON=new JSONObject();   
                    List<clsProductoEmpresa> lista=clsGestor.ListarProductoEmpresa(objEmpresa.getInt_id_empresa());
                    if(lista!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsProductoEmpresa entidad : lista)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_producto_empresa",entidad.getInt_id_producto_empresa());
                            entidadJSON.put("dou_precio",entidad.getDou_precio());
                            entidadJSON.put("int_id_producto",entidad.getObjProducto().getInt_id_producto());
                            listJSON.add(entidadJSON);
                        }

                        objListaProductoEmpresaJSON.put("lista",listJSON);
                        objListaProductoEmpresaJSON.put("error",0);
                    }
                    else
                         objListaProductoEmpresaJSON.put("error",1);
                    
                    obj.put("listaProductoEmpresa",objListaProductoEmpresaJSON); 
                    // </editor-fold>
                     
                     
                }
                else
                     obj.put("error",1);
                   
            }
           else
               obj.put("error",2);
              
           out.println(obj);
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
