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
public class clsBanco {
    private int int_id_banco;
    private String str_nombre;
    private boolean bool_estado;

    public clsBanco() {
    }

    public clsBanco(int int_id_banco) {
        this.int_id_banco = int_id_banco;
    }

    public int getInt_id_banco() {
        return int_id_banco;
    }

    public void setInt_id_banco(int int_id_banco) {
        this.int_id_banco = int_id_banco;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public boolean isBool_estado() {
        return bool_estado;
    }

    public void setBool_estado(boolean bool_estado) {
        this.bool_estado = bool_estado;
    }
}
