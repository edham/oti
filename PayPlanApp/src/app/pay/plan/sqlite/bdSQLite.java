package app.pay.plan.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class bdSQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PayPlanBD"; 
    private static final int DATABASE_VERSION = 1;        


       private static final String CREATE_EMPRESA = "CREATE TABLE EMPRESA ("
                        + "int_id_usuario_movil integer NOT NULL PRIMARY KEY,"
                        + "str_email text NOT NULL,"
                        + "bool_gps INTEGER NOT NULL,"
                        + "bool_cerro INTEGER NOT NULL,"
                        + "dat_fecha_creacion numeric NOT NULL);";
      

    private static final String CREATE_PRODUCTO ="CREATE TABLE PRODUCTO ("
                        +"int_id_producto integer NOT NULL PRIMARY KEY,"
                        +"str_nombre text NOT NULL,"
                        +"dat_fecha_actualizacion numeric NOT NULL,"
                        +"int_id_tipo_producto integer NOT NULL,"
                        +"str_nombre_tipo_producto text NOT NULL,"
                        +"int_id_marca integer NOT NULL,"
                        +"str_nombre_marca text NOT NULL);";

	public bdSQLite(Context context, CursorFactory factory) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_EMPRESA);
                db.execSQL(CREATE_PRODUCTO);

        }   
         
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {

                db.execSQL("drop table if exists EMPRESA");
                db.execSQL(CREATE_EMPRESA);
                db.execSQL("drop table if exists PRODUCTO");
                db.execSQL(CREATE_PRODUCTO);
        }
}