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
    
    private Insumo insumo;
    private Proveedor proveedor;
    private double volumen;
    private double precioUnitario;
    private UnidadMedida um;
    private ArrayList<SolicitudSuministro> solicitudesRelacionadas = new ArrayList<>();
    
    public DetalleCompra() {}
    
    public DetalleCompra(Insumo insumo, Proveedor prov) {
        this.insumo = insumo;
        this.proveedor = prov;
    }
    
    public void setVolumen(double vol) {
        this.volumen = vol;
    }
    
    public double getVolumen() {
        return volumen;
    }
    
    public void setPrecioUnitario(double pu) {
        this.precioUnitario = pu;
    }
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public void setUnidadMedida(UnidadMedida um) {
        this.um = um;
    }
    
    public UnidadMedida getUnidadMedida() {
        return um;
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }
    
    @Override
    public String toString() {
        return insumo.getNombreInsumo();
    }
    
}
