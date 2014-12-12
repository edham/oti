package app.pay.plan.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import app.pay.plan.entidades.clsEmpresa;
import app.pay.plan.fragment.*;
import app.pay.plan.sqlite.*;
import app.pay.plan.utilidades.clsDrawerItem;
import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends FragmentActivity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
        private FragmentManager frgManager;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
        private int posicion=0;
        private clsEmpresa entidad;
	CustomDrawerAdapter adapter;

	List<clsDrawerItem> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
                entidad=clsEmpresaDAO.Buscar(this);
                if(entidad==null)
                {
                    Intent i=new Intent(this,LoginActivity.class);
                    startActivity(i); 
                    finish();
                }
                frgManager = getSupportFragmentManager();
		// Initializing
		dataList = new ArrayList<clsDrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add Drawer Item to dataList
                
                
		dataList.add(new clsDrawerItem("INICIO", R.drawable.id));
                dataList.add(new clsDrawerItem("MOVIMIENTOS", R.drawable.addressbook));
                dataList.add(new clsDrawerItem("BUSCAR AGENTES", R.drawable.agents));                
                dataList.add(new clsDrawerItem("REGISTRAR PROFORMAS", R.drawable.add_item));
                if(entidad.isBool_empresa())
                {
                    dataList.add(new clsDrawerItem("COTIZAR PROFORMAS", R.drawable.dollar));
                    dataList.add(new clsDrawerItem("MIS PRODUCTO", R.drawable.tree));
                }
                dataList.add(new clsDrawerItem("CERRAR SESION", R.drawable.shut_down));
//	
		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);
                

		if (savedInstanceState == null) {
			SelectItem();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
         @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_settings:  
//                Toast.makeText(MenuActivity.this, "Seleccione Otro", Toast.LENGTH_SHORT).show();
            return true;
   
        default:
            return mDrawerToggle.onOptionsItemSelected(item);
        }
    }
	public void SelectItem() {

            boolean opcion=true;
		Fragment fragment = null;
		switch (posicion) {
		case 0:
			fragment = new FragmentInicio();
			break;
                case 1:
			fragment = new FragmentListaMovimientos();
			break;
                case 2:
			fragment = new FragmentMapa();
			break;
                case 3:
			fragment = new FragmentListaRegistroProformas();
			break;
                case 4:
                        if(entidad.isBool_empresa())
			fragment = new FragmentListaCotizarProformas();
                        else
                            Cerrar();
			break;
                case 5:
			fragment = new FragmentListaMisProductos();
			break;    
     
                case 6:
                        Cerrar();
                        break;
		default:
			break;
		}                
                
                if(fragment!=null)
                {
//                    fragment.setArguments(args);		
                    FragmentTransaction fragmentTransaction = frgManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();        
                    mDrawerList.setItemChecked(posicion, true);
                    setTitle(dataList.get(posicion).getItemName());
                    mDrawerLayout.closeDrawer(mDrawerList); 
                }
               
                   
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                    
                        posicion=position;
			SelectItem();
                   

		}
	}

        public class CustomDrawerAdapter extends ArrayAdapter<clsDrawerItem> {

	Context context;
	List<clsDrawerItem> drawerItemList;
	int layoutResID;

	public CustomDrawerAdapter(Context context, int layoutResourceID,
			List<clsDrawerItem> listItems) {
		super(context, layoutResourceID, listItems);
		this.context = context;
		this.drawerItemList = listItems;
		this.layoutResID = layoutResourceID;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		DrawerItemHolder drawerHolder;
		View view = convertView;

		if (view == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			drawerHolder = new DrawerItemHolder();

			view = inflater.inflate(layoutResID, parent, false);
			drawerHolder.ItemName = (TextView) view
					.findViewById(R.id.drawer_itemName);
			drawerHolder.icon = (ImageView) view.findViewById(R.id.drawer_icon);

			view.setTag(drawerHolder);

		} else {
			drawerHolder = (DrawerItemHolder) view.getTag();

		}

		clsDrawerItem dItem = (clsDrawerItem) this.drawerItemList.get(position);

		drawerHolder.icon.setImageDrawable(view.getResources().getDrawable(
				dItem.getImgResID()));
		drawerHolder.ItemName.setText(dItem.getItemName());

		return view;
	}

	private class DrawerItemHolder {
		TextView ItemName;
		ImageView icon;
	}
    }
     
    public void Cerrar()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Desea Cerrar Sesión");
        alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {  
                    clsAgenteDAO.Borrar(MenuActivity.this);
                    clsAgenteServicioDAO.Borrar(MenuActivity.this);
                    clsCotizacionDAO.Borrar(MenuActivity.this);
                    clsDetalleCotizacionDAO.Borrar(MenuActivity.this);
                    clsDetalleProformaDAO.Borrar(MenuActivity.this);
                    clsEmpresaDAO.Borrar(MenuActivity.this);
                    clsItemMovimientoDAO.Borrar(MenuActivity.this);
                    clsMovimientoDAO.Borrar(MenuActivity.this);
                    clsProductoDAO.Borrar(MenuActivity.this);
                    clsProductoEmpresaDAO.Borrar(MenuActivity.this);
                    clsProformaDAO.Borrar(MenuActivity.this);
                    clsProformaEmpresaDAO.Borrar(MenuActivity.this);
                    clsServicioDAO.Borrar(MenuActivity.this);
                    
                    Intent i=new Intent(MenuActivity.this,LoginActivity.class);
                        startActivity(i); 
                        finish();

                }});
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
               public void onClick(DialogInterface dialog, int whichButton) {    
            }});
               alert.show();
    }
        
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
   
    
    return false;

    }
}
