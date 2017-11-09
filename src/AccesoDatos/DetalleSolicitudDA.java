/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.DetalleSolicitud;
import Modelo.Insumo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author HP
 */

//private int codigoDetalleSolicitud;
//    private int codigoSolicitudSuministro;
//    private Insumo insumo;
//    private double volumen;
//    private int stock;
//    private String motivo;
//    private String estado;
public class DetalleSolicitudDA {
    
    public ArrayList<DetalleSolicitud> obtenerListaSolicitudesSuministro(int codigoSolSuministro){
        ArrayList<DetalleSolicitud> lista = new ArrayList<DetalleSolicitud>();
        try{
            Statement sentencia = Conexion.getConexion().createStatement();
            String query = "SELECT * FROM DetalleSolicitud WHERE idDetalleSolicitudSuministro = " + codigoSolSuministro;
            ResultSet rs = sentencia.executeQuery(query);
            while(rs.next()){
                DetalleSolicitud s = new DetalleSolicitud();                
                s.setCodigoDetalleSolicitud(Integer.parseInt(rs.getString("idDetalleSolicitudSuministro")));
                Insumo i = new Insumo();
                i.setCodigoInsumo(Integer.parseInt(rs.getString("idInsumo")));
                s.setVolumen(Double.parseDouble(rs.getString("volumen")));
                s.setStock(Integer.parseInt(rs.getString("stock")));
                s.setMotivo(rs.getString("motivo"));
                s.setEstado(rs.getString("estado"));
                lista.add(s);
            }
            Conexion.closeConexion();
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }        
        return lista;
    }
    
    public boolean atenderDetalleSolicitud(int codigo){
        try{
            Statement sentencia = Conexion.getConexion().createStatement();
            String query = "UPDATE DetalleSolicitud SET estado = 'Atendido' WHERE idDetalleSolicitudSuministro = " + codigo;
            int i = sentencia.executeUpdate(query);            
            Conexion.closeConexion();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }        
    }    
}
