/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Controlador.SolicitudCompraBL;
import Modelo.Compra;
import Modelo.DetalleCompra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class DetalleCompraDA {
    
    public void obtenerDetallesCompra(Compra compra) {
        ArrayList<DetalleCompra> detalles = new ArrayList<>();
        
        String query = "SELECT idSolicitudCompra,precioUnitario FROM DetalleCompra WHERE idCompra=" + compra.getId();
        
        SolicitudCompraBL solcompBL = new SolicitudCompraBL();
        
        Statement stmt;
        try {
            stmt = Conexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                int idSolicitudCompra = rs.getInt("idSolicitudCompra");
                double precioUnitario = rs.getDouble("precioUnitario");
                
                DetalleCompra detalle = new DetalleCompra(compra, solcompBL.buscarSolicitudCompra(idSolicitudCompra));
                detalle.setPrecioUnitario(precioUnitario);
                
                detalles.add(detalle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleCompraDA.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        compra.setDetalles(detalles);
    }
    
}
