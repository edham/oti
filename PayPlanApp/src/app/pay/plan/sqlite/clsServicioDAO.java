/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.sqlite;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.pay.plan.entidades.clsServicio;
import java.util.ArrayList;
import java.util.List;


public class clsServicioDAO {
    
    private static String NOMBRE_TABLA="SERVICIO";
    
     public static int Agregar(Context context,clsServicio entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_servicio",entidad.getInt_id_servicio());
        registro.put("str_nombre",entidad.getStr_nombre());
                
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;

    }   

     
     public static  List<clsServicio> Listar(Context context,int idAgente)
     {
        List<clsServicio> list=new ArrayList<clsServicio>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
              String query="select int_id_servicio,str_nombre from "+NOMBRE_TABLA;
              
            if(idAgente>0)
                query="select s.int_id_servicio,s.str_nombre from "+NOMBRE_TABLA+" as s inner join AGENTE_SERVICIO"
                        + " as a on a.int_id_agente=s.int_id_agente where a.int_id_agente="+idAgente;
                   

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsServicio entidad= new clsServicio();            
                    entidad.setInt_id_servicio(fila.getInt(0));
                    entidad.setStr_nombre(fila.getString(1));
                    
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
