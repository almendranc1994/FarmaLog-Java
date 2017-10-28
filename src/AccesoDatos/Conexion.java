/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author franc
 */
public class Conexion {
    
    private static final int MAX_RETRY = 10;
    
    private static final String url = "jdbc:mysql://localhost:3306/javabase";
    private static final String username = "java";
    private static final String password = "password";
    
    private static int retries = 0;
    private static volatile Connection conn = null;
    
    private Conexion() {}
    
    public static Connection getConexion() {
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
                    
                    try (Connection c = (Connection) DriverManager.getConnection(url, username, password)) {
                        System.out.println("Database connected!");
                        conn = c;
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
