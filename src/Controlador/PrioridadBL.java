/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import AccesoDatos.PrioridadDA;
/**
 *
 * @author HP
 */
public class PrioridadBL {
    private PrioridadDA accesoDatos;
    
    public PrioridadBL(){
        accesoDatos = new PrioridadDA();
    }
    
    public String obtenerNombre(int id){
        return accesoDatos.obtenerNombre(id);
    }
}
