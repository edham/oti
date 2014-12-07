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
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import app.pay.plan.entidades.clsDistrito;
import app.pay.plan.entidades.clsEmpresa;
import app.pay.plan.entidades.clsMarca;
import app.pay.plan.entidades.clsProducto;
import app.pay.plan.entidades.clsProductoEmpresa;
import app.pay.plan.entidades.clsTipoProducto;
import app.pay.plan.http.http;
import app.pay.plan.sqlite.clsEmpresaDAO;
import app.pay.plan.sqlite.clsProductoDAO;
import app.pay.plan.sqlite.clsProductoEmpresaDAO;
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
        String dato=http.getListarProductos();
        try {
            JSONObject objetoLisataProducto = new JSONObject(dato);
            if(objetoLisataProducto.getInt("error")==0)
            {
               JSONArray Array = new JSONArray(objetoLisataProducto.getString("lista"));
               for(int i=0;i<Array.length();i++){
                
                JSONObject json_data = Array.getJSONObject(i);
                clsTipoProducto objTipoProducto = new clsTipoProducto();
                objTipoProducto.setInt_id_tipo_producto(json_data.getInt("int_id_tipo_producto"));
                objTipoProducto.setStr_nombre(json_data.getString("str_nombre_tipo_producto"));
                
                clsMarca objMarca = new clsMarca();
                objMarca.setInt_id_marca(json_data.getInt("int_id_marca"));
                objMarca.setStr_nombre(json_data.getString("str_nombre_marca"));
                
                clsProducto entidad= new clsProducto();            
                entidad.setInt_id_producto(json_data.getInt("int_id_producto"));
                entidad.setStr_nombre(json_data.getString("str_nombre"));
                entidad.setDat_fecha_actualizacion(new Date(json_data.getLong("dat_fecha_actualizacion")));
                entidad.setObjTipoProducto(objTipoProducto);
                entidad.setObjMarca(objMarca);
                clsProductoDAO.Agregar(this, entidad);
//                   Toast.makeText(LoginActivity.this,""+json_data.getString("str_nombre"), Toast.LENGTH_SHORT).show();
               }
            }
             } catch (JSONException ex) {
            Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void btnIngresar(View v) 
    {
      
            
        if(!txtUsuario.getText().toString().equals(null) && !txtUsuario.getText().toString().equals(null)
           && !txtPassword.getText().toString().equals("") && !txtPassword.getText().toString().equals(""))
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
                        JSONObject objetoLisataProducto = new JSONObject(objeto.getString("listaProducto"));
                        if(objetoLisataProducto.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objetoLisataProducto.getString("lista"));
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
                        
                        //objetoLisataProductoEmpresa
                        JSONObject objetoLisataProductoEmpresa = new JSONObject(objeto.getString("listaProductoEmpresa"));
                        if(objetoLisataProductoEmpresa.getInt("error")==0)
                        {
                           JSONArray Array = new JSONArray(objetoLisataProductoEmpresa.getString("lista"));
                           for(int i=0;i<Array.length();i++){

                            JSONObject json_data = Array.getJSONObject(i);
                            clsProductoEmpresa objProductoEmpresa= new clsProductoEmpresa();            
                            objProductoEmpresa.setInt_id_producto_empresa(json_data.getInt("int_id_producto_empresa"));
                            objProductoEmpresa.setDou_precio(json_data.getDouble("dou_precio"));
                            objProductoEmpresa.setObjProducto(new clsProducto(json_data.getInt("int_id_producto")));
                            clsProductoEmpresaDAO.Agregar(LoginActivity.this, objProductoEmpresa);
                           }
                        }
                        
                        pd.dismiss();         
                        Intent i=new Intent(LoginActivity.this,MenuActivity.class);
                        startActivity(i); 
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

}
