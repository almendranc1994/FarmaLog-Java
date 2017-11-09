/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Proveedor;
import AccesoDatos.ProveedoresDA;
/**
 *
 * @author Andre Pando
 */
public class ProveedoresBL {
    private ProveedoresDA accesoDatos;
    
    public ProveedoresBL(){
        accesoDatos = new ProveedoresDA();
    }
    
    public boolean registrarProveedor(Proveedor prov){
        return accesoDatos.registrarProveedor(prov);
    }
    
    public Proveedor BuscarProveedor(int idProveedor){
        return accesoDatos.BuscarProveedor(idProveedor);
    }
}
