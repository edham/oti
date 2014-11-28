package app.pay.plan.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import app.pay.plan.entidades.clsDepartamento;
import app.pay.plan.entidades.clsDistrito;
import app.pay.plan.entidades.clsProvincia;
import app.pay.plan.utilidades.clsUbigeo;
import java.util.List;

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
    
    private Spinner ComboDepartamento;
    private Spinner ComboProvincia;
    private Spinner ComboDistrito;
 
    private View viewEmpresa;
    private CheckBox chkEmpresa;
    private  ProgressDialog pd;
    
      public void onResume() {
            super.onResume();
            getActionBar().setTitle("Registro de Usuario");
      }
            
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        chkEmpresa = (CheckBox)findViewById(R.id.chkEmpresa);   
        viewEmpresa = (View)findViewById(R.id.viewEmpresa);   
        txtNombres = (EditText)findViewById(R.id.txtNombres);
        txtApellidos = (EditText)findViewById(R.id.txtApellidos);
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        txtCelular = (EditText)findViewById(R.id.txtCelular);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtRuc = (EditText)findViewById(R.id.txtRuc);
        txtRazonSocial = (EditText)findViewById(R.id.txtRazonSocial);
        txtUsuario = (EditText)findViewById(R.id.txtUsuario);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        txtRPassword = (EditText)findViewById(R.id.txtRPassword);
        
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
        
        lista.add(0,new clsDistrito(0,"Selecciones una Provincia"));
        
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
         Intent i=new Intent(RegistroActivity.this,LoginActivity.class);
            startActivity(i); 
            finish();

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
    
    public void btnCancelar(View v){
        Intent i=new Intent(RegistroActivity.this,LoginActivity.class);
            startActivity(i); 
            finish();
         
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
