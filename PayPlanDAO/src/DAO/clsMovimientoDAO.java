/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidades.clsEmpresa;
import entidades.clsMovimiento;
import entidades.clsServicio;
import entidades.clsTipoMovimiento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsMovimientoDAO {
    public  static int insertar(clsMovimiento entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement  stmt = null;
        try {
            
           String sql="exec SP_Insertar_Movimiento ?,?,?,?,?,?,?,?,?,?";
           
            conn = ConexionDAO.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjTipoMovimiento().getInt_id_tipo_movimiento());
            stmt.setInt(2, entidad.getObjServicio().getInt_id_servicio());
            stmt.setInt(3, entidad.getObjEmpresa().getInt_id_empresa());
            stmt.setBoolean(4, entidad.isBool_ingreso());
            stmt.setString(5, entidad.getStr_detalle());
            stmt.setDouble(6, entidad.getDou_total());
            stmt.setDouble(7, entidad.getInt_couta_total());
            stmt.setInt(8, entidad.getInt_alerta_inicio());
            stmt.setInt(9, entidad.getInt_repeticion_alerta());
            stmt.setTimestamp(10, new Timestamp(entidad.getDat_fecha_movimiento().getTime()));
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
     public static List<clsMovimiento> Listar (int idEmpresa) throws Exception
    {
        List<clsMovimiento> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Movimiento "+idEmpresa;

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista=new ArrayList<clsMovimiento>();
                
                
                clsMovimiento entidad = new clsMovimiento();
                entidad.setInt_id_movimiento(dr.getInt(1));
                entidad.setObjTipoMovimiento(new clsTipoMovimiento(dr.getInt(2)));
                entidad.setObjServicio(new clsServicio(dr.getInt(3)));
                entidad.setObjEmpresa(new clsEmpresa(dr.getInt(4)));
                entidad.setBool_ingreso(dr.getBoolean(5));
                entidad.setStr_detalle(dr.getString(6));
                entidad.setDou_total(dr.getDouble(7));
                entidad.setDou_total_acumulado(dr.getDouble(8));
                entidad.setInt_couta_total(dr.getInt(9));
                entidad.setInt_couta_ingresadas(dr.getInt(10));
                entidad.setInt_estado(dr.getInt(11));
                entidad.setInt_alerta_inicio(dr.getInt(12));
                entidad.setInt_repeticion_alerta(dr.getInt(13));
                entidad.setDat_fecha_movimiento(dr.getTimestamp(14));
                entidad.setDat_fecha_creacion(dr.getTimestamp(15));
                
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
