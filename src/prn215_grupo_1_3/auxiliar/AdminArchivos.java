/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prn215_grupo_1_3.auxiliar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author JoseM
 */
public class AdminArchivos {
    public static String mime = "txt";

    public boolean agregarObjeto(File archivo, Object objeto) throws IOException
    {
        if(archivo.getName().endsWith(mime))
        {
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(archivo, true)))) {
                if(objeto != null && !objeto.toString().equals("null")){
                    pw.println(objeto.toString());
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean contieneObjeto(File archivo, Object objeto) throws IOException
    {
        if(archivo.getName().endsWith(mime))
        {
            boolean existeObjeto;
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                existeObjeto = false;
                while(br.ready())
                {
                    String linea = br.readLine();
                    if(linea.trim().equals(objeto.toString()))
                    {
                        existeObjeto = true;
                    }
                }
            }
            return existeObjeto;      
        }
        else
        {
            return false;
        }
    }

    public boolean quitarObjeto(File archivo, Object objeto) throws IOException
    {
        if(archivo.getName().endsWith(mime))
        {
            boolean existeObjeto;
            String[] lineasAnadir;
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                existeObjeto = false;
                lineasAnadir = new String[1000];
                int i = 0;
                while(br.ready())
                {
                    String linea = br.readLine();
                    if(!linea.trim().equals(objeto.toString()))
                    {
                        lineasAnadir[i] = linea.trim();
                    }
                    else
                    {
                        existeObjeto = true;
                    }
                }
            }
            try (BufferedWriter limpiadorArchivo = new BufferedWriter(new FileWriter(archivo))) {
                limpiadorArchivo.write("");
            }
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(archivo, true)))) {
                for(String lineaAnadir : lineasAnadir)
                {
                    if(lineaAnadir != null && !lineaAnadir.trim().equals("")){
                        pw.println(lineaAnadir);                    
                    }
                }
            }
            return existeObjeto;      

        }
        else
        {
            return false;
        }
    }

    public String[] obtenerContenido(File archivo) throws IOException
    {
        String[] contenido = new String[1000];
        if(archivo.getName().endsWith(mime))
        {
            int i = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                while(br.ready())
                {
                    String s1 = br.readLine();
                    if(s1 != null && !s1.trim().equals("")){
                        contenido[i] = s1;
                        i++;
                    }
                }
            }
        }
        return contenido;
    }
}
