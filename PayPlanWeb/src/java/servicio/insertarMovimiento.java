/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import COM.clsGestor;
import entidades.clsEmpresa;
import entidades.clsMovimiento;
import entidades.clsServicio;
import entidades.clsTipoMovimiento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "insertarMovimiento", urlPatterns = {"/insertarMovimiento"})
public class insertarMovimiento extends HttpServlet {

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
           if(request.getParameter("idEmpresa") != null && request.getParameter("idEmpresa") != "" &&
            request.getParameter("idTipoMovimiento") != null && request.getParameter("idTipoMovimiento") != "" &&
            request.getParameter("idServicio") != null && request.getParameter("idServicio") != "" &&
            request.getParameter("fecha") != null && request.getParameter("fecha") != "" &&
            request.getParameter("total") != null && request.getParameter("total") != "" &&
            request.getParameter("couta") != null && request.getParameter("couta") != "" &&
            request.getParameter("detalle") != null && request.getParameter("detalle") != "" &&
            request.getParameter("tipo") != null && request.getParameter("tipo") != "" &&
            request.getParameter("alerta") != null && request.getParameter("alerta") != "" &&
            request.getParameter("repeticion") != null && request.getParameter("repeticion") != "")
            {
                clsMovimiento entidad = new clsMovimiento();        
                entidad.setBool_ingreso(Boolean.parseBoolean(request.getParameter("tipo")));
                entidad.setObjEmpresa(new clsEmpresa(Integer.parseInt(request.getParameter("idEmpresa"))));
                entidad.setObjTipoMovimiento(new clsTipoMovimiento(Integer.parseInt(request.getParameter("idTipoMovimiento"))));
                entidad.setObjServicio(new clsServicio(Integer.parseInt(request.getParameter("idServicio"))));
                entidad.setDat_fecha_movimiento(new Date(Long.parseLong(request.getParameter("fecha"))));
                entidad.setDou_total(Double.parseDouble(request.getParameter("total")));
                entidad.setInt_couta_total(Integer.parseInt(request.getParameter("couta")));
                entidad.setStr_detalle(request.getParameter("detalle"));
                entidad.setInt_alerta_inicio(Integer.parseInt(request.getParameter("alerta")));
                entidad.setInt_repeticion_alerta(Integer.parseInt(request.getParameter("repeticion")));
                int id=clsGestor.insertarMovimiento(entidad);                
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
