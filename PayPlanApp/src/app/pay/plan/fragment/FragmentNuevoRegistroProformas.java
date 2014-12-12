package app.pay.plan.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import app.pay.plan.entidades.clsMarca;
import app.pay.plan.entidades.clsMovimiento;
import app.pay.plan.entidades.clsProducto;
import app.pay.plan.entidades.clsTipoProducto;
import app.pay.plan.sqlite.clsProductoDAO;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FragmentNuevoRegistroProformas extends Fragment {

    private  List<clsMovimiento> litsMovimientoTemp=null;
    private  List<clsMovimiento> litsMovimiento=null;
    private AdaptadorDetalle adaptadorDetalle;
    private ListView listaDetalle;
    private ListView lista;
    private Button btnCancelar;
    private Button btnRegistrar;
    private  List<clsMarca> listaMarca=null;
    private  List<clsTipoProducto> listaTipoProducto=null;
    private  List<clsProducto> itensTemp=null;
    private  List<clsProducto> itens=null;
    private Spinner ComboMarca; 
    private Spinner ComboTipo;
    private Adaptador adaptador;
    private EditText txtFiltro;
    private Dialog dialogProducto;
    
    @Override
        public void onResume() {
            super.onResume();
            getActivity().getActionBar().setTitle("NUEVA PROFORMA");
        }    

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_nuevo_regisro_proformas, container,
				false);
                listaMarca=clsProductoDAO.ListarMarca(this.getActivity());
                listaMarca.add(0,new clsMarca(0,"Todas las Marcas"));
                
                listaTipoProducto=clsProductoDAO.ListarTipoProducto(this.getActivity());
                listaTipoProducto.add(0,new clsTipoProducto(0,"Todos los Tipos"));
                
                
                
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
                listaDetalle = (ListView)view.findViewById(R.id.lista); 
                
                setAdapterDetalle();
//                
		return view;
	}

     
      public void setAdapterDetalle()
    {    
        litsMovimientoTemp=new ArrayList<clsMovimiento>();          
        litsMovimientoTemp.add(new clsMovimiento());
        litsMovimientoTemp.add(new clsMovimiento());
        litsMovimientoTemp.add(new clsMovimiento());
        litsMovimientoTemp.add(new clsMovimiento());
        litsMovimientoTemp.add(new clsMovimiento());
        litsMovimientoTemp.add(new clsMovimiento());
        litsMovimientoTemp.add(new clsMovimiento());
        litsMovimientoTemp.add(new clsMovimiento());
        litsMovimientoTemp.add(new clsMovimiento());
        
        
        adaptadorDetalle = new AdaptadorDetalle(this.getActivity());
        listaDetalle.setAdapter(adaptadorDetalle);
    }
        
     class AdaptadorDetalle extends ArrayAdapter {
    	
    	Activity context;

    	AdaptadorDetalle(Activity context) {
    		super(context, R.layout.lista_proformas, litsMovimientoTemp);
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
 
        dialogProducto = new Dialog(this.getActivity());
        dialogProducto.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogProducto.setCancelable(false);
        dialogProducto.setContentView(R.layout.dialog_producto_proforma);
         
        lista = (ListView)dialogProducto.findViewById(R.id.lista); 
        ComboMarca = (Spinner)dialogProducto.findViewById(R.id.ComboMarca); 
        ComboTipo = (Spinner)dialogProducto.findViewById(R.id.ComboTipo);  
        txtFiltro = (EditText) dialogProducto.findViewById(R.id.txtFiltro);
        
            List<String> listStringTipoProducto = new ArrayList<String>();
            for(clsTipoProducto objTipoMovimiento:listaTipoProducto)
                listStringTipoProducto.add(objTipoMovimiento.getStr_nombre());
            
            
            ArrayAdapter<String> adapterTipo = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listStringTipoProducto);
            adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_item);
            ComboTipo.setAdapter(adapterTipo);   
            ComboTipo.setSelection(0);
            ComboTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
                     setAdapter(txtFiltro.getText().toString());
                }
                public void onNothingSelected(AdapterView<?> parent) {
                    //User selected same item. Nothing to do.
                }
            });
            
            
        
            List<String> listStringMarca = new ArrayList<String>();
            for(clsMarca objMarca:listaMarca)
                listStringMarca.add(objMarca.getStr_nombre());


            ArrayAdapter<String> adapterMarca = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listStringMarca);
            adapterMarca.setDropDownViewResource(android.R.layout.simple_spinner_item);
            ComboMarca.setAdapter(adapterMarca);    
            ComboMarca.setSelection(0);
            ComboMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
                    setAdapter(txtFiltro.getText().toString());
                }
                public void onNothingSelected(AdapterView<?> parent) {
                    //User selected same item. Nothing to do.
                }
            });
        
                
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
        

        Button btnCerrar = (Button) dialogProducto.findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogProducto.dismiss();
            }
        });
        
        dialogProducto.show();

    }
    public void btnRegistrar()
    {
        Fragment InicioFragment = new FragmentListaRegistroProformas();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }
    public void btnCancelar()
    {
        Fragment InicioFragment = new FragmentListaRegistroProformas();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
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
                    dialogProducto.dismiss();
                    btnVerDetalle(posicion);
                }
            }); 
               
            return(item);
	}
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
      
   public void btnVerDetalle(int posicion){
 
         
 
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
                        Toast.makeText(FragmentNuevoRegistroProformas.this.getActivity(),"Debe ser mayor que 0", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(FragmentNuevoRegistroProformas.this.getActivity(),"Este campo es obligatorio", Toast.LENGTH_SHORT).show();
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
}
