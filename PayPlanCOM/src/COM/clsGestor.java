/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package COM;

import DAO.clsProductoDAO;
import DAO.clsEmpresaDAO;
import DAO.clsProductoEmpresaDAO;
import entidades.clsProducto;
import entidades.clsEmpresa;
import entidades.clsProductoEmpresa;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsGestor {
    
    public static clsEmpresa loginUsuario (String usuario,String clave) throws Exception
    {
        return clsEmpresaDAO.login(usuario, clave);
    }
    public static List<clsProducto> ListarProducto () throws Exception
    {
        return clsProductoDAO.Listar();
    }
    
    public static List<clsProductoEmpresa> ListarProductoEmpresa (int idEmpresa) throws Exception
    {
        return clsProductoEmpresaDAO.Listar(idEmpresa);
    }
}
