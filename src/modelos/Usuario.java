/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 * @author César Emilio Henríquez Avelar HA16008
 */
public class Usuario {
    private int idusuarios;
    private String usuario;
    private String clave;
       
    /**
     * @return the IDUsuario
     */
    public int getIDUsuario() {
        return idusuarios;
    }

    /**
     * @param IDUsuario the IDUsuario to set
     */
    public void setIDUsuario(int IDUsuario) {
        this.idusuarios = IDUsuario;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.usuario = Usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the NombreApellidos to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
