/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import COM.clsGestor;
import entidades.clsUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                clsUsuario objUsuario=clsGestor.loginUsuario(request.getParameter("usuario"), request.getParameter("clave"));
                
                if(objUsuario!=null)
                { 
                    obj.put("int_id_usuario",objUsuario.getInt_id_usuario());
                    obj.put("str_nombre",objUsuario.getStr_nombre());
                    obj.put("str_apellidos",objUsuario.getStr_apellidos());
                    obj.put("str_email",objUsuario.getStr_email());
                    obj.put("str_telefono",objUsuario.getStr_telefono());
                    obj.put("int_estado",objUsuario.getInt_estado());
                    obj.put("error",0); 
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
