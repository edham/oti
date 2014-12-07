/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import COM.clsGestor;
import entidades.clsProductoEmpresa;
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
@WebServlet(name = "listarProductoEmpresa", urlPatterns = {"/listarProductoEmpresa"})
public class listarProductoEmpresa extends HttpServlet {

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
            
        JSONObject objListaProductoEmpresaJSON=new JSONObject();     
        if(request.getParameter("idEmpresa") != null && request.getParameter("idEmpresa") != "")
        {
            List<clsProductoEmpresa> lista=clsGestor.ListarProductoEmpresa(Integer.parseInt(request.getParameter("idEmpresa")));
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
        }
        else
               objListaProductoEmpresaJSON.put("error",2);      
              
           out.println(objListaProductoEmpresaJSON);
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
