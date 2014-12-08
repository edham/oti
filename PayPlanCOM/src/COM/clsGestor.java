/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package COM;

import DAO.clsAgenteDAO;
import DAO.clsAgenteServicioDAO;
import DAO.clsEmpresaDAO;
import DAO.clsProductoDAO;
import DAO.clsProductoEmpresaDAO;
import DAO.clsServicioDAO;
import entidades.clsAgente;
import entidades.clsAgenteServicio;
import entidades.clsEmpresa;
import entidades.clsProducto;
import entidades.clsProductoEmpresa;
import entidades.clsServicio;
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
    public static List<clsAgente> ListarAgente() throws Exception
    {
        return clsAgenteDAO.Listar();
    }
    public static List<clsServicio> ListarServicio () throws Exception
    {
        return clsServicioDAO.Listar();
    }
     public static List<clsAgenteServicio> ListarAgenteServicio () throws Exception
     {
         return clsAgenteServicioDAO.Listar();
     }
}
