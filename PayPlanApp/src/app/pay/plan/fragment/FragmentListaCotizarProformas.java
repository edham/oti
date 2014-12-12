package app.pay.plan.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import app.pay.plan.entidades.clsProforma;
import app.pay.plan.sqlite.clsProformaDAO;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.List;

public class FragmentListaCotizarProformas extends Fragment {

    private  List<clsProforma> itensTemp=null;
    private  List<clsProforma> itens=null;
    private Adaptador adaptador;
    private ListView lista;
    private Button btnCancelar;
    private Button btnNuevo;
    private View viewFiltro;
    private EditText txtFiltro;
    
         @Override
        public void onResume() {
            super.onResume();
            getActivity().getActionBar().setTitle("COTIZAR PROFORMAS");
        }    


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_lista_regisro_proformas, container,
				false);
                viewFiltro  = (View)view.findViewById(R.id.viewFiltro);
                viewFiltro.setVisibility(View.VISIBLE);
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
                btnNuevo = (Button)view.findViewById(R.id.btnNuevo);
                btnNuevo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       btnNuevo(); 
                    }
                }); 
                lista = (ListView)view.findViewById(R.id.lista); 
                
                setAdapter("");
//                
		return view;
	}

     
      public void setAdapter(String filtro )
    {    
        itens=clsProformaDAO.Listar(FragmentListaCotizarProformas.this.getActivity());   
        itensTemp= new ArrayList<clsProforma>();
        for(clsProforma entidad : itens)
            if(entidad.getObjEmpresa().getStr_razon_social().toLowerCase().indexOf(filtro.toLowerCase()) != -1 ||
            entidad.getObjEmpresa().getStr_nombre_usuario().toLowerCase().indexOf(filtro.toLowerCase()) != -1 ||
            entidad.getObjEmpresa().getStr_apellidos_usuario().toLowerCase().indexOf(filtro.toLowerCase()) != -1 ||
            entidad.getObjEmpresa().getStr_ruc().toLowerCase().indexOf(filtro.toLowerCase()) != -1)
            itensTemp.add(entidad);
        
        
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
            
         
            
            TextView lblProforma = (TextView)item.findViewById(R.id.lblProforma);
            lblProforma.setText(Utilidades.getFechaCompletaString(itensTemp.get(position).getDat_fecha_creacion()));
            if(itensTemp.get(position).getObjEmpresa().isBool_empresa())
            {
                lblProforma.setText(lblProforma.getText().toString()+"\n"+
                        itensTemp.get(position).getObjEmpresa().getStr_razon_social()+"\n"+
                        itensTemp.get(position).getObjEmpresa().getStr_ruc());
            }
            else
            {
               lblProforma.setText(lblProforma.getText().toString()+"\n"+
                        itensTemp.get(position).getObjEmpresa().getStr_nombre_usuario()+" "+
                        itensTemp.get(position).getObjEmpresa().getStr_apellidos_usuario());
            }
            Button btnVer = (Button)item.findViewById(R.id.btnVer);
            btnVer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle args = new Bundle();
                    args.putInt("idProforma",itensTemp.get(posicion).getInt_id_proforma());
                    Fragment fragment = new FragmentNuevoCotizarProformas();
                    fragment.setArguments(args);	
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.content_frame, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }); 
               
            return(item);
	}
    }
     
    
    public void btnNuevo()
    {
        Fragment InicioFragment = new FragmentNuevoRegistroProformas();	
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, InicioFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }

}
