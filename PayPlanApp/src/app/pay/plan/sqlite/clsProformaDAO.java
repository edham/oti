/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.sqlite;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.pay.plan.entidades.clsEmpresa;
import app.pay.plan.entidades.clsProforma;
import app.pay.plan.entidades.clsServicio;
import app.pay.plan.entidades.clsTipoMovimiento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class clsProformaDAO {
    
    private static String NOMBRE_TABLA="PROFORMA";
    
     public static int Agregar(Context context,clsProforma entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_proforma",entidad.getInt_id_proforma());
        registro.put("dat_fecha_creacion",entidad.getDat_fecha_creacion().getTime());        
        registro.put("dat_fecha_finalizacion",entidad.getDat_fecha_finalizacion().getTime());  
        registro.put("int_estado",entidad.getInt_estado());
        registro.put("str_nombre_usuario_empresa",entidad.getObjEmpresa().getStr_nombre_usuario());
        registro.put("str_apellidos_usuario_empresa",entidad.getObjEmpresa().getStr_apellidos_usuario());
        registro.put("str_telefono_empresa",entidad.getObjEmpresa().getStr_telefono()); 
        registro.put("str_razon_social_empresa",entidad.getObjEmpresa().getStr_razon_social());
        registro.put("str_ruc_empresa",entidad.getObjEmpresa().getStr_ruc());
        registro.put("str_direccion_empresa",entidad.getObjEmpresa().getStr_direccion());
        
        if(entidad.getObjEmpresa().isBool_empresa())
            registro.put("bool_empresa_empresa",1);
        else
            registro.put("bool_empresa_empresa",0);
        
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;
    }
     
     public static  List<clsProforma> Listar(Context context)
     {
        List<clsProforma> list=new ArrayList<clsProforma>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
              String query="select int_id_proforma,dat_fecha_creacion,dat_fecha_finalizacion,int_estado,"
                      + "str_nombre_usuario_empresa,str_apellidos_usuario_empresa,str_telefono_empresa,"
                      + "str_razon_social_empresa,str_ruc_empresa,str_direccion_empresa,bool_empresa_empresa from "
                      +NOMBRE_TABLA;
              
            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsEmpresa objEmpresa = new clsEmpresa();
                    objEmpresa.setStr_nombre_usuario(fila.getString(4));
                    objEmpresa.setStr_apellidos_usuario(fila.getString(5));
                    objEmpresa.setStr_telefono(fila.getString(6));
                    objEmpresa.setStr_razon_social(fila.getString(7));
                    objEmpresa.setStr_ruc(fila.getString(8));
                    objEmpresa.setStr_direccion(fila.getString(9));
                    if(fila.getInt(10)==1)
                        objEmpresa.setBool_empresa(true);
                    else
                        objEmpresa.setBool_empresa(false);
                    
                    clsProforma entidad= new clsProforma();            
                    entidad.setInt_id_proforma(fila.getInt(0));                    
                    entidad.setDat_fecha_creacion(new Date(fila.getLong(1)));
                    entidad.setDat_fecha_finalizacion(new Date(fila.getLong(2)));
                    entidad.setInt_estado(fila.getInt(3));
                    entidad.setObjEmpresa(objEmpresa);
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   
         }
        bd.close();   
        return list;
     }
     
    public static void BorrarId(Context context,int id) {
     bdSQLite admin=new bdSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(NOMBRE_TABLA, "int_id_proforma=" + id , null);
     bd.close();
    }
     public static void Borrar(Context context) {
     bdSQLite admin=new bdSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(NOMBRE_TABLA, null, null);
     bd.close();
    }
   
}
