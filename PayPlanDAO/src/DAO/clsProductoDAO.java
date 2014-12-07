/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidades.clsMarca;
import entidades.clsProducto;
import entidades.clsTipoProducto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsProductoDAO {
     public static List<clsProducto> Listar () throws Exception
    {
        List<clsProducto> lista = null;
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
                if(lista==null)
                    lista=new ArrayList<clsProducto>();
                
                clsTipoProducto objTipoProducto = new clsTipoProducto();
                objTipoProducto.setInt_id_tipo_producto(dr.getInt(6));
                objTipoProducto.setStr_nombre(dr.getString(7));
                objTipoProducto.setStr_detalle(dr.getString(8));
                objTipoProducto.setBool_estado(dr.getBoolean(9));
                
                clsMarca objMarca = new clsMarca();
                objMarca.setInt_id_marca(dr.getInt(10));
                objMarca.setStr_nombre(dr.getString(11));
                objMarca.setBool_estado(dr.getBoolean(12));
                
                clsProducto objProducto = new clsProducto();
                objProducto.setInt_id_producto(dr.getInt(1));
                objProducto.setStr_nombre(dr.getString(2));
                objProducto.setDat_fecha_creacion(dr.getTimestamp(3));
                objProducto.setDat_fecha_actualizacion(dr.getTimestamp(4));
                objProducto.setInt_estado(dr.getInt(5));
                objProducto.setObjTipoProducto(objTipoProducto);
                objProducto.setObjMarca(objMarca);
                
                lista.add(objProducto);
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
        return lista;
    }
}
