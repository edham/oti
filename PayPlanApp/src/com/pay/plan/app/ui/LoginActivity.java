package com.pay.plan.app.ui;

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
import com.pay.plan.app.entidades.clsUsuario;
import com.pay.plan.app.http.http;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        setContentView(R.layout.login);
        txtUsuario = (EditText)findViewById(R.id.txtUsuario);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        
        TextView lblLink = (TextView)findViewById(R.id.lblLink);
        lblLink.setText(Html.fromHtml(getString(R.string.web)));
        Linkify.addLinks(lblLink, Linkify.ALL);
        lblLink.setMovementMethod(LinkMovementMethod.getInstance());
        txtUsuario.setText("otiniano");
        txtPassword.setText("123456");
    }
    
    public void btnIngresar(View v) 
    {

        if(!txtUsuario.getText().toString().equals(null) && !txtUsuario.getText().toString().equals(null)
           && !txtPassword.getText().toString().equals("") && !txtPassword.getText().toString().equals(""))
        {
            pd = new ProgressDialog(this);
            pd.setTitle("Cargando Datos");
            pd.setMessage("Espere un momento");     
            pd.show();        
            new Thread() { 
                public void run() { 
                    Message message = handler.obtainMessage();    
                    Bundle bundle = new Bundle();
                    bundle.putString("data",  http.getLogin(txtUsuario.getText().toString(), txtPassword.getText().toString()));
                    message.setData(bundle);
                    handler.sendMessage(message);     
                } 
        }.start();  

    }
      
    else	    
        Toast.makeText(this,"Por favor ingrese todos los campos.", Toast.LENGTH_SHORT).show();
    }
    
    
    
    
      
    final  Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();            
            try {
                JSONObject objeto = new JSONObject(bundle.getString("data"));
                if(objeto.getInt("error")==0)
                {
                    clsUsuario entidad=new clsUsuario();
                    entidad.setInt_id_usuario(objeto.getInt("int_id_usuario"));
                    entidad.setStr_nombre(objeto.getString("str_nombre"));
                    entidad.setStr_apellidos(objeto.getString("str_apellidos"));
                    entidad.setStr_email(objeto.getString("str_email"));
                    entidad.setStr_telefono(objeto.getString("str_telefono"));
                    entidad.setInt_estado(objeto.getInt("int_estado"));

                    Toast.makeText(LoginActivity.this,"Bienvenido "+entidad.getStr_nombre()+" "+entidad.getStr_apellidos(), Toast.LENGTH_SHORT).show();

                }
                else if(objeto.getInt("error")==1)
                    Toast.makeText(LoginActivity.this,"Error de Credenciales", Toast.LENGTH_SHORT).show();
                else if(objeto.getInt("error")==2)
                    Toast.makeText(LoginActivity.this,"Error Servidor", Toast.LENGTH_SHORT).show();
                else if(objeto.getInt("error")==3)
                    Toast.makeText(LoginActivity.this,"Error Conexion", Toast.LENGTH_SHORT).show();
            }catch (JSONException ex) {
                Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, null, ex);
            }

            pd.dismiss();         
            Intent i=new Intent(LoginActivity.this,MenuActivity.class);
            startActivity(i); 
        }
    };
}
