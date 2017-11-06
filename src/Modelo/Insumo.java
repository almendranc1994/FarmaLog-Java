
package Modelo;
//prueba
public class Insumo {

    private int codigoInsumo;
    private String nombreInsumo;
    private String descripcionInsumo;
    public Insumo(){
        
    }
    public Insumo(int idInsumo,String nombre,String descripcion){
        codigoInsumo=idInsumo;
        nombreInsumo=nombre;
        descripcionInsumo=descripcion;
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
