/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.DetalleSolicitud;
import AccesoDatos.DetalleSolicitudDA;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class DetalleSolicitudBL {
    private DetalleSolicitudDA accesoDatos;
    
    public DetalleSolicitudBL(){
        accesoDatos = new DetalleSolicitudDA();
    }
    
    public ArrayList<DetalleSolicitud> obtenerLista(int codigo){
        return accesoDatos.obtenerListaSolicitudesSuministro(codigo);
    }
    
    public boolean atenderInsumo(Deta){
        
    }
    
}
