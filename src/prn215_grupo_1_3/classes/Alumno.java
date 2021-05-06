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
public class Alumno {
    public int codigo;
    public String nombre; 
    public String sexo;
    public Date fechaNacimiento;
    public String grado;
    public int grupo; 
    
    
    @Override
    public String toString(){
        return codigo+";"+nombre+";"+sexo+";"+fechaNacimiento.toGMTString()+";"+grado+";"+grupo;
    }
    
    public static Alumno toObject(String cadena){
        Alumno al = new Alumno();
        if(cadena != null && !cadena.trim().equals("")){
            String[] cad = cadena.split(";");
            al.codigo = Integer.parseInt(cad[0]);
            al.nombre = cad[1];
            al.sexo = cad[2];
            al.fechaNacimiento = new Date(cad[3]);
            al.grado = cad[4];
            al.grupo = Integer.parseInt(cad[5]);
        }
        return al;
    }
    
    public Alumno[] leerAlumnos(){
        Alumno[] alumnos = new Alumno[2000];
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("alumnos.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    
                }
            }

            String[] contenido = aa.obtenerContenido(archivo);
            for(int i=0;i<contenido.length; i++){
                alumnos[i] = Alumno.toObject(contenido[i]);
            }
        } catch (IOException ex) {
            
        }
        return alumnos;
    }
    
    public boolean crearAlumno(Alumno alumno){
        boolean creada = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("alumnos.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    creada = false;
                }
            }

            boolean crear = aa.agregarObjeto(archivo,alumno);
            if(crear){
                creada = true;
            }
        } catch (IOException ex) {
            creada = false;
        }
        return creada;
    }
    
    public boolean existeAlumno(Alumno alumno){
        boolean existe = false;
        try{
            AdminArchivos aa = new AdminArchivos();
            File archivo = new File("alumnos.txt");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    existe = false;
                }
            }

            existe = aa.contieneObjeto(archivo, alumno);
        } catch (IOException ex) {
            existe = false;
        }
        return existe;
    }
    
    public boolean borrarAlumno(Alumno alumno){
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

            borrado = aa.quitarObjeto(archivo, alumno);
        } catch (IOException ex) {
            borrado = false;
        }
        return borrado;
    }
    
    public boolean buscarCodigo(int codigo){
        boolean existe = false;
        Alumno[] alumnos = this.leerAlumnos();
        for(Alumno alumno : alumnos){
            if(alumno.codigo == codigo){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public Alumno alumnoPorCodigo(int codigo){
        Alumno al = new Alumno();
        Alumno[] alumnos = this.leerAlumnos();
        for(Alumno alumno : alumnos){
            if(alumno.codigo == codigo){
                al = alumno;
                break;
            }
        }
        return al;
    }
    
    public boolean actualizarAlumno(int codigo, Alumno alumno){
        boolean actualizado = false;
        Alumno alumnoActualizar = this.alumnoPorCodigo(codigo);
        boolean borrada = this.borrarAlumno(alumnoActualizar);
        if(borrada){
            actualizado = this.crearAlumno(alumno);
        }
        return actualizado;
    }
}
