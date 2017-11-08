
package AccesoDatos;
import Modelo.Proveedor;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
public class ProveedoresDA {
    public Proveedor BuscarProveedor(int idProveedor){
       System.out.println("Entrado a buscarpROVEEDOR");
       int idProv = -1;
       String nombreEmpresa = null;
       String nombres = null;
       String apellidos = null;
       String direccion = null;
       String correo = null;
       String telefono = null;
       Boolean esNacional = false;
       
       try{    
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g1","inf282g1","BRXRKa3O5JUiqJWn");
            Statement sentencia=con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Proveedor WHERE idProveedor="+idProveedor);
            while(rs.next()){
                System.out.println("guuuuu");
                idProv= Integer.parseInt(rs.getString("idProveedor"));
                nombreEmpresa = rs.getString("nombreEmpresa");
                nombres = rs.getString("nombres");
                apellidos = rs.getString("apellidos");
                correo=rs.getString("correo");
                telefono=rs.getString("telefono");
                
                if(idProv==idProveedor) break;
            }
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            // Retornar null si no se pudo acceder a la db
            return null;
        }
        
        if(idProv == idProveedor) {
            
            Proveedor proveedor = new Proveedor(idProv,nombreEmpresa,esNacional);
            proveedor.setNombres(nombres);
            proveedor.setApellidos(apellidos);
            proveedor.setDireccion(direccion);
            proveedor.setCorreo(correo);
            proveedor.setTelefono(telefono);
            
            return proveedor;
        }
        return null;
    }
}
