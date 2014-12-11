 package app.pay.plan.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import static android.content.Context.LOCATION_SERVICE;
import android.content.DialogInterface;
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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import app.pay.plan.entidades.clsAgente;
import app.pay.plan.entidades.clsServicio;
import app.pay.plan.route.Routing;
import app.pay.plan.route.Routing.TravelMode;
import app.pay.plan.route.RoutingListener;
import app.pay.plan.sqlite.clsAgenteDAO;
import app.pay.plan.sqlite.clsServicioDAO;
import app.pay.plan.ui.R;
import app.pay.plan.utilidades.Utilidades;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;


public class FragmentMapa extends Fragment implements LocationListener,RoutingListener {

    private List<clsAgente> listAgente;
    
    private Spinner ComboServicio;
    
    private List<clsServicio> listServicio=null;
    
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
        listServicio=clsServicioDAO.Listar(this.getActivity(),0);
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
             googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    final int posicion=Integer.parseInt(marker.getSnippet());
                    
                    CharSequence[] items = {"Ver Detalle", "Llegar a Pie","Llegar en Carro","Cancelar"};   
                    AlertDialog.Builder alert = new AlertDialog.Builder(FragmentMapa.this.getActivity());
                    alert.setTitle(listAgente.get(posicion).getStr_nombre());
            
                    alert.setItems(items, new DialogInterface.OnClickListener() {  
                        public void onClick(DialogInterface dialog, int item) { 
                        opccionesMapa(posicion,item);
                     }});
                    alert.show();
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

    public void getRuta(int Posicion,boolean travelMode) {
      puntosSeleccion= new LatLng(listAgente.get(Posicion).getDou_latitud(),listAgente.get(Posicion).getDou_longitud());
      googleMap.clear();
      addMaker();
      Routing routing = new Routing(TravelMode.DRIVING);
      if(travelMode)
      {
        routing = new Routing(TravelMode.WALKING);
        color = Color.BLUE;
      }
      else
        color = Color.RED;
      
        routing.registerListener(this);
        routing.execute(puntosGPS, puntosSeleccion);
        pd = new ProgressDialog(this.getActivity());
                    pd.setMessage("Cargando Ruta");     
                    pd.show();       
          
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(puntosGPS);
        builder.include(puntosSeleccion);
        LatLngBounds bounds = builder.build();
        int padding = 30; 
        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
    }

    public void ComboServicio (){
       
        listServicio.add(0,new clsServicio(0,"Todas los Servicios"));
        List<String> listString = new ArrayList<String>();
        for(clsServicio objMarca:listServicio)
            listString.add(objMarca.getStr_nombre());
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listString);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboServicio.setAdapter(adapter);     
        ComboServicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {          
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
                addMaker();
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboServicio.setSelection(0);
    }

    
  public void addMaker()
{
    googleMap.clear();
    listAgente=clsAgenteDAO.Listar(this.getActivity(),listServicio.get(ComboServicio.getSelectedItemPosition()).getInt_id_servicio());
    if(listAgente!=null)
    for(int i=0; i<listAgente.size();i++)
        googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_agente)).title(""+listAgente.get(i).getStr_nombre()).snippet(""+i).position(new LatLng(listAgente.get(i).getDou_latitud(),listAgente.get(i).getDou_longitud())));

 }

    public void onRoutingFailure() {}

    public void onRoutingStart() {}

    public void onRoutingSuccess(PolylineOptions mPolyOptions) {
        PolylineOptions polyoptions = new PolylineOptions();
        polyoptions.color(color);
        polyoptions.width(5);
        polyoptions.addAll(mPolyOptions.getPoints());
        googleMap.addPolyline(polyoptions);
        pd.dismiss();       
    }
    
    public void opccionesMapa(int posicion,int opccion)
    {
        if(opccion==0)
        {
            final Dialog dialog = new Dialog(this.getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_agente);
        
        TextView lblTituloD = (TextView)dialog.findViewById(R.id.lblTituloD);
        lblTituloD.setText(listAgente.get(posicion).getStr_nombre());
//        
        TextView lblNombreBancoD = (TextView)dialog.findViewById(R.id.lblNombreBancoD);
        lblNombreBancoD.setText(listAgente.get(posicion).getObjBanco().getStr_nombre());
        
        TextView lblNombreEncargadoD = (TextView)dialog.findViewById(R.id.lblNombreEncargadoD);
        lblNombreEncargadoD.setText(listAgente.get(posicion).getStr_nombre_encargado());
        
        TextView lblTelefonoD = (TextView)dialog.findViewById(R.id.lblTelefonoD);
        lblTelefonoD.setText(listAgente.get(posicion).getStr_telefono());
        
        TextView lblDireccionD = (TextView)dialog.findViewById(R.id.lblDireccionD);
        lblDireccionD.setText(listAgente.get(posicion).getStr_direccion());
        
        TextView lblAtencionD = (TextView)dialog.findViewById(R.id.lblAtencionD);
        lblAtencionD.setText(Utilidades.getHora(listAgente.get(posicion).getDat_hora_inicio())
                +"\n"+Utilidades.getHora(listAgente.get(posicion).getDat_hora_fin()));


        Button btnCerrar = (Button) dialog.findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        dialog.show();
        }
        else if(opccion==1)
        {
            getRuta(posicion,true);
        }
        if(opccion==2)
        {
            getRuta(posicion,false);
        }
        if(opccion==3)
        {
            googleMap.clear();
            addMaker();
        }
    }
}
