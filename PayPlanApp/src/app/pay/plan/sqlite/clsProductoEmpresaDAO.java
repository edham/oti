/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.sqlite;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.pay.plan.entidades.clsMarca;
import app.pay.plan.entidades.clsProducto;
import app.pay.plan.entidades.clsProductoEmpresa;
import app.pay.plan.entidades.clsTipoProducto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class clsProductoEmpresaDAO {
    
    private static String NOMBRE_TABLA="PRODUCTO_EMPRESA";
    
    public static int Agregar(Context context,clsProductoEmpresa entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_producto_empresa",entidad.getInt_id_producto_empresa());
        registro.put("dou_precio",entidad.getDou_precio());
        registro.put("int_id_producto",entidad.getObjProducto().getInt_id_producto());
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;

    }   
    public  static boolean Actualizar(Context context,int id,double precio)
    {
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("dou_precio",precio);
        
        int cant = bd.update(NOMBRE_TABLA, registro, "int_id_producto_empresa="+id, null);
        bd.close();
        if(cant==1)
            return true;
        else
            return false;
       
    }  
    public static  clsProductoEmpresa Buscar(Context context,int id)
    {
        clsProductoEmpresa  entidad=null;
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select p.int_id_producto,p.str_nombre,p.dat_fecha_actualizacion,p.int_id_tipo_producto,"
                     + "p.str_nombre_tipo_producto,p.int_id_marca,p.str_nombre_marca,pe.int_id_producto_empresa,"
                     + "pe.dou_precio from "+NOMBRE_TABLA+" as pe inner join PRODUCTO as p on "
                     + "pe.int_id_producto=p.int_id_producto where p.int_id_producto="+id;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {          
                clsTipoProducto objTipoProducto = new clsTipoProducto();
                    objTipoProducto.setInt_id_tipo_producto(fila.getInt(3));
                    objTipoProducto.setStr_nombre(fila.getString(4));

                    clsMarca objMarca = new clsMarca();
                    objMarca.setInt_id_marca(fila.getInt(5));
                    objMarca.setStr_nombre(fila.getString(6));

                    clsProducto objProducto= new clsProducto();            
                    objProducto.setInt_id_producto(fila.getInt(0));
                    objProducto.setStr_nombre(fila.getString(1));
                    objProducto.setDat_fecha_actualizacion(new Date(fila.getLong(2)));
                    objProducto.setObjTipoProducto(objTipoProducto);
                    objProducto.setObjMarca(objMarca);
                    
                    entidad = new clsProductoEmpresa();
                    entidad.setInt_id_producto_empresa(fila.getInt(7));
                    entidad.setDou_precio(fila.getDouble(8));
                    entidad.setObjProducto(objProducto);
                
            }
        }
        bd.close();   
        return entidad;
    }
     
    public static  List<clsProductoEmpresa> Listar(Context context,int idMarca,int idTipoProducto)
    {
        List<clsProductoEmpresa> list=new ArrayList<clsProductoEmpresa>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
             String query="select p.int_id_producto,p.str_nombre,p.dat_fecha_actualizacion,p.int_id_tipo_producto,"
                     + "p.str_nombre_tipo_producto,p.int_id_marca,p.str_nombre_marca,pe.int_id_producto_empresa,"
                     + "pe.dou_precio from "+NOMBRE_TABLA+" as pe inner join PRODUCTO as p on "
                     + "pe.int_id_producto=p.int_id_producto";
                    if(idMarca>0 && idTipoProducto>0)
                        query+=" where p.int_id_marca="+idMarca+" and p.int_id_tipo_producto="+idTipoProducto;
                    else if(idMarca>0)
                        query+=" where p.int_id_marca="+idMarca;
                    else if(idTipoProducto>0)
                        query+=" where p.int_id_tipo_producto="+idTipoProducto;
                   

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsTipoProducto objTipoProducto = new clsTipoProducto();
                    objTipoProducto.setInt_id_tipo_producto(fila.getInt(3));
                    objTipoProducto.setStr_nombre(fila.getString(4));

                    clsMarca objMarca = new clsMarca();
                    objMarca.setInt_id_marca(fila.getInt(5));
                    objMarca.setStr_nombre(fila.getString(6));

                    clsProducto objProducto= new clsProducto();            
                    objProducto.setInt_id_producto(fila.getInt(0));
                    objProducto.setStr_nombre(fila.getString(1));
                    objProducto.setDat_fecha_actualizacion(new Date(fila.getLong(2)));
                    objProducto.setObjTipoProducto(objTipoProducto);
                    objProducto.setObjMarca(objMarca);
                    
                    clsProductoEmpresa entidad = new clsProductoEmpresa();
                    entidad.setInt_id_producto_empresa(fila.getInt(7));
                    entidad.setDou_precio(fila.getDouble(8));
                    entidad.setObjProducto(objProducto);
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
        bd.delete(NOMBRE_TABLA, "int_id_producto_empresa=" + id , null);
        bd.close();
   }
     
    public static void Borrar(Context context) {
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        bd.delete(NOMBRE_TABLA, null, null);
        bd.close();
    }
   
}
