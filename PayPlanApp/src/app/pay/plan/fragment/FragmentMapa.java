 package app.pay.plan.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import static android.content.Context.LOCATION_SERVICE;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import app.pay.plan.entidades.clsDepartamento;
import app.pay.plan.entidades.clsServicio;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.clsUbigeo;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import java.util.ArrayList;
import java.util.List;


public class FragmentMapa extends Fragment implements LocationListener,OnMapClickListener {

    
    private Spinner ComboServicio;
    
    private List<clsServicio> listaServicio=null;
    
    private int color = Color.RED;
    
    private GoogleMap googleMap;
    
    private ProgressDialog pd; 
    private LatLng puntosGPS;
    private LatLng puntosSeleccion;
    // flag for GPS status
    private boolean isGPSEnabled = false;
 
    // flag for network status
    private boolean isNetworkEnabled = false;
 
    // flag for GPS status
    private boolean canGetLocation = false;
    private boolean zoon=true;
    private Location location; // location
    
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 10 meters
 
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 20; // 1 minute
 
    // Declaring a Location Manager
    protected LocationManager locationManager;

     @Override
    public void onStart() 
    {
        super.onStart();

        ComboServicio = (Spinner)getView().findViewById(R.id.ComboServicio);   
        ComboServicio();
         int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.getActivity());
 
        // Showing status
        if(status!=ConnectionResult.SUCCESS){ // Google Play Services are not available
 
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this.getActivity(), requestCode);
            dialog.show();
 
        }else { 
  
            googleMap =((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
 
            googleMap.setMyLocationEnabled(true);
            googleMap.setOnMapClickListener(this);       

            googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {

                  
                 
                }
            });
            
            getLocation();
        }
    }
        @Override
	public void onDestroyView() {
             if(locationManager!=null)
                 locationManager.removeUpdates(this);
              try{
                    SupportMapFragment fragment = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map));
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        ft.remove(fragment);
                        ft.commit();
                      }catch(Exception e){
                      }
//            
		super.onDestroyView();

	}
     

        
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	   Bundle savedInstanceState) {
	  View myFragmentView = inflater.inflate(R.layout.fragment_mapa, container, false);
          
	  return myFragmentView;
	 }

    public void getLocation() {
        try {
            locationManager = (LocationManager) this.getActivity()
                    .getSystemService(LOCATION_SERVICE);
 
            // getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
 
            // getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
 
            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
                 Toast.makeText(this.getActivity(),"Por favor Active su GPS", Toast.LENGTH_SHORT).show();
            } else {
                this.canGetLocation = true;
                // First get location from Network Provider
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        location = locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            onLocationChanged(location);
                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                onLocationChanged(location);
                            }
                        }
                    }
                }
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onLocationChanged(Location location) {
        // Creating a LatLng object for the current location
        puntosGPS = new LatLng(location.getLatitude(), location.getLongitude());
        
        if(zoon)
        {
            googleMap.moveCamera(CameraUpdateFactory.zoomTo(18));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(puntosGPS));
            zoon=false;
        }
        
       
        
        
    }
 
 @Override
    public void onProviderDisabled(String provider) 
    {
        // TODO Auto-generated method stub
        Toast.makeText(this.getActivity(), "provider disabled", Toast.LENGTH_SHORT).show();
    }
 
    @Override
    public void onProviderEnabled(String provider) 
    {
        // TODO Auto-generated method stub
        Toast.makeText(this.getActivity(), "provider enabled", Toast.LENGTH_SHORT).show();
    }
 
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) 
    {
        
    }
 



//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event)
//    {
//   
//    
//    return false;
//
//    }

    public void onMapClick(LatLng latlng) {
        puntosSeleccion=latlng;
      googleMap.clear();
      
      
//      Routing routing = new Routing(travelMode);
//        routing.registerListener(this);
//        routing.execute(puntosGPS, puntosSeleccion);
//        pd = new ProgressDialog(this.getActivity());
//                    pd.setMessage(getString(R.string.str_espere));     
//                    pd.show();       
//          googleMap.addMarker(new MarkerOptions().position(puntosSeleccion).
//        icon(BitmapDescriptorFactory
//        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
//          
//        LatLngBounds.Builder builder = new LatLngBounds.Builder();
//        builder.include(puntosGPS);
//        builder.include(puntosSeleccion);
//        LatLngBounds bounds = builder.build();
//        int padding = 30; 
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
    }

    public void ComboServicio (){
       
        listaServicio = new ArrayList<clsServicio>();
        listaServicio.add(new clsServicio(0,"Todos los Servicios"));
        listaServicio.add(new clsServicio(1,"Luz"));
        listaServicio.add(new clsServicio(2,"Agua"));
        listaServicio.add(new clsServicio(3,"Colegio"));
        listaServicio.add(new clsServicio(4,"Universidad"));
        
        List<String> listString = new ArrayList<String>();
        for(clsServicio entidad : listaServicio)
        listString.add(entidad.getStr_nombre());
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboServicio.setAdapter(adapter);     
        ComboServicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
//                ComboProvincia(((clsServicio)ComboServicio.getSelectedItem()).getInt_id_depatamento());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboServicio.setSelection(0);
    }

}
