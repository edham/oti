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
        registro.put("dat_hora_fin",entidad.getDat_hora_inicio().getTime());
        registro.put("int_id_distrito",entidad.getObjDistrito().getInt_id_distrito());
        registro.put("int_id_banco",entidad.getObjBanco().getInt_id_banco());
        registro.put("str_nombre_banco",entidad.getObjBanco().getStr_nombre());
        
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;

    }   

     
//     public static  List<clsAgente> Listar(Context context,int idMarca,int idTipoProducto)
//     {
//        List<clsAgente> list=new ArrayList<clsAgente>();
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
//                    clsAgente entidad= new clsAgente();            
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
