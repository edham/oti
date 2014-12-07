/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import entidades.clsDistrito;
import entidades.clsEmpresa;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Toditos
 */
public class clsEmpresaDAO {

      
        public static clsEmpresa login (String usuario,String clave) throws Exception
    {
        clsEmpresa objUsuario = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Login_Empresa '"+usuario+"','"+clave+"'";

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {
                objUsuario = new clsEmpresa();
                objUsuario.setInt_id_empresa(dr.getInt(1));
                objUsuario.setStr_nombre_usuario(dr.getString(2));
                objUsuario.setStr_apellidos_usuario(dr.getString(3));
                objUsuario.setStr_email(dr.getString(4));
                objUsuario.setStr_telefono(dr.getString(5));
                objUsuario.setStr_celular(dr.getString(6));
                objUsuario.setStr_usuario(dr.getString(7));
                objUsuario.setStr_clave(dr.getString(8));
                objUsuario.setStr_razon_social(dr.getString(9));
                objUsuario.setStr_ruc(dr.getString(10));
                objUsuario.setStr_direccion(dr.getString(11));
                objUsuario.setInt_estado(dr.getInt(12));
                objUsuario.setBool_empresa(dr.getBoolean(13));
                objUsuario.setDat_fecha_creacion(dr.getTimestamp(14));
                objUsuario.setDat_fecha_actualizacion(dr.getTimestamp(15));
                objUsuario.setObjDistrito(new clsDistrito(dr.getInt(16)));
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
