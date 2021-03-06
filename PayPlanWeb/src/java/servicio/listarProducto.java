/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import COM.clsGestor;
import entidades.clsProducto;
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
@WebServlet(name = "listarProducto", urlPatterns = {"/listarProducto"})
public class listarProducto extends HttpServlet {

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
            
           JSONObject objProductoJSON=new JSONObject();           
            List<clsProducto> lista=clsGestor.ListarProducto();

            if(lista!=null)
            { 
                JSONArray listJSON = new JSONArray();
                for(clsProducto entidad : lista)
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
                    listJSON.add(entidadJSON);
                }
               
                
                objProductoJSON.put("lista",listJSON);
                objProductoJSON.put("error",0);
            }
            else
                 objProductoJSON.put("error",1);
                   
          
              
           out.println(objProductoJSON);
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
