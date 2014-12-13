/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

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
public class clsProformaDAO {
    public  static int insertar(int idEmpresa) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement  stmt = null;
        try {
            
           String sql="exec SP_Insertar_Proforma ?";
           
            conn = ConexionDAO.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,idEmpresa);
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
    
     public static List<clsProforma> ListarEmpresa (int idEmpresa) throws Exception
    {
        List<clsProforma> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Proforma_Empresa "+idEmpresa;

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista=new ArrayList<clsProforma>();
                
                
                clsProforma entidad = new clsProforma();
                entidad.setInt_id_proforma(dr.getInt(1));
                entidad.setObjEmpresa(new clsEmpresa(dr.getInt(2)));
                entidad.setDat_fecha_creacion(dr.getTimestamp(3));
                entidad.setDat_fecha_finalizacion(dr.getTimestamp(4));
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
     
      public static List<clsProforma> Listar (int idEmpresa) throws Exception
    {
        List<clsProforma> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Proforma "+idEmpresa;

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista=new ArrayList<clsProforma>();
                
                clsEmpresa objEmpresa = new clsEmpresa();
                objEmpresa.setInt_id_empresa(dr.getInt(5));
                objEmpresa.setStr_nombre_usuario(dr.getString(6));
                objEmpresa.setStr_apellidos_usuario(dr.getString(7));
                objEmpresa.setStr_telefono(dr.getString(8));
                objEmpresa.setBool_empresa(dr.getBoolean(9));
                objEmpresa.setStr_razon_social(dr.getString(10));
                objEmpresa.setStr_ruc(dr.getString(11));
                objEmpresa.setStr_direccion(dr.getString(12));
                
                clsProforma entidad = new clsProforma();
                entidad.setInt_id_proforma(dr.getInt(1));                
                entidad.setDat_fecha_creacion(dr.getTimestamp(2));
                entidad.setDat_fecha_finalizacion(dr.getTimestamp(3));
                entidad.setInt_estado(dr.getInt(4));
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
