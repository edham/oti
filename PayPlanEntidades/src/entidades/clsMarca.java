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
public class clsMarca {
    private int int_id_marca;
    private String str_nombre;
    private boolean bool_estado;

    public clsMarca() {
    }

    public clsMarca(int int_id_marca) {
        this.int_id_marca = int_id_marca;
    }

    public int getInt_id_marca() {
        return int_id_marca;
    }

    public void setInt_id_marca(int int_id_marca) {
        this.int_id_marca = int_id_marca;
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
