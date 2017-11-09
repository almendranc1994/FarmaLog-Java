
package AccesoDatos;
import Modelo.Proveedor;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ProveedoresDA {
    public boolean registrarProveedor(Proveedor p){
        try{
            //IN ruc int, IN nombEmp varchar(300), IN nomb varchar(200), IN ape varchar(45), IN direc varchar(45), IN coreo varchar(45),IN telef varchar(45))
            CallableStatement cStmt = Conexion.getConexion().prepareCall("{call AÑADIR_PROVEEDOR(?,?,?,?,?,?,?)}");
            cStmt.setInt(1, p.getRuc());
            cStmt.setString(2, p.getNombreEmpresa());
            cStmt.setString(3, p.getNombres());
            cStmt.setString(4, p.getApellidos());
            cStmt.setString(5, p.getDireccion());
            cStmt.setString(6, p.getCorreo());
            cStmt.setString(7, p.getTelefono());
            cStmt.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
    
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
