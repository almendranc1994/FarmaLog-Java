/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import java.util.ArrayList;
import Modelo.Insumo;
import Modelo.ProveedorxInsumo;
import java.sql.*;
import java.lang.*;


import com.mysql.jdbc.Connection;
/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class ProveedorxInsumoDA {
    public ArrayList<ProveedorxInsumo> devolverListaInsumo(String nombreInsumo){
        ArrayList<ProveedorxInsumo> listaInsumos = new ArrayList<ProveedorxInsumo>();
        try{    
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Insumo");
            int idInsumo=0;
            while(rs.next()){
                idInsumo= Integer.parseInt(rs.getString("idInsumo"));
                String nombre = rs.getString("nombre");
                if(nombre == nombreInsumo) break;
            }
            rs = sentencia.executeQuery("SELECT * FROM ProveedorxInsumo");
            while(rs.next()){
                int idProveedor= Integer.parseInt(rs.getString("Proveedor_idProveedor"));
                int idInsumo2 = Integer.parseInt(rs.getString("Insumo_idInsumo"));
                int idUnidad = Integer.parseInt(rs.getString("Unidad de Medida_idUnidad de Medida"));
                int stock = Integer.parseInt(rs.getString("stock"));
                int idMarca = Integer.parseInt(rs.getString("Marca_idMarca"));
                Double precio = Double.parseDouble(rs.getString("precio"));
                if(idInsumo2==idInsumo){
                    ProveedorxInsumo provxIns = new ProveedorxInsumo(idProveedor,idInsumo,idUnidad,stock,idMarca,precio);
                    listaInsumos.add(provxIns);
                }
            }
            
        }
        catch (SQLException e){
            // do something appropriate with the exception, *at least*:
            e.printStackTrace();
        }
        return listaInsumos;
        
    } 
}
