/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import COM.clsGestor;
import entidades.clsAgente;
import entidades.clsAgenteServicio;
import entidades.clsEmpresa;
import entidades.clsProducto;
import entidades.clsProductoEmpresa;
import entidades.clsServicio;
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
                    List<clsProductoEmpresa> listaProductoEmpresa=clsGestor.ListarProductoEmpresa(objEmpresa.getInt_id_empresa());
                    if(listaProductoEmpresa!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsProductoEmpresa entidad : listaProductoEmpresa)
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
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaAgenteJSON">
                    JSONObject objListaAgenteJSON=new JSONObject();   
                    List<clsAgente> listaAgente=clsGestor.ListarAgente();
                    if(listaAgente!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsAgente entidad : listaAgente)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_agente",entidad.getInt_id_agente());
                            entidadJSON.put("str_nombre",entidad.getStr_nombre());
                            entidadJSON.put("dou_latitud",entidad.getDou_latitud());
                            entidadJSON.put("dou_longitud",entidad.getDou_longitud());
                            entidadJSON.put("str_nombre_encargado",entidad.getStr_nombre_encargado());
                            entidadJSON.put("str_telefono",entidad.getStr_telefono());
                            entidadJSON.put("str_direccion",entidad.getStr_direccion());
                            entidadJSON.put("dat_hora_inicio",entidad.getDat_hora_inicio().getTime());
                            entidadJSON.put("dat_hora_fin",entidad.getDat_hora_fin().getTime());
                            entidadJSON.put("int_id_distrito",entidad.getObjDistrito().getInt_id_distrito());
                            entidadJSON.put("int_id_banco",entidad.getObjBanco().getInt_id_banco());
                            entidadJSON.put("str_nombre_banco",entidad.getObjBanco().getStr_nombre());
                            listJSON.add(entidadJSON);
                        }

                        objListaAgenteJSON.put("lista",listJSON);
                        objListaAgenteJSON.put("error",0);
                    }
                    else
                         objListaAgenteJSON.put("error",1);
                    
                    obj.put("listaAgente",objListaAgenteJSON); 
                    // </editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaServicioJSON">
                    JSONObject objListaServicioJSON=new JSONObject();   
                    List<clsServicio >listaServicio=clsGestor.ListarServicio();
                    if(listaServicio!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsServicio entidad : listaServicio)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_servicio",entidad.getInt_id_servicio());
                            entidadJSON.put("str_nombre",entidad.getStr_nombre());
                            listJSON.add(entidadJSON);
                        }

                        objListaServicioJSON.put("lista",listJSON);
                        objListaServicioJSON.put("error",0);
                    }
                    else
                         objListaServicioJSON.put("error",1);
                    
                    obj.put("listaServicio",objListaServicioJSON); 
                    // </editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaAgenteServicioJSON">
                    JSONObject objListaAgenteServicioJSON=new JSONObject();   
                    List<clsAgenteServicio >listaAgenteServicio=clsGestor.ListarAgenteServicio();
                    if(listaAgenteServicio!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsAgenteServicio entidad : listaAgenteServicio)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_agente_servicio",entidad.getInt_agente_servicio());
                            entidadJSON.put("int_id_agente",entidad.getInt_id_agente());
                            entidadJSON.put("int_id_servicio",entidad.getObjServicio().getInt_id_servicio());
                            listJSON.add(entidadJSON);
                        }

                        objListaAgenteServicioJSON.put("lista",listJSON);
                        objListaAgenteServicioJSON.put("error",0);
                    }
                    else
                         objListaAgenteServicioJSON.put("error",1);
                    
                    obj.put("listaAgenteServicio",objListaAgenteServicioJSON); 
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
