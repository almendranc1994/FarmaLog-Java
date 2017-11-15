/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Controlador.InsumoBL;
import Controlador.SolicitudSuministroBL;
import Controlador.CarritoBL;

import Modelo.SolicitudCompra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

/**
 *
 * @author franc
 */
public class SolicitudCompraDA {
    
    public SolicitudCompra obtenerSolicitudCompra(int idSolicitudCompra) {
        String query = "SELECT idSolicitudSuministro,idInsumo,idCarrito,cantidad,fechaSolicitud,fechaAtencion "
                + "FROM SolicitudCompra WHERE idSolicitudCompra=" + idSolicitudCompra;
        
        SolicitudSuministroBL solsumBL = new SolicitudSuministroBL();
        InsumoBL insumoBL = new InsumoBL();
        CarritoBL carritoBL = new CarritoBL(); 
        
        try {
            Statement stmt = Conexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next()) {
                SolicitudCompra solicitud = new SolicitudCompra();
                
                solicitud.setSolSuministro(solsumBL.obtenerSolicitudSuministro(rs.getInt("idSolicitudSuministro")));
                solicitud.setInsumo(insumoBL.BuscarInsumo(rs.getInt("idInsumo")));
                
                int idCarrito = rs.getInt("idCarrito");
                if(!rs.wasNull()) solicitud.setCarrito(carritoBL.buscarCarrito(idCarrito));
                
                double cantidad = rs.getDouble("cantidad");
                if(!rs.wasNull()) solicitud.setCantidad(cantidad);
                
                Date fechaSolicitud = rs.getDate("fechaSolicitud");
                if(!rs.wasNull()) solicitud.setFechaSolicitud(fechaSolicitud);
                
                Date fechaAtencion = rs.getDate("fechaAtencion");
                if(!rs.wasNull()) solicitud.setFechaAtencion(fechaAtencion);
                
                return solicitud;
            }            
        } catch (SQLException ex) {
            return null;
        }
        
        return null;
    }
    
}
