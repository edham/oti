/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import COM.clsGestor;
import entidades.clsAgente;
import entidades.clsAgenteServicio;
import entidades.clsCotizacion;
import entidades.clsDetalleCotizacion;
import entidades.clsDetalleProforma;
import entidades.clsEmpresa;
import entidades.clsItemMovimiento;
import entidades.clsMovimiento;
import entidades.clsProducto;
import entidades.clsProductoEmpresa;
import entidades.clsProforma;
import entidades.clsServicio;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author EdHam
 */
@WebServlet(name = "cargar", urlPatterns = {"/cargar"})
public class cargar extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           JSONObject obj=new JSONObject();
           if(request.getParameter("idEmpresa") != null && request.getParameter("idEmpresa") != "" )
            {
                    int idEmpresa=Integer.parseInt(request.getParameter("idEmpresa"));
                    
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
                    List<clsProductoEmpresa> listaProductoEmpresa=clsGestor.ListarProductoEmpresa(idEmpresa);
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
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaMovimientoJSON">
                    JSONObject objListaMovimientoJSON=new JSONObject();   
                    List<clsMovimiento>listaMovimiento=clsGestor.ListarMovimiento(idEmpresa);
                    if(listaMovimiento!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsMovimiento entidad : listaMovimiento)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_movimiento",entidad.getInt_id_movimiento());
                            entidadJSON.put("int_id_tipo_movimiento",entidad.getObjTipoMovimiento().getInt_id_tipo_movimiento());
                            entidadJSON.put("int_id_servicio",entidad.getObjServicio().getInt_id_servicio());
                            entidadJSON.put("bool_ingreso",entidad.isBool_ingreso());
                            entidadJSON.put("str_detalle",entidad.getStr_detalle());
                            entidadJSON.put("dou_total",entidad.getDou_total());
                            entidadJSON.put("dou_total_acumulado",entidad.getDou_total_acumulado());
                            entidadJSON.put("int_couta_total",entidad.getInt_couta_total());
                            entidadJSON.put("int_couta_ingresadas",entidad.getInt_couta_ingresadas());
                            entidadJSON.put("int_estado",entidad.getInt_estado());
                            entidadJSON.put("int_alerta_inicio",entidad.getInt_alerta_inicio());
                            entidadJSON.put("int_repeticion_alerta",entidad.getInt_repeticion_alerta());
                            entidadJSON.put("dat_fecha_creacion",entidad.getDat_fecha_creacion().getTime());
                            entidadJSON.put("dat_fecha_movimiento",entidad.getDat_fecha_movimiento().getTime());
                            
                            listJSON.add(entidadJSON);
                        }

                        objListaMovimientoJSON.put("lista",listJSON);
                        objListaMovimientoJSON.put("error",0);
                    }
                    else
                         objListaMovimientoJSON.put("error",1);
                    
                    obj.put("listaMovimiento",objListaMovimientoJSON); 
                    // </editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaItemMovimientoJSON">
                    JSONObject objListaItemMovimientoJSON=new JSONObject();   
                    List<clsItemMovimiento>listaItemMovimiento=clsGestor.ListarItemMovimiento(idEmpresa);
                    if(listaItemMovimiento!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsItemMovimiento entidad : listaItemMovimiento)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_item_movimiento",entidad.getInt_id_item_movimiento());
                            entidadJSON.put("int_id_movimiento",entidad.getInt_id_movimiento());
                            entidadJSON.put("int_numero_couta",entidad.getInt_numero_couta());
                            entidadJSON.put("dou_pago",entidad.getDou_pago());
                            entidadJSON.put("dat_fecha_creacion",entidad.getDat_fecha_creacion().getTime());
                            
                            listJSON.add(entidadJSON);
                        }

                        objListaItemMovimientoJSON.put("lista",listJSON);
                        objListaItemMovimientoJSON.put("error",0);
                    }
                    else
                         objListaItemMovimientoJSON.put("error",1);
                    
                    obj.put("listaItemMovimiento",objListaItemMovimientoJSON); 
                    // </editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaProformaEmpresaJSON">
                    JSONObject objListaProformaEmpresaJSON=new JSONObject();   
                    List<clsProforma>listaProformaEmpresa=clsGestor.ListarEmpresaProforma(idEmpresa);
                    if(listaProformaEmpresa!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsProforma entidad : listaProformaEmpresa)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_proforma",entidad.getInt_id_proforma());
                            entidadJSON.put("dat_fecha_creacion",entidad.getDat_fecha_creacion().getTime());
                            entidadJSON.put("dat_fecha_finalizacion",entidad.getDat_fecha_finalizacion().getTime());
                            entidadJSON.put("int_estado",entidad.getInt_estado());
                            
                            listJSON.add(entidadJSON);
                        }

                        objListaProformaEmpresaJSON.put("lista",listJSON);
                        objListaProformaEmpresaJSON.put("error",0);
                    }
                    else
                         objListaProformaEmpresaJSON.put("error",1);
                    
                    obj.put("listaProformaEmpresa",objListaProformaEmpresaJSON); 
                    // </editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaProformaJSON">
                    JSONObject objListaProformaJSON=new JSONObject();   
                    List<clsProforma>listaProforma=clsGestor.ListarProforma(idEmpresa);
                    if(listaProforma!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsProforma entidad : listaProforma)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_proforma",entidad.getInt_id_proforma());
                            entidadJSON.put("dat_fecha_creacion",entidad.getDat_fecha_creacion().getTime());
                            entidadJSON.put("dat_fecha_finalizacion",entidad.getDat_fecha_finalizacion().getTime());
                            entidadJSON.put("int_estado",entidad.getInt_estado());
                            entidadJSON.put("str_nombre_usuario",entidad.getObjEmpresa().getStr_nombre_usuario());
                            entidadJSON.put("str_apellidos_usuario",entidad.getObjEmpresa().getStr_apellidos_usuario());
                            entidadJSON.put("str_telefono",entidad.getObjEmpresa().getStr_telefono());
                            entidadJSON.put("bool_empresa",entidad.getObjEmpresa().isBool_empresa());
                            entidadJSON.put("str_razon_social",entidad.getObjEmpresa().getStr_razon_social());
                            entidadJSON.put("str_ruc",entidad.getObjEmpresa().getStr_ruc());
                            entidadJSON.put("str_direccion",entidad.getObjEmpresa().getStr_direccion());
                            listJSON.add(entidadJSON);
                        }

                        objListaProformaJSON.put("lista",listJSON);
                        objListaProformaJSON.put("error",0);
                    }
                    else
                         objListaProformaJSON.put("error",1);
                    
                    obj.put("listaProforma",objListaProformaJSON); 
                    // </editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaDetalleProformaJSON">
                    JSONObject objListaDetalleProformaJSON=new JSONObject();   
                    List<clsDetalleProforma>listaDetalleProforma=clsGestor.ListarDetalleProforma();
                    if(listaDetalleProforma!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsDetalleProforma entidad : listaDetalleProforma)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_detalle_proforma",entidad.getInt_id_detalle_proforma());
                            entidadJSON.put("int_id_proforma",entidad.getInt_id_proforma());
                            entidadJSON.put("int_id_producto",entidad.getObjProducto().getInt_id_producto());
                            entidadJSON.put("int_cantidad",entidad.getInt_cantidad());
                            entidadJSON.put("int_estado",entidad.getInt_estado());
                            listJSON.add(entidadJSON);
                        }

                        objListaDetalleProformaJSON.put("lista",listJSON);
                        objListaDetalleProformaJSON.put("error",0);
                    }
                    else
                         objListaDetalleProformaJSON.put("error",1);
                    
                    obj.put("listaDetalleProforma",objListaDetalleProformaJSON); 
                    // </editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaCotizacionJSON">
                    JSONObject objListaCotizacionJSON=new JSONObject();   
                    List<clsCotizacion>listaCotizacion=clsGestor.ListarCotizacion(idEmpresa);
                    if(listaCotizacion!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsCotizacion entidad : listaCotizacion)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_cotizacion",entidad.getInt_id_cotizacion());
                            entidadJSON.put("int_id_proforma",entidad.getObjProforma().getInt_id_proforma());
                            entidadJSON.put("dat_fecha_creacion",entidad.getDat_fecha_creacion().getTime());
                            entidadJSON.put("dat_fecha_finalizacion",entidad.getDat_fecha_finalizacion().getTime());
                            entidadJSON.put("int_estado",entidad.getInt_estado());
                            entidadJSON.put("str_nombre_usuario",entidad.getObjEmpresa().getStr_nombre_usuario());
                            entidadJSON.put("str_apellidos_usuario",entidad.getObjEmpresa().getStr_apellidos_usuario());
                            entidadJSON.put("str_telefono",entidad.getObjEmpresa().getStr_telefono());
                            entidadJSON.put("bool_empresa",entidad.getObjEmpresa().isBool_empresa());
                            entidadJSON.put("str_razon_social",entidad.getObjEmpresa().getStr_razon_social());
                            entidadJSON.put("str_ruc",entidad.getObjEmpresa().getStr_ruc());
                            entidadJSON.put("str_direccion",entidad.getObjEmpresa().getStr_direccion());
                            listJSON.add(entidadJSON);
                        }

                        objListaCotizacionJSON.put("lista",listJSON);
                        objListaCotizacionJSON.put("error",0);
                    }
                    else
                         objListaCotizacionJSON.put("error",1);
                    
                    obj.put("listaCotizacion",objListaCotizacionJSON); 
                    // </editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="objListaDetalleCotizacionJSON">
                    JSONObject objListaDetalleCotizacionJSON=new JSONObject();   
                    List<clsDetalleCotizacion>listaDetalleCotizacion=clsGestor.ListarDetalleCotizacion();
                    if(listaDetalleCotizacion!=null)
                    { 
                        JSONArray listJSON = new JSONArray();
                        for(clsDetalleCotizacion entidad : listaDetalleCotizacion)
                        {
                            JSONObject entidadJSON=new JSONObject();
                            entidadJSON.put("int_id_detalle_cotizacion",entidad.getInt_id_detalle_cotizacion());
                            entidadJSON.put("int_id_cotizacion",entidad.getInt_id_cotizacion());
                            entidadJSON.put("int_id_producto",entidad.getObjProducto().getInt_id_producto());
                            entidadJSON.put("int_cantidad",entidad.getInt_cantidad());
                            entidadJSON.put("dou_costo",entidad.getDou_costo());
                            entidadJSON.put("int_estado",entidad.getInt_estado());
                            listJSON.add(entidadJSON);
                        }

                        objListaDetalleCotizacionJSON.put("lista",listJSON);
                        objListaDetalleCotizacionJSON.put("error",0);
                    }
                    else
                         objListaDetalleCotizacionJSON.put("error",1);
                    
                    obj.put("listaDetalleCotizacion",objListaDetalleCotizacionJSON); 
                    // </editor-fold>
                     
                    obj.put("error",0); 
            }
           else
               obj.put("error",1);
              
           out.println(obj);
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
