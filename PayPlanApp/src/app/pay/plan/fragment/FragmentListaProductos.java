package app.pay.plan.fragment;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import app.pay.plan.entidades.clsMarca;
import app.pay.plan.entidades.clsProducto;
import app.pay.plan.entidades.clsTipoProducto;
import app.pay.plan.sqlite.clsProductoDAO;
import app.pay.plan.ui.R;
import java.util.ArrayList;
import java.util.List;

public class FragmentListaProductos extends Fragment {

    private  List<clsProducto> itensTemp=null;
    private  List<clsProducto> itens=null;
    private  List<clsMarca> listaMarca=null;
    private  List<clsTipoProducto> listaTipoProducto=null;
    private Adaptador adaptador;
    private ListView lista;
    private Spinner ComboTipo;
    private Spinner ComboMarca;
    private Button btnCancelar;
    private Button btnNuevo;
    private EditText txtFiltro;
        
        @Override
        public void onResume() {
            super.onResume();
            getActivity().getActionBar().setTitle("LISTA DE PRODUCTOS");
        }
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_lista_productos, container,
				false);
                listaMarca=clsProductoDAO.ListarMarca(this.getActivity());
                listaTipoProducto=clsProductoDAO.ListarTipoProducto(this.getActivity());
                
                
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
                ComboTipo = (Spinner)view.findViewById(R.id.ComboTipo);   
                ComboTipo();
                ComboMarca = (Spinner)view.findViewById(R.id.ComboMarca);   
                ComboMarca();                
                txtFiltro = (EditText) view.findViewById(R.id.txtFiltro);
                txtFiltro.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,int count) {                                
                            setAdapter(s.toString().trim()); 
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
                setAdapter("");
		return view;
	}

        public void ComboTipo (){
            
        listaTipoProducto.add(0,new clsTipoProducto(0,"Todos los Tipos"));
        
        List<String> listString = new ArrayList<String>();
        for(clsTipoProducto objTipoMovimiento:listaTipoProducto)
            listString.add(objTipoMovimiento.getStr_nombre());
            
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboTipo.setAdapter(adapter);   
        ComboTipo.setSelection(0);
        ComboTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
                 setAdapter(txtFiltro.getText().toString());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        
    }
        
    public void ComboMarca (){
        listaMarca.add(0,new clsMarca(0,"Todas las Marcas"));
        List<String> listString = new ArrayList<String>();
        for(clsMarca objMarca:listaMarca)
            listString.add(objMarca.getStr_nombre());
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboMarca.setAdapter(adapter);    
        ComboMarca.setSelection(0);
        ComboMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
                setAdapter(txtFiltro.getText().toString());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
       
    }
        
      public void setAdapter(String filtro)
    {   
        itens=clsProductoDAO.Listar(this.getActivity(),listaMarca.get(ComboMarca.getSelectedItemPosition()).getInt_id_marca(),listaTipoProducto.get(ComboTipo.getSelectedItemPosition()).getInt_id_tipo_producto());
        itensTemp= new ArrayList<clsProducto>();
        for(clsProducto objProducto : itens)
            if(objProducto.getStr_nombre().toLowerCase().indexOf(filtro.toLowerCase()) != -1 )
            itensTemp.add(objProducto);
        
        adaptador = new Adaptador(this.getActivity());
        lista.setAdapter(adaptador);
    }
        
     class Adaptador extends ArrayAdapter {
    	
    	Activity context;

    	Adaptador(Activity context) {
    		super(context, R.layout.lista_productos, itensTemp);
    		this.context = context;         
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            final int posicion = position;
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_productos, null);
            
         
            
            TextView lblNombreProducto = (TextView)item.findViewById(R.id.lblNombreProducto);
            lblNombreProducto.setText(itensTemp.get(position).getStr_nombre());
            TextView lblTipoProducto = (TextView)item.findViewById(R.id.lblTipoProducto);
            lblTipoProducto.setText(itensTemp.get(position).getObjTipoProducto().getStr_nombre());
            TextView lblMarca = (TextView)item.findViewById(R.id.lblMarca);
            lblMarca.setText(itensTemp.get(position).getObjMarca().getStr_nombre());

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
        
        TextView lblTituloD = (TextView)dialog.findViewById(R.id.lblTituloD);
        lblTituloD.setText("Agregar a Mis Productos");
        
        TextView lblNombreProductoD = (TextView)dialog.findViewById(R.id.lblNombreProductoD);
        lblNombreProductoD.setText(itensTemp.get(posicion).getStr_nombre());
        
        TextView lblTipoProductoD = (TextView)dialog.findViewById(R.id.lblTipoProductoD);
        lblTipoProductoD.setText(itensTemp.get(posicion).getObjTipoProducto().getStr_nombre());
        
        TextView lblMarcaD = (TextView)dialog.findViewById(R.id.lblMarcaD);
        lblMarcaD.setText(itensTemp.get(posicion).getObjMarca().getStr_nombre());
        
        final EditText txtPrecioD = (EditText)dialog.findViewById(R.id.txtPrecioD);
        txtPrecioD.setText("");
        
        Button btnRegistrar = (Button) dialog.findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtPrecioD.getText().toString().equals(""))
                {
                    double precio=Double.parseDouble(txtPrecioD.getText().toString());
                    if(precio>0)
                    {
                        dialog.dismiss();
                    }
                    else
                        Toast.makeText(FragmentListaProductos.this.getActivity(),"Debe ser mayor que 0", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(FragmentListaProductos.this.getActivity(),"Este campo es obligatorio", Toast.LENGTH_SHORT).show();
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
