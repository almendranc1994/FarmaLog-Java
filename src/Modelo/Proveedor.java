package Modelo;

public class Proveedor {
    
    private int codigo;
    private String nombre;
    private String direccion;
    private String Correo;
    private String telefono;
    private Boolean esNacional;
    
    public Proveedor(){
        
    }
    public Proveedor(int idProv,String nombre,String direccion,String correo, String telefono,Boolean esNac){
        codigo=idProv;
        this.nombre=nombre;
        this.direccion=direccion;
        Correo=correo;
        this.telefono=telefono;
        esNacional=esNac;
    }    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEsNacional() {
        return esNacional;
    }

    public void setEsNacional(Boolean esNacional) {
        this.esNacional = esNacional;
    }
    
}
