/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitemafamalog;

import Modelo.Proveedor;
import Modelo.Insumo;
import Modelo.Marca;
import Modelo.UnidadMedida;
import Controlador.ProveedoresBL;
import Controlador.ProveedorxInsumoBL;
import Modelo.ProveedorxInsumo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alulab14
 */
public class RegistroProveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistroProveedoresI
     */
    
    public Object[] getCurrentfila() {
        return currentfila;
    }

    /**
     * @param currentfila the currentfila to set
     */
    public void setCurrentfila(Object[] currentfila) {
        this.currentfila = currentfila;
    }

    /**
     * @return the selectedIndex
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * @param selectedIndex the selectedIndex to set
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return the add
     */
    public boolean isAdd() {
        return add;
    }

    /**
     * @param add the add to set
     */
    public void setAdd(boolean add) {
        this.add = add;
    }

    /**
     * @return the provxIns
     */
    public ProveedorxInsumo getProvxIns() {
        return provxIns;
    }

    /**
     * @param provxIns the provxIns to set
     */
    public void setProvxIns(ProveedorxInsumo provxIns) {
        this.provxIns = provxIns;
    }

    /**
     * @return the prov
     */
    public Proveedor getProv() {
        return prov;
    }

    /**
     * @param prov the prov to set
     */
    public void setProv(Proveedor prov) {
        this.prov = prov;
    }
    
    private Proveedor prov;
    private ProveedorxInsumo provxIns;
    private boolean add=false;
    private int selectedIndex;
    private ProveedoresBL logNegProv;
    public BuscarProveedor busqueda;
    public AnadirInsumo anadir;
    private ProveedorxInsumoBL logNegProvxIns;
    private ArrayList<ProveedorxInsumo> listaProveedorxInsumo;
    private Object[] currentfila;
    
    
    public RegistroProveedor() {
        initComponents();
        logNegProv = new ProveedoresBL();

        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtCorreo.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
        tableInsumosAsociados.setEnabled(false);
        pnAnadir.setEnabled(false);
        pnModificar.setEnabled(false);
        pnEliminar.setEnabled(false);
        txtRUC.setEnabled(false);
        txtEmpresa.setEnabled(false);
        txtTipoInstitucion.setEnabled(false);
        
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnBuscarProveedor.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminarProv.setEnabled(false);
        btnCancelarProv.setEnabled(false);
    }
    public void agregarPxI(ProveedorxInsumo pxi){
        listaProveedorxInsumo.add(pxi);
    }
    public void setProveedor(Proveedor P) {
        txtNombre.setText(P.getNombres());
        txtApellido.setText(P.getApellidos());
        txtCorreo.setText(P.getCorreo());
        txtTelefono.setText(P.getTelefono());
        txtDireccion.setText(P.getDireccion());
        txtRUC.setText(P.getRuc());
        txtEmpresa.setText(P.getNombreEmpresa());
        txtTipoInstitucion.setText(P.getInstitucion());
        pnAnadir.setEnabled(true);
        pnModificar.setEnabled(true);
        pnEliminar.setEnabled(true);
        this.setProv(P);
    }

     void modificarTabla(Insumo I, String Unidad, String Marca,int stock, double precio) {
        DefaultTableModel modelo = (DefaultTableModel) tableInsumosAsociados.getModel();
        modelo.setValueAt(I.getCodigoInsumo(), selectedIndex, 0);
        modelo.setValueAt(I.getNombreInsumo(), selectedIndex, 1);
        modelo.setValueAt(Unidad, selectedIndex, 2);
        modelo.setValueAt(Marca, selectedIndex, 3);
        modelo.setValueAt(stock, selectedIndex, 4);
        modelo.setValueAt(precio, selectedIndex, 5);
        
    }

    void modificarPxIenLista(ProveedorxInsumo pxIns) {
        listaProveedorxInsumo.set(selectedIndex,pxIns);
    }
    public void anadirInsumoEnTabla(Insumo I, String Unidad, String Marca,int stock, double precio) {
        DefaultTableModel modelo = (DefaultTableModel) tableInsumosAsociados.getModel();
        Object[] fila = new Object[6];
        fila[0] = I.getCodigoInsumo();
        fila[1] = I.getNombreInsumo();
        fila[2] = Unidad;
        fila[3] = Marca;
        fila[4]=stock;
        fila[5]=precio;
        modelo.addRow(fila);
    }
    public void actualizarDatosTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tableInsumosAsociados.getModel();
        modelo.setNumRows(0);
        Object[] fila = new Object[6];
        if(listaProveedorxInsumo==null){
            System.out.println("No hay nadaaa");
            return;
        }
        for (int i = 0; i < listaProveedorxInsumo.size(); i++) {
            fila[0] = listaProveedorxInsumo.get(i).getInsumo().getCodigoInsumo();
            fila[1] = listaProveedorxInsumo.get(i).getInsumo().getNombreInsumo();
            fila[2] = listaProveedorxInsumo.get(i).getUniMed().getUnidad();
            fila[3] = listaProveedorxInsumo.get(i).getMarca().getNombre();
            fila[4] = listaProveedorxInsumo.get(i).getStock();
            fila[5] = listaProveedorxInsumo.get(i).getPrecio();
            modelo.addRow(fila);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTipoInstitucion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInsumosAsociados = new javax.swing.JTable();
        pnAnadir = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnModificar = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pnEliminar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        btnNuevo = new javax.swing.JMenu();
        btnGuardar = new javax.swing.JMenu();
        btnBuscarProveedor = new javax.swing.JMenu();
        btnActualizar = new javax.swing.JMenu();
        btnEliminarProv = new javax.swing.JMenu();
        btnCancelarProv = new javax.swing.JMenu();

        setBorder(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Correo:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Dirección:");
        jLabel6.setToolTipText("");
        jLabel6.setName(""); // NOI18N

        txtApellido.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtApellido.setName("txtApellido"); // NOI18N
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        txtNombre.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtNombre.setName("txtNombre"); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtCorreo.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtCorreo.setName("txtCorreo"); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        txtDireccion.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtDireccion.setName("txtDireccion"); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtTelefono.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtTelefono.setName("txtTelefono"); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("RUC:");

        txtRUC.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtRUC.setName("txtDireccion"); // NOI18N
        txtRUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRUCActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Empresa:");

        txtEmpresa.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtEmpresa.setName("txtDireccion"); // NOI18N
        txtEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Institución:");

        txtTipoInstitucion.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtTipoInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoInstitucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(txtRUC)
                    .addComponent(txtApellido)
                    .addComponent(txtNombre)
                    .addComponent(txtCorreo)
                    .addComponent(txtTelefono)
                    .addComponent(txtDireccion)
                    .addComponent(txtTipoInstitucion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDireccion)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTipoInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel14.setText("Registro de Proveedor");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Insumos asociados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel2.setName("Insumos asociados"); // NOI18N

        tableInsumosAsociados.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tableInsumosAsociados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "U. Medida", "Marca", "Stock", "Precio Unitario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableInsumosAsociados.setName("tableInsumosAsociados"); // NOI18N
        jScrollPane1.setViewportView(tableInsumosAsociados);

        pnAnadir.setBackground(new java.awt.Color(0, 155, 200));
        pnAnadir.setName("panelAnadir"); // NOI18N
        pnAnadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnAnadirMouseClicked(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 155, 200));
        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Añadir");
        jLabel11.setName("pnAnadir"); // NOI18N

        javax.swing.GroupLayout pnAnadirLayout = new javax.swing.GroupLayout(pnAnadir);
        pnAnadir.setLayout(pnAnadirLayout);
        pnAnadirLayout.setHorizontalGroup(
            pnAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        pnAnadirLayout.setVerticalGroup(
            pnAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnModificar.setBackground(new java.awt.Color(0, 155, 200));
        pnModificar.setName("pnModificar"); // NOI18N
        pnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnModificarMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Modificar");

        javax.swing.GroupLayout pnModificarLayout = new javax.swing.GroupLayout(pnModificar);
        pnModificar.setLayout(pnModificarLayout);
        pnModificarLayout.setHorizontalGroup(
            pnModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        pnModificarLayout.setVerticalGroup(
            pnModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnEliminar.setBackground(new java.awt.Color(0, 155, 200));
        pnEliminar.setName("pnEliminar"); // NOI18N
        pnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnEliminarMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Eliminar");

        javax.swing.GroupLayout pnEliminarLayout = new javax.swing.GroupLayout(pnEliminar);
        pnEliminar.setLayout(pnEliminarLayout);
        pnEliminarLayout.setHorizontalGroup(
            pnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
        );
        pnEliminarLayout.setVerticalGroup(
            pnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 719, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jMenuBar2.setAlignmentY(0.5F);
        jMenuBar2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jMenuBar2.setMaximumSize(new java.awt.Dimension(259, 19));

        btnNuevo.setText("Nuevo");
        btnNuevo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnNuevo.setName("btnNuevo"); // NOI18N
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        jMenuBar2.add(btnNuevo);

        btnGuardar.setText("Guardar");
        btnGuardar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jMenuBar2.add(btnGuardar);

        btnBuscarProveedor.setText("Buscar");
        btnBuscarProveedor.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBuscarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarProveedorMouseClicked(evt);
            }
        });
        jMenuBar2.add(btnBuscarProveedor);

        btnActualizar.setText("Actualizar");
        btnActualizar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        jMenuBar2.add(btnActualizar);

        btnEliminarProv.setText("Eliminar");
        btnEliminarProv.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEliminarProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarProvMouseClicked(evt);
            }
        });
        jMenuBar2.add(btnEliminarProv);

        btnCancelarProv.setText("Cancelar");
        btnCancelarProv.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCancelarProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarProvMouseClicked(evt);
            }
        });
        jMenuBar2.add(btnCancelarProv);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        setProv(new Proveedor());
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnBuscarProveedor.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnEliminarProv.setEnabled(false);
        btnCancelarProv.setEnabled(true);
        
        getProv().setCodigo(logNegProv.devolverUltimoId()+1);
        txtNombre.setEnabled(true);
        txtNombre.setText("");
        txtApellido.setEnabled(true);
        txtApellido.setText("");
        txtCorreo.setEnabled(true);
        txtCorreo.setText("");
        txtTelefono.setEnabled(true);
        txtTelefono.setText("");
        txtDireccion.setEnabled(true);
        txtDireccion.setText("");
        txtEmpresa.setEnabled(true);
        txtEmpresa.setText("");
        txtTipoInstitucion.setEnabled(true);
        txtTipoInstitucion.setText("");
        tableInsumosAsociados.setEnabled(true);
        tableInsumosAsociados.removeAll();
        pnAnadir.setEnabled(true);
        txtRUC.setText("");
        pnModificar.setEnabled(true);
        pnEliminar.setEnabled(true);
        txtRUC.setEnabled(true);
        txtEmpresa.setEnabled(true);
        DefaultTableModel modelo = (DefaultTableModel) tableInsumosAsociados.getModel();
        modelo.setNumRows(0);
        listaProveedorxInsumo=new ArrayList<ProveedorxInsumo>();
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        if (!txtEmpresa.getText().equals("")&& !txtRUC.getText().equals("")&& !txtTelefono.getText().equals("")) {
            getProv().setNombres(txtNombre.getText());
            getProv().setApellidos(txtApellido.getText());
            getProv().setCorreo(txtCorreo.getText());
            getProv().setDireccion(txtDireccion.getText());
            getProv().setTelefono(txtTelefono.getText());
            getProv().setNombreEmpresa(txtEmpresa.getText());
            getProv().setRuc(txtRUC.getText());
            getProv().setInstitucion(txtTipoInstitucion.getText());
            logNegProvxIns=new ProveedorxInsumoBL();
            if (logNegProv.registrarProveedor(getProv())) {
                //JOptionPane.showMessageDialog(null, listaProveedorxInsumo.size()+" codigo del proveedor: "+getProv().getCodigo());
                System.out.println(listaProveedorxInsumo.size());
                for (ProveedorxInsumo proveedorxInsumo : listaProveedorxInsumo) {
                    proveedorxInsumo.setProveedor((new ProveedoresBL()).BuscarProveedor(getProv().getCodigo()));
                    logNegProvxIns.registrarProveedorxInsumo(proveedorxInsumo);
                }
                JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente!");
            }
            listaProveedorxInsumo=new ArrayList<ProveedorxInsumo>();
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe ingresar obligatoriamente: Nombre de la empresa, RUC y teléfono");
        }
        btnGuardar.setSelected(false);
    }//GEN-LAST:event_btnGuardarMouseClicked

    public void cargarInsumosAsociados(int codigo){
        try{
            logNegProvxIns=new ProveedorxInsumoBL();
            listaProveedorxInsumo=logNegProvxIns.devolverListaInsumodeProv(codigo);
        }
        catch(Exception e){
            
        }
        actualizarDatosTabla();
    }
    private void btnBuscarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProveedorMouseClicked
        try {
            // TODO add your handling code here:
            busqueda = new BuscarProveedor();
            busqueda.registro = this;
            busqueda.setVisible(true);
            //System.out.println("El codigo es "+prov.getNombreEmpresa());
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtCorreo.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtEmpresa.setEnabled(false);
        txtTipoInstitucion.setEnabled(false);
        tableInsumosAsociados.setEnabled(true);
        pnAnadir.setEnabled(true);
        pnModificar.setEnabled(true);
        pnEliminar.setEnabled(true);
        txtRUC.setEnabled(false);
        txtEmpresa.setEnabled(false);
        
        
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnBuscarProveedor.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminarProv.setEnabled(true);
        btnCancelarProv.setEnabled(true);
    }//GEN-LAST:event_btnBuscarProveedorMouseClicked

    
    private void btnCancelarProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarProvMouseClicked
        // TODO add your handling code here:
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnBuscarProveedor.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminarProv.setEnabled(false);
        btnCancelarProv.setEnabled(false);

        prov.setCodigo(logNegProv.devolverUltimoId()+1);
        txtNombre.setEnabled(false);
        txtNombre.setText("");
        txtApellido.setEnabled(false);
        txtApellido.setText("");
        txtCorreo.setEnabled(false);
        txtCorreo.setText("");
        txtTelefono.setEnabled(false);
        txtTelefono.setText("");
        txtDireccion.setEnabled(false);
        txtDireccion.setText("");
        txtEmpresa.setEnabled(false);
        txtEmpresa.setText("");
        txtTipoInstitucion.setEnabled(false);
        txtTipoInstitucion.setText("");
        tableInsumosAsociados.setEnabled(false);
        tableInsumosAsociados.removeAll();
        pnAnadir.setEnabled(false);
        txtRUC.setText("");
        pnModificar.setEnabled(false);
        pnEliminar.setEnabled(false);
        txtRUC.setEnabled(false);
        txtEmpresa.setEnabled(false);
        DefaultTableModel modelo = (DefaultTableModel) tableInsumosAsociados.getModel();
        modelo.setNumRows(0);
        listaProveedorxInsumo=new ArrayList<ProveedorxInsumo>();
    }//GEN-LAST:event_btnCancelarProvMouseClicked

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtRUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRUCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRUCActionPerformed

    private void txtEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaActionPerformed

    private void txtTipoInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoInstitucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoInstitucionActionPerformed

    private void pnAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnAnadirMouseClicked
        add=true;
        System.out.println("Anadir "+add);
        anadir = new AnadirInsumo();
        anadir.registro = this;
        anadir.setVisible(true);
    }//GEN-LAST:event_pnAnadirMouseClicked

    private void pnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnModificarMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        if(!tableInsumosAsociados.getSelectionModel().isSelectionEmpty()){
            selectedIndex=tableInsumosAsociados.getSelectedRow();
            provxIns=listaProveedorxInsumo.get(selectedIndex);
            add=false;
            currentfila = new Object[6];
            currentfila[0] = Integer.parseInt(tableInsumosAsociados.getModel().getValueAt(selectedIndex, 0).toString());
            currentfila[1] = tableInsumosAsociados.getModel().getValueAt(selectedIndex, 1).toString();
            currentfila[2] = tableInsumosAsociados.getModel().getValueAt(selectedIndex, 2).toString();
            currentfila[3] = tableInsumosAsociados.getModel().getValueAt(selectedIndex, 3).toString();
            currentfila[4]= tableInsumosAsociados.getModel().getValueAt(selectedIndex, 4).toString();
            currentfila[5]= tableInsumosAsociados.getModel().getValueAt(selectedIndex, 5).toString();
            anadir.setValues();
            anadir.setVisible(true);
        }
    }//GEN-LAST:event_pnModificarMouseClicked

    private void pnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnEliminarMouseClicked
        // TODO add your handling code here:
        if(!tableInsumosAsociados.getSelectionModel().isSelectionEmpty()){
            selectedIndex=tableInsumosAsociados.getSelectedRow();
            ((DefaultTableModel)tableInsumosAsociados.getModel()).removeRow(selectedIndex);
            listaProveedorxInsumo.remove(selectedIndex);
        }
    }//GEN-LAST:event_pnEliminarMouseClicked

    private void btnEliminarProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProvMouseClicked
        // TODO add your handling code here:
        logNegProv=new ProveedoresBL();
        logNegProvxIns=new ProveedorxInsumoBL();
        System.out.println(getProv().getCodigo());
        logNegProv.eliminarProveedor(getProv().getCodigo());
        logNegProvxIns.eliminarRastroDelProveedor(getProv().getCodigo());
        
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnBuscarProveedor.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminarProv.setEnabled(false);
        btnCancelarProv.setEnabled(false);
        
        txtNombre.setEnabled(false);
        txtNombre.setText("");
        txtApellido.setEnabled(false);
        txtApellido.setText("");
        txtCorreo.setEnabled(false);
        txtCorreo.setText("");
        txtTelefono.setEnabled(false);
        txtTelefono.setText("");
        txtDireccion.setEnabled(false);
        txtDireccion.setText("");
        txtEmpresa.setEnabled(false);
        txtEmpresa.setText("");
        txtTipoInstitucion.setEnabled(false);
        txtTipoInstitucion.setText("");
        tableInsumosAsociados.setEnabled(false);
        tableInsumosAsociados.removeAll();
        pnAnadir.setEnabled(false);
        txtRUC.setText("");
        pnModificar.setEnabled(false);
        pnEliminar.setEnabled(false);
        txtRUC.setEnabled(false);
        txtEmpresa.setEnabled(false);
        DefaultTableModel modelo = (DefaultTableModel) tableInsumosAsociados.getModel();
        modelo.setNumRows(0);
        listaProveedorxInsumo=new ArrayList<ProveedorxInsumo>();
    }//GEN-LAST:event_btnEliminarProvMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        // TODO add your handling code here:
        logNegProvxIns=new ProveedorxInsumoBL();
        logNegProvxIns.eliminarRastroDelProveedor(getProv().getCodigo());
        for (ProveedorxInsumo proveedorxInsumo : listaProveedorxInsumo) {
            proveedorxInsumo.setProveedor((new ProveedoresBL()).BuscarProveedor(getProv().getCodigo()));
            logNegProvxIns.registrarProveedorxInsumo(proveedorxInsumo);
        }
        JOptionPane.showMessageDialog(null, "Se ha actualizado exitosamente!");
    }//GEN-LAST:event_btnActualizarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnActualizar;
    private javax.swing.JMenu btnBuscarProveedor;
    private javax.swing.JMenu btnCancelarProv;
    private javax.swing.JMenu btnEliminarProv;
    private javax.swing.JMenu btnGuardar;
    private javax.swing.JMenu btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnAnadir;
    private javax.swing.JPanel pnEliminar;
    private javax.swing.JPanel pnModificar;
    private javax.swing.JTable tableInsumosAsociados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoInstitucion;
    // End of variables declaration//GEN-END:variables
}
