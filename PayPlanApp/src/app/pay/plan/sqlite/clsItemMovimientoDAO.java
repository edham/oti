/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.sqlite;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.pay.plan.entidades.clsItemMovimiento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class clsItemMovimientoDAO {
    
    private static String NOMBRE_TABLA="ITEM_MOVIMIENTO";
    
     public static int Agregar(Context context,clsItemMovimiento entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_item_movimiento",entidad.getInt_id_item_movimiento());
        registro.put("int_id_movimiento",entidad.getInt_id_movimiento());
        registro.put("int_numero_couta",entidad.getInt_numero_couta());        
        registro.put("dou_pago",entidad.getDou_pago());
        registro.put("dat_fecha_creacion",entidad.getDat_fecha_creacion().getTime());
        
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;

    }   

//     public  static boolean Actualizar(Context context,clsItemMovimiento entidad) 
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
//     public static  clsItemMovimiento Buscar(Context context,int id)
//     {
//        clsItemMovimiento  entidad=null;
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
//                entidad= new clsItemMovimiento();            
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
//     public static  List<clsItemMovimiento> Listar(Context context,int idMarca,int idTipoProducto)
//     {
//        List<clsItemMovimiento> list=new ArrayList<clsItemMovimiento>();
//        bdSQLite admin=new bdSQLite(context,null); 
//        SQLiteDatabase bd=admin.getWritableDatabase();
//         if(bd!=null)
//         {
//              String query="select p.int_id_producto,p.str_nombre,p.dat_fecha_actualizacion,p.int_id_tipo_producto,"
//                     + "p.str_nombre_tipo_producto,p.int_id_marca,p.str_nombre_marca from "+NOMBRE_TABLA+" as p "
//                      + "left outer join PRODUCTO_EMPRESA as pe on pe.int_id_producto=p.int_id_producto "
//                      + "where pe.int_id_producto_empresa IS NULL";
//              
//                    if(idMarca>0 && idTipoProducto>0)
//                        query+=" p.int_id_marca="+idMarca+" and p.int_id_tipo_producto="+idTipoProducto;
//                    else if(idMarca>0)
//                        query+=" p.int_id_marca="+idMarca;
//                    else if(idTipoProducto>0)
//                        query+=" p.int_id_tipo_producto="+idTipoProducto;
//                   
//
//            Cursor fila=bd.rawQuery(query,null);
//            int numRows = fila.getCount();   
//            fila.moveToFirst();   
//                for (int i = 0; i < numRows; ++i) 
//                {   
//                    clsTipoProducto objTipoProducto = new clsTipoProducto();
//                    objTipoProducto.setInt_id_tipo_producto(fila.getInt(3));
//                    objTipoProducto.setStr_nombre(fila.getString(4));
//
//                    clsMarca objMarca = new clsMarca();
//                    objMarca.setInt_id_marca(fila.getInt(5));
//                    objMarca.setStr_nombre(fila.getString(6));
//
//                    clsItemMovimiento entidad= new clsItemMovimiento();            
//                    entidad.setInt_id_producto(fila.getInt(0));
//                    entidad.setStr_nombre(fila.getString(1));
//                    entidad.setDat_fecha_actualizacion(new Date(fila.getLong(2)));
//                    entidad.setObjTipoProducto(objTipoProducto);
//                    entidad.setObjMarca(objMarca);
//                    
//                    list.add(entidad);
//                       
//                    fila.moveToNext();   
//                }   
//         }
//        bd.close();   
//        return list;
//     }
     

     public static void Borrar(Context context) {
     bdSQLite admin=new bdSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(NOMBRE_TABLA, null, null);
     bd.close();
    }
   
}
