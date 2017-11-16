/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.SolicitudCompraDA;
import Modelo.SolicitudCompra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franc
 */
public class SolicitudCompraBL {
    
    private static final long UPDATE_TIME = 20000; // 20 seg
    
    // Aplicando persistencia de datos
    private static final Map<Integer, Long> CREATION_TIME = new HashMap<>();
    private static final Map<Integer, SolicitudCompra> SOLICITUDES = new HashMap<>();
    
    private static final Map<Integer, Long> CARRITO_CREATION_TIME = new HashMap<>();
    private static final Map<Integer, ArrayList<SolicitudCompra>> SOLICITUDES_CARRITO = new HashMap<>();
    
    public SolicitudCompra buscarSolicitudCompra(int idSolicitudCompra) {
        if(!SOLICITUDES.containsKey(idSolicitudCompra) ||
                (CREATION_TIME.get(idSolicitudCompra) + UPDATE_TIME) < System.currentTimeMillis()) {
            SolicitudCompraDA solcompDA = new SolicitudCompraDA();
            
            SOLICITUDES.put(idSolicitudCompra, solcompDA.obtenerSolicitudCompra(idSolicitudCompra));
            CREATION_TIME.put(idSolicitudCompra, System.currentTimeMillis());
        }
        return SOLICITUDES.get(idSolicitudCompra);
    }
    
    public ArrayList<SolicitudCompra> buscarSolicitudesCarrito(int idCarrito) {
        if(!SOLICITUDES_CARRITO.containsKey(idCarrito) ||
                (CARRITO_CREATION_TIME.get(idCarrito) + UPDATE_TIME) < System.currentTimeMillis()) {
            SolicitudCompraDA solcompDA = new SolicitudCompraDA();
            
            ArrayList<Integer> query = solcompDA.obtenerIdsSolicitudesCarrito(idCarrito);
            ArrayList<SolicitudCompra> solicitudesCarrito = new ArrayList<>();
            
            query.stream().forEach((idSolicitud) -> {
                solicitudesCarrito.add(buscarSolicitudCompra(idSolicitud));
            });
            
            SOLICITUDES_CARRITO.put(idCarrito, solicitudesCarrito);
            CARRITO_CREATION_TIME.put(idCarrito, System.currentTimeMillis());
        }
        
        return SOLICITUDES_CARRITO.get(idCarrito);
    }
    
}
