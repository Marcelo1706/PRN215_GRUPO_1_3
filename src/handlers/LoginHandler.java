/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import utilities.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author José Marcelo Hernández Cerritos HC20034
 * @author César Emilio Henríquez Avelar HA16008
 */
public class LoginHandler {
    public boolean login(String usuario, String clave)throws SQLException {
     try {
         Conexion conexion = new Conexion().obtener();
         
         ResultSet resultado = conexion.consultar("SELECT idusuario, usuario FROM usuario WHERE usuario = '" + usuario + "' and clave = '" + clave + "'" );
         resultado.last();
         if (resultado.getRow() > 0){                     
             return true;
        }
   } catch (SQLException e) {
            return false;
        }
      return false;
   }
}
