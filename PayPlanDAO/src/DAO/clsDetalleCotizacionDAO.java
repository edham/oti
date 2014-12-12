/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidades.clsDetalleCotizacion;
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
public class clsDetalleCotizacionDAO {
    
    public  static int insertar(clsDetalleCotizacion entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement  stmt = null;
        try {
            
           String sql="exec SP_Insertar_Detalle_Cotizacion ?,?,?,?";
           
            conn = ConexionDAO.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,entidad.getInt_id_cotizacion());
            stmt.setInt(2,entidad.getObjProducto().getInt_id_producto());
            stmt.setInt(3,entidad.getInt_cantidad());
            stmt.setDouble(4,entidad.getDou_costo());
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
    
     public static List<clsDetalleCotizacion> Listar () throws Exception
    {
        List<clsDetalleCotizacion> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Detalle_Cotizacion ";

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista=new ArrayList<clsDetalleCotizacion>();
                
                clsDetalleCotizacion entidad = new clsDetalleCotizacion();
                entidad.setInt_id_detalle_cotizacion(dr.getInt(1));
                entidad.setInt_id_cotizacion(dr.getInt(2));
                entidad.setObjProducto(new clsProducto(dr.getInt(3)));
                entidad.setInt_cantidad(dr.getInt(4));
                entidad.setDou_costo(dr.getDouble(5));
                entidad.setInt_estado(dr.getInt(6));
                
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
