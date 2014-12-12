package app.pay.plan.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import app.pay.plan.entidades.clsDepartamento;
import app.pay.plan.entidades.clsDistrito;
import app.pay.plan.entidades.clsEmpresa;
import app.pay.plan.entidades.clsProvincia;
import app.pay.plan.http.http;
import app.pay.plan.utilidades.Utilidades;
import app.pay.plan.utilidades.clsUbigeo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistroActivity extends Activity
{
    /** Called when the activity is first created. */
    private EditText txtNombres;
    private EditText txtApellidos;
    private EditText txtTelefono;
    private EditText txtCelular;
    private EditText txtEmail;
    private EditText txtRuc;
    private EditText txtRazonSocial;
    private EditText txtUsuario;
    private EditText txtPassword;
    private EditText txtRPassword;
    private EditText txtDireccion;
    
    private Spinner ComboDepartamento;
    private Spinner ComboProvincia;
    private Spinner ComboDistrito;
 
    private View viewEmpresa;
    private CheckBox chkEmpresa;
    private  ProgressDialog pd;
    
    private clsEmpresa entidad;
    
      public void onResume() {
            super.onResume();
            getActionBar().setTitle("Registro de Usuario");
      }
            
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        entidad = new clsEmpresa();
        chkEmpresa = (CheckBox)findViewById(R.id.chkEmpresa);   
        viewEmpresa = (View)findViewById(R.id.viewEmpresa);   
        txtNombres = (EditText)findViewById(R.id.txtNombres);
        txtNombres.setText("");
        txtApellidos = (EditText)findViewById(R.id.txtApellidos);
        txtApellidos.setText("");
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        txtTelefono.setText("");
        txtCelular = (EditText)findViewById(R.id.txtCelular);
        txtCelular.setText("");
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtEmail.setText(Utilidades.getMail(this));
        txtRuc = (EditText)findViewById(R.id.txtRuc);
        txtRuc.setText("");
        txtRazonSocial = (EditText)findViewById(R.id.txtRazonSocial);
        txtRazonSocial.setText("");
        txtUsuario = (EditText)findViewById(R.id.txtUsuario);
        txtUsuario.setText("");
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        txtPassword.setText("");
        txtRPassword = (EditText)findViewById(R.id.txtRPassword);
        txtRPassword.setText("");
        txtDireccion = (EditText)findViewById(R.id.txtDireccion);
        txtDireccion.setText("");
        
        ComboDepartamento = (Spinner)findViewById(R.id.ComboDepartamento);   
        ComboDepartamento();
        ComboProvincia = (Spinner)findViewById(R.id.ComboProvincia);   
   
        ComboDistrito = (Spinner)findViewById(R.id.ComboDistrito);   
    }
    public void ComboDepartamento (){
        List<clsDepartamento> lista=clsUbigeo.getListDepartamento();
        lista.add(0,new clsDepartamento(0,"Selecciones un Departamento"));
        
        ArrayAdapter<clsDepartamento> adapter = new ArrayAdapter<clsDepartamento>(this,
        android.R.layout.simple_spinner_item,lista);       
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboDepartamento.setAdapter(adapter);     
        ComboDepartamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
                ComboProvincia(((clsDepartamento)ComboDepartamento.getSelectedItem()).getInt_id_depatamento());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboDepartamento.setSelection(0);
    }
    
    public void ComboProvincia(int idDepartamento){
        List<clsProvincia> lista=clsUbigeo.getListProvinciaXDepartamento(idDepartamento);
        
        lista.add(0,new clsProvincia(0,"Selecciones un Provincia"));
        
        ArrayAdapter<clsProvincia> adapter = new ArrayAdapter<clsProvincia>(this,
        android.R.layout.simple_spinner_item,lista);       
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboProvincia.setAdapter(adapter);     
        ComboProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {                    
                ComboDistrito(((clsProvincia)ComboProvincia.getSelectedItem()).getInt_id_provincia());;
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboProvincia.setSelection(0);
    }
    
    public void ComboDistrito(int idProvincia){
        List<clsDistrito> lista=clsUbigeo.getListDistritoXProvincia(idProvincia);
        
        lista.add(0,new clsDistrito(0,"Selecciones un Distrito"));
        
        ArrayAdapter<clsDistrito> adapter = new ArrayAdapter<clsDistrito>(this,
        android.R.layout.simple_spinner_item,lista);       
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboDistrito.setAdapter(adapter);     
        ComboDistrito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {                    
                Toast.makeText(RegistroActivity.this,((clsDistrito)ComboDistrito.getSelectedItem()).getStr_nombre(), Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboDistrito.setSelection(0);
    }
    public void chkEmpresa(View v)
    {
          if(chkEmpresa.isChecked())
             viewEmpresa.setVisibility(View.VISIBLE);
          else
              viewEmpresa.setVisibility(View.GONE);
    }
    public void btnRegistrar(View v) 
    {
//         Intent i=new Intent(RegistroActivity.this,LoginActivity.class);
//            startActivity(i); 
//            finish();

        if(!txtNombres.getText().toString().equals("") )
        {
            if(!txtApellidos.getText().toString().equals(""))
            {
                if(ComboDistrito.getSelectedItemPosition()>0)
                {
                    if(txtTelefono.getText().toString().length()==9)
                    {
                        if(txtCelular.getText().toString().length()==9)
                        {
                            if(!txtDireccion.getText().toString().equals(""))
                            {
                                if(Utilidades.isValidEmail(txtEmail.getText().toString()))
                                {
                                    if(txtUsuario.getText().toString().length()>3)
                                    {
                                        if(txtPassword.getText().toString().length()>5)
                                        {
                                            if(txtRPassword.getText().toString().equals(txtPassword.getText().toString()))
                                            {
                                                entidad.setStr_usuario(txtUsuario.getText().toString());
                                                entidad.setStr_nombre_usuario(txtNombres.getText().toString());
                                                entidad.setStr_apellidos_usuario(txtApellidos.getText().toString());
                                                entidad.setObjDistrito((clsDistrito)ComboDistrito.getSelectedItem());
                                                entidad.setStr_telefono(txtTelefono.getText().toString());
                                                entidad.setStr_celular(txtCelular.getText().toString());
                                                entidad.setStr_email(txtEmail.getText().toString());
                                                entidad.setStr_clave(txtPassword.getText().toString());
                                                entidad.setBool_empresa(chkEmpresa.isChecked());
                                                entidad.setStr_direccion(txtDireccion.getText().toString());
                                                entidad.setStr_ruc("");
                                                entidad.setStr_razon_social("");
                                                 if(chkEmpresa.isChecked())
                                                 {
                                                    if(txtRuc.getText().toString().length()==11)
                                                    {
                                                        if(!txtRazonSocial.getText().toString().equals(""))
                                                        {
                                                            entidad.setStr_ruc(txtRuc.getText().toString());
                                                            entidad.setStr_razon_social(txtRazonSocial.getText().toString());
                                                            Registrar();    
                                                        }
                                                        else
                                                            Toast.makeText(this,"Ingrese Razón Social", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else
                                                        Toast.makeText(this,"Ingrese RUC de 11 digitos", Toast.LENGTH_SHORT).show();
                                                 }
                                                 else
                                                 {
                                                     Registrar();    
                                                 }

                                            }
                                            else
                                                Toast.makeText(this,"No coincide la contraseña", Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                            Toast.makeText(this,"Ingrese Contraseña mayor a 6 caracteres", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                        Toast.makeText(this,"Ingrese Usuario mayor a 4 caracteres", Toast.LENGTH_SHORT).show();
                                }
                                else
                                    Toast.makeText(this,"Ingrese una Dirección", Toast.LENGTH_SHORT).show();
                            }
                            else
                                Toast.makeText(this,"Ingrese E-mail", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(this,"Ingrese número de Celular de 9 digitos", Toast.LENGTH_SHORT).show();                        
                    }
                    else
                        Toast.makeText(this,"Ingrese número de Telefono fijo de 9 digitos", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this,"Seleccione una Provincia", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this,"Ingrese Apellidos", Toast.LENGTH_SHORT).show();        
        }
        else
            Toast.makeText(this,"Ingrese Nombres", Toast.LENGTH_SHORT).show();
        
          
    }
    
    public void Registrar()
    {
       
          pd = new ProgressDialog(this);
            pd.setTitle("Registrando Usuario");
            pd.setMessage("Espere un momento");     
            pd.show();        
            new Thread() { 
                public void run() { 
                    Message message = handlerEmpresa.obtainMessage();    
                    Bundle bundle = new Bundle();
                    bundle.putString("data", http.insertarEmpresa(entidad));
                    message.setData(bundle);
                    handlerEmpresa.sendMessage(message);     
                } 
        }.start();  
    }
    public void btnCancelar(View v){
        Intent i=new Intent(RegistroActivity.this,LoginActivity.class);
            startActivity(i); 
            finish();
         
    }
    
    
    
//      
  final  Handler handlerEmpresa = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();            
            try {
                JSONObject objeto = new JSONObject(bundle.getString("data"));
                if(objeto.getInt("id")>0)
                {
                    pd.dismiss();     
                    Toast.makeText(RegistroActivity.this,"El Usuario se Registro Correctamente", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(RegistroActivity.this,LoginActivity.class);
                    startActivity(i); 
                    finish();
                }
                else if(objeto.getInt("id")==0)
                {
                    pd.dismiss();  
                    Toast.makeText(RegistroActivity.this,"Error al Registrar", Toast.LENGTH_SHORT).show();
                }
                else if(objeto.getInt("id")==-1)
                {
                    pd.dismiss();  
                    Toast.makeText(RegistroActivity.this,"Error de Parametros", Toast.LENGTH_SHORT).show();
                }
                else if(objeto.getInt("id")==-2)
                {
                    pd.dismiss();  
                    Toast.makeText(RegistroActivity.this,"Error Servidor", Toast.LENGTH_SHORT).show();
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
