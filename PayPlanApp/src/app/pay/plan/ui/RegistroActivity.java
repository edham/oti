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
import app.pay.plan.entidades.clsUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistroActivity extends Activity
{
    /** Called when the activity is first created. */
    private EditText txtUsuario;
    private EditText txtPassword;
    private  ProgressDialog pd;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
//        txtUsuario = (EditText)findViewById(R.id.txtUsuario);
//        txtPassword = (EditText)findViewById(R.id.txtPassword);
        
       
//       
//        txtUsuario.setText("otiniano");
//        txtPassword.setText("123456");
    }
    
    public void btnIngresar(View v) 
    {
         Intent i=new Intent(RegistroActivity.this,MenuActivity.class);
            startActivity(i); 

//        if(!txtUsuario.getText().toString().equals(null) && !txtUsuario.getText().toString().equals(null)
//           && !txtPassword.getText().toString().equals("") && !txtPassword.getText().toString().equals(""))
//        {
//            pd = new ProgressDialog(this);
//            pd.setTitle("Cargando Datos");
//            pd.setMessage("Espere un momento");     
//            pd.show();        
//            new Thread() { 
//                public void run() { 
//                    Message message = handler.obtainMessage();    
//                    Bundle bundle = new Bundle();
//                    bundle.putString("data",  http.getLogin(txtUsuario.getText().toString(), txtPassword.getText().toString()));
//                    message.setData(bundle);
//                    handler.sendMessage(message);     
//                } 
//        }.start();  
//
//    }
//      
//    else	    
//        Toast.makeText(this,"Por favor ingrese todos los campos.", Toast.LENGTH_SHORT).show();
    }
    
    
    
    
//      
//    final  Handler handler = new Handler()
//    {
//        @Override
//        public void handleMessage(Message msg) {
//            Bundle bundle = msg.getData();            
//            try {
//                JSONObject objeto = new JSONObject(bundle.getString("data"));
//                if(objeto.getInt("error")==0)
//                {
//                    clsUsuario entidad=new clsUsuario();
//                    entidad.setInt_id_usuario(objeto.getInt("int_id_usuario"));
//                    entidad.setStr_nombre(objeto.getString("str_nombre"));
//                    entidad.setStr_apellidos(objeto.getString("str_apellidos"));
//                    entidad.setStr_email(objeto.getString("str_email"));
//                    entidad.setStr_telefono(objeto.getString("str_telefono"));
//                    entidad.setInt_estado(objeto.getInt("int_estado"));
//
//                    Toast.makeText(RegistroActivity.this,"Bienvenido "+entidad.getStr_nombre()+" "+entidad.getStr_apellidos(), Toast.LENGTH_SHORT).show();
//
//                }
//                else if(objeto.getInt("error")==1)
//                    Toast.makeText(RegistroActivity.this,"Error de Credenciales", Toast.LENGTH_SHORT).show();
//                else if(objeto.getInt("error")==2)
//                    Toast.makeText(RegistroActivity.this,"Error Servidor", Toast.LENGTH_SHORT).show();
//                else if(objeto.getInt("error")==3)
//                    Toast.makeText(RegistroActivity.this,"Error Conexion", Toast.LENGTH_SHORT).show();
//            }catch (JSONException ex) {
//                Logger.getLogger(RegistroActivity.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            pd.dismiss();         
//            Intent i=new Intent(RegistroActivity.this,MenuActivity.class);
//            startActivity(i); 
//        }
//    };
}
