/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author franc
 */
public enum EstadoCompra {
    
    POR_PAGAR(1, "Por pagar"),
    PAGADA(2, "Pagada"),
    EN_CAMINO(3, "En camino"),
    PEDIDO_RECIBIDO(4, "Pedido recibido"),
    ESPERANDO_DEVOLUCION(5, "Esperando devolución"),
    CANCELADA(6, "Compra cancelada");
    
    private final int idEstado;
    private final String descripcion;
    
    EstadoCompra(int idEstado, String descripcion) {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }
    
    public int getIdEstado() {
        return idEstado;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean isOver() {
        return this==PEDIDO_RECIBIDO || this==CANCELADA;
    }
    
}
