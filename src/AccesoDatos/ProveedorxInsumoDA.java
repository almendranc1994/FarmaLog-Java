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
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Insumo");
            int idInsumo=0;
            String nombre="";
            while(rs.next()){
                idInsumo= Integer.parseInt(rs.getString("idInsumo"));
                System.out.println("id: "+idInsumo);
                nombre= rs.getString("nombre");
                System.out.println("nombre: "+nombre);
                System.out.println(nombre+"=="+nombreInsumo+" ?");
                
                if(nombre.equals(nombreInsumo)){
                    System.out.println("Sí son iguales :yesss:");
                    break;
                }
            }
            System.out.println("así que sale del while");
            
            if(!nombre.equals(nombreInsumo)){
                System.out.println("devuelve null");
                return null;
            }
            else{
                System.out.println("continuemos c:<");
            }
            System.out.println("id del insumo: "+idInsumo);
            System.out.println("holi0");
            Statement sentencia2=Conexion.getConexion().createStatement();
            ResultSet rs2 = sentencia2.executeQuery("SELECT * FROM ProveedorxInsumo");
            System.out.println("holi0");
                
            while(rs2.next()){
                System.out.println("holi");
                int idProveedor= Integer.parseInt(rs2.getString("idProveedor"));
                int idInsumo2 = Integer.parseInt(rs2.getString("idInsumo"));
                int idUnidad = Integer.parseInt(rs2.getString("idUnidadMedida"));
                int stock = Integer.parseInt(rs2.getString("stock"));
                int idMarca = Integer.parseInt(rs2.getString("idMarca"));
                Double precio = Double.parseDouble(rs2.getString("precio"));
                System.out.println("id del insumo del la tabla INSUMOXPROVEEDOR: "+idProveedor+" "+idInsumo2+" "+idUnidad+" "+stock+" "+idMarca+" "+precio);
                System.out.println(idInsumo+"=="+idInsumo2+" ?");
                if(idInsumo2==idInsumo){
                    System.out.println("Sí son iguales :yesss: x2");
                    ProveedorxInsumo provxIns = new ProveedorxInsumo(idProveedor,idInsumo,idUnidad,stock,idMarca,precio);
                    System.out.println("creamos un provxIns");
                    listaInsumos.add(provxIns);
                    System.out.println("agregado a la lista");
                }
            }
            Conexion.closeConexion();
        }
        catch (Exception e){
            // do something appropriate with the exception, *at least*:
            System.out.println(e.getMessage());
        }
        return listaInsumos;
    } 
}
