/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Controlador.ProveedoresBL;
import Controlador.SolicitudCompraBL;
import Modelo.Carrito;
import Modelo.EstadoCarrito;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franco
 */
public class CarritoDA {
    
    private final ProveedoresBL provBL = new ProveedoresBL();
    private final SolicitudCompraBL solcompBL = new SolicitudCompraBL();
    
    private Carrito getCarrito(ResultSet rs, int idCarrito) {
        try {
            Carrito carrito;
            
            int idProveedor = rs.getInt("idProveedor");
            Date fechaCreacion = rs.getDate("fechaCreacion");
            
            carrito = new Carrito(provBL.BuscarProveedor(idProveedor));
            carrito.setFechaCreacion(fechaCreacion);
            
            carrito.setSolicitudes(solcompBL.buscarSolicitudesCarrito(idCarrito));
            
            return carrito;
        } catch (SQLException ex) {
            Logger.getLogger(CarritoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Carrito obtenerCarrito(int idCarrito) {
        String query = "SELECT idProveedor,fechaCreacion FROM Carrito WHERE idCarrito=" + idCarrito;
        
        Carrito carrito = null;
        
        try {
            Statement stmt = Conexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next())
                carrito = getCarrito(rs, idCarrito);
        } catch (SQLException ex) {
            Logger.getLogger(CarritoDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return carrito;
    }
    
    public ArrayList<Carrito> obtenerCarritosPorEstado(EstadoCarrito estado) {
        ArrayList<Carrito> carritos = new ArrayList<>();
        
        String query = "SELECT idCarrito,idProveedor,fechaCreacion FROM Carrito WHERE estado=" + 
                estado.getIdEstado();
        
        try {
            Statement stmt = Conexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                int idCarrito = rs.getInt("idCarrito");
                Carrito carrito = getCarrito(rs, idCarrito);
                if(carrito!=null) carritos.add(carrito);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarritoDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return carritos;
    }
    
}
