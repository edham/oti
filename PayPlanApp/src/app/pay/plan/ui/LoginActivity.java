package app.pay.plan.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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
import app.pay.plan.entidades.clsServicio;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends Activity
{
    /** Called when the activity is first created. */
    private EditText txtUsuario;
    private EditText txtPassword;
    private  ProgressDialog pd;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsuario = (EditText)findViewById(R.id.txtUsuario);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        
        TextView lblLink = (TextView)findViewById(R.id.lblLink);
        lblLink.setText(Html.fromHtml(getString(R.string.web)));
        Linkify.addLinks(lblLink, Linkify.ALL);
        lblLink.setMovementMethod(LinkMovementMethod.getInstance());
        txtUsuario.setText("otiniano");
        txtPassword.setText("123456");
        if(clsEmpresaDAO.Buscar(this)!=null)
        {
            Intent i=new Intent(LoginActivity.this,MenuActivity.class);
            startActivity(i); 
            finish();
        }
    }
    public void btnRegistrarme(View v) 
    {
        Intent i=new Intent(LoginActivity.this,RegistroActivity.class);
        startActivity(i); 
        finish();
    }
    public void btnIngresar(View v) 
    {
      
            
        if(!txtUsuario.getText().toString().equals("") && !txtPassword.getText().toString().equals(""))
        {
            pd = new ProgressDialog(this);
            pd.setTitle("Datos de Usuario");
            pd.setMessage("Cargando...");
            pd.show();
            new Thread() {
                public void run() {
                    Message message = handlerEmpresa.obtainMessage();    
                    Bundle bundle = new Bundle();
                    bundle.putString("data",  http.getLogin(txtUsuario.getText().toString(), txtPassword.getText().toString()));
                    message.setData(bundle);
                    handlerEmpresa.sendMessage(message);
                }
        }.start();  

    }

    else	    
        Toast.makeText(this,"Por favor ingrese todos los campos.", Toast.LENGTH_SHORT).show();
       
    }
    
    
    
    
      
    final  Handler handlerEmpresa = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();            
            try {
                JSONObject objeto = new JSONObject(bundle.getString("data"));
                if(objeto.getInt("error")==0)
                {
                    clsEmpresa entidad=new clsEmpresa();
                    entidad.setInt_id_empresa(objeto.getInt("int_id_empresa"));
                    entidad.setStr_nombre_usuario(objeto.getString("str_nombre_usuario"));
                    entidad.setStr_apellidos_usuario(objeto.getString("str_apellidos_usuario"));
                    entidad.setStr_email(objeto.getString("str_email"));
                    entidad.setStr_telefono(objeto.getString("str_telefono"));
                    entidad.setStr_celular(objeto.getString("str_celular"));
                    entidad.setStr_razon_social(objeto.getString("str_razon_social"));
                    entidad.setStr_ruc(objeto.getString("str_ruc"));
                    entidad.setStr_direccion(objeto.getString("str_direccion"));
                    entidad.setBool_empresa(objeto.getBoolean("bool_empresa"));
                    entidad.setObjDistrito(new clsDistrito(objeto.getInt("int_id_distrito")));
                    entidad.setStr_usuario(txtUsuario.getText().toString());
                    entidad.setStr_clave(txtPassword.getText().toString());
                    entidad.setInt_estado(0);
                    int id=clsEmpresaDAO.Agregar(LoginActivity.this, entidad);
                    if(id>0)
                    {
                        //objetoLisataProducto
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
                            clsProductoDAO.Agregar(LoginActivity.this, objProducto);
                           }
                        }
                        
                        //objetoListarProductoEmpresa
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
                            clsProductoEmpresaDAO.Agregar(LoginActivity.this, objProductoEmpresa);
                           }
                        }
                        //objetoListarAgente
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
                            
                            clsAgenteDAO.Agregar(LoginActivity.this, objAgente);
                           }
                        }
                        
                        //objetoListarAgente
                        JSONObject objetoListarServicio = new JSONObject(objeto.getString("listaServicio"));
                        if(objetoListarServicio.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objetoListarServicio.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                                                       
                            clsServicio objServicio= new clsServicio();            
                            objServicio.setInt_id_servicio(json_data.getInt("int_id_servicio"));
                            objServicio.setStr_nombre(json_data.getString("str_nombre"));
                            
                            clsServicioDAO.Agregar(LoginActivity.this, objServicio);
                           }
                        }
                         //objetoListarAgente
                        JSONObject objetoListarAgenteServicio = new JSONObject(objeto.getString("listaAgenteServicio"));
                        if(objetoListarAgenteServicio.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objetoListarAgenteServicio.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                                                       
                            clsAgenteServicio objAgenteServicio= new clsAgenteServicio();            
                            objAgenteServicio.setInt_agente_servicio(json_data.getInt("int_agente_servicio"));
                            objAgenteServicio.setInt_id_agente(json_data.getInt("int_id_agente"));
                            objAgenteServicio.setObjServicio(new clsServicio(json_data.getInt("int_id_servicio")));
                            clsAgenteServicioDAO.Agregar(LoginActivity.this, objAgenteServicio);
                           }
                        }
                         //objListaMovimiento
                        JSONObject objListaMovimiento = new JSONObject(objeto.getString("listaMovimiento"));
                        if(objListaMovimiento.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objListaMovimiento.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                                                       
                            clsMovimiento objMovimiento= new clsMovimiento();            
                            objMovimiento.setInt_id_movimiento(json_data.getInt("int_id_movimiento"));
                            objMovimiento.setObjTipoMovimiento(new clsTipoMovimiento(json_data.getInt("int_id_tipo_movimiento")));
                            objMovimiento.setObjServicio(new clsServicio(json_data.getInt("int_id_servicio")));
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
                            clsMovimientoDAO.Agregar(LoginActivity.this, objMovimiento);
                           }
                        }
                         //objetoListarAgente
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
                            clsItemMovimientoDAO.Agregar(LoginActivity.this, objItemMovimiento);
                           }
                        }
                         //objListaProformaEmpresa
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
                            clsProformaEmpresaDAO.Agregar(LoginActivity.this, objProforma);
                           }
                        }
                        //objListaProforma
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
                            
                            clsProformaDAO.Agregar(LoginActivity.this, objProforma);
                           }
                        }
                         //objlistaDetalleProforma
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
                            clsDetalleProformaDAO.Agregar(LoginActivity.this, objDetalleProforma);
                           }
                        }
                        
                        //objListaCotizacion
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
                            
                            clsCotizacionDAO.Agregar(LoginActivity.this, objCotizacion);
                           }
                        }
                        
                        //objlistaDetalleCotizacion
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
                            
                            clsDetalleCotizacionDAO.Agregar(LoginActivity.this, objDetalleCotizacion);
                           }
                        }
                        pd.dismiss();         
                        Intent i=new Intent(LoginActivity.this,MenuActivity.class);
                        startActivity(i); 
                        finish();
                    }
                    
                    
                }
                else if(objeto.getInt("error")==1)
                {
                    pd.dismiss();  
                    Toast.makeText(LoginActivity.this,"Error de Credenciales", Toast.LENGTH_SHORT).show();
                }
                else if(objeto.getInt("error")==2)
                {
                    pd.dismiss();  
                    Toast.makeText(LoginActivity.this,"Error Servidor", Toast.LENGTH_SHORT).show();
                }
                else if(objeto.getInt("error")==3)
                {
                    pd.dismiss();  
                    Toast.makeText(LoginActivity.this,"Error Conexion", Toast.LENGTH_SHORT).show();
                }
            }catch (JSONException ex) {
                Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }
    };

     @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
   
    
    return false;

    }
}
