/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Carrito;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franco
 */
public class CarritoDA {
    
    public Carrito obtenerCarrito(int idCarrito) {
        String query = "SELECT idProveedor,fechaCreacion FROM Carrito WHERE idCarrito=" + idCarrito;
        
        Carrito carrito;
        
        try {
            Statement stmt = Conexion.getConexion().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CarritoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
