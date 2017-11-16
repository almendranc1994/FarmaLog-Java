package Modelo;

public class Proveedor {

   
    private int codigo;
    private String nombreEmpresa;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String Correo;
    private String telefono;
    private Boolean esNacional;
    private String institucion;
    private String ruc;
    
    public Proveedor(){
        this.esNacional = true;
    }
    public Proveedor(String nombreEmpresa, Boolean esNac){
        //codigo = idProv;
        this.nombreEmpresa = nombreEmpresa;
        codigo = -1;
        esNacional=esNac;
        
        this.nombres = null;
        this.apellidos = null;
        Correo=null;
    }
    
    public Proveedor(int idProveedor, String nombreEmpresa, Boolean esNac){
        codigo = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        esNacional=esNac;
        
        Correo = null;
        nombres = null;
        apellidos = null;
    }
     public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    
    public void setIdProveedor(int idProveedor) {
        codigo = idProveedor;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
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
    
    /**
     * @return the institucion
     */
    public String getInstitucion() {
        return institucion;
    }

    /**
     * @param institucion the institucion to set
     */
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
    
}
