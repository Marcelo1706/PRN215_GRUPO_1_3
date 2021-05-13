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
import modelos.Usuario;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 * @author César Emilio Henríquez Avelar HA16008
 */
public class UsuarioHandler {
    private static final String DB_URL = "jdbc:h2:./asistencia_monterrosa";
    private Connection conn;
    
    
    public static boolean insertUsuario(Usuario usuario) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "INSERT INTO USUARIO(usuario,clave) VALUES (?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1,usuario.getUsuario());
                statement.setString(2,usuario.getClave());
                
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
    
    public static ArrayList<Object[]> selectUsuario() throws ClassNotFoundException{
        ArrayList<Object[]> usuarios = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "SELECT * FROM USUARIO";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                
                while(result.next()){
                   Object[] resultado = new Object[]{result.getInt(1),result.getString(2),result.getString(3)};
                   usuarios.add(resultado);
                }
                conn.close();
            }
            
        } catch (SQLException ex) {
            return null;
        }
        
        return usuarios;
    }
    
    public static boolean updateUsuario(Usuario usuario) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "UPDATE USUARIO SET usuario=?, clave=? WHERE idusuario=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, usuario.getUsuario());
                statement.setString(2, usuario.getClave());
                statement.setInt(3, usuario.getIDUsuario());
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
    
    public static boolean deleteUsuario(int codigo) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "DELETE FROM USUARIO WHERE idusuario=?";
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
}
