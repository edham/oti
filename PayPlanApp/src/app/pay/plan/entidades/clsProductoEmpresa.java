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
public class clsProductoEmpresa {
    private int int_id_producto_empresa;
    private double dou_precio;
    private int int_estado;
    private clsEmpresa objEmpresa;
    private clsProducto objProducto;

    public clsProductoEmpresa() {
    }

    public clsProductoEmpresa(int int_id_producto_empresa) {
        this.int_id_producto_empresa = int_id_producto_empresa;
    }

    public int getInt_id_producto_empresa() {
        return int_id_producto_empresa;
    }

    public void setInt_id_producto_empresa(int int_id_producto_empresa) {
        this.int_id_producto_empresa = int_id_producto_empresa;
    }

    public double getDou_precio() {
        return dou_precio;
    }

    public void setDou_precio(double dou_precio) {
        this.dou_precio = dou_precio;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public clsEmpresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(clsEmpresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public clsProducto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(clsProducto objProducto) {
        this.objProducto = objProducto;
    }
    
}
