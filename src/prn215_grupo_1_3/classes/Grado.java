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
public class Grado {
    public int codigo;
    public String docente; 
    public String alumno;
    public int grupo; 
    
    
    @Override
    public String toString(){
        return codigo+";"+docente+";"+alumno+";"+grupo;
    }
    
    public static Grado toObject(String cadena){
        Grado gra = new Grado();
        if(cadena != null && !cadena.trim().equals("")){
            String[] cad = cadena.split(";");
            gra.codigo = Integer.parseInt(cad[0]);
            gra.docente = cad[1];
            gra.alumno = cad[2];
            gra.grupo = Integer.parseInt(cad[3]);
        }
        return gra;
    }
    
    public Grado[] leerGrados(){
        Grado[] grado = new Grado[2000];
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("grados.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    
                }
            }

            String[] contenido = aa.obtenerContenido(archivo);
            for(int i=0;i<contenido.length; i++){
                grado[i] = Grado.toObject(contenido[i]);
            }
        } catch (IOException ex) {
            
        }
        return grado;
    }
    
    public boolean crearGrado(Grado grado){
        boolean creada = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("grados.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    creada = false;
                }
            }

            boolean crear = aa.agregarObjeto(archivo,grado);
            if(crear){
                creada = true;
            }
        } catch (IOException ex) {
            creada = false;
        }
        return creada;
    }
    
    public boolean existeGrado(Grado grado){
        boolean existe = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("grados.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    existe = false;
                }
            }

            existe = aa.contieneObjeto(archivo, grado);
        } catch (IOException ex) {
            existe = false;
        }
        return existe;
    }
    
    public boolean borrarGrado(Grado grado){
        boolean borrado = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("grados.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    borrado = false;
                }
            }

            borrado = aa.quitarObjeto(archivo, grado);
        } catch (IOException ex) {
            borrado = false;
        }
        return borrado;
    }
    
    public boolean buscarCodigo(int codigo){
        boolean existe = false;
        Grado[] grados = this.leerGrados();
        for(Grado grado : grados){
            if(grado.codigo == codigo){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public Grado gradoPorCodigo(int codigo){
        Grado gra = new Grado();
        Grado[] grados = this.leerGrados();
        for(Grado grado : grados){
            if(grado.codigo == codigo){
                gra = grado;
                break;
            }
        }
        return gra;
    }
    
    public boolean actualizarGrado(int codigo, Grado grado){
        boolean actualizado = false;
        Grado gradoActualizar = this.gradoPorCodigo(codigo);
        boolean borrada = this.borrarGrado(gradoActualizar);
        if(borrada){
            actualizado = this.crearGrado(grado);
        }
        return actualizado;
    }
}
