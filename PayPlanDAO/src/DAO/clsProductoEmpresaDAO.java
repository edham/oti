/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidades.clsEmpresa;
import entidades.clsProducto;
import entidades.clsProductoEmpresa;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsProductoEmpresaDAO {
    
     public static List<clsProductoEmpresa> Listar (int idEmpresa) throws Exception
    {
        List<clsProductoEmpresa> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Producto_Empresa "+idEmpresa;

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista=new ArrayList<clsProductoEmpresa>();
               
                
                clsProductoEmpresa entidad = new clsProductoEmpresa();
                entidad.setInt_id_producto_empresa(dr.getInt(1));
                entidad.setObjProducto(new clsProducto(dr.getInt(2)));
                entidad.setObjEmpresa(new clsEmpresa(dr.getInt(3)));
                entidad.setDou_precio(dr.getDouble(4));
                entidad.setInt_estado(dr.getInt(5));
                
                
                lista.add(entidad);
            }

        } catch (Exception e) {
            throw new Exception("Listar "+e.getMessage(), e);
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
     
      public static int insertar (clsProductoEmpresa entidad) throws Exception
    {
        int rpta=-2;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Insertar_Producto_Empresa "
                    +entidad.getInt_id_producto_empresa()+","
                    +entidad.getObjProducto().getInt_id_producto()+","
                    +entidad.getObjEmpresa().getInt_id_empresa()+","
                    +entidad.getDou_precio()+","+entidad.getInt_estado();
            
            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
                rpta=dr.getInt(1);

        } catch (Exception e) {
            throw new Exception("Listar "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
}
