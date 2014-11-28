package app.pay.plan.fragment;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import app.pay.plan.entidades.clsMovimiento;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FragmentListaMovimientos extends Fragment {

    private  List<clsMovimiento> itensTemp=null;
    private Adaptador adaptador;
    private ListView lista;
    private Calendar calendar;
    private int mYear;    
    private int mMonth;    
    private int mDay; 
    private TextView lblFecha;
    private Button btnIzquierda;
    private Button btnDerecha;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_lista_movimientos, container,false);
                
                lista = (ListView)view.findViewById(R.id.lista); 
                
                btnIzquierda = (Button) view.findViewById(R.id.btnIzquierda);
                btnIzquierda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnIzquierda();
                    }
                });   
                btnDerecha = (Button) view.findViewById(R.id.btnDerecha);
                btnDerecha.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnDerecha();
                    }
                });   
                lblFecha = (TextView)view.findViewById(R.id.lblFecha);
                lblFecha.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lblFecha();
                    }
                });   
                calendar = Calendar.getInstance();
                setFecha();
                setAdapter();
		return view;
	}
        
        public void btnIzquierda(){
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            setFecha();
        }
        
        public void btnDerecha(){
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            setFecha();
        }
        
        public void lblFecha(){
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
            setFecha();    
    	}
    }
       
    public void setFecha()
    {
        lblFecha.setText(Utilidades.getFecha(calendar.getTime()));
        
        int diffDays = Utilidades.getDias(calendar.getTime(),new Date());
        
        if(diffDays<0)
            lblFecha.setTextColor(Color.RED);
        else if(diffDays==0)
            lblFecha.setTextColor(getResources().getColor(R.color.negro));
        if(diffDays>0)   
            lblFecha.setTextColor(Color.BLUE);
    
    }
    
     public void setAdapter( )
    {    
        Calendar calendarAdapter = Calendar.getInstance();
        calendarAdapter.add(Calendar.DAY_OF_YEAR, -3);
        
        itensTemp=new ArrayList<clsMovimiento>();    
        itensTemp.add(new clsMovimiento(new Date(calendarAdapter.getTimeInMillis()))); 
        itensTemp.add(new clsMovimiento(new Date(calendarAdapter.getTimeInMillis()))); 
        calendarAdapter.add(Calendar.DAY_OF_YEAR, 1);
        itensTemp.add(new clsMovimiento(new Date(calendarAdapter.getTimeInMillis())));  
        itensTemp.add(new clsMovimiento(new Date(calendarAdapter.getTimeInMillis())));  
        itensTemp.add(new clsMovimiento(new Date()));
        itensTemp.add(new clsMovimiento(new Date()));
        calendarAdapter.add(Calendar.DAY_OF_YEAR, 3);
        itensTemp.add(new clsMovimiento(new Date(calendarAdapter.getTimeInMillis())));  
        itensTemp.add(new clsMovimiento(new Date(calendarAdapter.getTimeInMillis())));  
        calendarAdapter.add(Calendar.DAY_OF_YEAR, 1);
        itensTemp.add(new clsMovimiento(new Date(calendarAdapter.getTimeInMillis())));
        itensTemp.add(new clsMovimiento(new Date(calendarAdapter.getTimeInMillis()))); 
        
        adaptador = new Adaptador(this.getActivity());
        lista.setAdapter(adaptador);
    }

     class Adaptador extends ArrayAdapter {
    	
    	Activity context;
    	Calendar calendarAdapter = calendar;
        
        
        boolean fecha=true;
        
    	Adaptador(Activity context) {
    		super(context, R.layout.lista_movimientos, itensTemp);
    		this.context = context;
                
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            final int posicion = position;
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_movimientos, null);
            if(fecha)
            {               
                TextView lblDiaMovimiento = (TextView)item.findViewById(R.id.lblDiaMovimiento);
                lblDiaMovimiento.setVisibility(View.VISIBLE);
                lblDiaMovimiento.setText(Utilidades.getFecha(itensTemp.get(position).getDat_fecha_creacion()));
                fecha=false;
            }
            else
            {
                int diffDays = Utilidades.getDias(itensTemp.get(position).getDat_fecha_creacion(),calendarAdapter.getTime());
                if(diffDays!=0)
                {
                    TextView lblDiaMovimiento = (TextView)item.findViewById(R.id.lblDiaMovimiento);
                    lblDiaMovimiento.setVisibility(View.VISIBLE);
                    lblDiaMovimiento.setText(Utilidades.getFecha(itensTemp.get(position).getDat_fecha_creacion()));
                    calendarAdapter.setTime(itensTemp.get(position).getDat_fecha_creacion());
                }
            }
           
            
            int diffDays = Utilidades.getDias(itensTemp.get(position).getDat_fecha_creacion(),new Date());
            if(diffDays<0)
            {
                View viewAntes = (View)item.findViewById(R.id.viewAntes);
                viewAntes.setVisibility(View.VISIBLE);
            }
            else if(diffDays==0)
            {
                View viewActual = (View)item.findViewById(R.id.viewActual);
                viewActual.setVisibility(View.VISIBLE);                
            }
            if(diffDays>0)   
            {
                View viewDespues = (View)item.findViewById(R.id.viewDespues);
                viewDespues.setVisibility(View.VISIBLE);                
            }
            
            
            
            
             
            

            return(item);
	}
    }
}
