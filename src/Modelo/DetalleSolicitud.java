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
    private String descripcion;
    private double volumen;
    private String motivo;
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
    
    public DetalleSolicitud(){
        
    }
    public DetalleSolicitud(String desc, double vol, String mot){
        descripcion = desc;
        volumen = vol;
        motivo = mot;
    }
}
