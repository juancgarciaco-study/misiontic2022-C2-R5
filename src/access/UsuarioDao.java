/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.logging.Logger;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import model.UsuarioModel;
import utils.ApplicationException;
import utils.dbConn;

/**
 *
 * @author juan
 */
public class UsuarioDao {

    private Connection conn = null;
    private static final Logger logger = Logger.getLogger(UsuarioDao.class.getName());

    private void ValidateConnection() throws ApplicationException {
//        try {
        if (conn == null) {
            conn = dbConn.getConnection();
        }
//        } catch (ApplicationException ex) {
//            logger.log(Level.SEVERE, ex.getMessage());
//            //throw new ApplicationException("usudao-validconn-001", ex.getMessage());
//            throw ex;
//            //return null;
//        }

    }

// C -> Create
    public boolean CrearUsuario(UsuarioModel usuario) throws ApplicationException {
        UsuarioModel retData = new UsuarioModel();

        this.ValidateConnection();

        String sqlText = "INSERT INTO usuario"
            + "(usu_username, usu_nombre, usu_apellido, usu_email, usu_celular, usu_secret, usu_fechanacimiento)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?)"
            + ";";

        try {
            PreparedStatement ps = conn.prepareStatement(sqlText);

            int ix = 0;
            ps.setString(++ix, usuario.getUsername());
            ps.setString(++ix, usuario.getNombre());
            ps.setString(++ix, usuario.getApellido());
            ps.setString(++ix, usuario.getEmail());
            ps.setString(++ix, usuario.getCelular());
            ps.setString(++ix, usuario.getSecret());
            ps.setDate(++ix, new java.sql.Date(usuario.getFechanacimiento().getTime()));

            int res = ps.executeUpdate();

            if (res == 1) {
                return Boolean.TRUE;
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new ApplicationException("usudao-CrearUsuario-001", ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

        return Boolean.FALSE;
    }

// R -> Read All
    public ArrayList<UsuarioModel> ObtenerUsuarios() throws ApplicationException {
        ArrayList<UsuarioModel> retData = new ArrayList<>();

        this.ValidateConnection();

        String sqlText = "SELECT * FROM usuario;";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlText);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                UsuarioModel usu = new UsuarioModel(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getDate(7)
                );

                retData.add(usu);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new ApplicationException("usudao-ObtenerUsuarios-001", ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

        return retData;
    }

// R -> Read one
    public UsuarioModel ObtenerUsuario(String username) throws ApplicationException {
        UsuarioModel retData = new UsuarioModel();

        this.ValidateConnection();

        String sqlText = "SELECT * FROM usuario WHERE usu_username = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlText);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                retData = new UsuarioModel(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getDate(7)
                );

                break;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new ApplicationException("usudao-ObtenerUsuario-001", ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

        return retData;
    }

    // U -> Update
    public boolean ActualizarUsuario(UsuarioModel usuario) throws ApplicationException {

        this.ValidateConnection();

        String sqlText = "UPDATE usuario SET "
            + "usu_nombre = ?, "
            + "usu_apellido = ?, "
            + "usu_email = ?, "
            + "usu_celular = ?, "
            + "usu_secret = ?, "
            + "usu_fechanacimiento = ? "
            + "WHERE usu_username = ? "
            + ";";

        try {
            PreparedStatement ps = conn.prepareStatement(sqlText);

            int ix = 0;
            ps.setString(++ix, usuario.getNombre());
            ps.setString(++ix, usuario.getApellido());
            ps.setString(++ix, usuario.getEmail());
            ps.setString(++ix, usuario.getCelular());
            ps.setString(++ix, usuario.getSecret());
            ps.setDate(++ix, new java.sql.Date(usuario.getFechanacimiento().getTime()));
            ps.setString(++ix, usuario.getUsername());

            int res = ps.executeUpdate();

            if (res == 1) {
                return Boolean.TRUE;
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new ApplicationException("usudao-ActualizarUsuario-001", ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

        return Boolean.FALSE;
    }

// D -> Delete
    public boolean EliminarUsuario(String usuario) throws ApplicationException {
        this.ValidateConnection();

        String sqlText = "DELETE FROM usuario "
            + "WHERE usu_username = ? "
            + ";";

        try {
            PreparedStatement ps = conn.prepareStatement(sqlText);

            ps.setString(1, usuario);

            int res = ps.executeUpdate();

            if (res == 1) {
                return Boolean.TRUE;
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new ApplicationException("usudao-EliminarUsuario-001", ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
        return Boolean.FALSE;

    }

}
