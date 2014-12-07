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
public class clsEmpresa {
    private int int_id_empresa;
    private String str_nombre_usuario;
    private String str_apellidos_usuario;
    private String str_email;
    private String str_telefono;
    private String str_celular;
    private String str_usuario;
    private String str_clave;
    private String str_razon_social;
    private String str_ruc;
    private String str_direccion;
    private int int_estado;
    private boolean bool_empresa;
    private Date dat_fecha_creacion;
    private Date dat_fecha_actualizacion;
    private clsDistrito objDistrito;

    public clsEmpresa() {
    }

    public clsEmpresa(int int_id_empresa) {
        this.int_id_empresa = int_id_empresa;
    }

    public int getInt_id_empresa() {
        return int_id_empresa;
    }

    public void setInt_id_empresa(int int_id_empresa) {
        this.int_id_empresa = int_id_empresa;
    }

    public String getStr_nombre_usuario() {
        return str_nombre_usuario;
    }

    public void setStr_nombre_usuario(String str_nombre_usuario) {
        this.str_nombre_usuario = str_nombre_usuario;
    }

    public String getStr_apellidos_usuario() {
        return str_apellidos_usuario;
    }

    public void setStr_apellidos_usuario(String str_apellidos_usuario) {
        this.str_apellidos_usuario = str_apellidos_usuario;
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

    public String getStr_celular() {
        return str_celular;
    }

    public void setStr_celular(String str_celular) {
        this.str_celular = str_celular;
    }

    public String getStr_usuario() {
        return str_usuario;
    }

    public void setStr_usuario(String str_usuario) {
        this.str_usuario = str_usuario;
    }

    public String getStr_clave() {
        return str_clave;
    }

    public void setStr_clave(String str_clave) {
        this.str_clave = str_clave;
    }

    public String getStr_razon_social() {
        return str_razon_social;
    }

    public void setStr_razon_social(String str_razon_social) {
        this.str_razon_social = str_razon_social;
    }

    public String getStr_ruc() {
        return str_ruc;
    }

    public void setStr_ruc(String str_ruc) {
        this.str_ruc = str_ruc;
    }

    public String getStr_direccion() {
        return str_direccion;
    }

    public void setStr_direccion(String str_direccion) {
        this.str_direccion = str_direccion;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public boolean isBool_empresa() {
        return bool_empresa;
    }

    public void setBool_empresa(boolean bool_empresa) {
        this.bool_empresa = bool_empresa;
    }

    public Date getDat_fecha_creacion() {
        return dat_fecha_creacion;
    }

    public void setDat_fecha_creacion(Date dat_fecha_creacion) {
        this.dat_fecha_creacion = dat_fecha_creacion;
    }

    public Date getDat_fecha_actualizacion() {
        return dat_fecha_actualizacion;
    }

    public void setDat_fecha_actualizacion(Date dat_fecha_actualizacion) {
        this.dat_fecha_actualizacion = dat_fecha_actualizacion;
    }

    public clsDistrito getObjDistrito() {
        return objDistrito;
    }

    public void setObjDistrito(clsDistrito objDistrito) {
        this.objDistrito = objDistrito;
    }

    
}
