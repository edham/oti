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
public class clsCotizacion {
    private int int_id_cotizacion;
    private clsEmpresa objEmpresa;
    private clsProforma objProforma;
    private Date dat_fecha_creacion;
    private Date dat_fecha_finalizacion;
    private int int_estado;
    private List<clsDetalleCotizacion> lista;
    public clsCotizacion() {
    }

    public clsCotizacion(int int_id_cotizacion) {
        this.int_id_cotizacion = int_id_cotizacion;
    }

    public int getInt_id_cotizacion() {
        return int_id_cotizacion;
    }

    public void setInt_id_cotizacion(int int_id_cotizacion) {
        this.int_id_cotizacion = int_id_cotizacion;
    }

    public clsEmpresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(clsEmpresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public clsProforma getObjProforma() {
        return objProforma;
    }

    public void setObjProforma(clsProforma objProforma) {
        this.objProforma = objProforma;
    }

    public Date getDat_fecha_creacion() {
        return dat_fecha_creacion;
    }

    public void setDat_fecha_creacion(Date dat_fecha_creacion) {
        this.dat_fecha_creacion = dat_fecha_creacion;
    }

    public Date getDat_fecha_finalizacion() {
        return dat_fecha_finalizacion;
    }

    public void setDat_fecha_finalizacion(Date dat_fecha_finalizacion) {
        this.dat_fecha_finalizacion = dat_fecha_finalizacion;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public List<clsDetalleCotizacion> getLista() {
        return lista;
    }

    public void setLista(List<clsDetalleCotizacion> lista) {
        this.lista = lista;
    }
    
}
