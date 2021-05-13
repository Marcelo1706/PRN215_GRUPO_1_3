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
public class Grupo {
    private int idgrupo;
    private String nombre;
    private int idgrado;
    
    public int getIdGrupo(){
        return this.idgrupo;
    }
    
    public void setIdGrupo(int idgrupo){
        this.idgrupo = idgrupo;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getIdGrado(){
        return this.idgrado;
    }
    
    public void setIdGrado(int idgrado){
        this.idgrado = idgrado;
    }
}
