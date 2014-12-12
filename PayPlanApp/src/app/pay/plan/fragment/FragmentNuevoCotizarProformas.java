package app.pay.plan.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import app.pay.plan.entidades.clsDetalleProforma;
import app.pay.plan.http.http;
import app.pay.plan.sqlite.clsDetalleProformaDAO;
import app.pay.plan.sqlite.clsEmpresaDAO;
import app.pay.plan.sqlite.clsProformaDAO;
import app.pay.plan.ui.R;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentNuevoCotizarProformas extends Fragment {

    private  List<clsDetalleProforma> itens=null;
    private Adaptador adaptador;
    private ListView lista;
    private Button btnCancelar;
    private Button btnRegistrar;
    private int idProforma;
    private  ProgressDialog pd;
         @Override
        public void onResume() {
            super.onResume();
            getActivity().getActionBar().setTitle("COTIZAR");
        }    


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_nuevo_regisro_cotizacion, container,
				false);
                idProforma=getArguments().getInt("idProforma");
                itens=clsDetalleProformaDAO.ListarProforma(FragmentNuevoCotizarProformas.this.getActivity(),idProforma);   

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
                lista = (ListView)view.findViewById(R.id.lista); 
                
                setAdapter();
//                
		return view;
	}

     
      public void setAdapter()
    {    
        adaptador = new Adaptador(this.getActivity());
        lista.setAdapter(adaptador);
    }
        
      class Adaptador extends ArrayAdapter {
    	
    	Activity context;

    	Adaptador(Activity context) {
    		super(context, R.layout.lista_productos, itens);
    		this.context = context;         
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            final int posicion = position;
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_productos, null);
            TextView lblNombreProducto = (TextView)item.findViewById(R.id.lblNombreProducto);
            if(itens.get(position).getObjProducto().getDou_precio()==0)
            {
                item.setBackgroundResource(R.color.rojo_oscuro);            
                View viewVer = (View)item.findViewById(R.id.viewVer);
                viewVer.setVisibility(View.GONE);
                lblNombreProducto.setText(itens.get(position).getObjProducto().getStr_nombre()
                    +"\nCantidad: "+itens.get(position).getInt_cantidad());
            }
            else 
            {
             lblNombreProducto.setText(itens.get(position).getObjProducto().getStr_nombre()+" P:"
                    +itens.get(position).getObjProducto().getDou_precio()
                    +"\nCantidad: "+itens.get(position).getInt_cantidad()+" T:"
                    +(itens.get(position).getObjProducto().getDou_precio()*itens.get(position).getInt_cantidad()));
                if(itens.get(position).isBool_seleccionado())
                    item.setBackgroundResource(R.color.azul_oscuro);     
            }
            TextView lblTipoProducto = (TextView)item.findViewById(R.id.lblTipoProducto);
            lblTipoProducto.setText(itens.get(position).getObjProducto().getObjTipoProducto().getStr_nombre());
            TextView lblMarca = (TextView)item.findViewById(R.id.lblMarca);
            lblMarca.setText(itens.get(position).getObjProducto().getObjMarca().getStr_nombre());

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
     
    
      public void btnRegistrar()
    {
        boolean rpta=false;
        for(int i=0;i<itens.size();i++)
            if(itens.get(i).isBool_seleccionado())
            {
                rpta=true;
                i=itens.size();
            }

        if(rpta)
        {
            pd = new ProgressDialog(this.getActivity());
            pd.setTitle("Registrando Movimiento");
            pd.setMessage("Espere un momento");     
            pd.show();        
            new Thread() { 
                public void run() { 
                    try {
                        int id=0;
                        JSONObject objetoProforma = new JSONObject(http.insertarCotizacion(clsEmpresaDAO.Buscar(FragmentNuevoCotizarProformas.this.getActivity()).getInt_id_empresa(),idProforma));
                        if(objetoProforma.getInt("id")>0)
                        {
                            id=objetoProforma.getInt("id");
                            
                            clsProformaDAO.BorrarId(FragmentNuevoCotizarProformas.this.getActivity(), idProforma);
                            for(clsDetalleProforma entidad : itens)
                            {
                                entidad.setInt_id_proforma(id);
                                http.insertarDetalleCotizacion(entidad);
                                
                            }
                            Message message = handlerEmpresa.obtainMessage();
                            Bundle bundle = new Bundle();
                            bundle.putString("data", "0");
                            message.setData(bundle);     
                            handlerEmpresa.sendMessage(message);
                        }
                        
                    } catch (JSONException ex) {}
                } 
            }.start();
        }
        else
            Toast.makeText(this.getActivity(),"Selecione al menos un Producto o mas", Toast.LENGTH_SHORT).show();
            
        
        
    }
    
    public void btnCancelar()
    {
        Fragment InicioFragment = new FragmentListaCotizarProformas();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }

     public void btnVer(int posicion){
        final int pos=posicion;
        String titulo="Quitar "+itens.get(posicion).getObjProducto().getStr_nombre();
        if(!itens.get(posicion).isBool_seleccionado())
            titulo="Selecionar "+itens.get(posicion).getObjProducto().getStr_nombre();
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
        alert.setTitle(titulo);
        alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {  
                    if(itens.get(pos).isBool_seleccionado())
                        itens.get(pos).setBool_seleccionado(false);
                    else  
                        itens.get(pos).setBool_seleccionado(true);
                        setAdapter();

                }});
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
               public void onClick(DialogInterface dialog, int whichButton) {    
            }});
        alert.show();
    }
     
     
       final  Handler handlerEmpresa = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();     
            Toast.makeText(FragmentNuevoCotizarProformas.this.getActivity(),"Se Registro Correctamente", Toast.LENGTH_SHORT).show();
            pd.dismiss();   
            Fragment InicioFragment = new FragmentListaCotizarProformas();	
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, InicioFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    };
}
