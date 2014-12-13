package app.pay.plan.fragment;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import app.pay.plan.entidades.clsCotizacion;
import app.pay.plan.entidades.clsDetalleCotizacion;
import app.pay.plan.entidades.clsProforma;
import app.pay.plan.sqlite.clsCotizacionDAO;
import app.pay.plan.sqlite.clsProformaEmpresaDAO;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import java.util.List;

public class FragmentDetalleRegistroProformas extends Fragment {

    private  List<clsCotizacion> itens=null;
    private Adaptador adaptador;
    private ListView lista;
    private Button btnNuevo;
    private int idProforma;
         @Override
        public void onResume() {
            super.onResume();
            getActivity().getActionBar().setTitle("DETALLE");
        }    


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_lista_regisro_proformas, container,
				false);
                idProforma=getArguments().getInt("idProforma");
                btnNuevo = (Button)view.findViewById(R.id.btnNuevo);
                btnNuevo.setText("Aceptar");
                btnNuevo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       btnNuevo(); 
                    }
                }); 
                lista = (ListView)view.findViewById(R.id.lista); 
                
                setAdapter();
//                
		return view;
	}

     
      public void setAdapter( )
    {    
        itens=clsCotizacionDAO.Listar(this.getActivity(), idProforma);          
        adaptador = new Adaptador(this.getActivity());
        lista.setAdapter(adaptador);
    }
        
     class Adaptador extends ArrayAdapter {
    	
    	Activity context;

    	Adaptador(Activity context) {
    		super(context, R.layout.lista_proformas, itens);
    		this.context = context;         
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            final int posicion = position;
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_proformas, null);
            
         
            
            TextView lblProforma = (TextView)item.findViewById(R.id.lblProforma);
            lblProforma.setText(Utilidades.getFechaCompletaString(itens.get(position).getDat_fecha_creacion()));
            String data="";
            for(clsDetalleCotizacion entidad : itens.get(position).getLista())
                    data="\n "+entidad.getObjProducto().getStr_nombre()+" - C:"+entidad.getInt_cantidad()+" - T:"+entidad.getDou_costo();
//        
            lblProforma.setText( lblProforma.getText().toString()+data);
            Button btnVer = (Button)item.findViewById(R.id.btnVer);
            btnVer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    btnVer(posicion);
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
        dialog.setContentView(R.layout.dialog_producto_proforma);
        
//        TextView lblHora = (TextView)dialog.findViewById(R.id.lblHora);
//        lblHora.setText(hora.format(lista.get(posicion).getDat_fecha_registro()));

      
        
//        Button btnRegistrar = (Button) dialog.findViewById(R.id.btnRegistrar);
//        btnRegistrar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
        Button btnCerrar = (Button) dialog.findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        dialog.show();

    }
    public void btnNuevo()
    {
        Fragment InicioFragment = new FragmentListaRegistroProformas();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }

}
