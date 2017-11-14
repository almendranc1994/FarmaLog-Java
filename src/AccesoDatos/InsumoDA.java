/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Insumo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre Pando <Hykire>
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
    public ArrayList<Insumo> devolverListaInsumo(String nombreInsumo){
        System.out.println("Busquemos... "+nombreInsumo);
                
        ArrayList<Insumo> listaInsumos = new ArrayList<Insumo>();
        try{    
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Insumo WHERE nombre LIKE  '%"+nombreInsumo+"%'");
            while(rs.next()){
                int idInsumo= Integer.parseInt(rs.getString("idInsumo"));
                System.out.println("id: "+idInsumo);
                String nombre= rs.getString("nombre");
                String descripcion= rs.getString("descripcion");
                System.out.println("nombre: "+nombre);
                listaInsumos.add(new Insumo(idInsumo,nombre,descripcion));
            }
            System.out.println("así que sale del while");
            Conexion.closeConexion();
        }
        catch (Exception e){
            // do something appropriate with the exception, *at least*:
            System.out.println(e.getMessage());
        }
        return listaInsumos;
    }
    
    public ArrayList<Insumo> devolverAlertaInsumos(){
        
        ArrayList<Insumo> listaInsumos = new ArrayList<Insumo>();
        try{
            CallableStatement cStmt = Conexion.getConexion().prepareCall("{call BUSCAR_ALERTA_INSUMO}");
            ResultSet rs = cStmt.executeQuery();
            while(rs.next()){
                int idInsumo= Integer.parseInt(rs.getString("idInsumo"));
                String nombre= rs.getString("nombre");
                String descripcion= rs.getString("descripcion");
                double stk= Double.parseDouble(rs.getString("stock"));
                double stkMin= Double.parseDouble(rs.getString("stockMinimo"));
                listaInsumos.add(new Insumo(idInsumo,nombre,descripcion,stk,stkMin));
            }           
            Conexion.closeConexion();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listaInsumos;
    }
    
}
