/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.SolicitudSuministro;
import Modelo.Prioridad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author HP
 */
public class SolicitudSuministroDA {
    public ArrayList<SolicitudSuministro> obtenerListaSolicitudesSuministro(){
        ArrayList<SolicitudSuministro> lista = new ArrayList<SolicitudSuministro>();
        try{
            Statement sentencia = Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM SolicitudSumnistros");
            while(rs.next()){
                SolicitudSuministro s = new SolicitudSuministro();
                s.setCodigoSolicitudSuministro(Integer.parseInt((rs.getString("idSolicitudSuministro"))));
                try{
                  DateFormat formatterFeticion = new SimpleDateFormat("MM/dd/yyyy");
                  Date datePeticion = (Date)formatterFeticion.parse(rs.getString("fechaPeticion"));
                  s.setFechaPeticion(datePeticion);
                }catch (Exception e){}
                try{
                  DateFormat formatterLimite = new SimpleDateFormat("MM/dd/yyyy");
                  Date dateLimite = (Date)formatterLimite.parse(rs.getString("fechaPeticion"));
                  s.setFechaLimite(dateLimite);
                }catch (Exception e){}
                s.setInstitucion(rs.getString("institucion"));
                Prioridad p = new Prioridad();
                    
                lista.add(s);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
        return lista;
    }
    public static void main(String[] args) {
        SolicitudSuministroDA gestor = new SolicitudSuministroDA();
        ArrayList<SolicitudSuministro> lista = gestor.obtenerListaSolicitudesSuministro();
    }
}
