/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitemafamalog;

import Controlador.InsumoBL;
import Modelo.Insumo;
import Modelo.Marca;
import Modelo.UnidadMedida;
import Controlador.MarcaBL;
import Controlador.UnidadMedidaBL;
import Controlador.ProveedorxInsumoBL;
import Modelo.ProveedorxInsumo;
import Modelo.UnidadMedida;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Karla Isabel Pedraza Salinas 20141056
 */
public class AnadirInsumo extends javax.swing.JFrame {

    ArrayList<Insumo> listaInsumos;
    ArrayList<Marca> listaMarcas;
    ArrayList<UnidadMedida> listaUniMed;
    MarcaBL logNegMarca = new MarcaBL();
    UnidadMedidaBL logNegUniMed = new UnidadMedidaBL();
    InsumoBL logicaInsumo = new InsumoBL();
    ProveedorxInsumo pxIns;
    ProveedorxInsumoBL pxILogica = new ProveedorxInsumoBL();
    public RegistroProveedor registro;

    /**
     * Creates new form AnadirInsumo
     */
    public ProveedorxInsumo getProveedorxInsumo(){
        return pxIns;
    }
    void setValues() {
        System.out.println("SET VALUEEEEES "+registro.isAdd());
        if(registro.isAdd()==true){
            txtPrecio.setEnabled(false);
            cbMarca.setEnabled(false);
            cbUniMed.setEnabled(false);
            txtStock.setEnabled(false);
            btnAgregar.setEnabled(false);
            btnNuevo.setEnabled(false);
        }
        else{
            txtPrecio.setEnabled(true);
            cbMarca.setEnabled(true);
            cbUniMed.setEnabled(true);
            txtStock.setEnabled(true);
            btnAgregar.setEnabled(true);
            btnNuevo.setEnabled(true);
            InsumoBL logNegIns=new InsumoBL();
            try{
                listaInsumos = logNegIns.devolverListaInsumo(registro.getCurrentfila()[1].toString());   
            }
            catch(Exception e){
                listaInsumos=null;
            }
            if (listaInsumos != null) {
                actualizarDatosTabla();
            }
            tablaInsumos.setRowSelectionInterval(0, 0);
            cbMarca.setSelectedItem(registro.getCurrentfila()[3]);
            cbUniMed.setSelectedItem(registro.getCurrentfila()[2]);
            txtPrecio.setText(""+registro.getCurrentfila()[5]);
            txtStock.setText(""+registro.getCurrentfila()[4]);
            
        }
    }
    public AnadirInsumo() {
        initComponents();
        txtPrecio.setEnabled(false);
        cbMarca.setEnabled(false);
        cbUniMed.setEnabled(false);
        txtStock.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnNuevo.setEnabled(false);
        try {
            listaMarcas = logNegMarca.devolverLista();
            System.out.println("marcas: " + listaMarcas.size());
            for (int i = 0; i < listaMarcas.size(); i++) {
                cbMarca.addItem(listaMarcas.get(i).getNombre());
            }
            listaUniMed = logNegUniMed.devolverLista();
            for (int i = 0; i < listaUniMed.size(); i++) {
                cbUniMed.addItem(listaUniMed.get(i).getUnidad());
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        txtNombreInsumo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInsumos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbMarca = new javax.swing.JComboBox<>();
        cbUniMed = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Insumos");
        setName("Añadir Insumo"); // NOI18N

        jLabel1.setText("Nombre:");

        txtNombreInsumo.setName("txtNombre"); // NOI18N

        btnBuscar.setText("Buscar");
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.setName("btnNuevo"); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.setName("btnAgregar"); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tablaInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Descripción"
            }
        ));
        tablaInsumos.setName("tableAñadirInsumos"); // NOI18N
        jScrollPane1.setViewportView(tablaInsumos);

        jLabel2.setText("Marca:");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel3.setText("Unidad de Medida:");

        jLabel4.setText("Precio Unitario:");

        jLabel5.setText("Stock:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)
                                .addGap(57, 57, 57)
                                .addComponent(txtNombreInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addComponent(txtStock))
                            .addComponent(cbUniMed, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbUniMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addContainerGap(59, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        RegistroNuevoInsumo frmNewInsumo = new RegistroNuevoInsumo();
        frmNewInsumo.setVisible(true);

    }//GEN-LAST:event_btnNuevoActionPerformed
    public boolean validarPrecio(String p) {
        double precio;
        try {
            precio = Double.parseDouble(p);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en precio");
            return false;
        }
        if (precio > 0) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Ingrese un número positivo en precio");
        return false;
    }

    public boolean validarStock(String s) {
        int stock;
        try {
            stock = Integer.parseInt(s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en stock");
            return false;
        }
        if (stock > 0) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Ingrese un número positivo en stock");
        return false;
    }
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        System.out.println(Integer.parseInt(tablaInsumos.getModel().getValueAt(tablaInsumos.getSelectedRow(), 0).toString()) + "");
        System.out.println(cbUniMed.getSelectedItem().toString());
        System.out.println(Double.parseDouble(txtPrecio.getText()));
        try {
            if (!tablaInsumos.getSelectionModel().isSelectionEmpty() && validarPrecio(txtPrecio.getText()) && validarStock(txtStock.getText())) {
                UnidadMedida uniMed = (new UnidadMedidaBL()).BuscarUnidadMedidaporNombre(cbUniMed.getSelectedItem().toString());
                Marca marca = (new MarcaBL()).BuscarMarcaporNombre(cbMarca.getSelectedItem().toString());
                Insumo I = logicaInsumo.BuscarInsumo(Integer.parseInt(tablaInsumos.getModel().getValueAt(tablaInsumos.getSelectedRow(), 0).toString()));
                int stock = Integer.parseInt(txtStock.getText());
                double precio = Double.parseDouble(txtPrecio.getText());
                System.out.println(""+registro.getProv().getCodigo()+I.getCodigoInsumo()+uniMed.getUnidad()+stock+marca.getNombre()+precio);
                pxIns = new ProveedorxInsumo(registro.getProv().getCodigo(), I.getCodigoInsumo(), uniMed.getUnidad(), stock, marca.getNombre(), precio);
                registro.anadirInsumoEnTabla(I, cbUniMed.getSelectedItem().toString(),cbMarca.getSelectedItem().toString(),stock,precio);
                registro.agregarPxI(pxIns);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //pxIns=new ProveedorxInsumo();
        } finally {
            //this.dispose();
        }
        //this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        System.out.println("Botón apretado o: " + txtNombreInsumo.getText());
        InsumoBL logNegIns = new InsumoBL();
        System.out.println("bl creado");
        try {
            System.out.println("dentro del try");
            listaInsumos = logNegIns.devolverListaInsumo(txtNombreInsumo.getText());
            System.out.println("a punto de salir del try, tamaño de lista Insumos= " + listaInsumos.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (listaInsumos != null) {
            actualizarDatosTabla();
        }
        txtPrecio.setEnabled(true);
        cbMarca.setEnabled(true);
        cbUniMed.setEnabled(true);
        txtStock.setEnabled(true);
        btnAgregar.setEnabled(true);
        btnNuevo.setEnabled(true);
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed
    public void actualizarDatosTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaInsumos.getModel();
        modelo.setNumRows(0);
        Object[] fila = new Object[3];
        for (int i = 0; i < listaInsumos.size(); i++) {
            fila[0] = listaInsumos.get(i).getCodigoInsumo();
            fila[1] = listaInsumos.get(i).getNombreInsumo();
            fila[2] = listaInsumos.get(i).getDescripcionInsumo();
            modelo.addRow(fila);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnadirInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnadirInsumo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JComboBox<String> cbUniMed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaInsumos;
    private javax.swing.JTextField txtNombreInsumo;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
