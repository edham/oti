/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import COM.clsGestor;
import entidades.clsDistrito;
import entidades.clsEmpresa;
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
@WebServlet(name = "insertarEmpresa", urlPatterns = {"/insertarEmpresa"})
public class insertarEmpresa extends HttpServlet {

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
           if(request.getParameter("nombre") != null && request.getParameter("nombre") != "" &&
            request.getParameter("apellido") != null && request.getParameter("apellido") != "" &&
            request.getParameter("email") != null && request.getParameter("email") != "" &&
            request.getParameter("telefono") != null && request.getParameter("telefono") != "" &&
            request.getParameter("celular") != null && request.getParameter("celular") != "" &&
            request.getParameter("usuario") != null && request.getParameter("usuario") != "" &&
            request.getParameter("clave") != null && request.getParameter("clave") != "" &&            
            request.getParameter("direccion") != null && request.getParameter("direccion") != "" &&
            request.getParameter("idDistrito") != null && request.getParameter("idDistrito") != "" &&
            request.getParameter("empresa") != null && request.getParameter("empresa") != "")
            {
                clsEmpresa entidad = new clsEmpresa();        
                entidad.setStr_nombre_usuario(request.getParameter("nombre"));
                entidad.setStr_apellidos_usuario(request.getParameter("apellido"));
                entidad.setStr_email(request.getParameter("email"));
                entidad.setStr_telefono(request.getParameter("telefono"));
                entidad.setStr_celular(request.getParameter("celular"));
                entidad.setStr_usuario(request.getParameter("usuario"));
                entidad.setStr_clave(request.getParameter("clave"));
                entidad.setStr_razon_social("");                
                entidad.setStr_ruc("");
                entidad.setStr_direccion(request.getParameter("direccion"));
                entidad.setObjDistrito(new clsDistrito(Integer.parseInt(request.getParameter("idDistrito"))));
                entidad.setBool_empresa(Boolean.parseBoolean(request.getParameter("empresa")));
                
                if(request.getParameter("razon") != null && request.getParameter("razon") != "")
                    entidad.setStr_razon_social(request.getParameter("razon"));       
                if(request.getParameter("ruc") != null && request.getParameter("ruc") != "")
                    entidad.setStr_ruc(request.getParameter("ruc"));
          
                int id=clsGestor.insertarEmpresa(entidad);                
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
