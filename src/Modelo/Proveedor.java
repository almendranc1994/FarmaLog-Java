package Modelo;

public class Proveedor {
    
    private int codigo;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String Correo;
    private String telefono;
    private Boolean esNacional;
    
    public Proveedor(){
        
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
