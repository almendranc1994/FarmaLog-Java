/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Insumo;
import AccesoDatos.InsumoDA;
import java.util.ArrayList;
/**
 *
 * @author Andre Pando
 */
public class InsumoBL {
    private InsumoDA accesoDatos;
    
    public InsumoBL(){
        accesoDatos = new InsumoDA();
    }
    
    public ArrayList<Insumo> devolverListaInsumo(String nombre){
        return accesoDatos.devolverListaInsumo(nombre);
    }
    public Insumo BuscarInsumo(int idInsumo){
        return accesoDatos.BuscarInsumo(idInsumo);
    }
    public boolean registrarInsumo(Insumo newInsumo){
        return accesoDatos.registrarInsumo(newInsumo);
    }
    
    public ArrayList<Insumo> devolverAlertaInsumos(){
        return accesoDatos.devolverAlertaInsumos();
    }
}
