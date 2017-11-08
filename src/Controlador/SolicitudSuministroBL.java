/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import AccesoDatos.SolicitudSuministroDA;
import Modelo.SolicitudSuministro;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class SolicitudSuministroBL {
    private SolicitudSuministroDA accesoDatos;
    
    public SolicitudSuministroBL(){
        accesoDatos = new SolicitudSuministroDA();
    }
    
    public ArrayList<SolicitudSuministro> obtenerListaSolicitudSuministro(){
        return accesoDatos.obtenerListaSolicitudesSuministro();
    }
    
    public void eliminarSolicitudSuministro(int id){
        accesoDatos.eliminarSolicitudSuministro(id);
    }
}
