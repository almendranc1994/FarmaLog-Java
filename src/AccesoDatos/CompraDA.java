package AccesoDatos;

import Modelo.Compra;
import Modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;
/**
 *
 * @author Milton
 */
public class CompraDA {
    public ArrayList<Proveedor> obtenerListaProveedores(Date fechaI,Date fechaF){
        ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
        ProveedoresDA datosProveedor = new ProveedoresDA();
        
        try{    
            Statement sentencia=Conexion.getConexion().createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Compra WHERE fechaCompra>"+fechaI+" AND fechaCompra<"+fechaF);
            while(rs.next()){
                int idProveedor = Integer.parseInt(rs.getString("idProvedor"));
                Proveedor p = datosProveedor.BuscarProveedor(idProveedor);
                lista.add(p);
            }
            Conexion.closeConexion();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
