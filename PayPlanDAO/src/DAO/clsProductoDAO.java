/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidades.clsProducto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author EdHam
 */
public class clsProductoDAO {
          public static clsProducto Listar () throws Exception
    {
        clsProducto objUsuario = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Producto";

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                objUsuario = new clsProducto();
                objUsuario.setInt_id_usuario(dr.getInt(1));
                objUsuario.setStr_nombre(dr.getString(2));
                objUsuario.setStr_apellidos(dr.getString(3));
                objUsuario.setStr_email(dr.getString(4));
                objUsuario.setStr_telefono(dr.getString(5));
                objUsuario.setStr_usuario(dr.getString(6));
                objUsuario.setStr_clave(dr.getString(7));
                objUsuario.setInt_estado(dr.getInt(8));
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
