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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class SolicitudCompraDA {
    
    private final SolicitudSuministroBL solsumBL = new SolicitudSuministroBL();
    private final InsumoBL insumoBL = new InsumoBL();
    private final CarritoBL carritoBL = new CarritoBL(); 
    
    private SolicitudCompra getSolicitudCompra(ResultSet rs, int idSolicitudCompra) {
        try {
            SolicitudCompra solicitud = new SolicitudCompra();
            solicitud.setId(idSolicitudCompra);
            
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
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudCompraDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public SolicitudCompra obtenerSolicitudCompra(int idSolicitudCompra) {
        String query = "SELECT idSolicitudSuministro,idInsumo,idCarrito,cantidad,fechaSolicitud,fechaAtencion "
                + "FROM SolicitudCompra WHERE idSolicitudCompra=" + idSolicitudCompra;
        
        try {
            Statement stmt = Conexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next())
                return getSolicitudCompra(rs, idSolicitudCompra);
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudCompraDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }
    
    public ArrayList<SolicitudCompra> obtenerSolicitudesCompraNoAsignadas() {
        ArrayList<SolicitudCompra> solicitudes = new ArrayList<>();
        String query = "SELECT idSolicitudCompra,idSolicitudSumnistro,idInsumo,idCarrito,cantidad,fechaSolicitud,fechaAtencion "
                + "FROM SolicitudCompra WHERE idCarrito IS NULL";
        
        try {
            Statement stmt = Conexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                int idSolicitudCompra = rs.getInt("idSolicitudCompra");
                SolicitudCompra solicitud = getSolicitudCompra(rs, idSolicitudCompra);
                if(solicitud!=null) solicitudes.add(solicitud);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            Logger.getLogger(SolicitudCompraDA.class.getName()).log(Level.SEVERE, null, ex);
            return solicitudes;
        }
        
        //System.out.println(solicitudes);
        return solicitudes;
    }
    
    public ArrayList<SolicitudCompra> obtenerSolicitudesCarrito(int idCarrito) {
        ArrayList<SolicitudCompra> solicitudes = new ArrayList<>();
        
        String query = "SELECT idSolicitudCompra,idSolicitudSuministro,idInsumo,idCarrito,cantidad,fechaSolicitud,fechaAtencion "
                + "FROM SolicitudCompra WHERE idCarrito=" + idCarrito;
        
        try {
            Statement stmt = Conexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                int idSolicitudCompra = rs.getInt("idSolicitudCompra");
                SolicitudCompra solicitud = getSolicitudCompra(rs, idSolicitudCompra);
                
                if(solicitud!=null) solicitudes.add(solicitud);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudCompraDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return solicitudes;
    }
    
    public ArrayList<Integer> obtenerIdsSolicitudesCarrito(int idCarrito) {
        ArrayList<Integer> solicitudes = new ArrayList<>();
        
        String query = "SELECT idSolicitudCompra FROM SolicitudCompra WHERE idCarrito=" + idCarrito;
        
        try {
            Statement stmt = Conexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                int idSolicitudCompra = rs.getInt("idSolicitudCompra");
                if(!rs.wasNull()) solicitudes.add(idSolicitudCompra);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudCompraDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return solicitudes;
    }
    
}
