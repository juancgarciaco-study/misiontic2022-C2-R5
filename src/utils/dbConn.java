/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author juan
 */
public class dbConn {

    private static final Logger logger = Logger.getLogger(dbConn.class.getName());

    public static Connection getConnection() throws ApplicationException {
        return getConnection(false);
    }

    private static Connection getConnection(boolean isDebug) throws ApplicationException {
        JSONParser parser = new JSONParser();
        Connection conn = null;
        // conectar
        String credentials_path = System.getProperty("user.dir") + "/src/utils/dbConn.json";
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(credentials_path));

            String host = (String) jsonObject.get("db_ip");
            String port = (String) jsonObject.get("dp_port");
            String username = (String) jsonObject.get("db_user");
            String password = (String) jsonObject.get("db_pssword");
            String dbURL = "jdbc:mysql://" + host + ":" + port + "/editorial";

            conn = DriverManager.getConnection(dbURL, username, password);

            if (isDebug) {
                if (conn != null) {
                    System.out.println("debug: Connection successful to database.");
                }
            }
        } catch (FileNotFoundException ex) {
            //ex.printStackTrace();
            throw new ApplicationException("CONN-001", String.format("Error leyendo archivo JSON de configuración en: %s", credentials_path));
        } catch (SQLException ex) {
            throw new ApplicationException("CONN-002", "Error en la configuración del conector de Base de datos", String.valueOf(ex.getMessage()));
        } catch (IOException | ParseException ex) {
            //ex.printStackTrace();
            throw new ApplicationException("CONN-003", "Error general conectando a Base de datos");
        }

        return conn;
    }

    public static void main(String[] args) {
        try {
            getConnection(true);
        } catch (ApplicationException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
