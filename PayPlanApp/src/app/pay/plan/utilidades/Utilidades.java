/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.pay.plan.utilidades;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author EdHam
 */
public class Utilidades {
    
    public static double getRedondear(double NDecimal,int decimales)
    {
      return Math.round(NDecimal*Math.pow(10,decimales))/Math.pow(10,decimales);
    } 
    public static String getFecha(Date fecha)
    {
        SimpleDateFormat e=new SimpleDateFormat("dd/MM/yyyy");
        return e.format(fecha);
    }
     public static String getHora(Date fecha)
    {
        SimpleDateFormat e=new SimpleDateFormat("HH:mm a");
        return e.format(fecha);
    }
    public static String getFechaCompletaString(Date fecha)
    {
        SimpleDateFormat e=new SimpleDateFormat("EEEE dd MMMM yyyy - HH:mm a");
        return e.format(fecha);
    }
     public static String getFechaString(Date fecha)
    {
        SimpleDateFormat e=new SimpleDateFormat("EEEE dd MMMM yyyy");
        return e.format(fecha);
    }
    public static int getDias(Date date,Date dateActual)
    {
        Calendar calendarActual = Calendar.getInstance();
        calendarActual.setTime(dateActual);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        int fechaActual=(int)(calendarActual.getTimeInMillis()/ (24 * 60 * 60 * 1000));
        
        int fecha=(int)(calendar.getTimeInMillis()/ (24 * 60 * 60 * 1000));
        
        return fecha-fechaActual;
    }
    
     public static boolean isValidEmail(String email)
    {
      
        String emailExpression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(emailExpression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches())
        	return true;
        else
		return false;
    }

 public static boolean isTelefono(String tele){
 
	Pattern dniPattern = Pattern.compile("(\\d{1,9})");
	Matcher m = dniPattern.matcher(tele);
	if(m.matches()){
		return true;
	}
	else
		return false;
    }

public static String getMail(Context context) {
      String possibleEmail=null;
         
           try{
                   Account[] accounts = AccountManager.get(context).getAccountsByType("com.google");
                    
                   for (Account account : accounts) {
                      
                     possibleEmail =account.name;
                      
                   }
              }
              catch(Exception e)
              {
                   Log.i("Exception", "Exception:"+e) ; 
              }
      return possibleEmail;
  }

}
