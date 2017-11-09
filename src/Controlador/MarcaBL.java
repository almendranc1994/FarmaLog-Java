/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.MarcaDA;
import Modelo.Marca;

/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class MarcaBL {
    private MarcaDA accesoDatos;
    public Marca BuscarMarcaporNombre(String nombre){
        return accesoDatos.BuscarMarcaporNombre(nombre);
    }
}
