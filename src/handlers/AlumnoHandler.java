/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Alumno;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 * @author César Emilio Henríquez Avelar HA16008
 */
public class AlumnoHandler {
    private static final String DB_URL = "jdbc:h2:./asistencia_monterrosa";
    private Connection conn;
    
    
    public static boolean insertAlumno(Alumno alumno) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "INSERT INTO ALUMNO(nombre,sexo,idgrupo) VALUES (?,?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1,alumno.getNombre());
                statement.setString(2,alumno.getSexo());
                statement.setInt(3,alumno.getIdGrupo());
                
                int rowInserted = statement.executeUpdate();
                conn.close();
                if(rowInserted > 0){
                    return true;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    public static ArrayList<Object[]> selectAlumno() throws ClassNotFoundException{
        ArrayList<Object[]> usuarios = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "SELECT * FROM ALUMNO";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                
                while(result.next()){
                   Object[] resultado = new Object[]{result.getInt(1),result.getString(2),result.getString(3), GrupoHandler.selectGrupoConGrado(result.getInt(4))};
                   usuarios.add(resultado);
                }
                conn.close();
            }
            
        } catch (SQLException ex) {
            return null;
        }
        
        return usuarios;
    }
    
    public static boolean updateAlumno(Alumno alumno) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "UPDATE ALUMNO SET nombre=?, sexo=?, idgrupo=? WHERE idalumno=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, alumno.getNombre());
                statement.setString(2, alumno.getSexo());
                statement.setInt(3, alumno.getIdGrupo());
                statement.setInt(4, alumno.getIdAlumno());
                int rowsUpdated = statement.executeUpdate();
                conn.close();
                if (rowsUpdated > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public static boolean deleteAlumno(int codigo) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "DELETE FROM ALUMNO WHERE idalumno=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, codigo);
                int rowsDeleted = statement.executeUpdate();
                conn.close();
                if (rowsDeleted > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public static String selectAlumnoId(int idAlumno) throws ClassNotFoundException{
        String nombre = "";
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "SELECT nombre FROM ALUMNO WHERE idAlumno = "+idAlumno;
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                
                while(result.next()){
                   nombre = result.getString(1);
                }
                conn.close();
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return nombre;
    }
}
