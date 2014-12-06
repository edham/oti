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
import app.pay.plan.entidades.clsProducto;
import app.pay.plan.sqlite.clsProductoDAO;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FragmentListaMisProductos extends Fragment {

    private  List<clsProducto> itensTemp=null;
    private  List<clsProducto> itens=null;
    private Adaptador adaptador;
    private ListView lista;
    private Spinner ComboTipo;
    private Spinner ComboMarca;
    private Button btnNuevo;
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_lista_mis_productos, container,
				false);
                btnNuevo = (Button)view.findViewById(R.id.btnNuevo);
                btnNuevo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       btnNuevo(); 
                    }
                }); 
                lista = (ListView)view.findViewById(R.id.lista); 
                ComboTipo = (Spinner)view.findViewById(R.id.ComboTipo);   
                ComboTipo();
                ComboMarca = (Spinner)view.findViewById(R.id.ComboMarca);   
                ComboMarca();
                itens=clsProductoDAO.Listar(this.getActivity(),0,0);          
                setAdapter();
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
        
        public void ComboMarca (){
        List<String> listString = Arrays.asList("Seleccione un Movimiento", "Entrada", "Salida");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboMarca.setAdapter(adapter);     
        ComboMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
//                ComboProvincia(((clsTipoMovimiento)ComboTipo.getSelectedItem()).getInt_id_depatamento());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboMarca.setSelection(0);
    }
        
      public void setAdapter( )
    {    
        itensTemp=itens;
        adaptador = new Adaptador(this.getActivity());
        lista.setAdapter(adaptador);
    }
        
     class Adaptador extends ArrayAdapter {
    	
    	Activity context;

    	Adaptador(Activity context) {
    		super(context, R.layout.lista_mis_productos, itensTemp);
    		this.context = context;         
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            final int posicion = position;
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_mis_productos, null);

            TextView lblNombreProducto = (TextView)item.findViewById(R.id.lblNombreProducto);
            lblNombreProducto.setText(itensTemp.get(position).getStr_nombre());

            TextView lblDetalleProducto = (TextView)item.findViewById(R.id.lblDetalleProducto);
            lblDetalleProducto.setText("pro ucto - as sas pro ucto - asa as prod cto - asa as pro cto - asa as");
            
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
        Fragment InicioFragment = new FragmentListaProductos();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }
}
