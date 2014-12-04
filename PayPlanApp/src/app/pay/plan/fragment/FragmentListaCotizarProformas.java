package app.pay.plan.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import app.pay.plan.entidades.clsMovimiento;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FragmentListaCotizarProformas extends Fragment {

    private  List<clsMovimiento> itensTemp=null;
    private  List<clsMovimiento> itens=null;
    private Adaptador adaptador;
    private ListView lista;
    private Button btnCancelar;
    private Button btnNuevo;
    
        

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_lista_regisro_proformas, container,
				false);
                btnNuevo = (Button)view.findViewById(R.id.btnNuevo);
                btnNuevo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       btnNuevo(); 
                    }
                }); 
                btnCancelar = (Button)view.findViewById(R.id.btnCancelar);
                btnCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       btnCancelar(); 
                    }
                }); 
                lista = (ListView)view.findViewById(R.id.lista); 
                
                setAdapter();
//                
		return view;
	}

     
      public void setAdapter( )
    {    
        itensTemp=new ArrayList<clsMovimiento>();          
        itensTemp.add(new clsMovimiento());
        itensTemp.add(new clsMovimiento());
        itensTemp.add(new clsMovimiento());
        itensTemp.add(new clsMovimiento());
        itensTemp.add(new clsMovimiento());
        itensTemp.add(new clsMovimiento());
        itensTemp.add(new clsMovimiento());
        itensTemp.add(new clsMovimiento());
        itensTemp.add(new clsMovimiento());
        
        
        adaptador = new Adaptador(this.getActivity());
        lista.setAdapter(adaptador);
    }
        
     class Adaptador extends ArrayAdapter {
    	
    	Activity context;

    	Adaptador(Activity context) {
    		super(context, R.layout.lista_proformas, itensTemp);
    		this.context = context;         
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            final int posicion = position;
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_proformas, null);
            
         
            
//            TextView lblNombreProducto = (TextView)item.findViewById(R.id.lblNombreProducto);
//            lblNombreProducto.setText("pro ucto");

//            TextView lblDetalleProducto = (TextView)item.findViewById(R.id.lblDetalleProducto);
//            lblDetalleProducto.setText("pro ucto - as sas pro ucto - asa as prod cto - asa as pro cto - asa as");
//            
            Button btnVer = (Button)item.findViewById(R.id.btnVer);
            btnVer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnVer(posicion);
                }
            }); 
               
            return(item);
	}
    }
     
    public void btnVer(int posicion){
 
         
 
//        final CharSequence[] items = {"Contado", "Una Parte","Cancelar"};   
//        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
//        alert.setTitle("Tipo de Pago");
//
//        alert.setItems(items, new DialogInterface.OnClickListener() {  
//            public void onClick(DialogInterface dialog, int item) { 
////            opciones_pago(item);
//         }});
//        alert.show();
        
        
        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_producto);
        
//        TextView lblHora = (TextView)dialog.findViewById(R.id.lblHora);
//        lblHora.setText(hora.format(lista.get(posicion).getDat_fecha_registro()));

      
        
        Button btnRegistrar = (Button) dialog.findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button btnCancelar = (Button) dialog.findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        dialog.show();

    }
    public void btnNuevo()
    {
        Fragment InicioFragment = new FragmentListaMisProductos();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }
    public void btnCancelar()
    {
        Fragment InicioFragment = new FragmentListaMisProductos();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
