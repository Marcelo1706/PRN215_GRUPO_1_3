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
public class Grado {
    private int idgrado;
    private String nombre;
    private String seccion;
    
    public int getIdGrado(){
        return this.idgrado;
    }
    
    public void setIdGrado(int idgrado){
        this.idgrado = idgrado;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getSeccion(){
        return this.seccion;
    }
    
    public void setSeccion(String seccion){
        this.seccion = seccion;
    }
}
