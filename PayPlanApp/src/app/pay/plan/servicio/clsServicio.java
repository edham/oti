package app.pay.plan.servicio;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import app.pay.plan.entidades.clsAgente;
import app.pay.plan.entidades.clsAgenteServicio;
import app.pay.plan.entidades.clsBanco;
import app.pay.plan.entidades.clsCotizacion;
import app.pay.plan.entidades.clsDetalleCotizacion;
import app.pay.plan.entidades.clsDetalleProforma;
import app.pay.plan.entidades.clsDistrito;
import app.pay.plan.entidades.clsEmpresa;
import app.pay.plan.entidades.clsItemMovimiento;
import app.pay.plan.entidades.clsMarca;
import app.pay.plan.entidades.clsMovimiento;
import app.pay.plan.entidades.clsProducto;
import app.pay.plan.entidades.clsProductoEmpresa;
import app.pay.plan.entidades.clsProforma;
import app.pay.plan.entidades.clsTipoMovimiento;
import app.pay.plan.entidades.clsTipoProducto;
import app.pay.plan.http.http;
import app.pay.plan.sqlite.clsAgenteDAO;
import app.pay.plan.sqlite.clsAgenteServicioDAO;
import app.pay.plan.sqlite.clsCotizacionDAO;
import app.pay.plan.sqlite.clsDetalleCotizacionDAO;
import app.pay.plan.sqlite.clsDetalleProformaDAO;
import app.pay.plan.sqlite.clsEmpresaDAO;
import app.pay.plan.sqlite.clsItemMovimientoDAO;
import app.pay.plan.sqlite.clsMovimientoDAO;
import app.pay.plan.sqlite.clsProductoDAO;
import app.pay.plan.sqlite.clsProductoEmpresaDAO;
import app.pay.plan.sqlite.clsProformaDAO;
import app.pay.plan.sqlite.clsProformaEmpresaDAO;
import app.pay.plan.sqlite.clsServicioDAO;
import app.pay.plan.ui.LoginActivity;
import app.pay.plan.ui.MenuActivity;
import app.pay.plan.utilidades.Utilidades;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class clsServicio extends Service {

	private Timer timer = new Timer();
	private static final long UPDATE_INTERVAL = 1000*60;// timer cada minuto
	
        private clsEmpresa objEmpresa=null;
	
        
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public void onCreate() {
            super.onCreate();         
            objEmpresa=clsEmpresaDAO.Buscar(this.getApplicationContext());            
//            if(objUsuario!=null)
//            {
                   _startService();
//            }
//                      else
//                onDestroy();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();               
		_shutdownService();           
	}
	
	private void _startService() {
           
		timer.scheduleAtFixedRate(
			new TimerTask() {
				public void run() {
                         
                       if(Utilidades.verificaConexion(clsServicio.this.getApplication()))
                        try {
                       JSONObject objeto = new JSONObject(http.cargar(objEmpresa.getInt_id_empresa()));
                       if(objeto.getInt("error")==0)
                       {
                    
                        //objetoLisataProducto
                        clsProductoDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objetoListarProducto = new JSONObject(objeto.getString("listaProducto"));
                        if(objetoListarProducto.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objetoListarProducto.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                            clsTipoProducto objTipoProducto = new clsTipoProducto();
                            objTipoProducto.setInt_id_tipo_producto(json_data.getInt("int_id_tipo_producto"));
                            objTipoProducto.setStr_nombre(json_data.getString("str_nombre_tipo_producto"));

                            clsMarca objMarca = new clsMarca();
                            objMarca.setInt_id_marca(json_data.getInt("int_id_marca"));
                            objMarca.setStr_nombre(json_data.getString("str_nombre_marca"));

                            clsProducto objProducto= new clsProducto();            
                            objProducto.setInt_id_producto(json_data.getInt("int_id_producto"));
                            objProducto.setStr_nombre(json_data.getString("str_nombre"));
                            objProducto.setDat_fecha_actualizacion(new Date(json_data.getLong("dat_fecha_actualizacion")));
                            objProducto.setObjTipoProducto(objTipoProducto);
                            objProducto.setObjMarca(objMarca);
                            clsProductoDAO.Agregar(clsServicio.this.getApplication(), objProducto);
                           }
                        }
                        
                        //objetoListarProductoEmpresa
                        clsProductoEmpresaDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objetoListarProductoEmpresa = new JSONObject(objeto.getString("listaProductoEmpresa"));
                        if(objetoListarProductoEmpresa.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objetoListarProductoEmpresa.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                            clsProductoEmpresa objProductoEmpresa= new clsProductoEmpresa();            
                            objProductoEmpresa.setInt_id_producto_empresa(json_data.getInt("int_id_producto_empresa"));
                            objProductoEmpresa.setDou_precio(json_data.getDouble("dou_precio"));
                            objProductoEmpresa.setObjProducto(new clsProducto(json_data.getInt("int_id_producto")));
                            clsProductoEmpresaDAO.Agregar(clsServicio.this.getApplication(), objProductoEmpresa);
                           }
                        }
                        //objetoListarAgente
                        clsAgenteDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objetoListarAgente = new JSONObject(objeto.getString("listaAgente"));
                        if(objetoListarAgente.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objetoListarAgente.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                            clsBanco objBanco = new clsBanco();
                            objBanco.setInt_id_banco(json_data.getInt("int_id_banco"));
                            objBanco.setStr_nombre(json_data.getString("str_nombre_banco"));
                            
                            clsAgente objAgente= new clsAgente();            
                            objAgente.setInt_id_agente(json_data.getInt("int_id_agente"));
                            objAgente.setStr_nombre(json_data.getString("str_nombre"));
                            objAgente.setDou_latitud(json_data.getDouble("dou_latitud"));
                            objAgente.setDou_longitud(json_data.getDouble("dou_longitud"));
                            objAgente.setStr_nombre_encargado(json_data.getString("str_nombre_encargado"));
                            objAgente.setStr_telefono(json_data.getString("str_telefono"));
                            objAgente.setStr_direccion(json_data.getString("str_direccion"));
                            objAgente.setDat_hora_inicio(new Date(json_data.getLong("dat_hora_inicio")));
                            objAgente.setDat_hora_fin(new Date(json_data.getLong("dat_hora_fin")));
                            objAgente.setObjDistrito(new clsDistrito(json_data.getInt("int_id_distrito")));
                            objAgente.setObjBanco(objBanco);
                            
                            clsAgenteDAO.Agregar(clsServicio.this.getApplication(), objAgente);
                           }
                        }
                        
                        //objetoListarAgente
                        clsServicioDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objetoListarServicio = new JSONObject(objeto.getString("listaServicio"));
                        if(objetoListarServicio.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objetoListarServicio.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                                                       
                            app.pay.plan.entidades.clsServicio objServicio= new app.pay.plan.entidades.clsServicio();            
                            objServicio.setInt_id_servicio(json_data.getInt("int_id_servicio"));
                            objServicio.setStr_nombre(json_data.getString("str_nombre"));
                            
                            clsServicioDAO.Agregar(clsServicio.this.getApplication(), objServicio);
                           }
                        }
                         //objetoListarAgente
                        clsAgenteServicioDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objetoListarAgenteServicio = new JSONObject(objeto.getString("listaAgenteServicio"));
                        if(objetoListarAgenteServicio.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objetoListarAgenteServicio.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                                                       
                            clsAgenteServicio objAgenteServicio= new clsAgenteServicio();            
                            objAgenteServicio.setInt_agente_servicio(json_data.getInt("int_agente_servicio"));
                            objAgenteServicio.setInt_id_agente(json_data.getInt("int_id_agente"));
                            objAgenteServicio.setObjServicio(new app.pay.plan.entidades.clsServicio(json_data.getInt("int_id_servicio")));
                            clsAgenteServicioDAO.Agregar(clsServicio.this.getApplication(), objAgenteServicio);
                           }
                        }
                         //objListaMovimiento
                        clsMovimientoDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objListaMovimiento = new JSONObject(objeto.getString("listaMovimiento"));
                        if(objListaMovimiento.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objListaMovimiento.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                                                       
                            clsMovimiento objMovimiento= new clsMovimiento();            
                            objMovimiento.setInt_id_movimiento(json_data.getInt("int_id_movimiento"));
                            objMovimiento.setObjTipoMovimiento(new clsTipoMovimiento(json_data.getInt("int_id_tipo_movimiento")));
                            objMovimiento.setObjServicio(new app.pay.plan.entidades.clsServicio(json_data.getInt("int_id_servicio")));
                            objMovimiento.setBool_ingreso(json_data.getBoolean("bool_ingreso"));
                            objMovimiento.setStr_detalle(json_data.getString("str_detalle"));
                            objMovimiento.setDou_total(json_data.getDouble("dou_total"));
                            objMovimiento.setDou_total_acumulado(json_data.getDouble("dou_total_acumulado"));
                            objMovimiento.setInt_couta_total(json_data.getInt("int_couta_total"));
                            objMovimiento.setInt_couta_ingresadas(json_data.getInt("int_couta_ingresadas"));
                            objMovimiento.setInt_estado(json_data.getInt("int_estado"));
                            objMovimiento.setInt_alerta_inicio(json_data.getInt("int_alerta_inicio"));
                            objMovimiento.setInt_repeticion_alerta(json_data.getInt("int_repeticion_alerta"));
                            objMovimiento.setDat_fecha_creacion(new Date(json_data.getLong("dat_fecha_creacion")));
                            objMovimiento.setDat_fecha_movimiento(new Date(json_data.getLong("dat_fecha_movimiento")));
                            clsMovimientoDAO.Agregar(clsServicio.this.getApplication(), objMovimiento);
                           }
                        }
                         //objetoListarAgente
                        clsItemMovimientoDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objetoListaItemMovimiento = new JSONObject(objeto.getString("listaItemMovimiento"));
                        if(objetoListaItemMovimiento.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objetoListaItemMovimiento.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                                                       
                            clsItemMovimiento objItemMovimiento= new clsItemMovimiento();            
                            objItemMovimiento.setInt_id_item_movimiento(json_data.getInt("int_id_item_movimiento"));
                            objItemMovimiento.setInt_id_movimiento(json_data.getInt("int_id_movimiento"));
                            objItemMovimiento.setInt_numero_couta(json_data.getInt("int_numero_couta"));
                            objItemMovimiento.setDou_pago(json_data.getInt("dou_pago"));
                            objItemMovimiento.setDat_fecha_creacion(new Date(json_data.getLong("dat_fecha_creacion")));
                            clsItemMovimientoDAO.Agregar(clsServicio.this.getApplication(), objItemMovimiento);
                           }
                        }
                         //objListaProformaEmpresa
                        clsProformaEmpresaDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objListaProformaEmpresa = new JSONObject(objeto.getString("listaProformaEmpresa"));
                        if(objListaProformaEmpresa.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objListaProformaEmpresa.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                                                       
                            clsProforma objProforma= new clsProforma();            
                            objProforma.setInt_id_proforma(json_data.getInt("int_id_proforma"));
                            objProforma.setInt_estado(json_data.getInt("int_estado"));
                            objProforma.setDat_fecha_creacion(new Date(json_data.getLong("dat_fecha_creacion")));
                            objProforma.setDat_fecha_finalizacion(new Date(json_data.getLong("dat_fecha_finalizacion")));
                            clsProformaEmpresaDAO.Agregar(clsServicio.this.getApplication(), objProforma);
                           }
                        }
                        //objListaProforma
                        clsProformaDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objListaProforma = new JSONObject(objeto.getString("listaProforma"));
                        if(objListaProforma.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objListaProforma.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                             clsEmpresa objEmpresa = new clsEmpresa();
                            objEmpresa.setStr_nombre_usuario(json_data.getString("str_nombre_usuario"));
                            objEmpresa.setStr_apellidos_usuario(json_data.getString("str_apellidos_usuario"));
                            objEmpresa.setStr_telefono(json_data.getString("str_telefono"));
                            objEmpresa.setStr_razon_social(json_data.getString("str_razon_social"));
                            objEmpresa.setStr_ruc(json_data.getString("str_ruc"));
                            objEmpresa.setStr_direccion(json_data.getString("str_direccion"));
                            objEmpresa.setBool_empresa(json_data.getBoolean("bool_empresa"));     
                            
                            clsProforma objProforma= new clsProforma();            
                            objProforma.setInt_id_proforma(json_data.getInt("int_id_proforma"));
                            objProforma.setInt_estado(json_data.getInt("int_estado"));
                            objProforma.setDat_fecha_creacion(new Date(json_data.getLong("dat_fecha_creacion")));
                            objProforma.setDat_fecha_finalizacion(new Date(json_data.getLong("dat_fecha_finalizacion")));
                            objProforma.setObjEmpresa(objEmpresa);
                            
                            clsProformaDAO.Agregar(clsServicio.this.getApplication(), objProforma);
                           }
                        }
                         //objlistaDetalleProforma
                        clsDetalleProformaDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objlistaDetalleProforma = new JSONObject(objeto.getString("listaDetalleProforma"));
                        if(objlistaDetalleProforma.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objlistaDetalleProforma.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                                                       
                            clsDetalleProforma objDetalleProforma= new clsDetalleProforma();            
                            objDetalleProforma.setInt_id_detalle_proforma(json_data.getInt("int_id_detalle_proforma"));
                            objDetalleProforma.setInt_id_proforma(json_data.getInt("int_id_proforma"));
                            objDetalleProforma.setObjProducto(new clsProducto(json_data.getInt("int_id_producto")));
                            objDetalleProforma.setInt_cantidad(json_data.getInt("int_cantidad"));
                            objDetalleProforma.setInt_estado(json_data.getInt("int_estado"));
                            clsDetalleProformaDAO.Agregar(clsServicio.this.getApplication(), objDetalleProforma);
                           }
                        }
                        
                        //objListaCotizacion
                        clsCotizacionDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objListaCotizacion = new JSONObject(objeto.getString("listaCotizacion"));
                        if(objListaCotizacion.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objListaCotizacion.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                             clsEmpresa objEmpresa = new clsEmpresa();
                            objEmpresa.setStr_nombre_usuario(json_data.getString("str_nombre_usuario"));
                            objEmpresa.setStr_apellidos_usuario(json_data.getString("str_apellidos_usuario"));
                            objEmpresa.setStr_telefono(json_data.getString("str_telefono"));
                            objEmpresa.setStr_razon_social(json_data.getString("str_razon_social"));
                            objEmpresa.setStr_ruc(json_data.getString("str_ruc"));
                            objEmpresa.setStr_direccion(json_data.getString("str_direccion"));
                            objEmpresa.setBool_empresa(json_data.getBoolean("bool_empresa"));     
                            
                            clsCotizacion objCotizacion= new clsCotizacion();            
                            objCotizacion.setInt_id_cotizacion(json_data.getInt("int_id_cotizacion"));
                            objCotizacion.setObjProforma(new clsProforma(json_data.getInt("int_id_proforma")));
                            objCotizacion.setInt_estado(json_data.getInt("int_estado"));
                            objCotizacion.setDat_fecha_creacion(new Date(json_data.getLong("dat_fecha_creacion")));
                            objCotizacion.setDat_fecha_finalizacion(new Date(json_data.getLong("dat_fecha_finalizacion")));
                            objCotizacion.setObjEmpresa(objEmpresa);
                            
                            clsCotizacionDAO.Agregar(clsServicio.this.getApplication(), objCotizacion);
                           }
                        }
                        
                        //objlistaDetalleCotizacion
                        clsDetalleCotizacionDAO.Borrar(clsServicio.this.getApplication());
                        JSONObject objlistaDetalleCotizacion = new JSONObject(objeto.getString("listaDetalleCotizacion"));
                        if(objlistaDetalleCotizacion.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objlistaDetalleCotizacion.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                                                       
                            clsDetalleCotizacion objDetalleCotizacion= new clsDetalleCotizacion();            
                            objDetalleCotizacion.setInt_id_detalle_cotizacion(json_data.getInt("int_id_detalle_cotizacion"));
                            objDetalleCotizacion.setInt_id_cotizacion(json_data.getInt("int_id_cotizacion"));
                            objDetalleCotizacion.setObjProducto(new clsProducto(json_data.getInt("int_id_producto")));
                            objDetalleCotizacion.setInt_cantidad(json_data.getInt("int_cantidad"));
                            objDetalleCotizacion.setInt_estado(json_data.getInt("int_estado"));
                            objDetalleCotizacion.setDou_costo(json_data.getDouble("dou_costo"));
                            
                            clsDetalleCotizacionDAO.Agregar(clsServicio.this.getApplication(), objDetalleCotizacion);
                           }
                        }
                    

                        }

                    }catch (JSONException ex) {
                        Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            
                                    
                                   
                                    
				}
			},
			0,
			UPDATE_INTERVAL);      
                
                

	}
	
	private void _shutdownService() {            
		if (timer != null) timer.cancel();
                borrarNotificacion();
	}
	
public void borrarNotificacion()
 {
     String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
    (NotificationManager) getSystemService(ns);
    notManager.cancelAll();
 }
public void borrarNotificacionxId(int Id)
 {
     String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
    (NotificationManager) getSystemService(ns);
    notManager.cancel(Id);
 }

public void Notificacion(String Titulo,String Motivo,int id,int idCosulta)
{
    String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
        (NotificationManager) getSystemService(ns);

//    int icono = R.drawable.seguros;
//    CharSequence textoEstado = Titulo;
//    long hora = System.currentTimeMillis();
//
//    Notification notif = 
//        new Notification(icono, textoEstado, hora);
//
//    Context contexto = getApplicationContext();
//    CharSequence titulo = Titulo;
//    CharSequence descripcion = Motivo;
//    Intent notIntent=null;
//    if(id==0)
//    notIntent = new Intent(contexto,MenuActivity.class);
//    else if(id==1)
//    {
//        notIntent = new Intent(contexto,.class);
//        notIntent.putExtra("Id",""+idCosulta);
//    }
//     else if(id==2)         
//        notIntent = new Intent(contexto,CitasActivity.class);
//    RespuestasConsultasActivity
//    PendingIntent contIntent = PendingIntent.getActivity(
//                contexto, 0, notIntent, 0);
//
//    notif.setLatestEventInfo(
//                contexto, titulo, descripcion, contIntent);
//
//    notif.flags |= Notification.FLAG_AUTO_CANCEL;
//    notif.flags |= Notification.FLAG_ONGOING_EVENT;
//    notif.defaults |= Notification.DEFAULT_SOUND;
//
//
//    notManager.notify(id, notif);                                      
}


         
         
    
}
