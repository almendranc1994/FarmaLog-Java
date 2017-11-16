/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.MarcaDA;
import Modelo.Marca;
import java.util.ArrayList;

/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class MarcaBL {
    private MarcaDA accesoDatos=new MarcaDA();
    public Marca BuscarMarcaporNombre(String nombre){
        return accesoDatos.BuscarMarcaporNombre(nombre);
    }
    public ArrayList<Marca> devolverLista(){
        return accesoDatos.devolverLista();
    }
}
