/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Babsy Gamboa
 */
public class clsServicio {
    private int int_id_servicio;
    private String str_nombre;

    public clsServicio() {
    }

    public clsServicio(int int_id_servicio, String str_nombre) {
        this.int_id_servicio = int_id_servicio;
        this.str_nombre = str_nombre;
    }

    public int getInt_id_servicio() {
        return int_id_servicio;
    }

    public void setInt_id_servicio(int int_id_servicio) {
        this.int_id_servicio = int_id_servicio;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

   
 
  
     @Override
    public String toString()
    {
        return str_nombre;
    }
}
