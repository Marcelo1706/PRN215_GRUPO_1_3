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
import modelos.AsistenciaAlumno;
import modelos.AsistenciaDocente;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 * @author César Emilio Henríquez Avelar HA16008
 */
public class AsistenciaDocenteHandler {
    private static final String DB_URL = "jdbc:h2:./asistencia_monterrosa";
    private Connection conn;
    
    
    public static boolean insertAsistencia(AsistenciaDocente asistencia) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "INSERT INTO ASISTENCIA_DOCENTE(iddocente,fecha,modalidad,ausencia,justificacion) VALUES (?,?,?,?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1,asistencia.getIdDocente());
                statement.setString(2,asistencia.getFecha());
                statement.setString(3,asistencia.getModalidad());
                statement.setBoolean(4,asistencia.getAusencia());
                statement.setString(5,asistencia.getJustificacion());
                
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
    
    public static ArrayList<Object[]> selectAsistencia() throws ClassNotFoundException{
        ArrayList<Object[]> usuarios = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "SELECT * FROM ASISTENCIA_DOCENTE";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                
                while(result.next()){
                   String ausencia = ("TRUE".equals(result.getString(5))) ? "Sí" : "No";
                   String docente = DocenteHandler.selectDocenteId(result.getInt(2));
                   Object[] resultado = new Object[]{result.getInt(1),docente,result.getString(3), result.getString(4), ausencia, result.getString(6)};
                   usuarios.add(resultado);
                }
                conn.close();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return usuarios;
    }
    
    public static boolean updateAsistencia(AsistenciaDocente asistencia) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "UPDATE ASISTENCIA_DOCENTE SET iddocente=?, fecha=?, modalidad=?, ausencia=?, justificacion=? WHERE idasistencia=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1,asistencia.getIdDocente());
                statement.setString(2,asistencia.getFecha());
                statement.setString(3,asistencia.getModalidad());
                statement.setBoolean(4,asistencia.getAusencia());
                statement.setString(5,asistencia.getJustificacion());
                statement.setInt(6,asistencia.getIdAsistencia());
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
    
    public static boolean deleteAsistencia(int codigo) throws ClassNotFoundException{
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL); 
            if (conn != null) {
                String sql = "DELETE FROM ASISTENCIA_DOCENTE WHERE idasistencia=?";
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
