package Modelo;

public class UnidadMedida {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the abrev
     */
    public String getAbrev() {
        return abrev;
    }

    /**
     * @param abrev the abrev to set
     */
    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }
    private int id;
    private String unidad;
    private String abrev;
    public UnidadMedida(){
        
    }
    public UnidadMedida(int id,String unidad,String abrev){
        this.id=id;
        this.unidad=unidad;
        this.abrev=abrev;
    }
}
