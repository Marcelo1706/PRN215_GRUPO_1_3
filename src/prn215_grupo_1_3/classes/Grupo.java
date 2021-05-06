/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prn215_grupo_1_3.classes;

import java.io.File;
import java.io.IOException;
import prn215_grupo_1_3.auxiliar.AdminArchivos;

/**
 *
 * @author JoseM
 */
public class Grupo {
    public int numero;
    public String alumno;
    public String grado; 
    
    
    @Override
    public String toString(){
        return numero+";"+alumno+";"+grado;
    }
    
    public static Grupo toObject(String cadena){
        Grupo gru = new Grupo();
        if(cadena != null && !cadena.trim().equals("")){
            String[] cad = cadena.split(";");
            gru.numero = Integer.parseInt(cad[0]);
            gru.alumno = cad[1];
            gru.grado = cad[2];
        }
        return gru;
    }
    
    public Grupo[] leerGrupos(){
        Grupo[] grupo = new Grupo[2000];
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("grupos.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    
                }
            }

            String[] contenido = aa.obtenerContenido(archivo);
            for(int i=0;i<contenido.length; i++){
                grupo[i] = Grupo.toObject(contenido[i]);
            }
        } catch (IOException ex) {
            
        }
        return grupo;
    }
    
    public boolean crearGrupo(Grupo grupo){
        boolean creada = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("grupos.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    creada = false;
                }
            }

            boolean crear = aa.agregarObjeto(archivo,grupo);
            if(crear){
                creada = true;
            }
        } catch (IOException ex) {
            creada = false;
        }
        return creada;
    }
    
    public boolean existeGrupo(Grupo grupo){
        boolean existe = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("grupos.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    existe = false;
                }
            }

            existe = aa.contieneObjeto(archivo, grupo);
        } catch (IOException ex) {
            existe = false;
        }
        return existe;
    }
    
    public boolean borrarGrupo(Grupo grupo){
        boolean borrado = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("grupos.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    borrado = false;
                }
            }

            borrado = aa.quitarObjeto(archivo, grupo);
        } catch (IOException ex) {
            borrado = false;
        }
        return borrado;
    }
    
    public boolean buscarCodigo(int codigo){
        boolean existe = false;
        Grupo[] grupos = this.leerGrupos();
        for(Grupo grupo : grupos){
            if(grupo.numero == codigo){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public Grupo grupooPorCodigo(int codigo){
        Grupo gru = new Grupo();
        Grupo[] grupos = this.leerGrupos();
        for(Grupo grupo : grupos){
            if(grupo.numero == codigo){
                gru = grupo;
                break;
            }
        }
        return gru;
    }
    
    public boolean actualizarGrupo(int codigo, Grupo grupo){
        boolean actualizado = false;
        Grupo grupoActualizar = this.grupooPorCodigo(codigo);
        boolean borrada = this.borrarGrupo(grupoActualizar);
        if(borrada){
            actualizado = this.crearGrupo(grupo);
        }
        return actualizado;
    }
}
