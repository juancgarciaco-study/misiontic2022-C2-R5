/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author juan
 */
public class UsuarioModel {

    private String username;
    private String nombre;
    private String apellido;
    private String nombreCompleto;
    private String email;
    private String celular;
    private String secret;
    private Date fechanacimiento;

    /**
     * Empty Constructor
     */
    public UsuarioModel() {
    }

    /**
     * Basic Constructor
     *
     * @param username
     * @param nombre
     * @param apellido
     * @param email
     * @param celular
     * @param secret
     * @param fechanacimiento
     */
    public UsuarioModel(String username, String nombre, String apellido, String email, String celular, String secret, Date fechanacimiento) {
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.secret = secret;
        this.fechanacimiento = fechanacimiento;

        this.nombreCompleto = String.format("%s %s", nombre == null ? "" : nombre.trim(), apellido == null ? "" : apellido.trim());
    }

    public Object[] toArray() {
        //Object[] data = {username, nombre, apellido, email, celular, secret, fechanacimiento};
        Object[] data = {username, nombreCompleto, email, celular};
        return data;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @param secret the secret to set
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * @return the fechanacimiento
     */
    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    /**
     * @param fechanacimiento the fechanacimiento to set
     */
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

}
