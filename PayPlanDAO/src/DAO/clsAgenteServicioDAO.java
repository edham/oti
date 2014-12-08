/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidades.clsAgenteServicio;
import entidades.clsServicio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsAgenteServicioDAO {
    
     public static List<clsAgenteServicio> Listar () throws Exception
    {
        List<clsAgenteServicio> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec SP_Listar_Agente_Servicio";

            conn = ConexionDAO.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                    lista=new ArrayList<clsAgenteServicio>();

                clsAgenteServicio entidad = new clsAgenteServicio();
                entidad.setInt_agente_servicio(dr.getInt(1));
                entidad.setObjServicio(new clsServicio(dr.getInt(2)));                
                entidad.setInt_id_agente(dr.getInt(3));
                
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
     
      
}
