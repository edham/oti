/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package COM;

import DAO.clsUsuarioDAO;
import entidades.clsUsuario;

/**
 *
 * @author EdHam
 */
public class clsGestor {
    
    public static clsUsuario loginUsuario (String usuario,String clave) throws Exception
    {
        return clsUsuarioDAO.login(usuario, clave);
    }
}
