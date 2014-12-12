/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.pay.plan.entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsMovimiento {

    private int int_id_movimiento;
    private clsTipoMovimiento objTipoMovimiento;
    private clsServicio objServicio;
    private clsEmpresa objEmpresa;
    private boolean bool_ingreso;
    private String str_detalle;
    private double dou_total;
    private double dou_total_acumulado;
    private int int_couta_total;
    private int int_couta_ingresadas;
    private int int_estado;
    private int int_alerta_inicio;
    private int int_repeticion_alerta;
    private Date dat_fecha_creacion;
    private Date dat_fecha_movimiento;
    private List<clsItemMovimiento> lista;
    
    public clsMovimiento() {
    }

    public clsMovimiento(int int_id_movimiento) {
        this.int_id_movimiento = int_id_movimiento;
    }

    public Date getDat_fecha_creacion() {
        return dat_fecha_creacion;
    }

    public int getInt_id_movimiento() {
        return int_id_movimiento;
    }

    public void setInt_id_movimiento(int int_id_movimiento) {
        this.int_id_movimiento = int_id_movimiento;
    }

    public clsTipoMovimiento getObjTipoMovimiento() {
        return objTipoMovimiento;
    }

    public void setObjTipoMovimiento(clsTipoMovimiento objTipoMovimiento) {
        this.objTipoMovimiento = objTipoMovimiento;
    }

    public clsServicio getObjServicio() {
        return objServicio;
    }

    public void setObjServicio(clsServicio objServicio) {
        this.objServicio = objServicio;
    }

    public clsEmpresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(clsEmpresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public boolean isBool_ingreso() {
        return bool_ingreso;
    }

    public void setBool_ingreso(boolean bool_ingreso) {
        this.bool_ingreso = bool_ingreso;
    }

    public String getStr_detalle() {
        return str_detalle;
    }

    public void setStr_detalle(String str_detalle) {
        this.str_detalle = str_detalle;
    }

    public double getDou_total() {
        return dou_total;
    }

    public void setDou_total(double dou_total) {
        this.dou_total = dou_total;
    }

    public double getDou_total_acumulado() {
        return dou_total_acumulado;
    }

    public void setDou_total_acumulado(double dou_total_acumulado) {
        this.dou_total_acumulado = dou_total_acumulado;
    }

    public int getInt_couta_total() {
        return int_couta_total;
    }

    public void setInt_couta_total(int int_couta_total) {
        this.int_couta_total = int_couta_total;
    }

    public int getInt_couta_ingresadas() {
        return int_couta_ingresadas;
    }

    public void setInt_couta_ingresadas(int int_couta_ingresadas) {
        this.int_couta_ingresadas = int_couta_ingresadas;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public int getInt_alerta_inicio() {
        return int_alerta_inicio;
    }

    public void setInt_alerta_inicio(int int_alerta_inicio) {
        this.int_alerta_inicio = int_alerta_inicio;
    }

    public int getInt_repeticion_alerta() {
        return int_repeticion_alerta;
    }

    public void setInt_repeticion_alerta(int int_repeticion_alerta) {
        this.int_repeticion_alerta = int_repeticion_alerta;
    }

    public Date getDat_fecha_movimiento() {
        return dat_fecha_movimiento;
    }

    public void setDat_fecha_movimiento(Date dat_fecha_movimiento) {
        this.dat_fecha_movimiento = dat_fecha_movimiento;
    }

    public void setDat_fecha_creacion(Date dat_fecha_creacion) {
        this.dat_fecha_creacion = dat_fecha_creacion;
    }

    public clsMovimiento(Date dat_fecha_creacion) {
        this.dat_fecha_creacion = dat_fecha_creacion;
    }

    public List<clsItemMovimiento> getLista() {
        return lista;
    }

    public void setLista(List<clsItemMovimiento> lista) {
        this.lista = lista;
    }
    
    
}
