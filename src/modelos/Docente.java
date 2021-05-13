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
public class Docente {
    private int idalumno;
    private String nombre;
    private String sexo;
    private int idgrado;
    
    public int getIdAlumno(){
        return this.idalumno;
    }
    
    public void setIdAlumno(int idalumno){
        this.idalumno = idalumno;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getSexo(){
        return this.sexo;
    }
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    public int getIdGrado(){
        return this.idgrado;
    }
    
    public void setIdGrado(int idgrupo){
        this.idgrado = idgrupo;
    }
}
