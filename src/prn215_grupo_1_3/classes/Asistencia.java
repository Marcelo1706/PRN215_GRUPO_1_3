/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prn215_grupo_1_3.classes;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import prn215_grupo_1_3.auxiliar.AdminArchivos;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 *  
 */
public class Asistencia {
    public int codigo;
    public String alumno;
    public String docente;
    public boolean asistencia;
    public Date fechaAsistencia;
    
    @Override
    public String toString(){
        return codigo+";"+alumno+";"+docente+";"+asistencia+";"+fechaAsistencia.toGMTString();
    }
    
    public static Asistencia toObject(String cadena){
        Asistencia asis = new Asistencia();
        if(cadena != null && !cadena.trim().equals("")){
            String[] cad = cadena.split(";");
            asis.codigo = Integer.parseInt(cad[0]);
            asis.alumno = cad[1];
            asis.docente = cad[2];
            asis.asistencia = Boolean.parseBoolean(cad[3]);
            asis.fechaAsistencia = new Date(cad[4]);
        }
        return asis;
    }
    
    public Asistencia[] leerAsistencia(){
        Asistencia[] asistencia = new Asistencia[2000];
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("asistencia.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    
                }
            }

            String[] contenido = aa.obtenerContenido(archivo);
            for(int i=0;i<contenido.length; i++){
                asistencia[i] = Asistencia.toObject(contenido[i]);
            }
        } catch (IOException ex) {
            
        }
        return asistencia;
    }
    
    public boolean crearAsistencia(Asistencia asistencia){
        boolean creada = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("asistencia.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    creada = false;
                }
            }

            boolean crear = aa.agregarObjeto(archivo,asistencia);
            if(crear){
                creada = true;
            }
        } catch (IOException ex) {
            creada = false;
        }
        return creada;
    }
    
    public boolean existeAsistencia(Asistencia asistencia){
        boolean existe = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("asistencia.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    existe = false;
                }
            }

            existe = aa.contieneObjeto(archivo, asistencia);
        } catch (IOException ex) {
            existe = false;
        }
        return existe;
    }
    
    public boolean borrarAsistencia(Asistencia asistencia){
        boolean borrado = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("alumnos.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    borrado = false;
                }
            }

            borrado = aa.quitarObjeto(archivo, asistencia);
        } catch (IOException ex) {
            borrado = false;
        }
        return borrado;
    }
    
    public boolean buscarCodigo(int codigo){
        boolean existe = false;
        Asistencia[] asist = this.leerAsistencia();
        for(Asistencia asis : asist){
            if(asis.codigo == codigo){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public Asistencia asistenciaPorCodigo(int codigo){
        Asistencia asist = new Asistencia();
        Asistencia[] asistencias = this.leerAsistencia();
        for(Asistencia asis : asistencias){
            if(asis.codigo == codigo){
                asist = asis;
                break;
            }
        }
        return asist;
    }
    
    public boolean actualizarAsistencia(int codigo, Asistencia asistencia){
        boolean actualizado = false;
        Asistencia asistenciaActualizar = this.asistenciaPorCodigo(codigo);
        boolean borrada = this.borrarAsistencia(asistenciaActualizar);
        if(borrada){
            actualizado = this.crearAsistencia(asistencia);
        }
        return actualizado;
    }
}
