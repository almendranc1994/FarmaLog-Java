
package AccesoDatos;
import Modelo.Proveedor;
import java.sql.*;

public class ProveedoresDA {
    public Proveedor BuscarProveedor(int idProveedor){
        
       int idProv = -1;
       String nombreEmpresa = null;
       String nombres = null;
       String apellidos = null;
       String direccion = null;
       String correo = null;
       String telefono = null;
       Boolean esNacional = false;
       
       try{    
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Proveedor WHERE idProveedor="+idProveedor);
            while(rs.next()){
                idProv= Integer.parseInt(rs.getString("idProveedor"));
                nombreEmpresa = rs.getString("nombreEmpresa");
                nombres = rs.getString("nombres");
                apellidos = rs.getString("apellidos");
                direccion=rs.getString("descripcion");
                correo=rs.getString("correo");
                telefono=rs.getString("telefono");
                esNacional=rs.getBoolean("esNacional");
                
                if(idProv==idProveedor) break;
            }
            
        } catch (SQLException e){
            e.printStackTrace();
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
