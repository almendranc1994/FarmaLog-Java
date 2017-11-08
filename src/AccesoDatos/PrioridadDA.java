/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class PrioridadDA {
    
    public String obtenerNombre(int id){
        try{
            Statement sentencia = Conexion.getConexion().createStatement();
            String query = "SELECT * FROM Prioridad" + " WHERE " +  "idPrioridad = '" + id + "'";
            ResultSet rs = sentencia.executeQuery(query);
            String nombre = null;
            
            while(rs.next()){
                int id_ = Integer.parseInt(rs.getString("idPrioridad"));
                if(id_ == id){
                    nombre = rs.getString("nombre");
                    break;
                }                
            }
            Conexion.closeConexion();    
            return nombre;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
//    public static void main(String[] args) {
//        PrioridadDA gestor = new PrioridadDA();
//        System.out.println(gestor.obtenerNombre(1));
//        
//    }
}
