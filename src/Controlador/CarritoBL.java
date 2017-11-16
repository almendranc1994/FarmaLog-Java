/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.CarritoDA;
import AccesoDatos.SolicitudCompraDA;
import Modelo.Carrito;
import Modelo.EstadoCarrito;
import Modelo.SolicitudCompra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franc
 */
public class CarritoBL {
     
    private static final long UPDATE_TIME = 20000; // 20 seg
    
    // Aplicando persistencia de datos
    private static final Map<Integer, Long> CREATION_TIME = new HashMap<>();
    private static final Map<Integer, Carrito> CARRITOS = new HashMap<>();
    
    public Carrito buscarCarrito(int idCarrito) {
        if(!CARRITOS.containsKey(idCarrito) ||
                (CREATION_TIME.get(idCarrito) + UPDATE_TIME) < System.currentTimeMillis()) {
            CarritoDA carritoDA = new CarritoDA();
            
            CARRITOS.put(idCarrito, carritoDA.obtenerCarrito(idCarrito));
            CREATION_TIME.put(idCarrito, System.currentTimeMillis());
        }
        return CARRITOS.get(idCarrito);
    }
    
    public ArrayList<Carrito> obtenerCarritosActivos() {
        CarritoDA carritoDA = new CarritoDA();
        return carritoDA.obtenerCarritosPorEstado(EstadoCarrito.ACTIVO);
    }
    
    public ArrayList<Carrito> obtenerCarritosInactivos() {
        CarritoDA carritoDA = new CarritoDA();
        return carritoDA.obtenerCarritosPorEstado(EstadoCarrito.INACTIVO);
    }
    
}
