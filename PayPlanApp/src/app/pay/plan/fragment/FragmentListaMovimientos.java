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
import app.pay.plan.entidades.clsMovimiento;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FragmentListaMovimientos extends Fragment {
    
    private  List<clsMovimiento> itensTemp=null;
    private  List<clsMovimiento> itens=null;
    private Adaptador adaptador;
    private ListView lista;
    private Calendar calendar;
    private int mYear;    
    private int mMonth;    
    private int mDay; 
    private TextView lblFecha;
    private Button btnIzquierda;
    private Button btnDerecha;
    private Button btnRefresh;
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_lista_movimientos, container,false);
                
                lista = (ListView)view.findViewById(R.id.lista); 
                
                btnRefresh = (Button) view.findViewById(R.id.btnRefresh);
                btnRefresh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnRefresh();
                    }
                }); 
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
                
                
                
                
                Calendar calendarA = Calendar.getInstance();
                calendarA.add(Calendar.DAY_OF_YEAR, -3);
                itens=new ArrayList<clsMovimiento>();    
                itens.add(new clsMovimiento(new Date(calendarA.getTimeInMillis())));  
                itens.add(new clsMovimiento(new Date(calendarA.getTimeInMillis())));  
                 calendarA.add(Calendar.DAY_OF_YEAR, 1);
                itens.add(new clsMovimiento(new Date(calendarA.getTimeInMillis())));  
                itens.add(new clsMovimiento(new Date(calendarA.getTimeInMillis())));  
                itens.add(new clsMovimiento(new Date()));
                itens.add(new clsMovimiento(new Date()));
                calendarA.add(Calendar.DAY_OF_YEAR, 3);
                itens.add(new clsMovimiento(new Date(calendarA.getTimeInMillis())));  
                itens.add(new clsMovimiento(new Date(calendarA.getTimeInMillis())));  
                calendarA.add(Calendar.DAY_OF_YEAR, 1);
                itens.add(new clsMovimiento(new Date(calendarA.getTimeInMillis())));  
                itens.add(new clsMovimiento(new Date(calendarA.getTimeInMillis())));  
        
                
                setFecha();
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
        
        public void btnRefresh(){
            calendar = Calendar.getInstance();
            setFecha();
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
        
        setAdapter();
    
    }
    
     public void setAdapter( )
    {    
        itensTemp=new ArrayList<clsMovimiento>();   
        for(clsMovimiento entidad : itens)
         if(0<=Utilidades.getDias(entidad.getDat_fecha_creacion(),calendar.getTime()))
             itensTemp.add(entidad);
        
        
        adaptador = new Adaptador(this.getActivity());
        lista.setAdapter(adaptador);
    }

     class Adaptador extends ArrayAdapter {
    	
    	Activity context;

    	Adaptador(Activity context) {
    		super(context, R.layout.lista_movimientos, itensTemp);
    		this.context = context;         
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
//            final int posicion = position;
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_movimientos, null);
            
            int diffDays2 = Utilidades.getDias(itensTemp.get(position).getDat_fecha_creacion(),new Date());
            if(diffDays2<0)
            {
                View viewAntes = (View)item.findViewById(R.id.viewAntes);
                viewAntes.setVisibility(View.VISIBLE);
            }
            else if(diffDays2==0)
            {
                View viewActual = (View)item.findViewById(R.id.viewActual);
                viewActual.setVisibility(View.VISIBLE);                
            }
            if(diffDays2>0)   
            {
                View viewDespues = (View)item.findViewById(R.id.viewDespues);
                viewDespues.setVisibility(View.VISIBLE);                
            }
            
        
            TextView lblDiaMovimiento = (TextView)item.findViewById(R.id.lblDiaMovimiento);
            lblDiaMovimiento.setText(Utilidades.getFechaString(itensTemp.get(position).getDat_fecha_creacion()));


         
            return(item);
	}
    }
}
