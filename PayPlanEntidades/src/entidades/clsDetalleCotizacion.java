/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author EdHam
 */
public class clsDetalleCotizacion {
    private int int_id_detalle_cotizacion;
    private int int_id_cotizacion;
    private clsProducto objProducto;
    private int int_cantidad;
    private double dou_costo;
    private int int_estado;

    public clsDetalleCotizacion() {
    }

    public int getInt_id_detalle_cotizacion() {
        return int_id_detalle_cotizacion;
    }

    public void setInt_id_detalle_cotizacion(int int_id_detalle_cotizacion) {
        this.int_id_detalle_cotizacion = int_id_detalle_cotizacion;
    }

    public int getInt_id_cotizacion() {
        return int_id_cotizacion;
    }

    public void setInt_id_cotizacion(int int_id_cotizacion) {
        this.int_id_cotizacion = int_id_cotizacion;
    }

    public clsProducto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(clsProducto objProducto) {
        this.objProducto = objProducto;
    }

    public int getInt_cantidad() {
        return int_cantidad;
    }

    public void setInt_cantidad(int int_cantidad) {
        this.int_cantidad = int_cantidad;
    }

    public double getDou_costo() {
        return dou_costo;
    }

    public void setDou_costo(double dou_costo) {
        this.dou_costo = dou_costo;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

}
