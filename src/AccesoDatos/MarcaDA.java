/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Marca;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class MarcaDA {
    public Marca BuscarMarcaporNombre(String nombreABuscar){
        try{    
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Marca WHERE nombre="+nombreABuscar);
            while(rs.next()){
                int idIns= Integer.parseInt(rs.getString("idMarca"));
                String nombre = rs.getString("nombre");
                Conexion.closeConexion();
                return (new Marca(idIns,nombre));
            }
        }
        catch (SQLException e){
            // do something appropriate with the exception, *at least*:
            e.printStackTrace();
        }
        Conexion.closeConexion();
        return new Marca();
    }
    public ArrayList<Marca> devolverLista(){
        
        ArrayList<Marca> listaMarca=new ArrayList<Marca>();
        
        try{    
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Marca");
            while(rs.next()){
                int idIns= Integer.parseInt(rs.getString("idMarca"));
                String nombre = rs.getString("nombre");
                listaMarca.add(new Marca(idIns,nombre));
            }
        }
        catch (SQLException e){
            // do something appropriate with the exception, *at least*:
            e.printStackTrace();
        }
        Conexion.closeConexion();
        return listaMarca;
    }
}
