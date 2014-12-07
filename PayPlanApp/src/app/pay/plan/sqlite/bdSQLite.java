package app.pay.plan.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class bdSQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PayPlanBD"; 
    private static final int DATABASE_VERSION = 1;        


       private static final String CREATE_EMPRESA = "CREATE TABLE EMPRESA ("
                        + "int_id_empresa integer NOT NULL PRIMARY KEY,"
                        + "str_nombre_usuario text NOT NULL,"
                        + "str_apellidos_usuario text NOT NULL,"
                        + "str_email text NOT NULL,"
                        + "str_telefono text NOT NULL,"
                        + "str_celular text NOT NULL,"
                        + "str_usuario text NOT NULL,"
                        + "str_clave text NOT NULL,"
                        + "str_razon_social text NOT NULL,"
                        + "str_ruc text NOT NULL,"
                        + "str_direccion text NOT NULL,"
                        + "int_estado INTEGER NOT NULL,"
                        + "bool_empresa INTEGER NOT NULL,"
                        + "int_id_distrito INTEGER NOT NULL);";


        private static final String CREATE_PRODUCTO ="CREATE TABLE PRODUCTO ("
                        +"int_id_producto integer NOT NULL PRIMARY KEY,"
                        +"str_nombre text NOT NULL,"
                        +"dat_fecha_actualizacion numeric NOT NULL,"
                        +"int_id_tipo_producto integer NOT NULL,"
                        +"str_nombre_tipo_producto text NOT NULL,"
                        +"int_id_marca integer NOT NULL,"
                        +"str_nombre_marca text NOT NULL);";
        
        private static final String CREATE_PRODUCTO_EMPRESA ="CREATE TABLE PRODUCTO_EMPRESA ("
                        +"int_id_producto_empresa integer NOT NULL PRIMARY KEY,"
                        +"dou_precio text NOT NULL,"
                        +"int_id_producto numeric NOT NULL);";

        
	public bdSQLite(Context context, CursorFactory factory) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_EMPRESA);
                db.execSQL(CREATE_PRODUCTO);
                db.execSQL(CREATE_PRODUCTO_EMPRESA);

        }   
         
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {

                db.execSQL("drop table if exists EMPRESA");
                db.execSQL(CREATE_EMPRESA);
                db.execSQL("drop table if exists PRODUCTO");
                db.execSQL(CREATE_PRODUCTO);
                db.execSQL("drop table if exists PRODUCTO_EMPRESA");
                db.execSQL(CREATE_PRODUCTO_EMPRESA);
        }
}