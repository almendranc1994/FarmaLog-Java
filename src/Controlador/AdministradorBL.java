/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Administrador;
import AccesoDatos.AdministradorDA;
import java.util.ArrayList;
/**
 *
 * @author Gonzalo
 */
public class AdministradorBL {
    
    private AdministradorDA accesoDatos;
    
    public AdministradorBL(){
        accesoDatos = new AdministradorDA();
    }
    
    public Administrador LogUser(String username, String password){
        return accesoDatos.LogUser(username, password);
        
        
    }
    
}
