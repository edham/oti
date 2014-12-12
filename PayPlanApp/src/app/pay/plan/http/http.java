/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.http;

import app.pay.plan.entidades.clsDetalleCotizacion;
import app.pay.plan.entidades.clsDetalleProforma;
import app.pay.plan.entidades.clsEmpresa;
import app.pay.plan.entidades.clsMovimiento;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class http {

    private static String url="http://192.168.1.47:8084/";
    private static HttpClient client;
    private static HttpResponse responseGet;
    private static HttpEntity resEntityGet;
    
    
      public static String cargar(int idEmpresa) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url+"cargar");

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>(1);
            Value.add(new BasicNameValuePair("idEmpresa",""+idEmpresa));
           httppost.setEntity(new UrlEncodedFormEntity(Value));
            responseGet = client.execute(httppost);
            resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                    return  EntityUtils.toString(resEntityGet).trim();
            }
            } catch (ClientProtocolException e) {
                return "{\"id\":3}";
            } catch (IOException e) {
                return "{\"id\":3} ";
            }
         return "{\"id\":3} ";
    }   
    
    
  public static String insertarDetalleCotizacion(clsDetalleProforma entidad) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url+"insertarDetalleCotizacion");

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>(4);
            Value.add(new BasicNameValuePair("id_cotizacion",""+entidad.getInt_id_proforma()));
            Value.add(new BasicNameValuePair("idProducto",""+entidad.getObjProducto().getInt_id_producto()));
            Value.add(new BasicNameValuePair("cantidad",""+entidad.getInt_cantidad()));
            Value.add(new BasicNameValuePair("costo",""+entidad.getObjProducto().getDou_precio()));
            httppost.setEntity(new UrlEncodedFormEntity(Value));
            responseGet = client.execute(httppost);
            resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                    return  EntityUtils.toString(resEntityGet).trim();
            }
            } catch (ClientProtocolException e) {
                return "{\"id\":-2}";
            } catch (IOException e) {
                return "{\"id\":-2} ";
            }
         return "{\"id\":-2} ";
    }   
  public static String insertarCotizacion(int idEmpresa,int idProforma) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url+"insertarCotizacion");

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>(2);
            Value.add(new BasicNameValuePair("idEmpresa",""+idEmpresa));
            Value.add(new BasicNameValuePair("idProforma",""+idProforma));
           httppost.setEntity(new UrlEncodedFormEntity(Value));
            responseGet = client.execute(httppost);
            resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                    return  EntityUtils.toString(resEntityGet).trim();
            }
            } catch (ClientProtocolException e) {
                return "{\"id\":-2}";
            } catch (IOException e) {
                return "{\"id\":-2} ";
            }
         return "{\"id\":-2} ";
    }      
    
 public static String insertarDetalleProforma(clsDetalleProforma entidad) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url+"insertarDetalleProforma");

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>(1);
            Value.add(new BasicNameValuePair("idProforma",""+entidad.getInt_id_proforma()));
            Value.add(new BasicNameValuePair("idProducto",""+entidad.getObjProducto().getInt_id_producto()));
            Value.add(new BasicNameValuePair("cantidad",""+entidad.getInt_cantidad()));
           httppost.setEntity(new UrlEncodedFormEntity(Value));
            responseGet = client.execute(httppost);
            resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                    return  EntityUtils.toString(resEntityGet).trim();
            }
            } catch (ClientProtocolException e) {
                return "{\"id\":-2}";
            } catch (IOException e) {
                return "{\"id\":-2} ";
            }
         return "{\"id\":-2} ";
    }   
  public static String insertarProforma(int idEmpresa) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url+"insertarProforma");

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>(1);
            Value.add(new BasicNameValuePair("idEmpresa",""+idEmpresa));
           httppost.setEntity(new UrlEncodedFormEntity(Value));
            responseGet = client.execute(httppost);
            resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                    return  EntityUtils.toString(resEntityGet).trim();
            }
            } catch (ClientProtocolException e) {
                return "{\"id\":-2}";
            } catch (IOException e) {
                return "{\"id\":-2} ";
            }
         return "{\"id\":-2} ";
    }   
 
 public static String insertarEmpresa(clsEmpresa entidad) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url+"insertarEmpresa");

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>(12);
            Value.add(new BasicNameValuePair("nombre",entidad.getStr_nombre_usuario()));
            Value.add(new BasicNameValuePair("apellido",entidad.getStr_apellidos_usuario()));
            Value.add(new BasicNameValuePair("email",entidad.getStr_email()));
            Value.add(new BasicNameValuePair("telefono",entidad.getStr_telefono()));
            Value.add(new BasicNameValuePair("celular",entidad.getStr_celular()));
            Value.add(new BasicNameValuePair("usuario",entidad.getStr_usuario()));
            Value.add(new BasicNameValuePair("clave",entidad.getStr_clave()));
            Value.add(new BasicNameValuePair("razon",entidad.getStr_razon_social()));
            Value.add(new BasicNameValuePair("ruc",""+entidad.getStr_ruc()));
            Value.add(new BasicNameValuePair("direccion",entidad.getStr_direccion()));
            Value.add(new BasicNameValuePair("idDistrito",""+entidad.getObjDistrito().getInt_id_distrito()));
            Value.add(new BasicNameValuePair("empresa",""+entidad.isBool_empresa()));
           httppost.setEntity(new UrlEncodedFormEntity(Value));
            responseGet = client.execute(httppost);
            resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                    return  EntityUtils.toString(resEntityGet).trim();
            }
            } catch (ClientProtocolException e) {
                return "{\"id\":-2}";
            } catch (IOException e) {
                return "{\"id\":-2} ";
            }
         return "{\"id\":-2} ";
    }   
   
public static String insertarMovimiento(clsMovimiento entidad) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url+"insertarMovimiento");

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>(10);
            Value.add(new BasicNameValuePair("idEmpresa",""+entidad.getObjEmpresa().getInt_id_empresa()));
            Value.add(new BasicNameValuePair("idTipoMovimiento",""+entidad.getObjTipoMovimiento().getInt_id_tipo_movimiento()));
            Value.add(new BasicNameValuePair("idServicio",""+entidad.getObjServicio().getInt_id_servicio()));
            Value.add(new BasicNameValuePair("fecha",""+entidad.getDat_fecha_movimiento().getTime()));
            Value.add(new BasicNameValuePair("total",""+entidad.getDou_total()));
            Value.add(new BasicNameValuePair("couta",""+entidad.getInt_couta_total()));
            Value.add(new BasicNameValuePair("detalle",entidad.getStr_detalle()));
            Value.add(new BasicNameValuePair("tipo",""+entidad.isBool_ingreso()));
            Value.add(new BasicNameValuePair("alerta",""+entidad.getInt_alerta_inicio()));
            Value.add(new BasicNameValuePair("repeticion",""+entidad.getInt_repeticion_alerta()));
           httppost.setEntity(new UrlEncodedFormEntity(Value));
            responseGet = client.execute(httppost);
            resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                    return  EntityUtils.toString(resEntityGet).trim();
            }
            } catch (ClientProtocolException e) {
                return "{\"id\":-2}";
            } catch (IOException e) {
                return "{\"id\":-2} ";
            }
         return "{\"id\":-2} ";
    }
    
    public static String getLogin(String usuario,String clave) 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url+"login");

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>(2);
            Value.add(new BasicNameValuePair("usuario",usuario));
            Value.add(new BasicNameValuePair("clave",clave));
            httppost.setEntity(new UrlEncodedFormEntity(Value));
            responseGet = client.execute(httppost);
            resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                    return  EntityUtils.toString(resEntityGet).trim();
            }
            } catch (ClientProtocolException e) {
                return "{\"error\":3}";
            } catch (IOException e) {
                return "{\"error\":3} ";
            }
         return "{\"error\":3} ";
    }
    
    public static String getListarProductos() 
    {
    client = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url+"listarProducto");

        try {
            List<NameValuePair> Value = new ArrayList<NameValuePair>(0);            
            httppost.setEntity(new UrlEncodedFormEntity(Value));
            responseGet = client.execute(httppost);
            resEntityGet = responseGet.getEntity();
            if (resEntityGet != null) {
                    return  EntityUtils.toString(resEntityGet).trim();
            }
            } catch (ClientProtocolException e) {
                return "{\"error\":2}";
            } catch (IOException e) {
                return "{\"error\":2} ";
            }
         return "{\"error\":2} ";
    }

}
