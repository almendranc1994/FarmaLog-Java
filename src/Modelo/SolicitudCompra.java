/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author franc
 */
public class SolicitudCompra {
    
    private int id;
    private SolicitudSuministro solSuministro;
    
    private Carrito carrito;
    
    private Insumo insumo;
    private double cantidad;
    private Date fechaSolicitud;
    private Date fechaAtencion;
    
    public SolicitudCompra() {}
    
    public SolicitudCompra(SolicitudSuministro solSuministro, Insumo insumo, double cantidad, Date fechaSolicitud) {
        this.id = -1;
        this.solSuministro = solSuministro;
        this.insumo = insumo;
        this.cantidad = cantidad;
        this.fechaSolicitud = fechaSolicitud;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the solSuministro
     */
    public SolicitudSuministro getSolSuministro() {
        return solSuministro;
    }

    /**
     * @param solSuministro the solSuministro to set
     */
    public void setSolSuministro(SolicitudSuministro solSuministro) {
        this.solSuministro = solSuministro;
    }

    /**
     * @return the carrito
     */
    public Carrito getCarrito() {
        return carrito;
    }

    /**
     * @param carrito the carrito to set
     */
    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    /**
     * @return the insumo
     */
    public Insumo getInsumo() {
        return insumo;
    }

    /**
     * @param insumo the insumo to set
     */
    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the fechaSolicitud
     */
    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * @param fechaSolicitud the fechaSolicitud to set
     */
    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    /**
     * @return the fechaAtencion
     */
    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    /**
     * @param fechaAtencion the fechaAtencion to set
     */
    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
    
    @Override
    public String toString() {
        return insumo.getNombreInsumo();
    }
    
}
