/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.UnidadMedidaDA;
import Modelo.UnidadMedida;
import java.util.ArrayList;

/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class UnidadMedidaBL {

    
    
    private UnidadMedidaDA accesoDatos;
    public UnidadMedidaBL(){
        accesoDatos = new UnidadMedidaDA();
    }
    public UnidadMedida BuscarUnidadMedidaporNombre(String nombre){
        return accesoDatos.BuscarUnidadMedidaporNombre(nombre);
    }
    public ArrayList<UnidadMedida> getMedidas(){
        return accesoDatos.getMedidas();
    }
    public ArrayList<UnidadMedida> devolverLista(){
        return accesoDatos.devolverLista();
    }

    public UnidadMedida BuscarUnidadMedidaporId(int idUnidad) {
        return accesoDatos.BuscarUnidadMedidaporId(idUnidad);
    }
}
