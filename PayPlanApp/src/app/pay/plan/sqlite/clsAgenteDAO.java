/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.sqlite;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.pay.plan.entidades.clsAgente;
import app.pay.plan.entidades.clsBanco;
import app.pay.plan.utilidades.clsUbigeo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class clsAgenteDAO {
    
    private static String NOMBRE_TABLA="AGENTE";
    
     public static int Agregar(Context context,clsAgente entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_agente",entidad.getInt_id_agente());
        registro.put("str_nombre",entidad.getStr_nombre());
        registro.put("dou_latitud",entidad.getDou_latitud());
        registro.put("dou_longitud",entidad.getDou_longitud());
        registro.put("str_nombre_encargado",entidad.getStr_nombre_encargado());
        registro.put("str_telefono",entidad.getStr_telefono());
        registro.put("str_direccion",entidad.getStr_direccion());
        registro.put("dat_hora_inicio",entidad.getDat_hora_inicio().getTime());
        registro.put("dat_hora_fin",entidad.getDat_hora_fin().getTime());
        registro.put("int_id_distrito",entidad.getObjDistrito().getInt_id_distrito());
        registro.put("int_id_banco",entidad.getObjBanco().getInt_id_banco());
        registro.put("str_nombre_banco",entidad.getObjBanco().getStr_nombre());
        
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;

    }   

     
     public static  List<clsAgente> Listar(Context context,int idServicio)
     {
        List<clsAgente> list=new ArrayList<clsAgente>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
              String query="select a.int_id_agente,a.str_nombre,a.dou_latitud,a.dou_longitud,a.str_nombre_encargado,"
                      + "a.str_telefono,a.str_direccion,a.dat_hora_inicio,a.dat_hora_fin,a.int_id_distrito,a.int_id_banco,"
                      + "a.str_nombre_banco from "+NOMBRE_TABLA+" as a inner join AGENTE_SERVICIO as s on "
                      + "a.int_id_agente=s.int_id_agente";
              
                    if(idServicio>0)
                        query+=" where s.int_id_servicio="+idServicio;
                   

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   

                    clsBanco objBanco = new clsBanco();
                    objBanco.setInt_id_banco(fila.getInt(10));
                    objBanco.setStr_nombre(fila.getString(11));
                    
                    clsAgente entidad= new clsAgente();            
                    entidad.setInt_id_agente(fila.getInt(0));
                    entidad.setStr_nombre(fila.getString(1));
                    entidad.setDou_latitud(fila.getDouble(2));
                    entidad.setDou_longitud(fila.getDouble(3));
                    entidad.setStr_nombre_encargado(fila.getString(4));
                    entidad.setStr_telefono(fila.getString(5));
                    entidad.setStr_direccion(fila.getString(6));
                    entidad.setDat_hora_inicio(new Date(fila.getLong(7)));
                    entidad.setDat_hora_fin(new Date(fila.getLong(8)));
                    entidad.setObjDistrito(clsUbigeo.getDistrito(fila.getInt(9)));
                    entidad.setObjBanco(objBanco);
                    entidad.setItems(clsServicioDAO.Listar(context, 0));
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   
         }
        bd.close();   
        return list;
     }

     public static void Borrar(Context context) {
     bdSQLite admin=new bdSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(NOMBRE_TABLA, null, null);
     bd.close();
    }
   
}
