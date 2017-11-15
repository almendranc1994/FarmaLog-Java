/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.SolicitudCompraDA;
import Modelo.SolicitudCompra;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franc
 */
public class SolicitudCompraBL {
    
    private static final long UPDATE_TIME = 20000; // 20 seg
    
    // Aplicando persistencia de datos
    private static Map<Integer, Long> creationTime = new HashMap<>();
    private static Map<Integer, SolicitudCompra> solicitudes = new HashMap<>();
    
    public SolicitudCompra buscarSolicitudCompra(int idSolicitudCompra) {
        if(!solicitudes.containsKey(idSolicitudCompra) ||
                (creationTime.get(idSolicitudCompra) + UPDATE_TIME) < System.currentTimeMillis()) {
            SolicitudCompraDA solcompDA = new SolicitudCompraDA();
            
            solicitudes.put(idSolicitudCompra, solcompDA.obtenerSolicitudCompra(idSolicitudCompra));
            creationTime.put(idSolicitudCompra, System.currentTimeMillis());
        }
        return solicitudes.get(idSolicitudCompra);
    }
    
}
