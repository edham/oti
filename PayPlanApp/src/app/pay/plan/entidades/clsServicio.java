/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pay.plan.entidades;

/**
 *
 * @author Babsy Gamboa
 */
public class clsServicio {
    private int int_id_servicio;
    private String str_nombre;
    private boolean bool_estado;

    public clsServicio() {
    }

    public clsServicio(int int_id_servicio) {
        this.int_id_servicio = int_id_servicio;
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

    public boolean isBool_estado() {
        return bool_estado;
    }

    public void setBool_estado(boolean bool_estado) {
        this.bool_estado = bool_estado;
    }

     @Override
    public String toString()
    {
        return str_nombre;
    }
}
