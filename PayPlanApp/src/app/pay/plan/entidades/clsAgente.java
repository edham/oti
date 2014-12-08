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
public class clsAgente {
    private int int_id_agente;
    private String str_nombre;
    private double dou_latitud;
    private double dou_longitud;
    private String str_nombre_encargado;
    private String str_email;
    private String str_telefono;
    private String str_telefono_encargado;
    private String str_direccion;
    private boolean bool_estado;
    private Date dat_fecha_creacion;
    private Date dat_hora_inicio;
    private Date dat_hora_fin;
    private clsBanco objBanco;
    private clsDistrito objDistrito;
    private List<clsServicio> items;

    public clsAgente() {
    }

    public clsAgente(int int_id_agente) {
        this.int_id_agente = int_id_agente;
    }

    public int getInt_id_agente() {
        return int_id_agente;
    }

    public void setInt_id_agente(int int_id_agente) {
        this.int_id_agente = int_id_agente;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public double getDou_latitud() {
        return dou_latitud;
    }

    public void setDou_latitud(double dou_latitud) {
        this.dou_latitud = dou_latitud;
    }

    public double getDou_longitud() {
        return dou_longitud;
    }

    public void setDou_longitud(double dou_longitud) {
        this.dou_longitud = dou_longitud;
    }

    public String getStr_nombre_encargado() {
        return str_nombre_encargado;
    }

    public void setStr_nombre_encargado(String str_nombre_encargado) {
        this.str_nombre_encargado = str_nombre_encargado;
    }

    public String getStr_email() {
        return str_email;
    }

    public void setStr_email(String str_email) {
        this.str_email = str_email;
    }

    public String getStr_telefono() {
        return str_telefono;
    }

    public void setStr_telefono(String str_telefono) {
        this.str_telefono = str_telefono;
    }

    public String getStr_telefono_encargado() {
        return str_telefono_encargado;
    }

    public void setStr_telefono_encargado(String str_telefono_encargado) {
        this.str_telefono_encargado = str_telefono_encargado;
    }

    public String getStr_direccion() {
        return str_direccion;
    }

    public void setStr_direccion(String str_direccion) {
        this.str_direccion = str_direccion;
    }

    public boolean isBool_estado() {
        return bool_estado;
    }

    public void setBool_estado(boolean bool_estado) {
        this.bool_estado = bool_estado;
    }

    public Date getDat_fecha_creacion() {
        return dat_fecha_creacion;
    }

    public void setDat_fecha_creacion(Date dat_fecha_creacion) {
        this.dat_fecha_creacion = dat_fecha_creacion;
    }

    public Date getDat_hora_inicio() {
        return dat_hora_inicio;
    }

    public void setDat_hora_inicio(Date dat_hora_inicio) {
        this.dat_hora_inicio = dat_hora_inicio;
    }

    public Date getDat_hora_fin() {
        return dat_hora_fin;
    }

    public void setDat_hora_fin(Date dat_hora_fin) {
        this.dat_hora_fin = dat_hora_fin;
    }

    public clsBanco getObjBanco() {
        return objBanco;
    }

    public void setObjBanco(clsBanco objBanco) {
        this.objBanco = objBanco;
    }

    public clsDistrito getObjDistrito() {
        return objDistrito;
    }

    public void setObjDistrito(clsDistrito objDistrito) {
        this.objDistrito = objDistrito;
    }

    public List<clsServicio> getItems() {
        return items;
    }

    public void setItems(List<clsServicio> items) {
        this.items = items;
    }
    
}
