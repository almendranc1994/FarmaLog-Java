/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Administrador;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Gonzalo
 */
public class AdministradorDA {
    public AdministradorDA(){
        
    }
    public Administrador LogUser(String user, String password){
        Administrador admin;
        try{
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Administrador WHERE usuario ='"+user+"' AND password ='"+password+"'");
//            Statement sentencia1=Conexion.getConexion().createStatement();
//            ResultSet rsEmp = sentencia1.executeQuery("SELECT * FROM Empleado WHERE idEmpleado ="+rs.getString("idEmpleado"));
            
            if(rs.next()){
                
                admin = new Administrador(Integer.parseInt(rs.getString("idEmpleado")),
                rs.getString("usuario"),rs.getString("password"),rs.getString("ip"));
                
                return admin;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
         return null; 
    }
}
