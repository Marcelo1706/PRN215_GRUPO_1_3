/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 * @author César Emilio Henríquez Avelar HA16008
 */
public class AsistenciaAlumno {
    private int idasistencia;
    private int idalumno;
    private Date fecha;
    private String modalidad;
    private boolean ausencia;
    private String justificacion;
    
    public int getIdAsistencia(){
        return this.idasistencia;
    }
    
    public void setIdAsistencia(int idasistencia){
        this.idasistencia = idasistencia;
    }
    
    public int getIdAlumno(){
        return this.idalumno;
    }
    
    public void setIdAlumno(int idalumno){
        this.idalumno = idalumno;
    }
    
    public String getFecha(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        return dateFormat.format(this.fecha);  
    }
    
    public void setFecha(String fecha) throws ParseException{
        this.fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
    }
    
    public String getModalidad(){
        return this.modalidad;
    } 
    
    public void setModalidad(String modalidad){
        this.modalidad = modalidad;
    }
    
    public boolean getAusencia(){
        return this.ausencia;
    }
    
    public void setAusencia(boolean ausencia){
        this.ausencia = ausencia;
    }
    
    public String getJustificacion(){
        return this.justificacion;
    }
    
    public void setJustificacion(String justificacion){
        this.justificacion = justificacion;
    }
}
