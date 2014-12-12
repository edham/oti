/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidades.clsItemMovimiento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsItemMovimientoDAO {
   
     public static List<clsItemMovimiento> Listar (int idEmpresa) throws Exception
    {
        List<clsItemMovimiento> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Item_Movimiento "+idEmpresa;

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista=new ArrayList<clsItemMovimiento>();
                
                clsItemMovimiento entidad = new clsItemMovimiento();
                entidad.setInt_id_item_movimiento(dr.getInt(1));
                entidad.setInt_id_movimiento(dr.getInt(2));
                entidad.setInt_numero_couta(dr.getInt(3));
                entidad.setDou_pago(dr.getDouble(4));
                entidad.setDat_fecha_creacion(dr.getTimestamp(5));
                
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
