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
public class clsProforma {
    private int int_id_proforma;
    private clsEmpresa objEmpresa;
    private Date dat_fecha_creacion;
    private Date dat_fecha_finalizacion;
    private int int_estado;
    private List<clsDetalleProforma> lista;

    public clsProforma() {
    }

    public clsProforma(int int_id_proforma) {
        this.int_id_proforma = int_id_proforma;
    }

    public int getInt_id_proforma() {
        return int_id_proforma;
    }

    public void setInt_id_proforma(int int_id_proforma) {
        this.int_id_proforma = int_id_proforma;
    }

    public clsEmpresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(clsEmpresa objEmpresa) {
        this.objEmpresa = objEmpresa;
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

    public List<clsDetalleProforma> getLista() {
        return lista;
    }

    public void setLista(List<clsDetalleProforma> lista) {
        this.lista = lista;
    }
    
}
