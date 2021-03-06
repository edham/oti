/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import COM.clsGestor;
import entidades.clsDetalleProforma;
import entidades.clsProducto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author EdHam
 */
@WebServlet(name = "insertarDetalleProforma", urlPatterns = {"/insertarDetalleProforma"})
public class insertarDetalleProforma extends HttpServlet {

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
           if(request.getParameter("idProforma") != null && request.getParameter("idProforma") != "" &&
           request.getParameter("idProducto") != null && request.getParameter("idProducto") != "" &&
           request.getParameter("cantidad") != null && request.getParameter("cantidad") != "")
            {
                clsDetalleProforma entidad = new clsDetalleProforma();
                entidad.setInt_id_proforma(Integer.parseInt(request.getParameter("idProforma")));
                entidad.setObjProducto(new clsProducto(Integer.parseInt(request.getParameter("idProducto"))));
                entidad.setInt_cantidad(Integer.parseInt(request.getParameter("cantidad")));
                int id=clsGestor.insertarDetalleProforma(entidad);                
                obj.put("id",id);
            }
            else
               obj.put("id",-1);
              
           out.println(obj);
        } catch (Exception ex) { }
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
