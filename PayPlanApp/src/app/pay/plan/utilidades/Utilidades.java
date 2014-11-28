/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.pay.plan.utilidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author EdHam
 */
public class Utilidades {
    
    public static String getFecha(Date fecha)
    {
        SimpleDateFormat e=new SimpleDateFormat("dd/MM/yyyy");
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
}
