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
 * @author JoseM
 */
public class RegistroAcademico {
    public int codigo;
    public String alumno; 
    public String docente;
    public String materiaAsignada;
    public String grado;
    public int grupo; 
    public boolean asistencia; 
    public Date fechaAsistencia;
    
    
    @Override
    public String toString(){
        return codigo+";"+alumno+";"+docente+";"+materiaAsignada+";"+grado+";"+grupo+";"+asistencia+";"+fechaAsistencia.toGMTString();
    }
    
    public static RegistroAcademico toObject(String cadena){
        RegistroAcademico regAd = new RegistroAcademico();
        if(cadena != null && !cadena.trim().equals("")){
            String[] cad = cadena.split(";");
            regAd.codigo = Integer.parseInt(cad[0]);
            regAd.alumno = cad[1];
            regAd.docente = cad[2];
            regAd.materiaAsignada = cad[3];
            regAd.grado = cad[4];
            regAd.grupo = Integer.parseInt(cad[5]);
            regAd.asistencia = Boolean.parseBoolean(cad[6]);
            regAd.fechaAsistencia = new Date(cad[3]);
        }
        return regAd;
    }
    
    public RegistroAcademico[] leerRegistroAcademico(){
        RegistroAcademico[] registroAcad = new RegistroAcademico[2000];
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("registro.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    
                }
            }

            String[] contenido = aa.obtenerContenido(archivo);
            for(int i=0;i<contenido.length; i++){
                registroAcad[i] = RegistroAcademico.toObject(contenido[i]);
            }
        } catch (IOException ex) {
            
        }
        return registroAcad;
    }
    
    public boolean crearRegistroAcademico(RegistroAcademico registroAcademico){
        boolean creada = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("registro.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    creada = false;
                }
            }

            boolean crear = aa.agregarObjeto(archivo,registroAcademico);
            if(crear){
                creada = true;
            }
        } catch (IOException ex) {
            creada = false;
        }
        return creada;
    }
    
    public boolean existeRegistroAcademico(RegistroAcademico registroAcademico){
        boolean existe = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("registro.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    existe = false;
                }
            }

            existe = aa.contieneObjeto(archivo, registroAcademico);
        } catch (IOException ex) {
            existe = false;
        }
        return existe;
    }
    
    public boolean borrarRegistroAcademico(RegistroAcademico registroAcademico){
        boolean borrado = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("registro.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    borrado = false;
                }
            }

            borrado = aa.quitarObjeto(archivo, registroAcademico);
        } catch (IOException ex) {
            borrado = false;
        }
        return borrado;
    }
    
    public boolean buscarCodigo(int codigo){
        boolean existe = false;
        RegistroAcademico[] registros = this.leerRegistroAcademico();
        for(RegistroAcademico registro : registros){
            if(registro.codigo == codigo){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public RegistroAcademico registroPorCodigo(int codigo){
        RegistroAcademico regAd = new RegistroAcademico();
        RegistroAcademico[] registros = this.leerRegistroAcademico();
        for(RegistroAcademico registro : registros){
            if(registro.codigo == codigo){
                regAd = registro;
                break;
            }
        }
        return regAd;
    }
    
    public boolean actualizarRegistroAcademico(int codigo, RegistroAcademico registroAcademico){
        boolean actualizado = false;
        RegistroAcademico registroActualizar = this.registroPorCodigo(codigo);
        boolean borrada = this.borrarRegistroAcademico(registroActualizar);
        if(borrada){
            actualizado = this.crearRegistroAcademico(registroAcademico);
        }
        return actualizado;
    }
}
