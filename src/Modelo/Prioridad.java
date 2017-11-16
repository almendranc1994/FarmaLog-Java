/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author franco
 */
public enum Prioridad {
    
    ALTA (3, "Alta"),
    MEDIA (2, "Media"),
    BAJA (1, "Baja");
    
    private final int idPrioridad;
    private final String prioridad;
    
    private Prioridad(int id, String nombre) {
        this.idPrioridad = id;
        this.prioridad = nombre;
    }
    
    public int getIdPrioridad() {
        return idPrioridad;
    }

    public String getNombre() {
        return prioridad;
    }

    public static Prioridad getPrioridad(int indice) {
        for(Prioridad p: Prioridad.values()) {
            if(p.getIdPrioridad()==indice) return p;
        }
        return null;
    }
}
