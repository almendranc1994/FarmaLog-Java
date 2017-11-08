/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author franco
 */
public class SolicitudSuministro {
    private int codigoSolicitudSuministro;
    private Date fechaPeticion;
    private Date fechaLimite;
    private String institucion;
    private Prioridad prioridad; 
    
    public int getCodigoSolicitudSuministro() {
        return codigoSolicitudSuministro;
    }

    public void setCodigoSolicitudSuministro(int codigoSolicitudSuministro) {
        this.codigoSolicitudSuministro = codigoSolicitudSuministro;
    }

    public Date getFechaPeticion() {
        return fechaPeticion;
    }

    public void setFechaPeticion(Date fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
    
    
    // TODO
    //private Empleado empleado;
    
}
