/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.*;
/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class ProveedorxInsumo {
    private Insumo insumo;
    private Proveedor proveedor;
    private UnidadMedida uniMed;
    private int stock;
    private Marca marca;
    private double precio;
    public ProveedorxInsumo(){
        proveedor=new Proveedor();
        uniMed=new UnidadMedida();
        marca=new Marca();
    }
    public ProveedorxInsumo(int idProveedor,int idInsumo,int idUnidad,int stock,int idMarca,double precio){
        /*proveedor=(new ProveedoresBL()).BuscarProveedor(idProveedor);
        insumo=(new InsumoBL()).BuscarInsumo(idInsumo);
        UniMed=(new UnidadMedidaBL()).BuscarUnidadMedida(idUnidad);
        this.stock=stock;
        marca=(new MarcaBL()).BuscarMarca(idMarca);
        this.precio=precio;*/
    }
    /**
     * @return the insumo
     */
    public Insumo getInsumo() {
        return insumo;
    }

    /**
     * @param insumo the insumo to set
     */
    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
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
     * @return the uniMed
     */
    public UnidadMedida getUniMed() {
        return uniMed;
    }

    /**
     * @param uniMed the uniMed to set
     */
    public void setUniMed(UnidadMedida uniMed) {
        this.uniMed = uniMed;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
