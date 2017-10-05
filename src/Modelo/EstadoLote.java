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
public class EstadoLote {
    private String estado;
    private String descripcion;
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public EstadoLote(){
        
    }
    public EstadoLote(String est, String desc){
        estado = est;
        descripcion = desc;
    }
}
