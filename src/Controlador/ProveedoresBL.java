/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Proveedor;
import AccesoDatos.ProveedoresDA;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public ArrayList<Proveedor> devolverProveedores() throws SQLException{
        return accesoDatos.devolverProveedores();
    }
    public int devolverUltimoId(){
        return accesoDatos.devolverUltimoId();
    }
    public void eliminarProveedor(int codigo) {
        accesoDatos.eliminarProveedor(codigo);
    }
}
