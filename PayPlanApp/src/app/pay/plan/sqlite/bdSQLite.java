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
                        +"dou_precio numeric NOT NULL,"
                        +"int_id_producto integer NOT NULL);";
        
        private static final String CREATE_AGENTE ="CREATE TABLE AGENTE ("
                        +"int_id_agente integer NOT NULL PRIMARY KEY,"
                        +"str_nombre text NOT NULL,"
                        +"dou_latitud numeric NOT NULL,"
                        +"dou_longitud numeric NOT NULL,"
                        +"str_nombre_encargado text NOT NULL,"
                        +"str_telefono text NOT NULL,"
                        +"str_direccion text NOT NULL,"
                        +"dat_hora_inicio numeric NOT NULL,"
                        +"dat_hora_fin numeric NOT NULL,"
                        +"int_id_distrito integer NOT NULL,"
                        +"int_id_banco integer NOT NULL,"
                        +"str_nombre_banco text NOT NULL);";

        private static final String CREATE_SERVICIO ="CREATE TABLE SERVICIO ("
                        +"int_id_servicio integer NOT NULL PRIMARY KEY,"
                        +"str_nombre text NOT NULL);";
        
        private static final String CREATE_AGENTE_SERVICIO ="CREATE TABLE AGENTE_SERVICIO ("
                        +"int_agente_servicio integer NOT NULL PRIMARY KEY,"
                        +"int_id_agente integer NOT NULL,"
                        +"int_id_servicio integer NOT NULL);";
        
        private static final String CREATE_MOVIMIENTO ="CREATE TABLE MOVIMIENTO ("
                        +"int_id_movimiento integer NOT NULL PRIMARY KEY,"
                        +"int_id_tipo_movimiento integer NOT NULL,"
                        +"int_id_servicio integer NOT NULL,"
                        +"bool_ingreso integer NOT NULL,"
                        +"str_detalle text NOT NULL,"
                        +"dou_total numeric NOT NULL,"
                        +"dou_total_acumulado numeric NOT NULL,"
                        +"int_couta_total integer NOT NULL,"
                        +"int_couta_ingresadas integer NOT NULL,"
                        +"int_estado integer NOT NULL,"
                        +"int_alerta_inicio integer NOT NULL,"
                        +"int_repeticion_alerta integer NOT NULL,"
                        +"dat_fecha_creacion numeric NOT NULL,"
                        +"dat_fecha_movimiento numeric NOT NULL);";
        
        private static final String CREATE_ITEM_MOVIMIENTO ="CREATE TABLE ITEM_MOVIMIENTO ("
                        +"int_id_item_movimiento integer NOT NULL PRIMARY KEY,"
                        +"int_id_movimiento integer NOT NULL,"
                        +"int_numero_couta integer NOT NULL,"
                        +"dou_pago numeric NOT NULL,"
                        +"dat_fecha_creacion numeric NOT NULL);";
        
        private static final String CREATE_PROFORMA_EMPRESA ="CREATE TABLE PROFORMA_EMPRESA ("
                        +"int_id_proforma integer NOT NULL PRIMARY KEY,"
                        +"dat_fecha_creacion numeric NOT NULL,"
                        +"dat_fecha_finalizacion numeric NOT NULL,"
                        +"int_estado integer NOT NULL);";
        
        private static final String CREATE_PROFORMA ="CREATE TABLE PROFORMA ("
                        +"int_id_proforma integer NOT NULL PRIMARY KEY,"
                        +"dat_fecha_creacion numeric NOT NULL,"
                        +"dat_fecha_finalizacion numeric NOT NULL,"
                        +"str_nombre_usuario_empresa text NOT NULL,"
                        +"str_apellidos_usuario_empresa text NOT NULL,"
                        +"str_telefono_empresa text NOT NULL,"
                        +"bool_empresa_empresa integer NOT NULL,"
                        +"str_razon_social_empresa text NOT NULL,"
                        +"str_ruc_empresa text NOT NULL,"
                        +"str_direccion_empresa text NOT NULL,"
                        +"int_estado integer NOT NULL);";
        
        
        private static final String CREATE_DETALLE_PROFORMA ="CREATE TABLE DETALLE_PROFORMA ("
                        +"int_id_detalle_proforma integer NOT NULL PRIMARY KEY,"
                        +"int_id_proforma integer NOT NULL,"
                        +"int_id_producto numeric NOT NULL,"
                        +"int_cantidad numeric NOT NULL,"
                        +"int_estado integer NOT NULL);";
        
        private static final String CREATE_COTIZACION ="CREATE TABLE COTIZACION ("
                        +"int_id_cotizacion integer NOT NULL PRIMARY KEY,"
                        +"int_id_proforma integer NOT NULL,"
                        +"dat_fecha_creacion numeric NOT NULL,"
                        +"dat_fecha_finalizacion numeric NOT NULL,"
                        +"str_nombre_usuario_empresa text NOT NULL,"
                        +"str_apellidos_usuario_empresa text NOT NULL,"
                        +"str_telefono_empresa text NOT NULL,"
                        +"bool_empresa_empresa integer NOT NULL,"
                        +"str_razon_social_empresa text NOT NULL,"
                        +"str_ruc_empresa text NOT NULL,"
                        +"str_direccion_empresa text NOT NULL,"
                        +"int_estado integer NOT NULL);";
        
        private static final String CREATE_DETALLE_COTIZACION ="CREATE TABLE DETALLE_COTIZACION ("
                        +"int_id_detalle_cotizacion integer NOT NULL PRIMARY KEY,"
                        +"int_id_cotizacion integer NOT NULL,"
                        +"int_id_producto numeric NOT NULL,"
                        +"dou_costo numeric NOT NULL,"
                        +"int_cantidad integer NOT NULL,"
                        +"int_estado integer NOT NULL);";
	public bdSQLite(Context context, CursorFactory factory) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_EMPRESA);
                db.execSQL(CREATE_PRODUCTO);
                db.execSQL(CREATE_PRODUCTO_EMPRESA);
                db.execSQL(CREATE_AGENTE);
                db.execSQL(CREATE_SERVICIO);
                db.execSQL(CREATE_AGENTE_SERVICIO);
                db.execSQL(CREATE_MOVIMIENTO);
                db.execSQL(CREATE_ITEM_MOVIMIENTO);
                db.execSQL(CREATE_PROFORMA);
                db.execSQL(CREATE_DETALLE_PROFORMA);
                db.execSQL(CREATE_PROFORMA_EMPRESA);
                db.execSQL(CREATE_COTIZACION);
                db.execSQL(CREATE_DETALLE_COTIZACION);
                

        }   
         
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {

                db.execSQL("drop table if exists EMPRESA");
                db.execSQL(CREATE_EMPRESA);
                db.execSQL("drop table if exists PRODUCTO");
                db.execSQL(CREATE_PRODUCTO);
                db.execSQL("drop table if exists PRODUCTO_EMPRESA");
                db.execSQL(CREATE_PRODUCTO_EMPRESA);
                db.execSQL("drop table if exists AGENTE");
                db.execSQL(CREATE_AGENTE);
                db.execSQL("drop table if exists SERVICIO");
                db.execSQL(CREATE_SERVICIO);
                db.execSQL("drop table if exists AGENTE_SERVICIO");
                db.execSQL(CREATE_AGENTE_SERVICIO);
                db.execSQL("drop table if exists MOVIMIENTO");
                db.execSQL(CREATE_MOVIMIENTO);
                db.execSQL("drop table if exists ITEM_MOVIMIENTO");
                db.execSQL(CREATE_ITEM_MOVIMIENTO);                
                db.execSQL("drop table if exists PROFORMA");
                db.execSQL(CREATE_PROFORMA);
                db.execSQL("drop table if exists DETALLE_PROFORMA");
                db.execSQL(CREATE_DETALLE_PROFORMA);
                db.execSQL("drop table if exists PROFORMA_EMPRESA");
                db.execSQL(CREATE_PROFORMA_EMPRESA);
                db.execSQL("drop table if exists COTIZACION");
                db.execSQL(CREATE_COTIZACION);
                db.execSQL("drop table if exists DETALLE_COTIZACION");
                db.execSQL(CREATE_DETALLE_COTIZACION);
                
        }
}