/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;



public class clsTipoMovimiento {

    private int int_id_tipo_movimiento;
    private String str_nombre;  

    public clsTipoMovimiento(int int_id_tipo_movimiento, String str_nombre) {
        this.int_id_tipo_movimiento = int_id_tipo_movimiento;
        this.str_nombre = str_nombre;
    }

    public clsTipoMovimiento(int int_id_tipo_movimiento) {
        this.int_id_tipo_movimiento = int_id_tipo_movimiento;
    }

    public clsTipoMovimiento() {
    }

    public int getInt_id_tipo_movimiento() {
        return int_id_tipo_movimiento;
    }

    public void setInt_id_tipo_movimiento(int int_id_tipo_movimiento) {
        this.int_id_tipo_movimiento = int_id_tipo_movimiento;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    
}
