/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.sqlite;




import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import app.pay.plan.entidades.clsAgenteServicio;

public class clsAgenteServicioDAO {
    
    private static String NOMBRE_TABLA="AGENTE_SERVICIO";
    
     public static int Agregar(Context context,clsAgenteServicio entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_agente_servicio",entidad.getInt_agente_servicio());
        registro.put("int_id_agente",entidad.getInt_id_agente());
        registro.put("int_id_servicio",entidad.getObjServicio().getInt_id_servicio());
        
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;

    } 
     
     public static void Borrar(Context context) {
     bdSQLite admin=new bdSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(NOMBRE_TABLA, null, null);
     bd.close();
    }
   
}
