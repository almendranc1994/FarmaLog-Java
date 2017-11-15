package Controlador;
import Modelo.Proveedor;
import AccesoDatos.CompraDA;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author Milton
 */
public class CompraBL {
    private CompraDA accesoDatos;
    
    public CompraBL(){
        accesoDatos = new CompraDA();
    }
    
    public ArrayList<Proveedor> obtenerListaCompras(Date fechaI,Date fechaF){
        return accesoDatos.obtenerListaCompras(fechaI,fechaF);
    }
    
}
