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
import modelos.Grupo;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 * @author César Emilio Henríquez Avelar HA16008
 */
public class GrupoHandler {
    private static final String DB_URL = "jdbc:h2:./asistencia_monterrosa";
    private Connection conn;
    
    
    public static boolean insertGrupo(Grupo grupo) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "INSERT INTO GRUPO(nombre,idgrado) VALUES (?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1,grupo.getNombre());
                statement.setInt(2,grupo.getIdGrado());
                
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
    
    public static ArrayList<Object[]> selectGrupo() throws ClassNotFoundException{
        ArrayList<Object[]> grupos = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "SELECT * FROM GRUPO";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                
                while(result.next()){
                   Object[] resultado = new Object[]{result.getInt(1),result.getString(2),GradoHandler.selectNombreGrado(result.getInt(3))};
                   grupos.add(resultado);
                }
                conn.close();
            }
            
        } catch (SQLException ex) {
            return null;
        }
        
        return grupos;
    }
    
    public static ArrayList<Object[]> selectGruposGrados() throws ClassNotFoundException{
        ArrayList<Object[]> grupos = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "SELECT grupo.idgrupo, grupo.nombre as gruponom, grado.nombre, grado.seccion FROM Grado INNER JOIN Grupo ON Grado.idgrado = grupo.idgrado";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                
                while(result.next()){
                   Object[] resultado = new Object[]{result.getInt("IDGRUPO"),result.getString("GRUPONOM"),result.getString("NOMBRE"),result.getString("SECCION")};
                   grupos.add(resultado);
                }
                conn.close();
            }
            
        } catch (SQLException ex) {
            grupos.add(new Object[]{ex.getLocalizedMessage()});
        }
        
        return grupos;
    }
    
    public static boolean updateGrupo(Grupo grupo) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "UPDATE GRUPO SET nombre=?, idgrado=? WHERE idgrupo=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, grupo.getNombre());
                statement.setInt(2, grupo.getIdGrado());
                statement.setInt(3, grupo.getIdGrupo());
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
    
    public static boolean deleteGrupo(int codigo) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "DELETE FROM GRUPO WHERE idgrupo=?";
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
    
    public static String selectGrupoConGrado(int idGrupo) throws ClassNotFoundException{
        String nombreGrupo = "";
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "SELECT grupo.nombre, grado.nombre, grado.seccion FROM Grado INNER JOIN Grupo ON Grado.idgrado = grupo.idgrado WHERE grupo.idgrupo="+idGrupo;
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while(result.next()){
                  nombreGrupo = result.getString(1)+" "+result.getString(2)+" "+result.getString(3);
                }
                conn.close();
            }
            
        } catch (SQLException ex) {
            return "ERROR "+ex.getLocalizedMessage();
        }
        return nombreGrupo;
    }
}
