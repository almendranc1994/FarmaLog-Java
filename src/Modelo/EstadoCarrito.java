/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author franco
 */
public enum EstadoCarrito {
    
    ACTIVO (1, "Activo"),
    INACTIVO (2, "Inactivo");
    
    private final int idEstado;
    private final String estado;
    
    private EstadoCarrito(int id, String estado) {
        this.idEstado = id;
        this.estado = estado;
    }
    
    public int getIdEstado() {
        return idEstado;
    }
    
    public String getEstado() {
        return estado;
    }
    
}
