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
    private UnidadMedidaDA accesoDatos=new UnidadMedidaDA();
    public UnidadMedida BuscarUnidadMedidaporNombre(String nombre){
        return accesoDatos.BuscarUnidadMedidaporNombre(nombre);
    }
    public ArrayList<UnidadMedida> devolverLista(){
        return accesoDatos.devolverLista();
    }
}
