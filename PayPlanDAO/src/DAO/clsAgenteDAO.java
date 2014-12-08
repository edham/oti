/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidades.clsAgente;
import entidades.clsBanco;
import entidades.clsDistrito;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsAgenteDAO {
     public static List<clsAgente> Listar () throws Exception
    {
        List<clsAgente> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Agente";

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista=new ArrayList<clsAgente>();
                
                clsBanco objBanco = new clsBanco();
                objBanco.setInt_id_banco(dr.getInt(15));
                objBanco.setStr_nombre(dr.getString(16));
                objBanco.setBool_estado(dr.getBoolean(17));
                
                clsAgente entidad = new clsAgente();
                entidad.setInt_id_agente(dr.getInt(1));
                entidad.setStr_nombre(dr.getString(2));
                entidad.setDou_latitud(dr.getDouble(3));
                entidad.setDou_longitud(dr.getDouble(4));
                entidad.setStr_nombre_encargado(dr.getString(5));
                entidad.setStr_email(dr.getString(6));
                entidad.setStr_telefono(dr.getString(7));
                entidad.setStr_telefono_encargado(dr.getString(8));
                entidad.setStr_direccion(dr.getString(9));
                entidad.setBool_estado(dr.getBoolean(10));
                entidad.setDat_fecha_creacion(dr.getTimestamp(11));
                entidad.setDat_hora_inicio(dr.getTimestamp(12));
                entidad.setDat_hora_fin(dr.getTimestamp(13));
                entidad.setObjDistrito(new clsDistrito(dr.getInt(14)));
                entidad.setObjBanco(objBanco);
                
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
