package app.pay.plan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.pay.plan.entidades.clsEmpresa;
import app.pay.plan.sqlite.clsEmpresaDAO;
import app.pay.plan.ui.R;

public class FragmentInicio extends Fragment {

//
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_inicio, container,
				false);
                TextView  lblTitulo = (TextView)view.findViewById(R.id.lblTitulo);
                
                clsEmpresa entidad = clsEmpresaDAO.Buscar(this.getActivity());
                
                if(entidad.isBool_empresa())
                    lblTitulo.setText(entidad.getStr_razon_social());
                else
                    lblTitulo.setText(entidad.getStr_apellidos_usuario()+" "+entidad.getStr_nombre_usuario());
                
//                
		return view;
	}

}
