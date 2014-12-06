package app.pay.plan.servicio;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import app.pay.plan.entidades.clsEmpresa;
import java.util.Timer;
import java.util.TimerTask;

public class clsServicio extends Service {

	private Timer timer = new Timer();
	private static final long UPDATE_INTERVAL = 1000*60;// timer cada minuto
	
        private clsEmpresa objUsuario=null;
	
        
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public void onCreate() {
            super.onCreate();         
//            objUsuario=clsUsuarioDAO.Buscar(this.getApplicationContext());            
//            if(objUsuario!=null)
//            {
                   _startService();
//            }
//                      else
//                onDestroy();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();               
		_shutdownService();           
	}
	
	private void _startService() {
           
		timer.scheduleAtFixedRate(
			new TimerTask() {
				public void run() {
                                    
                            
                                    
                                   
                                    
				}
			},
			0,
			UPDATE_INTERVAL);      
                
                

	}
	
	private void _shutdownService() {            
		if (timer != null) timer.cancel();
                borrarNotificacion();
	}
	
public void borrarNotificacion()
 {
     String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
    (NotificationManager) getSystemService(ns);
    notManager.cancelAll();
 }
public void borrarNotificacionxId(int Id)
 {
     String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
    (NotificationManager) getSystemService(ns);
    notManager.cancel(Id);
 }

public void Notificacion(String Titulo,String Motivo,int id,int idCosulta)
{
    String ns = Context.NOTIFICATION_SERVICE;
    NotificationManager notManager = 
        (NotificationManager) getSystemService(ns);

//    int icono = R.drawable.seguros;
//    CharSequence textoEstado = Titulo;
//    long hora = System.currentTimeMillis();
//
//    Notification notif = 
//        new Notification(icono, textoEstado, hora);
//
//    Context contexto = getApplicationContext();
//    CharSequence titulo = Titulo;
//    CharSequence descripcion = Motivo;
//    Intent notIntent=null;
//    if(id==0)
//    notIntent = new Intent(contexto,MenuActivity.class);
//    else if(id==1)
//    {
//        notIntent = new Intent(contexto,.class);
//        notIntent.putExtra("Id",""+idCosulta);
//    }
//     else if(id==2)         
//        notIntent = new Intent(contexto,CitasActivity.class);
//    RespuestasConsultasActivity
//    PendingIntent contIntent = PendingIntent.getActivity(
//                contexto, 0, notIntent, 0);
//
//    notif.setLatestEventInfo(
//                contexto, titulo, descripcion, contIntent);
//
//    notif.flags |= Notification.FLAG_AUTO_CANCEL;
//    notif.flags |= Notification.FLAG_ONGOING_EVENT;
//    notif.defaults |= Notification.DEFAULT_SOUND;
//
//
//    notManager.notify(id, notif);                                      
}


         
         
    
}
