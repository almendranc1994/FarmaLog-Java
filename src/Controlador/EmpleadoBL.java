/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import AccesoDatos.EmpleadoDA;
import java.util.ArrayList;
/**
 *
 * @author Gonzalo
 */
public class EmpleadoBL {
    private EmpleadoDA accesoDatos;
    
    public EmpleadoBL(){
        accesoDatos = new EmpleadoDA();
    }
    public Empleado LogEmpleado(String username, String password){
        return accesoDatos.buscarEmpleado(username, password);
        
        
    }
    public void logOut(Empleado emp){
        accesoDatos.logOut(emp);
        
    }
    public void logIn(Empleado emp){
        accesoDatos.logIn(emp);
    }
    public ArrayList<Empleado> getEmpleadosOnline(){
        ArrayList<Empleado> onlineUsers = new ArrayList<Empleado>();
        
        onlineUsers = accesoDatos.getOnlineUsers();
        return onlineUsers;
    }
}
