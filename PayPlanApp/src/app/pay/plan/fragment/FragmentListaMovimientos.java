package app.pay.plan.fragment;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import app.pay.plan.entidades.clsMovimiento;
import app.pay.plan.sqlite.clsMovimientoDAO;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FragmentListaMovimientos extends Fragment {
    
    private Spinner ComboTipoMovimiento;
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
    private Button btnNuevo;
    private Button btnEstadisticas;
    private List<String> listStringMovimiento = Arrays.asList("Movimiento Unico", "Movimiento a Plazos", "Movimiento Mensual");
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_lista_movimientos, container,false);
                
                lista = (ListView)view.findViewById(R.id.lista); 
                
                ComboTipoMovimiento = (Spinner)view.findViewById(R.id.ComboTipoMovimiento);   
                ComboTipoMovimiento();
                
                btnNuevo = (Button) view.findViewById(R.id.btnNuevo);
                btnNuevo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnNuevo();
                    }
                }); 
                btnEstadisticas = (Button) view.findViewById(R.id.btnEstadisticas);
                btnEstadisticas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnEstadisticas();
                    }
                }); 
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
        itens=clsMovimientoDAO.Listar(this.getActivity(), ComboTipoMovimiento.getSelectedItemPosition());
        itensTemp=new ArrayList<clsMovimiento>();   
        for(clsMovimiento entidad : itens)
         if(0<=Utilidades.getDias(entidad.getDat_fecha_movimiento(),calendar.getTime()))
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
            
            View viewMovimiento = (View)item.findViewById(R.id.viewMovimiento);
            
            ImageView imageTipoMovimiento = (ImageView)item.findViewById(R.id.imageTipoMovimiento);
            Button btnVer = (Button)item.findViewById(R.id.btnVer);
            btnVer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                        btnIzquierda();
                }
            });  
            int diffDays = Utilidades.getDias(itensTemp.get(position).getDat_fecha_movimiento(),new Date());
            
            if(diffDays<0)
            {
               viewMovimiento.setBackgroundResource(R.drawable.rojo);
            }
            else if(diffDays==0)
            {
                
            }
            if(diffDays>0)   
            {
                viewMovimiento.setBackgroundResource(R.drawable.azul); 
            }
            
            if(!itensTemp.get(position).isBool_ingreso())
            {
                imageTipoMovimiento.setImageResource(R.drawable.btn_menos); 
            }
            
            TextView lblDiaMovimiento = (TextView)item.findViewById(R.id.lblDiaMovimiento);
            lblDiaMovimiento.setText(Utilidades.getFechaString(itensTemp.get(position).getDat_fecha_movimiento())+" S/."+Utilidades.getRedondear(itensTemp.get(position).getDou_total(), 2));

            
            TextView lblMovimiento = (TextView)item.findViewById(R.id.lblMovimiento);
            
            if(itensTemp.get(position).getObjTipoMovimiento().getInt_id_tipo_movimiento()==1)
            {
                lblMovimiento.setText(listStringMovimiento.get(0)+"\n Servicio "
                        +itensTemp.get(position).getObjServicio().getStr_nombre()
                        +"\n"+itensTemp.get(position).getStr_detalle());
            }
            else if(itensTemp.get(position).getObjTipoMovimiento().getInt_id_tipo_movimiento()==2)
            {
                lblMovimiento.setText(listStringMovimiento.get(1)+"\n Servicio "
                        +itensTemp.get(position).getObjServicio().getStr_nombre()
                        +"\n Coutas "+itensTemp.get(position).getInt_couta_ingresadas()+" de "+itensTemp.get(position).getInt_couta_total()
                        +"\n"+itensTemp.get(position).getStr_detalle());
            }
             else if(itensTemp.get(position).getObjTipoMovimiento().getInt_id_tipo_movimiento()==3)
             {
                lblMovimiento.setText(listStringMovimiento.get(2)+"\n Servicio "
                        +itensTemp.get(position).getObjServicio().getStr_nombre()
                        +"\n"+itensTemp.get(position).getStr_detalle());
             }
            
               
            return(item);
	}
    }
     
     
   public void ComboTipoMovimiento (){
        List<String> listString = Arrays.asList("Todos", "Entrada", "Salida");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboTipoMovimiento.setAdapter(adapter);     
        ComboTipoMovimiento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
                setAdapter( );
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboTipoMovimiento.setSelection(0);
    }
   
   public void btnNuevo()
   {
        Bundle args = new Bundle();
        args.putInt("IdPersona",0);
        Fragment InicioFragment = new FragmentNuevoMovimiento();
        InicioFragment.setArguments(args);	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
       
   }
   public void btnEstadisticas()
   {
       
   }
}
