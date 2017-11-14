
package Modelo;
//prueba
public class Insumo {

    private int codigoInsumo;
    private String nombreInsumo;
    private String descripcionInsumo;
    private double stock;
    private double stockMinimo;
    public Insumo(){
        
    }
    public Insumo(int idInsumo,String nombre,String descripcion){
        codigoInsumo=idInsumo;
        nombreInsumo=nombre;
        descripcionInsumo=descripcion;
        stock=0;
        stockMinimo=0;
    }

    public Insumo(int idInsumo,String nombre,String descripcion,double stk,double stkMin){
        codigoInsumo=idInsumo;
        nombreInsumo=nombre;
        descripcionInsumo=descripcion;
        stock=stk;
        stockMinimo=stkMin;
    }
    
    public double getStock(){
        return stock;
    }
    
    public double getStockMinimo(){
        return stockMinimo;
    }
    
    public void setStock(double stock){
        this.stock = stock;
    }
    
    public void setStockMinimo(double stockMinimo){
        this.stockMinimo = stockMinimo;
    }
    
    public int getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(int codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }
    /**
     * @return the descripcionInsumo
     */
    public String getDescripcionInsumo() {
        return descripcionInsumo;
    }

    /**
     * @param descripcionInsumo the descripcionInsumo to set
     */
    public void setDescripcionInsumo(String descripcionInsumo) {
        this.descripcionInsumo = descripcionInsumo;
    }
}
