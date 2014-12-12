
import COM.clsGestor;
import entidades.clsDistrito;
import entidades.clsEmpresa;
import entidades.clsMovimiento;
import entidades.clsServicio;
import entidades.clsTipoMovimiento;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EdHam
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        clsEmpresa entidad = new clsEmpresa();
        
        entidad.setStr_nombre_usuario("xd");
        entidad.setStr_apellidos_usuario("xd");
        entidad.setStr_email("xd");
        entidad.setStr_telefono("xd");
        entidad.setStr_celular("xd");
        entidad.setStr_usuario("xd");
        entidad.setStr_clave("xd");
        entidad.setStr_razon_social("xd");
        entidad.setStr_ruc("xd");
        entidad.setStr_direccion("xd");
        entidad.setObjDistrito(new clsDistrito(1));
        entidad.setBool_empresa(true);
        
        System.out.print(""+clsGestor.ListarMovimiento(0).size());
    }
    
}
