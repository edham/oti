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
public class clsAgenteServicio {
    private int int_agente_servicio;
    private clsServicio objServicio;
    private int int_id_agente;

    public clsAgenteServicio() {
    }

    public int getInt_agente_servicio() {
        return int_agente_servicio;
    }

    public void setInt_agente_servicio(int int_agente_servicio) {
        this.int_agente_servicio = int_agente_servicio;
    }

    public clsServicio getObjServicio() {
        return objServicio;
    }

    public void setObjServicio(clsServicio objServicio) {
        this.objServicio = objServicio;
    }

    public int getInt_id_agente() {
        return int_id_agente;
    }

    public void setInt_id_agente(int int_id_agente) {
        this.int_id_agente = int_id_agente;
    }    
}
