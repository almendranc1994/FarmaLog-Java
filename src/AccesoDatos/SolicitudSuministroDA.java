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
                s.setCodigoSolicitudSuministro(Integer.parseInt(rs.getString("idSolicitudSumnistro")));                
                try{
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString1 = rs.getString("fechaPeticion");
                    Date date1 = sdf1.parse(dateString1);
                    s.setFechaPeticion(date1);
                }catch (Exception e){}
                try{
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString2 = rs.getString("fechaLimite");
                    Date date2 = sdf2.parse(dateString2);
                    s.setFechaLimite(date2);
                }catch (Exception e){}
                s.setInstitucion(rs.getString("institucion"));                
                s.setPrioridad(Integer.parseInt(rs.getString("prioridad")));
                lista.add(s);
            }
            Conexion.closeConexion();
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
        return lista;
    }
    
    public void eliminarSolicitudSuministro(int id){
        try{
            Statement sentencia = Conexion.getConexion().createStatement();
            String query = "DELETE FROM SolicitudSumnistros WHERE idSolicitudSumnistro = " + id;
            int i = sentencia.executeUpdate(query);
            Conexion.closeConexion();
        }catch(Exception ex){
            System.out.println();
        }
    }
    
//    public static void main(String[] args) {
//        SolicitudSuministroDA gestor = new SolicitudSuministroDA();
//        ArrayList<SolicitudSuministro> lista = gestor.obtenerListaSolicitudesSuministro();
//    }
}
