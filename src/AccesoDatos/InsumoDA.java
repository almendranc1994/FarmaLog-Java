/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import java.util.ArrayList;
import Modelo.Insumo;
import java.sql.*;
//import com.mysql.jdbc.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class InsumoDA {
    public Insumo BuscarInsumo(int idInsumo){
       Insumo insumo;
       int idIns=0;
       String nombre="";
       String descripcion="";
       
        try{    
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Insumo");
            idIns=0;
            while(rs.next()){
                idIns= Integer.parseInt(rs.getString("idInsumo"));
                nombre = rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                if(idInsumo == idIns) break;
            }
        }
        catch (SQLException e){
            // do something appropriate with the exception, *at least*:
            e.printStackTrace();
        }
        if(idInsumo==idIns)
            insumo=new Insumo(idInsumo,nombre,descripcion);
        else
            insumo=new Insumo();
        return insumo;
    }
    public boolean registrarInsumo (Insumo newInsumo){
        try{
            
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://200.16.7.96/inf282g1";
//            Connection con = DriverManager.getConnection(url,"inf282g1","BRXRKa3O5JUiqJWn");
//            System.out.println(newInsumo.getCodigoInsumo());
//            System.out.println(newInsumo.getNombreInsumo());
//            CallableStatement cStmt = con.prepareCall("{call AÑADIR_NUEVO_INSUMO(?,?,?)}");
            CallableStatement cStmt = Conexion.getConexion().prepareCall("{call AÑADIR_NUEVO_INSUMO(?,?,?)}");
            cStmt.setInt(1, newInsumo.getCodigoInsumo());
            cStmt.setString(2, newInsumo.getNombreInsumo());
            cStmt.setString(3, newInsumo.getDescripcionInsumo());
            cStmt.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
}
