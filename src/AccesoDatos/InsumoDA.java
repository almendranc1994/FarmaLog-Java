/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import java.util.ArrayList;
import Modelo.Insumo;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
/**
 *
 * @author HP
 */
public class InsumoDA {
    public Insumo BuscarInsumo(int idInsumo){
       Insumo insumo;
       int idIns=0;
       String nombre="";
       String descripcion="";
       
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g1","inf282g1","BRXRKa3O5JUiqJWn");
            Statement sentencia=con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Insumo");
            idIns=0;
            while(rs.next()){
                idIns= Integer.parseInt(rs.getString("idInsumo"));
                nombre = rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                if(idInsumo == idIns) break;
            }
        }
        catch (Exception e){
            // do something appropriate with the exception, *at least*:
            e.printStackTrace();
        }
        if(idInsumo==idIns)
            insumo=new Insumo(idInsumo,nombre,descripcion);
        else
            insumo=new Insumo();
        return insumo;
    }
}
