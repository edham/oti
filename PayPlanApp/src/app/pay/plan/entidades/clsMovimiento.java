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
public class clsMovimiento {

    private Date dat_fecha_creacion;
    public clsMovimiento() {
    }

    public Date getDat_fecha_creacion() {
        return dat_fecha_creacion;
    }

    public void setDat_fecha_creacion(Date dat_fecha_creacion) {
        this.dat_fecha_creacion = dat_fecha_creacion;
    }

    public clsMovimiento(Date dat_fecha_creacion) {
        this.dat_fecha_creacion = dat_fecha_creacion;
    }
    
    
}
