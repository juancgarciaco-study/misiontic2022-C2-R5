/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.UsuarioDao;
import java.util.ArrayList;
import model.UsuarioModel;
import utils.ApplicationException;

/**
 *
 * @author juan
 */
public class UsuarioController {

    private ArrayList<UsuarioModel> usuarios;
    private UsuarioModel usuarioSeleccionado;

    public UsuarioController() {
    }

    /**
     * @return the usuarios
     * @throws utils.ApplicationException
     */
    public ArrayList<UsuarioModel> GetUsuarios() throws ApplicationException {
        UsuarioDao usuDao = new UsuarioDao();
        this.usuarios = usuDao.ObtenerUsuarios();
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void GetUsuarios(ArrayList<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @param username
     * @return
     * @throws utils.ApplicationException
     */
    public UsuarioModel GetUsuario(String username) throws ApplicationException {
        UsuarioDao usuDao = new UsuarioDao();
        usuarioSeleccionado = usuDao.ObtenerUsuario(username);
        return GetUsuarioSeleccionado();
    }

    /**
     * @return the usuarioSeleccionado
     */
    public UsuarioModel GetUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public boolean CrearUsuario(UsuarioModel usuario) throws ApplicationException {
        UsuarioDao usuDao = new UsuarioDao();
        return usuDao.CrearUsuario(usuario);
    }

    public boolean ActualizarUsuario(UsuarioModel usuario) throws ApplicationException {
        UsuarioDao usuDao = new UsuarioDao();
        return usuDao.ActualizarUsuario(usuario);
    }

    public boolean EliminarUsuario(UsuarioModel usuario) throws ApplicationException {
        UsuarioDao usuDao = new UsuarioDao();
        return usuDao.EliminarUsuario(usuario.getUsername());
    }
}
