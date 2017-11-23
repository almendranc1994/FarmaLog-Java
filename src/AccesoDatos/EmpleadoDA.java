/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Controlador.AdministradorBL;
import Modelo.Administrador;
import Modelo.Empleado;
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
public class EmpleadoDA {
    public EmpleadoDA(){
        
    }
    
    public ArrayList<Empleado> getOnlineUsers(){
        ArrayList<Empleado> lisOnline = new ArrayList<>();
        try{
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Empleado where conectado=1");
            while(rs.next()){
                System.out.println(Integer.parseInt(rs.getString("idEmpleado")));
                lisOnline.add( new Empleado(Integer.parseInt(rs.getString("idEmpleado")),Integer.parseInt(rs.getString("idArea")),
                rs.getString("nombres"),rs.getString("apellidos"),rs.getString("correo"),rs.getString("telefono")));
                
                
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return lisOnline;
    }
    public void logOut(Empleado emp){
        
        try{
            Statement sentencia=Conexion.getConexion().createStatement();
            sentencia.executeUpdate("UPDATE Empleado SET conectado = 0 WHERE idEmpleado ="+emp.getId()+"");
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    public void logIn(Empleado emp){
        
        try{
            Statement sentencia=Conexion.getConexion().createStatement();
            sentencia.executeUpdate("UPDATE Empleado SET conectado = 1 WHERE idEmpleado ="+emp.getId()+"");
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    public Empleado buscarEmpleado(String username, String password){
        Empleado emp;
        
        
        AdministradorBL adminCtrl;
        adminCtrl = new AdministradorBL();
        Administrador adminU;
        adminU = adminCtrl.LogUser(username, password);
        if(adminU != null){

            try{
                Statement sentencia=Conexion.getConexion().createStatement();
                ResultSet rs = sentencia.executeQuery("SELECT * FROM Empleado where idEmpleado="+adminU.getId());
                if(rs.next()){
                    emp = new Empleado(Integer.parseInt(rs.getString("idEmpleado")),Integer.parseInt(rs.getString("idArea")),
                rs.getString("nombres"),rs.getString("apellidos"),rs.getString("correo"),rs.getString("telefono"));
                    
                    return emp;
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }

            
        }
 
        return null;
    
        
  
    }
}
