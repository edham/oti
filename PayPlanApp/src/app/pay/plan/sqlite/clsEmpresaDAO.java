/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.sqlite;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.pay.plan.entidades.clsDistrito;
import app.pay.plan.entidades.clsEmpresa;


public class clsEmpresaDAO {
    
    private static String NOMBRE_TABLA="EMPRESA";
    
     public static int Agregar(Context context,clsEmpresa entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_empresa",entidad.getInt_id_empresa());
        registro.put("str_nombre_usuario",entidad.getStr_nombre_usuario());
        registro.put("str_apellidos_usuario",entidad.getStr_apellidos_usuario());
        registro.put("str_email",entidad.getStr_email());
        registro.put("str_razon_social",entidad.getStr_razon_social());
        registro.put("str_telefono",entidad.getStr_telefono());
        registro.put("str_celular",entidad.getStr_celular());
        registro.put("str_usuario",entidad.getStr_usuario());
        registro.put("str_clave",entidad.getStr_clave());
        registro.put("str_ruc",entidad.getStr_ruc());
        registro.put("str_direccion",entidad.getStr_direccion());
        registro.put("int_estado",entidad.getInt_estado());        
        registro.put("int_id_distrito",entidad.getObjDistrito().getInt_id_distrito());
        
        if(entidad.isBool_empresa())
            registro.put("bool_empresa",1);
        else
            registro.put("bool_empresa",0);
        
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;

    }   

     public  static boolean Actualizar(Context context,clsEmpresa entidad) 
     {
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("str_nombre_usuario",entidad.getStr_nombre_usuario());
        registro.put("str_apellidos_usuario",entidad.getStr_apellidos_usuario());
        registro.put("str_email",entidad.getStr_email());
        registro.put("str_telefono",entidad.getStr_telefono());
        registro.put("str_celular",entidad.getStr_celular());
        registro.put("str_usuario",entidad.getStr_usuario());
        registro.put("str_clave",entidad.getStr_clave());
        registro.put("str_ruc",entidad.getStr_ruc());
        registro.put("str_direccion",entidad.getStr_direccion());
        registro.put("int_estado",entidad.getInt_estado());        
        registro.put("int_id_distrito",entidad.getObjDistrito().getInt_id_distrito());
        
        if(entidad.isBool_empresa())
            registro.put("bool_empresa",1);
        else
            registro.put("bool_empresa",0);
        
        
        int cant = bd.update(NOMBRE_TABLA, registro, "int_id_empresa="+entidad.getInt_id_empresa(), null);
        bd.close();
        if(cant==1)
            return true;
        else
            return false;
       
    }  

     public static  clsEmpresa Buscar(Context context)
     {
        clsEmpresa  entidad=null;
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select int_id_empresa,str_nombre_usuario,str_apellidos_usuario,str_email,"
                    + "str_telefono,str_celular,str_usuario,str_clave,str_ruc,str_direccion,"
                    + "int_estado,int_id_distrito,bool_empresa from "+NOMBRE_TABLA;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {          
                
                entidad= new clsEmpresa();            
                entidad.setInt_id_empresa(fila.getInt(0));
                entidad.setStr_nombre_usuario(fila.getString(1));
                entidad.setStr_apellidos_usuario(fila.getString(2));
                entidad.setStr_email(fila.getString(3));
                entidad.setStr_telefono(fila.getString(4));
                entidad.setStr_celular(fila.getString(5));
                entidad.setStr_usuario(fila.getString(6));
                entidad.setStr_clave(fila.getString(7));
                entidad.setStr_ruc(fila.getString(8));
                entidad.setStr_direccion(fila.getString(9));
                entidad.setInt_estado(fila.getInt(10));
                entidad.setObjDistrito(new clsDistrito(fila.getInt(11)));
                if(fila.getInt(12)==1)
                    entidad.setBool_empresa(true);
                else
                    entidad.setBool_empresa(false);
            }
        }
        bd.close();   
        return entidad;
     }
     

     public static void Borrar(Context context) {
     bdSQLite admin=new bdSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(NOMBRE_TABLA, null, null);
     bd.close();
    }
   
}
