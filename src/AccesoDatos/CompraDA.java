package AccesoDatos;

import Controlador.ProveedoresBL;
import Modelo.Compra;
import Modelo.EstadoCompra;
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
    
    public static ArrayList<Compra> obtenerComprasEnEstados(ArrayList<Integer> estados) {
        ArrayList<Compra> seleccion = new ArrayList<>();
        ProveedoresBL provBL = new ProveedoresBL();
        
        String query = "SELECT (idCompras,idProveedor,fechaCotizacion,fechaCompra,subtotal,impuestos,total,estado) FROM Compra WHERE estado IN (";
        for(int i=0;i<estados.size();i++) {
            if(i>0) query += ",";
            query += estados.get(i);
        }
        query += ")";
        
        try {
            Statement stmt = Conexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                int id = rs.getInt("idCompras");
                int idProveedor = rs.getInt("idProveedor");
                
                Compra compra = new Compra(provBL.BuscarProveedor(idProveedor));
                compra.setId(id);
                
                Date fechaCotizacion = rs.getDate("fechaCotizacion");
                if(!rs.wasNull()) compra.setFechaCotizacion(fechaCotizacion);
                
                Date fechaCompra = rs.getDate("fechaCompra");
                if(!rs.wasNull()) compra.setFechaCompra(fechaCompra);
                
                double subtotal = rs.getDouble("subtotal");
                if(!rs.wasNull()) compra.setSubtotal(subtotal);
                
                double impuestos = rs.getDouble("impuestos");
                if(!rs.wasNull()) compra.setImpuestos(impuestos);
                
                double total = rs.getDouble("total");
                if(!rs.wasNull()) compra.setTotal(total);
                
                int estado = rs.getInt("estado");
                if(!rs.wasNull()) compra.setEstado(estado);
            }
        } catch (SQLException ex) {
            // Error
            return null;
        }
        
        return seleccion;
    }
    
    public static ArrayList<Compra> obtenerComprasPendientes() {
        ArrayList<Integer> estados = new ArrayList<>();
        
        for(EstadoCompra estado : EstadoCompra.values()) {
            if(!estado.isOver())
                estados.add(estado.getIdEstado());
        }
        
        return obtenerComprasEnEstados(estados);
    }
    
    public static ArrayList<Compra> obtenerComprasCompletadas() {
        ArrayList<Integer> estados = new ArrayList<>();
        estados.add(EstadoCompra.PEDIDO_RECIBIDO.getIdEstado());
        return obtenerComprasEnEstados(estados);
    }
    
    public static ArrayList<Compra> obtenerComprasCanceladas() {
        ArrayList<Integer> estados = new ArrayList<>();
        estados.add(EstadoCompra.CANCELADA.getIdEstado());
        return obtenerComprasEnEstados(estados);
    }
    
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
