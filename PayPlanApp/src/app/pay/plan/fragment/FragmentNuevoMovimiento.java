package app.pay.plan.fragment;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
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
import app.pay.plan.entidades.clsTipoMovimiento;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class FragmentNuevoMovimiento extends Fragment {
    
    private Spinner ComboTipo;
    private Spinner ComboTipoMovimiento;
    private Spinner ComboTiempo;
    private Spinner ComboDiasAlerta;
    private Spinner ComboTiempoAlerta;
    
    private TextView lblTipo;
    private TextView lblInicioPago;
    private TextView lblPagoAcumulado;
    
    private View viewNumeroCoutas;
    private View viewCoutaPago;
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
            txtPagoTotal = (EditText)view.findViewById(R.id.txtPagoTotal); 
            txtNumeroCoutas = (EditText)view.findViewById(R.id.txtNumeroCoutas); 
            txtDetalle = (EditText)view.findViewById(R.id.txtDetalle); 
            
            viewNumeroCoutas = (View)view.findViewById(R.id.viewNumeroCoutas);
            viewCoutaPago = (View)view.findViewById(R.id.viewCoutaPago);
            viewDiasAlerta = (View)view.findViewById(R.id.viewDiasAlerta);
            viewTiempoAlerta = (View)view.findViewById(R.id.viewTiempoAlerta);
            
            lblPagoAcumulado = (TextView)view.findViewById(R.id.lblPagoAcumulado); 
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
            ComboTipoMovimiento = (Spinner)view.findViewById(R.id.ComboTipoMovimiento);   
            ComboTipoMovimiento();
            ComboTiempo = (Spinner)view.findViewById(R.id.ComboTiempo);   
            ComboTiempo();
            
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
        
    public void ComboTipoMovimiento(){
       
        List<clsTipoMovimiento> listaServicio = new ArrayList<clsTipoMovimiento>();
        listaServicio.add(new clsTipoMovimiento(0,"Selecione un Servicios"));
        listaServicio.add(new clsTipoMovimiento(1,"Luz"));
        listaServicio.add(new clsTipoMovimiento(2,"Agua"));
        listaServicio.add(new clsTipoMovimiento(3,"Colegio"));
        listaServicio.add(new clsTipoMovimiento(4,"Universidad"));
        
        List<String> listString = new ArrayList<String>();
        for(clsTipoMovimiento entidad : listaServicio)
        listString.add(entidad.getStr_nombre());
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboTipoMovimiento.setAdapter(adapter);     
        ComboTipoMovimiento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
//                ComboProvincia(((clsTipoMovimiento)ComboServicio.getSelectedItem()).getInt_id_depatamento());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboTipoMovimiento.setSelection(0);
    }
    
    public void ComboTiempo(){
        listStringMovimiento = Arrays.asList("Movimiento Unico", "Movimiento a Plazos", "Movimiento Mensual");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listStringMovimiento);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboTiempo.setAdapter(adapter);     
        ComboTiempo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
                setComboTiempo(position);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboTiempo.setSelection(0);
    }

     public void ComboDiasAlerta (){
        List<String> listString = Arrays.asList("El mismo día", "Un día de anticipación", "Dos días de anticipación", "Tres días de anticipación");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboDiasAlerta.setAdapter(adapter);     
        ComboDiasAlerta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
//                ComboProvincia(((clsTipoMovimiento)ComboTipo.getSelectedItem()).getInt_id_depatamento());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboDiasAlerta.setSelection(0);
    }
    public void ComboTiempoAlerta (){
        List<String> listString = Arrays.asList("Cada hora", "Cada dos horas", "Cada tres horas");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboTiempoAlerta.setAdapter(adapter);     
        ComboTiempoAlerta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
//                ComboProvincia(((clsTipoMovimiento)ComboTipo.getSelectedItem()).getInt_id_depatamento());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboTiempoAlerta.setSelection(0);
    }
        
    public void setComboTiempo(int posicion)
    {
        lblTipo.setText(listStringMovimiento.get(posicion).toString());
        if(ComboTiempo.getSelectedItemPosition()==0)
        {
            viewNumeroCoutas.setVisibility(View.GONE);
            viewCoutaPago.setVisibility(View.GONE);
            viewDiasAlerta.setVisibility(View.GONE);
            viewTiempoAlerta.setVisibility(View.GONE);
            
        }
        else if(ComboTiempo.getSelectedItemPosition()==1)
        {
            viewNumeroCoutas.setVisibility(View.VISIBLE);
            viewCoutaPago.setVisibility(View.VISIBLE);
            viewDiasAlerta.setVisibility(View.VISIBLE);
            viewTiempoAlerta.setVisibility(View.VISIBLE);
            
        }
        else if(ComboTiempo.getSelectedItemPosition()==2)
        {
            viewNumeroCoutas.setVisibility(View.GONE);
            viewCoutaPago.setVisibility(View.GONE);
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
        Fragment InicioFragment = new FragmentListaMovimientos();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }
    private void btnCancelar()
    {
        Fragment InicioFragment = new FragmentListaMovimientos();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }
}
