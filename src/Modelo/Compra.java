/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author franco
 */
public class Compra {

    private int id;
    // No puede existir compra sin proveedor
    private final Proveedor proveedor;
    
    private Date fechaCotizacion;
    private Date fechaCompra;
    
    private double subtotal;
    private double impuestos;
    private double total;
    
    private ArrayList<DetalleCompra> detalles = new ArrayList<>();
    
    public Compra() {
        this.proveedor = null;
    }
    
    public Compra(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void addDetalle(DetalleCompra detalle) {
        detalles.add(detalle);
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
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @return the fechaCotizacion
     */
    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    /**
     * @param fechaCotizacion the fechaCotizacion to set
     */
    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    /**
     * @return the fechaCompra
     */
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * @param fechaCompra the fechaCompra to set
     */
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the impuestos
     */
    public double getImpuestos() {
        return impuestos;
    }

    /**
     * @param impuestos the impuestos to set
     */
    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the detalles
     */
    public ArrayList<DetalleCompra> getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(ArrayList<DetalleCompra> detalles) {
        this.detalles = detalles;
    }
    
    
    
}
