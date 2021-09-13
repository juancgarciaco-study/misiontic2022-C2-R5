/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.logging.Level;
import model.UsuarioModel;
import utils.ApplicationException;

/**
 *
 * @author juan
 */
public class zDirectTest {

    private static final Logger logger = Logger.getLogger(zDirectTest.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UsuarioDao usuDao = new UsuarioDao();
        var newLine = System.lineSeparator();

        ArrayList<UsuarioModel> usuarios = null;

        try {
            usuarios = usuDao.ObtenerUsuarios();
        } catch (ApplicationException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }

        if (usuarios != null) {
            usuarios.forEach(usuario -> {
                logger.info(String.format("%s, %s %tF %s", usuario.getUsername(), usuario.getApellido(), usuario.getFechanacimiento(), newLine));
            });
        }
    }

}
