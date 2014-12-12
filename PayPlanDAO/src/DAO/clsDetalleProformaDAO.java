/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidades.clsDetalleProforma;
import entidades.clsProducto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsDetalleProformaDAO {
    
    public  static int insertar(clsDetalleProforma entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement  stmt = null;
        try {
            
           String sql="exec SP_Insertar_Detalle_Proforma ?,?,?";
           
            conn = ConexionDAO.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,entidad.getInt_id_proforma());
            stmt.setInt(2,entidad.getObjProducto().getInt_id_producto());
            stmt.setInt(3,entidad.getInt_cantidad());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next()){
                rpta=rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception("Insertar"+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return rpta;
    } 
    
     public static List<clsDetalleProforma> Listar () throws Exception
    {
        List<clsDetalleProforma> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Detalle_Proforma ";

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista=new ArrayList<clsDetalleProforma>();
                
                clsDetalleProforma entidad = new clsDetalleProforma();
                entidad.setInt_id_detalle_proforma(dr.getInt(1));
                entidad.setInt_id_proforma(dr.getInt(2));
                entidad.setObjProducto(new clsProducto(dr.getInt(3)));
                entidad.setInt_cantidad(dr.getInt(4));
                entidad.setInt_estado(dr.getInt(5));
                
                lista.add(entidad);
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
