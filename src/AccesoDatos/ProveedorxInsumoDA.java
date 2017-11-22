/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.util.ArrayList;
import Modelo.Insumo;
import Modelo.ProveedorxInsumo;
import Controlador.MarcaBL;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class ProveedorxInsumoDA {

    public ArrayList<ProveedorxInsumo> devolverListaInsumo(String nombreInsumo) {

        ArrayList<ProveedorxInsumo> listaInsumos = new ArrayList<ProveedorxInsumo>();
        try {
            Statement sentencia = Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Insumo WHERE nombre = '" + nombreInsumo + "';");

            Statement sentencia2 = Conexion.getConexion().createStatement();
            ResultSet rs2 = sentencia2.executeQuery("SELECT * FROM ProveedorxInsumo WHERE IdInsumo = " + rs.getInt(0)+";");

            while (rs2.next()) {
                ProveedorxInsumo provxIns;
                MarcaBL logicaM = new MarcaBL();
                provxIns = new ProveedorxInsumo(rs2.getInt(1), rs2.getInt(2), rs.getString(2), 
                        rs.getInt(5), (logicaM.BuscarMarcaporCodigo(rs2.getInt(4))).getNombre(), rs2.getInt(3));
                listaInsumos.add(provxIns);
            }
            Conexion.closeConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaInsumos;
    }
    public ArrayList<ProveedorxInsumo> devolverListaInsumodeProv(int codigoProv) {
        System.out.println("En da: "+codigoProv);
        ArrayList<ProveedorxInsumo> listaInsumos = new ArrayList<ProveedorxInsumo>();
        try {
            Statement sentencia = Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM ProveedorxInsumo WHERE IdProveedor = " + codigoProv);
            System.out.println("SELECT * FROM ProveedorxInsumo WHERE IdProveedor = " + codigoProv);
            while (rs.next()) {
                System.out.println("entró a rs.next");
                ProveedorxInsumo provxIns;
                MarcaBL logicaM = new MarcaBL();
                int idIns= Integer.parseInt(rs.getString("idInsumo"));
                int idUnidadMedida = Integer.parseInt(rs.getString("idUnidadMedida"));
                int stock=Integer.parseInt(rs.getString("stock"));
                int idMarca=Integer.parseInt(rs.getString("idMarca"));
                double precio=Double.parseDouble(rs.getString("precioUnitario"));
                System.out.println("idIns: "+idIns+"; idUniMed:  "+idUnidadMedida+", Stock: "+stock+" ,idMarca: "+idMarca+"; precio:"+precio);
                provxIns = new ProveedorxInsumo(codigoProv, idIns, idUnidadMedida, stock, (logicaM.BuscarMarcaporCodigo(idMarca)).getNombre(), precio);
                System.out.println("holiii");
                System.out.println("idProv: "+provxIns.getProveedor().getCodigo()+"idIns: "+provxIns.getInsumo().getCodigoInsumo()+"; idUniMed:  "+provxIns.getUniMed().getId()+", Stock: "+provxIns.getStock()+" ,idMarca: "+provxIns.getMarca().getIdMarca()+"; precio:"+provxIns.getPrecio());
                System.out.println("logró crear provxIns");
                listaInsumos.add(provxIns);
                System.out.println("lo agregó a la lista. Tamaño: "+listaInsumos.size());
            }
            Conexion.closeConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaInsumos;
    }
    public boolean registrarProveedorxInsumo(ProveedorxInsumo PxI) {
        try {
            System.out.println("PxI.getInsumo().getNombreInsumo() "+PxI.getInsumo().getNombreInsumo());
            System.out.println("siiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
            Statement sentencia = Conexion.getConexion().createStatement();
            System.out.println("noooooooooooooooooooooooooooooooooooooooooooooooo");
            String query = "INSERT INTO ProveedorxInsumo VALUES(";
            System.out.println("PxI.getInsumo().getCodigoInsumo() "+PxI.getInsumo().getCodigoInsumo());
            System.out.println("PxI.getPrecio() "+PxI.getPrecio());
            System.out.println("PxI.getMarca().getIdMarca() "+PxI.getMarca().getIdMarca());
            System.out.println("PxI.getProveedor().getCodigo() "+PxI.getProveedor().getCodigo());           
            System.out.println("PxI.getUniMed().getId() "+PxI.getUniMed().getId());           
            System.out.println("PxI.getStock() "+PxI.getStock());           
            
            
            
            query += PxI.getProveedor().getCodigo();
            query += "," + PxI.getInsumo().getCodigoInsumo();
            query += "," + PxI.getPrecio();
            query += "," + PxI.getMarca().getIdMarca();
            query += "," + PxI.getUniMed().getId();
            query += "," +  PxI.getStock()+ ");";
            
            System.out.println(query);
            sentencia.executeUpdate(query);
            Conexion.closeConexion();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No lo agrego");
            Conexion.closeConexion();
            return false;
        }
    }
}
