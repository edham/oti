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
public class clsEmpresa {
    private int int_id_usuario;
    private String str_nombre;
    private String str_apellidos;
    private String str_email;
    private String str_telefono;
    private String str_usuario;
    private String str_clave;
    private int int_estado;
    private Date fat_fecha_creacion;

    public clsEmpresa() {
    }

    public int getInt_id_usuario() {
        return int_id_usuario;
    }

    public void setInt_id_usuario(int int_id_usuario) {
        this.int_id_usuario = int_id_usuario;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public String getStr_apellidos() {
        return str_apellidos;
    }

    public void setStr_apellidos(String str_apellidos) {
        this.str_apellidos = str_apellidos;
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

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public Date getFat_fecha_creacion() {
        return fat_fecha_creacion;
    }

    public void setFat_fecha_creacion(Date fat_fecha_creacion) {
        this.fat_fecha_creacion = fat_fecha_creacion;
    }
    
}
