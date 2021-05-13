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
import modelos.Grado;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 * @author César Emilio Henríquez Avelar HA16008
 */
public class GradoHandler {
    private static final String DB_URL = "jdbc:h2:./asistencia_monterrosa";
    private Connection conn;
    
    
    public static boolean insertGrado(Grado grado) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "INSERT INTO GRADO(nombre,seccion) VALUES (?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1,grado.getNombre());
                statement.setString(2,grado.getSeccion());
                
                int rowInserted = statement.executeUpdate();
                conn.close();
                if(rowInserted > 0){
                    return true;
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public static ArrayList<Object[]> selectGrado() throws ClassNotFoundException{
        ArrayList<Object[]> grados = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "SELECT * FROM Grado";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                
                while(result.next()){
                   Object[] resultado = new Object[]{result.getInt(1),result.getString(2),result.getString(3)};
                   grados.add(resultado);
                }
                conn.close();
            }
            
        } catch (SQLException ex) {
            return null;
        }
        
        return grados;
    }
    
    public static boolean updateGrado(Grado grado) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "UPDATE GRADO SET nombre=?, seccion=? WHERE idgrado=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, grado.getNombre());
                statement.setString(2, grado.getSeccion());
                statement.setInt(3, grado.getIdGrado());
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
    
    public static boolean deleteGrado(int codigo) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "DELETE FROM GRADO WHERE idgrado=?";
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
    
    public static String selectNombreGrado(int idGrado) throws ClassNotFoundException{
        String nombreGrado = "";
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "SELECT nombre, seccion FROM Grado WHERE idgrado="+idGrado;
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while(result.next()){
                  nombreGrado = result.getString(1)+" "+result.getString(2);
                }
                conn.close();
            }
            
        } catch (SQLException ex) {
            return "ERROR "+ex.getLocalizedMessage();
        }
        return nombreGrado;
    }
}
