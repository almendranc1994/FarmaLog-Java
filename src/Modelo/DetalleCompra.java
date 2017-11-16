/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author franco
 */
public class DetalleCompra {
    
    private final Compra compra;
    private final SolicitudCompra solicitud;
    private double precioUnitario;
    
    public DetalleCompra(Compra compra, SolicitudCompra solicitud) {
        this.compra = compra;
        this.solicitud = solicitud;
    }
    
    @Override
    public String toString() {
        return getSolicitud().getInsumo().getNombreInsumo();
    }

    /**
     * @return the compra
     */
    public Compra getCompra() {
        return compra;
    }

    /**
     * @return the solicitud
     */
    public SolicitudCompra getSolicitud() {
        return solicitud;
    }

    /**
     * @return the precioUnitario
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
}
