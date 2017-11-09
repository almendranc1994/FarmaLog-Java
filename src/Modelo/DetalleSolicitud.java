/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Andre Pando
 */
public class DetalleSolicitud {
    private int codigoDetalleSolicitud;
    private int codigoSolicitudSuministro;
    private Insumo insumo;
    private double volumen;
    private int stock;
    private String motivo;
    private String estado;
    
    public int getCodigoDetalleSolicitud() {
        return codigoDetalleSolicitud;
    }

    public void setCodigoDetalleSolicitud(int codigoDetalleSolicitud) {
        this.codigoDetalleSolicitud = codigoDetalleSolicitud;
    }

    public int getCodigoSolicitudSuministro() {
        return codigoSolicitudSuministro;
    }

    public void setCodigoSolicitudSuministro(int codigoSolicitudSuministro) {
        this.codigoSolicitudSuministro = codigoSolicitudSuministro;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
       
}
