package app.pay.plan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.pay.plan.ui.R;

public class FragmentNuevoMovimiento extends Fragment {
    

        @Override
        public void onResume() {
            super.onResume();
            getActivity().getActionBar().setTitle("Nuevo Movimiento");
        }
       
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_nuevo_movimiento, container,
				false);

//                
		return view;
	}

}
