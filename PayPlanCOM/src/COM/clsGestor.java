/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package COM;

import DAO.clsEmpresaDAO;
import DAO.clsUsuarioDAO;
import entidades.clsProducto;
import entidades.clsEmpresa;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsGestor {
    
    public static clsEmpresa loginUsuario (String usuario,String clave) throws Exception
    {
        return clsUsuarioDAO.login(usuario, clave);
    }
    public static List<clsProducto> ListarProducto () throws Exception
    {
        return clsEmpresaDAO.Listar();
    }
}
