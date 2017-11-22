/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import AccesoDatos.InsumoDA;
import Modelo.ProveedorxInsumo;
import AccesoDatos.ProveedorxInsumoDA;
import Modelo.Insumo;
import java.util.ArrayList;
/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class ProveedorxInsumoBL {
    private ProveedorxInsumoDA accesoDatos;
    
    public ProveedorxInsumoBL(){
        accesoDatos = new ProveedorxInsumoDA();
    }
    
    public ArrayList<ProveedorxInsumo> devolverListaInsumo(String nombre){
        return accesoDatos.devolverListaInsumo(nombre);
    }
    
    public boolean registrarProveedorxInsumo (ProveedorxInsumo PxI){
        System.out.println(PxI.getInsumo().getNombreInsumo());
        return accesoDatos.registrarProveedorxInsumo(PxI);
    }    
    public ArrayList<ProveedorxInsumo> devolverListaInsumodeProv(int codigoProv){
        return accesoDatos.devolverListaInsumodeProv(codigoProv);
    }

    public void eliminarRastroDelProveedor(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
