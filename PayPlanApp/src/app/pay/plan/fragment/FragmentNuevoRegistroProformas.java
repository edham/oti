package app.pay.plan.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import app.pay.plan.entidades.clsDetalleProforma;
import app.pay.plan.entidades.clsMarca;
import app.pay.plan.entidades.clsProducto;
import app.pay.plan.entidades.clsProforma;
import app.pay.plan.entidades.clsTipoProducto;
import app.pay.plan.http.http;
import app.pay.plan.sqlite.clsDetalleProformaDAO;
import app.pay.plan.sqlite.clsEmpresaDAO;
import app.pay.plan.sqlite.clsProductoDAO;
import app.pay.plan.sqlite.clsProformaEmpresaDAO;
import app.pay.plan.ui.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentNuevoRegistroProformas extends Fragment {

    private  List<clsDetalleProforma> litsDetalleProforma=null;
    
    private AdaptadorDetalle adaptadorDetalle;
    private ListView listaDetalle;
    private ListView lista;
    private Button btnCancelar;
    private Button btnRegistrar;
    private Button btnAgregar;
    
    private  List<clsMarca> listaMarca=null;
    private  List<clsTipoProducto> listaTipoProducto=null;
    
    private  List<clsProducto> itensTemp=null;
    private  List<clsProducto> itens=null;
    private Spinner ComboMarca; 
    private Spinner ComboTipo;
    private Adaptador adaptador;
    private EditText txtFiltro;
    private Dialog dialogProducto;
    
    private  ProgressDialog pd;
    
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
                
                litsDetalleProforma =new ArrayList<clsDetalleProforma>();         
                btnAgregar = (Button)view.findViewById(R.id.btnAgregar);
                btnAgregar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       btnAgregar(); 
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
                listaDetalle = (ListView)view.findViewById(R.id.lista); 

//                
		return view;
	}

     
      public void setAdapterDetalle()
    {         
        adaptadorDetalle = new AdaptadorDetalle(this.getActivity());
        listaDetalle.setAdapter(adaptadorDetalle);
    }
        
     class AdaptadorDetalle extends ArrayAdapter {
    	
    	Activity context;

    	AdaptadorDetalle(Activity context) {
    		super(context, R.layout.lista_productos, litsDetalleProforma);
    		this.context = context;         
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            final int posicion = position;
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_productos, null);
            
            TextView lblNombreProducto = (TextView)item.findViewById(R.id.lblNombreProducto);
            lblNombreProducto.setText(litsDetalleProforma.get(position).getObjProducto().getStr_nombre()+"\nTotal:"+litsDetalleProforma.get(position).getInt_cantidad());
            
            TextView lblTipoProducto = (TextView)item.findViewById(R.id.lblTipoProducto);
            lblTipoProducto.setText(litsDetalleProforma.get(position).getObjProducto().getObjTipoProducto().getStr_nombre());
            TextView lblMarca = (TextView)item.findViewById(R.id.lblMarca);
            lblMarca.setText(litsDetalleProforma.get(position).getObjProducto().getObjMarca().getStr_nombre());
            
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
        final int pos=posicion;
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
        alert.setTitle(litsDetalleProforma.get(posicion).getObjProducto().getStr_nombre());
        alert.setMessage("Desea eliminar este producto.");
        alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {  
                   litsDetalleProforma.remove(pos);
                   setAdapterDetalle();
                }});
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
               public void onClick(DialogInterface dialog, int whichButton) {    
            }});
               alert.show();
}
    
    public void btnRegistrar()
    {
        if(litsDetalleProforma.size()>0)
        {
            pd = new ProgressDialog(this.getActivity());
            pd.setTitle("Registrando Movimiento");
            pd.setMessage("Espere un momento");     
            pd.show();        
            new Thread() { 
                public void run() { 
                    try {
                        
                        JSONObject objetoProforma = new JSONObject(http.insertarProforma(clsEmpresaDAO.Buscar(FragmentNuevoRegistroProformas.this.getActivity()).getInt_id_empresa()));
                        if(objetoProforma.getInt("id")>0)
                        {
                            clsProforma objProforma = new clsProforma();
                            objProforma.setInt_id_proforma(objetoProforma.getInt("id"));
                            objProforma.setDat_fecha_creacion(new Date());
                            objProforma.setDat_fecha_finalizacion(new Date());
                            objProforma.setInt_estado(0);
                            clsProformaEmpresaDAO.Agregar(FragmentNuevoRegistroProformas.this.getActivity(), objProforma);
                            for(clsDetalleProforma entidad : litsDetalleProforma)
                            {
                                entidad.setInt_id_proforma(objProforma.getInt_id_proforma());
                                entidad.setInt_estado(0);
                                JSONObject objetoDetalle = new JSONObject(http.insertarDetalleProforma(entidad));
                                if(objetoDetalle.getInt("id")>0)
                                {
                                    entidad.setInt_id_detalle_proforma(objetoDetalle.getInt("id"));
                                    clsDetalleProformaDAO.Agregar(FragmentNuevoRegistroProformas.this.getActivity(), entidad);

                                }
                            }
                            Message message = handlerEmpresa.obtainMessage();
                            Bundle bundle = new Bundle();
                            bundle.putString("data", "0");
                            message.setData(bundle);     
                            handlerEmpresa.sendMessage(message);
                        }
                        
                    } catch (JSONException ex) {
                        Logger.getLogger(FragmentNuevoRegistroProformas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            }.start();
        }
        else
            Toast.makeText(this.getActivity(),"Ingrese un Producto o mas", Toast.LENGTH_SHORT).show();
            
        
        
    }
    public void btnCancelar()
    {
        Fragment InicioFragment = new FragmentListaRegistroProformas();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }
    
    public void btnAgregar()
    {
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
        itens=clsProductoDAO.ListarEmpresa(this.getActivity(),listaMarca.get(ComboMarca.getSelectedItemPosition()).getInt_id_marca(),listaTipoProducto.get(ComboTipo.getSelectedItemPosition()).getInt_id_tipo_producto(),clsEmpresaDAO.Buscar(this.getActivity()).isBool_empresa());
        itensTemp= new ArrayList<clsProducto>();
        for(clsProducto objProducto : itens)
            if(objProducto.getStr_nombre().toLowerCase().indexOf(filtro.toLowerCase()) != -1 )
            itensTemp.add(objProducto);
        
        adaptador = new Adaptador(this.getActivity());
        lista.setAdapter(adaptador);
    }
      
   public void btnVerDetalle(int posicion){
       
       boolean repetido=false;
       for(int i=0;i<litsDetalleProforma.size();i++)
           if(litsDetalleProforma.get(i).getObjProducto().getInt_id_producto()==itensTemp.get(posicion).getInt_id_producto())
           {
               repetido=true;
               i=litsDetalleProforma.size();
           }
           
       
       
       if(!repetido)
       {
        final int pos = posicion;
        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_producto);
        
        TextView lblTituloD = (TextView)dialog.findViewById(R.id.lblTituloD);
        lblTituloD.setText("Agregar Producto");
        
        TextView lblNombreProductoD = (TextView)dialog.findViewById(R.id.lblNombreProductoD);
        lblNombreProductoD.setText(itensTemp.get(posicion).getStr_nombre());
        
        TextView lblTipoProductoD = (TextView)dialog.findViewById(R.id.lblTipoProductoD);
        lblTipoProductoD.setText(itensTemp.get(posicion).getObjTipoProducto().getStr_nombre());
        
        TextView lblMarcaD = (TextView)dialog.findViewById(R.id.lblMarcaD);
        lblMarcaD.setText(itensTemp.get(posicion).getObjMarca().getStr_nombre());
        
        TextView lblPrecioD = (TextView)dialog.findViewById(R.id.lblPrecioD);
        lblPrecioD.setText("Cantidad:");
         
        final EditText txtPrecioD = (EditText)dialog.findViewById(R.id.txtPrecioD);
        txtPrecioD.setText("");
        
        Button btnRegistrar = (Button) dialog.findViewById(R.id.btnRegistrar);
        btnRegistrar.setText("Agregar");
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtPrecioD.getText().toString().equals(""))
                {
                    int precio=Integer.parseInt(txtPrecioD.getText().toString());
                    if(precio>0)
                    {
                        
                        litsDetalleProforma.add(new clsDetalleProforma(itensTemp.get(pos),precio));
                        dialog.dismiss();
                        setAdapterDetalle();
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
    else
        Toast.makeText(this.getActivity(),"Este Producto ya esta Selecionado", Toast.LENGTH_SHORT).show();
   }
   
   
      final  Handler handlerEmpresa = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();     
            Toast.makeText(FragmentNuevoRegistroProformas.this.getActivity(),"Se Registro Correctamente", Toast.LENGTH_SHORT).show();
            pd.dismiss();   
            Fragment InicioFragment = new FragmentListaRegistroProformas();	
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, InicioFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    };
}
