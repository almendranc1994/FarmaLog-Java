/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import AccesoDatos.SolicitudCompraDA;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author franco
 */
public class Carrito {
    
    private int id;
    // Todo carrito esta asociado a un proveedor
    private Proveedor proveedor;
    private Date fechaCreacion;
    
    private ArrayList<SolicitudCompra> solicitudes = new ArrayList<>();
    
    public Carrito(Proveedor proveedor) {
        this.proveedor = proveedor;
        solicitudes = null;
    }
    
    public void checkoutCarrito() {
        SolicitudCompraDA solcompDA = new SolicitudCompraDA();
        setSolicitudes(solcompDA.obtenerSolicitudesCarrito(getId()));
    }
    
    public void addSolicitud(SolicitudCompra solicitud) {
        getSolicitudes().add(solicitud);
    }
    
    public void addTreeStructure(DefaultMutableTreeNode parent) {
        for(SolicitudCompra detalle: getSolicitudes()) {
            DefaultMutableTreeNode nodoDetalle = new DefaultMutableTreeNode(detalle);
            parent.add(nodoDetalle);
        }
    }
    
    @Override
    public String toString() {
        return getProveedor().getNombreEmpresa();
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the solicitudes
     */
    public ArrayList<SolicitudCompra> getSolicitudes() {
        return solicitudes;
    }

    /**
     * @param solicitudes the solicitudes to set
     */
    public void setSolicitudes(ArrayList<SolicitudCompra> solicitudes) {
        this.solicitudes = solicitudes;
    }
    
}
