package app.pay.plan.fragment;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import app.pay.plan.entidades.clsEmpresa;
import app.pay.plan.entidades.clsMovimiento;
import app.pay.plan.entidades.clsServicio;
import app.pay.plan.entidades.clsTipoMovimiento;
import app.pay.plan.http.http;
import app.pay.plan.sqlite.clsEmpresaDAO;
import app.pay.plan.sqlite.clsMovimientoDAO;
import app.pay.plan.sqlite.clsServicioDAO;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentNuevoMovimiento extends Fragment {
    
    private List<clsServicio> listServicio;
     
    private Spinner ComboTipo;
    private Spinner ComboServicio;
    private Spinner ComboMovimiento;
    private Spinner ComboDiasAlerta;
    private Spinner ComboTiempoAlerta;
    
    private TextView lblTipo;
    private TextView lblInicioPago;
    
    private View viewNumeroCoutas;
    private View viewDiasAlerta;
    private View viewTiempoAlerta;
    
    private EditText txtPagoTotal;
    private EditText txtNumeroCoutas;
    private EditText txtDetalle;
    
    private Button btnRegistrar;
    private Button btnCancelar;
    
    private List<String> listStringMovimiento = Arrays.asList("Movimiento Unico", "Movimiento a Plazos", "Movimiento Mensual");
     
    private Calendar calendar;
    private int mYear;    
    private int mMonth;    
    private int mDay; 
    
    private clsMovimiento entidad = new clsMovimiento();
    private  ProgressDialog pd;
    @Override
        public void onResume() {
            super.onResume();
            getActivity().getActionBar().setTitle("Nuevo Movimiento");
        }
       
        
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
//
            View view = inflater.inflate(R.layout.fragment_nuevo_movimiento, container,
                            false);
            listServicio=clsServicioDAO.Listar(this.getActivity(),0);
            
            txtPagoTotal = (EditText)view.findViewById(R.id.txtPagoTotal); 
            txtPagoTotal.setText("");
            txtNumeroCoutas = (EditText)view.findViewById(R.id.txtNumeroCoutas); 
            txtNumeroCoutas.setText("");
            txtDetalle = (EditText)view.findViewById(R.id.txtDetalle); 
            txtDetalle.setText("");
            
            viewNumeroCoutas = (View)view.findViewById(R.id.viewNumeroCoutas);
            viewDiasAlerta = (View)view.findViewById(R.id.viewDiasAlerta);
            viewTiempoAlerta = (View)view.findViewById(R.id.viewTiempoAlerta);
            
            lblTipo = (TextView)view.findViewById(R.id.lblTipo); 
            lblInicioPago = (TextView)view.findViewById(R.id.lblInicioPago);
            lblInicioPago.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lblInicioPago();
                }
            });  
            btnRegistrar = (Button)view.findViewById(R.id.btnRegistrar);
            btnRegistrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnRegistrar();
                }
            });  
            btnCancelar = (Button)view.findViewById(R.id.btnCancelar);
            btnCancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnCancelar();
                }
            });  
            ComboTipo = (Spinner)view.findViewById(R.id.ComboTipo);   
            ComboTipo();
            ComboServicio = (Spinner)view.findViewById(R.id.ComboServicio);   
            ComboServicio();
            ComboMovimiento = (Spinner)view.findViewById(R.id.ComboMovimiento);   
            ComboMovimiento();
            
            ComboDiasAlerta = (Spinner)view.findViewById(R.id.ComboDiasAlerta);   
            ComboDiasAlerta();
            
            ComboTiempoAlerta = (Spinner)view.findViewById(R.id.ComboTiempoAlerta);   
            ComboTiempoAlerta();
            
            calendar = Calendar.getInstance();
            lblInicioPago.setText(Utilidades.getFecha(calendar.getTime()));
            return view;
	}
        
    public void ComboTipo (){
        List<String> listString = Arrays.asList("Seleccione un Movimiento", "Entrada", "Salida");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboTipo.setAdapter(adapter);     
        ComboTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
//                ComboProvincia(((clsTipoMovimiento)ComboTipo.getSelectedItem()).getInt_id_depatamento());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboTipo.setSelection(0);
    }
        
      public void ComboServicio (){
       
        listServicio.add(0,new clsServicio(0,"Todas los Servicios"));
        List<String> listString = new ArrayList<String>();
        for(clsServicio objMarca:listServicio)
            listString.add(objMarca.getStr_nombre());
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboServicio.setAdapter(adapter);     
        ComboServicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
//                addMaker();
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboServicio.setSelection(0);
    }
    public void ComboMovimiento(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listStringMovimiento);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboMovimiento.setAdapter(adapter);     
        ComboMovimiento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
                setComboTiempo(position);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboMovimiento.setSelection(0);
    }

     public void ComboDiasAlerta (){
        List<String> listString = Arrays.asList("El mismo día", "Un día de anticipación", "Dos días de anticipación", "Tres días de anticipación");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboDiasAlerta.setAdapter(adapter);     
        ComboDiasAlerta.setSelection(0);
    }
    public void ComboTiempoAlerta (){
        List<String> listString = Arrays.asList("Cada hora", "Cada dos horas", "Cada tres horas");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboTiempoAlerta.setAdapter(adapter);     
        ComboTiempoAlerta.setSelection(0);
    }
        
    public void setComboTiempo(int posicion)
    {
        lblTipo.setText(listStringMovimiento.get(posicion).toString());
        if(ComboMovimiento.getSelectedItemPosition()==0)
        {
            viewNumeroCoutas.setVisibility(View.GONE);
            viewDiasAlerta.setVisibility(View.GONE);
            viewTiempoAlerta.setVisibility(View.GONE);
            
        }
        else if(ComboMovimiento.getSelectedItemPosition()==1)
        {
            viewNumeroCoutas.setVisibility(View.VISIBLE);
            viewDiasAlerta.setVisibility(View.VISIBLE);
            viewTiempoAlerta.setVisibility(View.VISIBLE);
            
        }
        else if(ComboMovimiento.getSelectedItemPosition()==2)
        {
            viewNumeroCoutas.setVisibility(View.GONE);
            viewDiasAlerta.setVisibility(View.VISIBLE);
            viewTiempoAlerta.setVisibility(View.VISIBLE); 
        }
    }
    
    public void lblInicioPago(){ 
        DialogFragment newFragment = new SelectDateFragment();
        newFragment.show(getFragmentManager(), "DatePicker");
    }
    
    public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    	@Override
    	public Dialog onCreateDialog(Bundle savedInstanceState) {
			int yy = calendar.get(Calendar.YEAR);
			int mm = calendar.get(Calendar.MONTH);
			int dd = calendar.get(Calendar.DAY_OF_MONTH);
			return new DatePickerDialog(getActivity(), this, yy, mm, dd);
    	}
    	
    	public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            mYear = yy;                    
            mMonth = mm;                    
            mDay = dd;   
            calendar.set(mYear, mMonth, mDay);
            lblInicioPago.setText(Utilidades.getFecha(calendar.getTime()));
    	}
    }
    
    private void btnRegistrar()
    {
         if(ComboTipo.getSelectedItemPosition()>0)
        {
            if(ComboServicio.getSelectedItemPosition()>0)
            {
                if(calendar.getTime().getTime()>=(new Date()).getTime())
                {
                    if(!txtPagoTotal.getText().toString().equals("") )
                    {
                        if(Double.parseDouble(txtPagoTotal.getText().toString())>0)
                        {
                            if(!txtDetalle.getText().toString().equals("") )
                            {    
                                entidad.setBool_ingreso(false);
                                if(ComboTipo.getSelectedItemPosition()==1)
                                    entidad.setBool_ingreso(true);
                                entidad.setObjEmpresa(clsEmpresaDAO.Buscar(this.getActivity()));
                                entidad.setObjTipoMovimiento(new clsTipoMovimiento(ComboMovimiento.getSelectedItemPosition()+1));
                                entidad.setObjServicio(listServicio.get(ComboServicio.getSelectedItemPosition()));
                                entidad.setDat_fecha_movimiento(calendar.getTime());
                                entidad.setDou_total(Double.parseDouble(txtPagoTotal.getText().toString()));
                                entidad.setInt_couta_total(0);
                                entidad.setStr_detalle(txtDetalle.getText().toString());
                                entidad.setInt_alerta_inicio(ComboDiasAlerta.getSelectedItemPosition());
                                entidad.setInt_repeticion_alerta(ComboTiempoAlerta.getSelectedItemPosition());
                                entidad.setDat_fecha_creacion(new Date());
                                entidad.setDou_total_acumulado(0);
                                entidad.setInt_couta_ingresadas(0);
                                if(ComboMovimiento.getSelectedItemPosition()==0 || ComboMovimiento.getSelectedItemPosition()==2)
                                    Registrar();
                                else 
                                {
                                     if(!txtNumeroCoutas.getText().toString().equals("") )
                                    {
                                        if(Integer.parseInt(txtNumeroCoutas.getText().toString())>0)
                                        {
                                            
                                            entidad.setInt_couta_total(Integer.parseInt(txtNumeroCoutas.getText().toString()));
                                            Registrar();
                                        }
                                        else 
                                            Toast.makeText(this.getActivity(),"Ingrese un Número de Coutas mayor a cero", Toast.LENGTH_SHORT).show();    
                                    }
                                    else
                                        Toast.makeText(this.getActivity(),"Ingrese un Número de Coutas", Toast.LENGTH_SHORT).show();    
                                }
                            }
                            else 
                                Toast.makeText(this.getActivity(),"Ingrese Detalle", Toast.LENGTH_SHORT).show();                     
                        }
                        else
                            Toast.makeText(this.getActivity(),"Ingrese Pago Total mayor a cero", Toast.LENGTH_SHORT).show();    
                    }
                    else
                        Toast.makeText(this.getActivity(),"Ingrese Pago Total", Toast.LENGTH_SHORT).show();    
                }
                else
                    Toast.makeText(this.getActivity(),"Inicio de Pago debe ser igual o mayor a la fecha actual", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this.getActivity(),"Seleccione un Servicio", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this.getActivity(),"Seleccione un Movimiento", Toast.LENGTH_SHORT).show();
        
    }
  
    public void Registrar()
    {
        
          pd = new ProgressDialog(this.getActivity());
            pd.setTitle("Registrando Movimiento");
            pd.setMessage("Espere un momento");     
            pd.show();        
            new Thread() { 
                public void run() { 
                    Message message = handlerEmpresa.obtainMessage();    
                    Bundle bundle = new Bundle();
                    bundle.putString("data", http.insertarMovimiento(entidad));
                    message.setData(bundle);
                    handlerEmpresa.sendMessage(message);     
                } 
        }.start();
    }
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
                    entidad.setInt_id_movimiento(objeto.getInt("id"));
                    
                    clsMovimientoDAO.Agregar(FragmentNuevoMovimiento.this.getActivity(), entidad);
                    
                    Toast.makeText(FragmentNuevoMovimiento.this.getActivity(),"El Movimiento se Registro Correctamente", Toast.LENGTH_SHORT).show();
                    Fragment InicioFragment = new FragmentListaMovimientos();	
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.content_frame, InicioFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(objeto.getInt("id")==0)
                {
                    pd.dismiss();  
                    Toast.makeText(FragmentNuevoMovimiento.this.getActivity(),"Error al Registrar", Toast.LENGTH_SHORT).show();
                }
                else if(objeto.getInt("id")==-1)
                {
                    pd.dismiss();  
                    Toast.makeText(FragmentNuevoMovimiento.this.getActivity(),"Error de Parametros", Toast.LENGTH_SHORT).show();
                }
                else if(objeto.getInt("id")==-2)
                {
                    pd.dismiss();  
                    Toast.makeText(FragmentNuevoMovimiento.this.getActivity(),"Error Servidor", Toast.LENGTH_SHORT).show();
                }
            }catch (JSONException ex) { }
        }
    };
    private void btnCancelar()
    {
        Fragment InicioFragment = new FragmentListaMovimientos();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }
}
