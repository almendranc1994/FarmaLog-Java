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

    public boolean registrarProveedorxInsumo(ProveedorxInsumo PxI) {
        try {
            Statement sentencia = Conexion.getConexion().createStatement();
            String query = "INSERT INTO ProveedorxInsumo VALUES(";
            query += PxI.getProveedor().getCodigo();
            query += "," + PxI.getInsumo().getCodigoInsumo();
            query += "," + PxI.getPrecio();
            query += "," + PxI.getMarca().getIdMarca() + ");";
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
