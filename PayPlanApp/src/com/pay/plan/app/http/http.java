/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pay.plan.app.http;

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

    private static String url="http://192.168.1.43:8084/";
    private static HttpClient client;
    private static HttpResponse responseGet;
    private static HttpEntity resEntityGet;
    
    
    
   

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

}
