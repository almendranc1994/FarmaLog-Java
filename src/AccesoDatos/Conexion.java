/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author franc
 */
public class Conexion {
    
    private static final int MAX_RETRY = 10;
    
    private static final String url = "jdbc:mysql://200.16.7.96/inf282g1";
    private static final String username = "inf282g1";
    private static final String password = "BRXRKa3O5JUiqJWn";
    
    private static int retries = 0;
    private static volatile Connection conn = null;
    
    public Conexion() {}
    
    public static Connection getConexion() {

        try {
            if(conn!=null && conn.isClosed()) conn = null;
        } catch (SQLException ex) {
            conn = null;
        }

        if (conn == null) {
            synchronized(Conexion.class) {
                if (conn == null) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        System.out.println("Driver loaded!");
                    } catch (ClassNotFoundException e) {
                        if(retries>=MAX_RETRY)
                            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
                        else {
                            retries ++;
                            return getConexion();
                        }
                    }
                    
                    try {
                        System.out.println("Database connected!");
                        conn = (Connection) DriverManager.getConnection(url, username, password);
                        if (conn.isClosed()) {
                            throw new SQLException("Connection closed");
                        }
                    } catch (SQLException e) {
                        if(retries>=MAX_RETRY)
                            throw new IllegalStateException("Cannot connect the database!", e);
                        else {
                            retries ++;
                            return getConexion();
                        }
                    }
                }
            }
        }
        return conn;
    }
    
}
