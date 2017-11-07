/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import java.util.ArrayList;
import Modelo.Insumo;
import Modelo.ProveedorxInsumo;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class ProveedorxInsumoDA {
    public ArrayList<ProveedorxInsumo> devolverListaInsumo(String nombreInsumo){
        System.out.println("Busquemos... "+nombreInsumo);
                
        ArrayList<ProveedorxInsumo> listaInsumos = new ArrayList<ProveedorxInsumo>();
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g1","inf282g1","BRXRKa3O5JUiqJWn");
            Statement sentencia=con.createStatement();
            
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Insumo");
            int idInsumo=0;
            String nombre="";
            while(rs.next()){
                idInsumo= Integer.parseInt(rs.getString("idInsumo"));
                System.out.println("id: "+idInsumo);
                nombre= rs.getString("nombre");
                System.out.println("nombre: "+nombre);
                System.out.println(nombre+" "+nombreInsumo+" ?");
                
                if(nombre.equals(nombreInsumo)){
                    System.out.println("Sí son iguales :yesss:");
                    break;
                }
            }
            if(!nombre.equals(nombreInsumo)) return null;
            System.out.println("id del insumo: "+idInsumo);
            rs = sentencia.executeQuery("SELECT * FROM ProveedorxInsumo");
            while(rs.next()){
                int idProveedor= Integer.parseInt(rs.getString("idProveedor"));
                int idInsumo2 = Integer.parseInt(rs.getString("idInsumo"));
                int idUnidad = Integer.parseInt(rs.getString("idUnidadMedida"));
                int stock = Integer.parseInt(rs.getString("stock"));
                int idMarca = Integer.parseInt(rs.getString("idMarca"));
                Double precio = Double.parseDouble(rs.getString("precio"));
                if(idInsumo2==idInsumo){
                    ProveedorxInsumo provxIns = new ProveedorxInsumo(idProveedor,idInsumo,idUnidad,stock,idMarca,precio);
                    listaInsumos.add(provxIns);
                }
            }
            
        }
        catch (Exception e){
            // do something appropriate with the exception, *at least*:
            System.out.println(e.getMessage());
        }
        return listaInsumos;
    } 
}
