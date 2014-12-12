/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidades.clsCotizacion;
import entidades.clsEmpresa;
import entidades.clsProforma;
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
public class clsCotizacionDAO {
    public  static int insertar(int idEmpresa,int idProforma) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement  stmt = null;
        try {
            
           String sql="exec SP_Insertar_Cotizacion ?,?";
           
            conn = ConexionDAO.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,idEmpresa);
            stmt.setInt(2,idProforma);
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
    

      public static List<clsCotizacion> Listar (int idEmpresa) throws Exception
    {
        List<clsCotizacion> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Cotizacion "+idEmpresa;

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista=new ArrayList<clsCotizacion>();
                
                clsEmpresa objEmpresa = new clsEmpresa();
                objEmpresa.setInt_id_empresa(dr.getInt(6));
                objEmpresa.setStr_nombre_usuario(dr.getString(7));
                objEmpresa.setStr_apellidos_usuario(dr.getString(8));
                objEmpresa.setStr_telefono(dr.getString(9));
                objEmpresa.setBool_empresa(dr.getBoolean(10));
                objEmpresa.setStr_razon_social(dr.getString(11));
                objEmpresa.setStr_ruc(dr.getString(12));
                objEmpresa.setStr_direccion(dr.getString(13));
                
                clsCotizacion entidad = new clsCotizacion();
                entidad.setInt_id_cotizacion(dr.getInt(1));   
                entidad.setObjProforma(new clsProforma(dr.getInt(2)));  
                entidad.setDat_fecha_creacion(dr.getTimestamp(3));
                entidad.setDat_fecha_finalizacion(dr.getTimestamp(4));
                entidad.setInt_estado(dr.getInt(5));
                entidad.setObjEmpresa(objEmpresa);
                
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
