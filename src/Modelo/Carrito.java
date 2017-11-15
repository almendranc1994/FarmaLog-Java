/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author franco
 */
public class Carrito {
    
    private Proveedor proveedor;
    private ArrayList<SolicitudCompra> solicitudes;
    
    public Carrito() {}
    
    public Carrito(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public void addSolicitud(SolicitudCompra solicitud) throws Exception {
        solicitudes.add(solicitud);
    }
    
    
    public void addTreeStructure(DefaultMutableTreeNode parent) {
        for(SolicitudCompra detalle: solicitudes) {
            DefaultMutableTreeNode nodoDetalle = new DefaultMutableTreeNode(detalle);
            parent.add(nodoDetalle);
        }
    }
    
    @Override
    public String toString() {
        return proveedor.getNombreEmpresa();
    }
    
}
