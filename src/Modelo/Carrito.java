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
    private ArrayList<DetalleCompra> detalles = new ArrayList<>();
    
    public Carrito() {}
    
    public Carrito(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public void addDetalle(DetalleCompra detalle) throws Exception {
        if(detalle.getProveedor()!=proveedor) {
            throw new Exception("Este carrito de compras le pertenece a otro proveedor!");
        }
        
        detalles.add(detalle);
    }
    
    
    public void addTreeStructure(DefaultMutableTreeNode parent) {
        for(DetalleCompra detalle: detalles) {
            DefaultMutableTreeNode nodoDetalle = new DefaultMutableTreeNode(detalle);
            parent.add(nodoDetalle);
        }
    }
    
    @Override
    public String toString() {
        return proveedor.getNombreEmpresa();
    }
    
}
