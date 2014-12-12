/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.Date;

/**
 *
 * @author EdHam
 */
public class clsItemMovimiento {
    private int int_id_item_movimiento;
    private int int_id_movimiento;
    private int int_numero_couta;
    private double dou_pago;
    private Date dat_fecha_creacion;

    public clsItemMovimiento() {
    }

    public clsItemMovimiento(int int_id_item_movimiento) {
        this.int_id_item_movimiento = int_id_item_movimiento;
    }

    public int getInt_id_item_movimiento() {
        return int_id_item_movimiento;
    }

    public void setInt_id_item_movimiento(int int_id_item_movimiento) {
        this.int_id_item_movimiento = int_id_item_movimiento;
    }

    public int getInt_id_movimiento() {
        return int_id_movimiento;
    }

    public void setInt_id_movimiento(int int_id_movimiento) {
        this.int_id_movimiento = int_id_movimiento;
    }

    public int getInt_numero_couta() {
        return int_numero_couta;
    }

    public void setInt_numero_couta(int int_numero_couta) {
        this.int_numero_couta = int_numero_couta;
    }

    public double getDou_pago() {
        return dou_pago;
    }

    public void setDou_pago(double dou_pago) {
        this.dou_pago = dou_pago;
    }

    public Date getDat_fecha_creacion() {
        return dat_fecha_creacion;
    }

    public void setDat_fecha_creacion(Date dat_fecha_creacion) {
        this.dat_fecha_creacion = dat_fecha_creacion;
    }
    
}
