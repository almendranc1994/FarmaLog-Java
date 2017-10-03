/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Andre
 */
public class DetalleSuministro {
    private double volumen;
    private boolean vdProduccion;
    private double remanente;
    private double totalUtilizado;
    
    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public boolean isVdProduccion() {
        return vdProduccion;
    }

    public void setVdProduccion(boolean vdProduccion) {
        this.vdProduccion = vdProduccion;
    }

    public double getRemanente() {
        return remanente;
    }

    public void setRemanente(double remanente) {
        this.remanente = remanente;
    }

    public double getTotalUtilizado() {
        return totalUtilizado;
    }

    public void setTotalUtilizado(double totalUtilizado) {
        this.totalUtilizado = totalUtilizado;
    }
    
    public DetalleSuministro(){
        
    }
    public DetalleSuministro(double vol, boolean vdProd, double rem, double total){
        volumen = vol;
        vdProduccion = vdProd;
        remanente = rem;
        totalUtilizado = total;
    }
    
}
