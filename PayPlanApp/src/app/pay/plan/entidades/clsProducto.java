/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.pay.plan.entidades;

import java.util.Date;

/**
 *
 * @author EdHam
 */
public class clsProducto {
    private int int_id_producto;
    private String str_nombre;
    private Date dat_fecha_creacion;
    private Date dat_fecha_actualizacion;
    private int int_estado;
    private clsTipoProducto objTipoProducto;
    private clsMarca objMarca;
    private double dou_precio;

    public clsProducto() {
    }

    public clsProducto(int int_id_producto) {
        this.int_id_producto = int_id_producto;
    }

    public int getInt_id_producto() {
        return int_id_producto;
    }

    public void setInt_id_producto(int int_id_producto) {
        this.int_id_producto = int_id_producto;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public Date getDat_fecha_creacion() {
        return dat_fecha_creacion;
    }

    public void setDat_fecha_creacion(Date dat_fecha_creacion) {
        this.dat_fecha_creacion = dat_fecha_creacion;
    }

    public Date getDat_fecha_actualizacion() {
        return dat_fecha_actualizacion;
    }

    public void setDat_fecha_actualizacion(Date dat_fecha_actualizacion) {
        this.dat_fecha_actualizacion = dat_fecha_actualizacion;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public clsTipoProducto getObjTipoProducto() {
        return objTipoProducto;
    }

    public void setObjTipoProducto(clsTipoProducto objTipoProducto) {
        this.objTipoProducto = objTipoProducto;
    }

    public clsMarca getObjMarca() {
        return objMarca;
    }

    public void setObjMarca(clsMarca objMarca) {
        this.objMarca = objMarca;
    }

    public double getDou_precio() {
        return dou_precio;
    }

    public void setDou_precio(double dou_precio) {
        this.dou_precio = dou_precio;
    }
    
    
}
