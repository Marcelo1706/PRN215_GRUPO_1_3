/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

//import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 * @author César Emilio Henríquez Avelar HA16008
 */
public class Conexion {
   private Connection conexion;
   
   public Conexion obtener(){
      
      try {
            Class.forName("org.h2.Driver");
            setConexion(DriverManager.getConnection("jdbc:h2:./asistencia_monterrosa"));
            
            if(getConexion() != null){
                System.out.println("Conexion Exitosa!");
            }else{
                System.out.println("Conexion Fallida!");                
            }
            
      } catch (Exception e) {
            	e.printStackTrace();
	}
   
      return this;
   }
   public Connection getConexion() {
	return conexion;
   }    
   public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }   
   
   public ResultSet consultar(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }        return resultado;
    }

}
