/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import java.util.ArrayList;
import Modelo.Insumo;
import java.sql.*;
/**
 *
 * @author HP
 */
public class InsumoDA {
    private String ruta="test/clientes.txt";
    
    public ArrayList<Insumo> devolverLista(){
        ArrayList<Insumo> insumos = new ArrayList<Insumo>();
        try {//registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            //establecer la conexión
            Connection con = DriverManager.getConnection("jdbc:mysql://50.62.209.188/20141056", "kpedraza", "Mjw1h88");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return insumos;
    }
    
}
