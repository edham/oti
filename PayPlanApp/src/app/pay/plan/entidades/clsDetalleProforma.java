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
public class clsDetalleProforma {
    private int int_id_detalle_proforma;
    private int int_id_proforma;
    private clsProducto objProducto;
    private int int_cantidad;
    private int int_estado;

    public clsDetalleProforma() {
    }

    public int getInt_id_detalle_proforma() {
        return int_id_detalle_proforma;
    }

    public void setInt_id_detalle_proforma(int int_id_detalle_proforma) {
        this.int_id_detalle_proforma = int_id_detalle_proforma;
    }

    public int getInt_id_proforma() {
        return int_id_proforma;
    }

    public void setInt_id_proforma(int int_id_proforma) {
        this.int_id_proforma = int_id_proforma;
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

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }
    
}
