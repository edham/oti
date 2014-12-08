/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.pay.plan.entidades;

/**
 *
 * @author EdHam
 */
public class clsTipoProducto {
    private int int_id_tipo_producto;
    private String str_nombre;
    private String str_detalle;
    private boolean bool_estado;

    public clsTipoProducto() {
    }

    public clsTipoProducto(int int_id_tipo_producto) {
        this.int_id_tipo_producto = int_id_tipo_producto;
    }

    public clsTipoProducto(int int_id_tipo_producto, String str_nombre) {
        this.int_id_tipo_producto = int_id_tipo_producto;
        this.str_nombre = str_nombre;
    }

    public int getInt_id_tipo_producto() {
        return int_id_tipo_producto;
    }

    public void setInt_id_tipo_producto(int int_id_tipo_producto) {
        this.int_id_tipo_producto = int_id_tipo_producto;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public String getStr_detalle() {
        return str_detalle;
    }

    public void setStr_detalle(String str_detalle) {
        this.str_detalle = str_detalle;
    }

    public boolean isBool_estado() {
        return bool_estado;
    }

    public void setBool_estado(boolean bool_estado) {
        this.bool_estado = bool_estado;
    }
    
}
