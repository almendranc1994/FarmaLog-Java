/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Marca;
import Modelo.UnidadMedida;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class UnidadMedidaDA {
    public UnidadMedidaDA(){
        
    }
    public UnidadMedida BuscarUnidadMedidaporNombre(String nombreABuscar){
        try{    
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM UnidadMedida WHERE nombre="+nombreABuscar);
            while(rs.next()){
                int idIns= Integer.parseInt(rs.getString("idUnidadMedida"));
                String nombre = rs.getString("nombre");
                String abrev = rs.getString("abrev");
                Conexion.closeConexion();
                return (new UnidadMedida(idIns,nombre,abrev));
            }
        }
        catch (SQLException e){
            // do something appropriate with the exception, *at least*:
            e.printStackTrace();
        }
        Conexion.closeConexion();
        return new UnidadMedida();

    public ArrayList<UnidadMedida> getMedidas(){
        ArrayList<UnidadMedida> listaMedidas = new ArrayList<UnidadMedida>();
        
        try{
            Statement sentencia = Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM UnidadMedida");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
                listaMedidas.add(new UnidadMedida(Integer.parseInt(rs.getString("idUnidadMedida")), rs.getString("nombre"), rs.getString("abrev")));
                
            }
            Conexion.closeConexion();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return listaMedidas;
    }
    
    public ArrayList<UnidadMedida> devolverLista(){
        ArrayList<UnidadMedida> listaUniMed=new ArrayList<UnidadMedida>();   
        try{    
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM UnidadMedida");
            while(rs.next()){
                int id= Integer.parseInt(rs.getString("idUnidadMedida"));
                String nombre = rs.getString("nombre");
                String abrev = rs.getString("abrev");
                listaUniMed.add(new UnidadMedida(id,nombre,abrev));
            }
        }
        catch (SQLException e){
            // do something appropriate with the exception, *at least*:
            e.printStackTrace();
        }
        Conexion.closeConexion();
        return listaUniMed;

    }
}
