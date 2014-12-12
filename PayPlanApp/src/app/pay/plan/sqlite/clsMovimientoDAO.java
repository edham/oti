/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.sqlite;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.pay.plan.entidades.clsMovimiento;
import app.pay.plan.entidades.clsServicio;
import app.pay.plan.entidades.clsTipoMovimiento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class clsMovimientoDAO {
    
    private static String NOMBRE_TABLA="MOVIMIENTO";
    
     public static int Agregar(Context context,clsMovimiento entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_movimiento",entidad.getInt_id_movimiento());
        registro.put("int_id_tipo_movimiento",entidad.getObjTipoMovimiento().getInt_id_tipo_movimiento());
        registro.put("int_id_servicio",entidad.getObjServicio().getInt_id_servicio());        
        registro.put("str_detalle",entidad.getStr_detalle());
        registro.put("dou_total",entidad.getDou_total());
        registro.put("dou_total_acumulado",entidad.getDou_total_acumulado());
        registro.put("int_couta_total",entidad.getInt_couta_total());
        registro.put("int_couta_ingresadas",entidad.getInt_couta_ingresadas());
        registro.put("int_estado",entidad.getInt_estado());
        registro.put("int_alerta_inicio",entidad.getInt_alerta_inicio());
        registro.put("int_repeticion_alerta",entidad.getInt_repeticion_alerta());
        registro.put("dat_fecha_creacion",entidad.getDat_fecha_creacion().getTime());
        registro.put("dat_fecha_movimiento",entidad.getDat_fecha_movimiento().getTime());
        
        if(entidad.isBool_ingreso())
        registro.put("bool_ingreso",1);
        else
            registro.put("bool_ingreso",0);
        
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;

    }   

//     public  static boolean Actualizar(Context context,clsMovimiento entidad) 
//     {
//        bdSQLite admin=new bdSQLite(context,null);
//        SQLiteDatabase bd = admin.getWritableDatabase();
//        ContentValues registro = new ContentValues();
//        registro.put("str_nombre",entidad.getStr_nombre());
//        registro.put("dat_fecha_actualizacion",entidad.getDat_fecha_actualizacion().getTime());
//        registro.put("int_id_tipo_producto",entidad.getObjTipoProducto().getInt_id_tipo_producto());
//        registro.put("str_nombre_tipo_producto",entidad.getObjTipoProducto().getStr_nombre());
//        registro.put("int_id_marca",entidad.getObjMarca().getInt_id_marca());
//        registro.put("str_nombre_marca",entidad.getObjMarca().getStr_nombre());
//        
//        int cant = bd.update(NOMBRE_TABLA, registro, "int_id_producto="+entidad.getInt_id_producto(), null);
//        bd.close();
//        if(cant==1)
//            return true;
//        else
//            return false;
//       
//    }  
//
//     public static  clsMovimiento Buscar(Context context,int id)
//     {
//        clsMovimiento  entidad=null;
//        bdSQLite admin=new bdSQLite(context,null); 
//        SQLiteDatabase bd=admin.getWritableDatabase();
//         if(bd!=null)
//         {
//            String query="select int_id_producto,str_nombre,dat_fecha_actualizacion,int_id_tipo_producto,"
//                    +"str_nombre_tipo_producto,int_id_marca,str_nombre_marca from "+NOMBRE_TABLA
//                    +" where int_id_producto="+id;
//
//            Cursor fila=bd.rawQuery(query,null);
//            if (fila.moveToFirst())
//            {          
//                clsTipoProducto objTipoProducto = new clsTipoProducto();
//                objTipoProducto.setInt_id_tipo_producto(fila.getInt(3));
//                objTipoProducto.setStr_nombre(fila.getString(4));
//                
//                clsMarca objMarca = new clsMarca();
//                objMarca.setInt_id_marca(fila.getInt(5));
//                objMarca.setStr_nombre(fila.getString(6));
//                
//                entidad= new clsMovimiento();            
//                entidad.setInt_id_producto(fila.getInt(0));
//                entidad.setStr_nombre(fila.getString(1));
//                entidad.setDat_fecha_actualizacion(new Date(fila.getLong(2)));
//                entidad.setObjTipoProducto(objTipoProducto);
//                entidad.setObjMarca(objMarca);
//                
//            }
//        }
//        bd.close();   
//        return entidad;
//     }
//     
     public static  List<clsMovimiento> Listar(Context context,int tipo)
     {
        List<clsMovimiento> list=new ArrayList<clsMovimiento>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
              String query="select m.int_id_movimiento,m.int_id_tipo_movimiento,m.int_id_servicio,m.str_detalle,"
                      + "m.dou_total,m.dou_total_acumulado,m.int_couta_total,m.int_couta_ingresadas,m.int_estado,"
                      + "m.int_alerta_inicio,m.int_repeticion_alerta,m.dat_fecha_creacion,m.dat_fecha_movimiento,"
                      + "m.bool_ingreso,s.str_nombre from "+NOMBRE_TABLA+" as m inner join SERVICIO as s on "
                      + "m.int_id_servicio=s.int_id_servicio";
              
                    if(tipo==1)
                        query+=" where m.bool_ingreso=1";
                    else if(tipo==2)
                        query+=" where m.bool_ingreso=0";
                    
                    query+=" order by m.dat_fecha_movimiento ASC";
                    
            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   

                    clsMovimiento entidad= new clsMovimiento();            
                    entidad.setInt_id_movimiento(fila.getInt(0));
                    entidad.setObjTipoMovimiento(new clsTipoMovimiento(fila.getInt(1),fila.getString(13)));
                    entidad.setObjServicio(new clsServicio(fila.getInt(2)));                    
                    entidad.setStr_detalle(fila.getString(3));
                    entidad.setDou_total(fila.getDouble(4));
                    entidad.setDou_total_acumulado(fila.getDouble(5));
                    entidad.setInt_couta_total(fila.getInt(6));
                    entidad.setInt_couta_ingresadas(fila.getInt(7));
                    entidad.setInt_estado(fila.getInt(8));
                    entidad.setInt_alerta_inicio(fila.getInt(9));
                    entidad.setInt_repeticion_alerta(fila.getInt(10));
                    entidad.setDat_fecha_creacion(new Date(fila.getLong(11)));
                    entidad.setDat_fecha_movimiento(new Date(fila.getLong(12)));
                    
                    if(fila.getInt(13)==1)
                    entidad.setBool_ingreso(true);
                    else
                        entidad.setBool_ingreso(false);
                    
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
