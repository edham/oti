/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.sqlite;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.pay.plan.entidades.clsDetalleProforma;
import app.pay.plan.entidades.clsMarca;
import app.pay.plan.entidades.clsProducto;
import app.pay.plan.entidades.clsServicio;
import app.pay.plan.entidades.clsTipoMovimiento;
import app.pay.plan.entidades.clsTipoProducto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class clsDetalleProformaDAO {
    
    private static String NOMBRE_TABLA="DETALLE_PROFORMA";
    
     public static int Agregar(Context context,clsDetalleProforma entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_detalle_proforma",entidad.getInt_id_detalle_proforma());
        registro.put("int_id_proforma",entidad.getInt_id_proforma());        
        registro.put("int_id_producto",entidad.getObjProducto().getInt_id_producto());  
        registro.put("int_cantidad",entidad.getInt_cantidad());
        registro.put("int_estado",entidad.getInt_estado());
       
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;
    }
     
     public static  List<clsDetalleProforma> Listar(Context context,int idProforma)
     {
        List<clsDetalleProforma> list=new ArrayList<clsDetalleProforma>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
              String query="select d.int_id_detalle_proforma,d.int_id_proforma,"
                      + "d.int_cantidad,d.int_estado,d.int_id_producto,p.str_nombre,"
                      + "p.str_nombre_tipo_producto,p.str_nombre_marca from "
                      +NOMBRE_TABLA+" as d inner join producto as p on "
                      + "d.int_id_producto=p.int_id_producto where d.int_id_proforma="+idProforma;
                   

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    
                    clsProducto objProducto = new clsProducto();
                    objProducto.setInt_id_producto(fila.getInt(4));
                    objProducto.setStr_nombre(fila.getString(5));
                    objProducto.setObjTipoProducto(new clsTipoProducto(fila.getString(6)));
                    objProducto.setObjMarca(new clsMarca(fila.getString(7)));
                    
                    clsDetalleProforma entidad= new clsDetalleProforma();           
                    entidad.setInt_id_detalle_proforma(fila.getInt(0));    
                    entidad.setInt_id_proforma(fila.getInt(1));  
                    entidad.setInt_cantidad(fila.getInt(2));
                    entidad.setInt_estado(fila.getInt(3));
                    entidad.setObjProducto(objProducto);
               
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   
         }
        bd.close();   
        return list;
     }
     
     
     public static  List<clsDetalleProforma> ListarProforma(Context context,int idProforma)
     {
        List<clsDetalleProforma> list=new ArrayList<clsDetalleProforma>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
              String query="select d.int_id_detalle_proforma,d.int_id_proforma,"
                      + "d.int_cantidad,d.int_estado,d.int_id_producto,p.str_nombre,"
                      + "p.str_nombre_tipo_producto,p.str_nombre_marca,pe.dou_precio "
                      + "from "+NOMBRE_TABLA+" as d inner join producto as p on "
                      + "d.int_id_producto=p.int_id_producto left outer join PRODUCTO_EMPRESA as pe "
                      + "on pe.int_id_producto=d.int_id_producto where d.int_id_proforma="+idProforma
                      +" order by pe.int_id_producto_empresa DESC";
                   

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    
                    clsProducto objProducto = new clsProducto();
                    objProducto.setInt_id_producto(fila.getInt(4));
                    objProducto.setStr_nombre(fila.getString(5));
                    objProducto.setObjTipoProducto(new clsTipoProducto(fila.getString(6)));
                    objProducto.setObjMarca(new clsMarca(fila.getString(7)));
                    objProducto.setDou_precio(fila.getDouble(8));
                        
                    clsDetalleProforma entidad= new clsDetalleProforma();           
                    entidad.setInt_id_detalle_proforma(fila.getInt(0));    
                    entidad.setInt_id_proforma(fila.getInt(1));  
                    entidad.setInt_cantidad(fila.getInt(2));
                    entidad.setInt_estado(fila.getInt(3));
                    entidad.setObjProducto(objProducto);
               
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
