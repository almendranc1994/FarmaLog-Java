/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.UnidadMedida;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class UnidadMedidaDA {
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
    }
}
