/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import entidades.clsUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Toditos
 */
public class clsUsuarioDAO {

      
        public static clsUsuario login (String usuario,String clave) throws Exception
    {
        clsUsuario objUsuario = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT id_usuario,nombre,apellidos,email,telefono,usuario,clave,estado,"
                    + "fecha_creacion FROM usuario where usuario='"+usuario+"' and clave='"+clave+"'";

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {
                objUsuario = new clsUsuario();
                objUsuario.setInt_id_usuario(dr.getInt(1));
                objUsuario.setStr_nombre(dr.getString(2));
                objUsuario.setStr_apellidos(dr.getString(3));
                objUsuario.setStr_email(dr.getString(4));
                objUsuario.setFat_fecha_creacion(dr.getTimestamp(9));
            }

        } catch (Exception e) {
            throw new Exception("Listar Distrito "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return objUsuario;
    }

      
    
}
