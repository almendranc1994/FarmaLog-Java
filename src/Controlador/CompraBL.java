package Controlador;
import Modelo.Proveedor;
import AccesoDatos.ComprasDA;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author Milton
 */
public class ComprasBL {
    private ComprasDA accesoDatos;
    
    public ComprasBL(){
        accesoDatos = new ComprasDA();
    }
    
    public ArrayList<Proveedor> obtenerListaProveedores(Date fechaI,Date fechaF){
        return accesoDatos.obtenerListaProveedores(fechaI,fechaF);
    }
    
}
