/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Andre
 */
public class Suministro {
    private String codigo;
    private Date fechaAtencion;
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
    
    public Suministro(){
        
    }
    public Suministro(String cod, Date fecha){
        codigo = cod;
        fechaAtencion = fecha;
    }
    
}
