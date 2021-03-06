/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.sqlite;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.pay.plan.entidades.clsCotizacion;
import app.pay.plan.entidades.clsEmpresa;
import app.pay.plan.entidades.clsProforma;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class clsCotizacionDAO {
    
    private static String NOMBRE_TABLA="COTIZACION";
    
     public static int Agregar(Context context,clsCotizacion entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_cotizacion",entidad.getInt_id_cotizacion());
        registro.put("int_id_proforma",entidad.getObjProforma().getInt_id_proforma());
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
     
     public static  List<clsCotizacion> Listar(Context context,int idProforma)
     {
        List<clsCotizacion> list=new ArrayList<clsCotizacion>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
              String query="select int_id_cotizacion,int_id_proforma,dat_fecha_creacion,dat_fecha_finalizacion,int_estado,"
                      + "str_nombre_usuario_empresa,str_apellidos_usuario_empresa,str_telefono_empresa,"
                      + "str_razon_social_empresa,str_ruc_empresa,str_direccion_empresa,bool_empresa_empresa from "
                      +NOMBRE_TABLA+" where int_id_proforma="+idProforma;
              
            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsEmpresa objEmpresa = new clsEmpresa();
                    objEmpresa.setStr_nombre_usuario(fila.getString(5));
                    objEmpresa.setStr_apellidos_usuario(fila.getString(6));
                    objEmpresa.setStr_telefono(fila.getString(7));
                    objEmpresa.setStr_razon_social(fila.getString(8));
                    objEmpresa.setStr_ruc(fila.getString(9));
                    objEmpresa.setStr_direccion(fila.getString(10));
                    if(fila.getInt(11)==1)
                        objEmpresa.setBool_empresa(true);
                    else
                        objEmpresa.setBool_empresa(false);
                    
                    clsCotizacion entidad= new clsCotizacion();            
                    entidad.setInt_id_cotizacion(fila.getInt(0));    
                    entidad.setObjProforma(new clsProforma(fila.getInt(1)));         
                    entidad.setDat_fecha_creacion(new Date(fila.getLong(2)));
                    entidad.setDat_fecha_finalizacion(new Date(fila.getLong(3)));
                    entidad.setInt_estado(fila.getInt(4));
                    entidad.setObjEmpresa(objEmpresa);
                    
                    entidad.setLista(clsDetalleCotizacionDAO.Listar(context, entidad.getInt_id_cotizacion()));
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
     bd.delete(NOMBRE_TABLA, "int_id_cotizacion=" + id , null);
     bd.close();
    }
     public static void Borrar(Context context) {
     bdSQLite admin=new bdSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(NOMBRE_TABLA, null, null);
     bd.close();
    }
   
}
