/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Controlador.ProveedoresBL;
import Controlador.SolicitudCompraBL;
import Modelo.Carrito;
import java.sql.Date;
import java.sql.ResultSet;
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
        
        ProveedoresBL provBL = new ProveedoresBL();
        SolicitudCompraBL solcompBL = new SolicitudCompraBL();
        Carrito carrito = null;
        
        try {
            Statement stmt = Conexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next()) {
                int idProveedor = rs.getInt("idProveedor");
                Date fechaCreacion = rs.getDate("fechaCreacion");
                
                carrito = new Carrito(provBL.BuscarProveedor(idProveedor));
                carrito.setFechaCreacion(fechaCreacion);
                
                carrito.setSolicitudes(solcompBL.buscarSolicitudesCarrito(idCarrito));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarritoDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return carrito;
    }
    
}
