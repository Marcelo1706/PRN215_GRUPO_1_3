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
public class Docente {
    public int codigo;
    public String nombre; 
    public String sexo;
    public Date fechaNacimiento;
    public String grado;
    public String materiaAsignada; 
    
    
    @Override
    public String toString(){
        return codigo+";"+nombre+";"+sexo+";"+fechaNacimiento.toGMTString()+";"+grado+";"+materiaAsignada;
    }
    
    public static Docente toObject(String cadena){
        Docente doc = new Docente();
        if(cadena != null && !cadena.trim().equals("")){
            String[] cad = cadena.split(";");
            doc.codigo = Integer.parseInt(cad[0]);
            doc.nombre = cad[1];
            doc.sexo = cad[2];
            doc.fechaNacimiento = new Date(cad[3]);
            doc.grado = cad[4];
            doc.materiaAsignada = cad[5];
        }
        return doc;
    }
    
    public Docente[] leerDocentes(){
        Docente[] docente = new Docente[2000];
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("docentes.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    
                }
            }

            String[] contenido = aa.obtenerContenido(archivo);
            for(int i=0;i<contenido.length; i++){
                docente[i] = Docente.toObject(contenido[i]);
            }
        } catch (IOException ex) {
            
        }
        return docente;
    }
    
    public boolean crearDocente(Docente docente){
        boolean creada = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("docentes.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    creada = false;
                }
            }

            boolean crear = aa.agregarObjeto(archivo,docente);
            if(crear){
                creada = true;
            }
        } catch (IOException ex) {
            creada = false;
        }
        return creada;
    }
    
    public boolean existeDocente(Docente docente){
        boolean existe = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("docentes.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    existe = false;
                }
            }

            existe = aa.contieneObjeto(archivo, docente);
        } catch (IOException ex) {
            existe = false;
        }
        return existe;
    }
    
    public boolean borrarDocente(Docente docente){
        boolean borrado = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("docentes.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    borrado = false;
                }
            }

            borrado = aa.quitarObjeto(archivo, docente);
        } catch (IOException ex) {
            borrado = false;
        }
        return borrado;
    }
    
    public boolean buscarCodigo(int codigo){
        boolean existe = false;
        Docente[] docentes = this.leerDocentes();
        for(Docente docente : docentes){
            if(docente.codigo == codigo){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public Docente docentePorCodigo(int codigo){
        Docente doc = new Docente();
        Docente[] docentes = this.leerDocentes();
        for(Docente docente : docentes){
            if(docente.codigo == codigo){
                doc = docente;
                break;
            }
        }
        return doc;
    }
    
    public boolean actualizarDocente(int codigo, Docente docente){
        boolean actualizado = false;
        Docente docenteActualizar = this.docentePorCodigo(codigo);
        boolean borrada = this.borrarDocente(docenteActualizar);
        if(borrada){
            actualizado = this.crearDocente(docente);
        }
        return actualizado;
    }
}
