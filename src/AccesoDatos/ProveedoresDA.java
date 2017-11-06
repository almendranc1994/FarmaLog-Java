
package AccesoDatos;
import java.util.ArrayList;
import Modelo.Proveedor;
import java.sql.*;

import com.mysql.jdbc.Connection;
public class ProveedoresDA {
    public Proveedor BuscarProveedor(int idProveedor){
       Proveedor proveedor;
       int idProv=0;
       String nombre="";
       String direccion="";
       String correo="";
       String telefono="";
       Boolean esNacional=false;
       
        try{    
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Proveedor");
            while(rs.next()){
                idProv= Integer.parseInt(rs.getString("idInsumo"));
                nombre = rs.getString("nombre");
                direccion=rs.getString("descripcion");
                correo=rs.getString("correo");
                telefono=rs.getString("telefono");
                esNacional=(rs.getString("esNacional")=="true")? true:false;
                
                if(idProveedor == idProv) break;
            }
        }
        catch (SQLException e){
            // do something appropriate with the exception, *at least*:
            e.printStackTrace();
        }
        if(idProveedor == idProv)
            proveedor=new Proveedor(idProv,nombre,direccion,correo,telefono,esNacional);
        else
            proveedor=new Proveedor();
        return proveedor;
    }
}
