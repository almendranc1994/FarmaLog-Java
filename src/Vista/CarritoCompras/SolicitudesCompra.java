/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.CarritoCompras;

import Controlador.CarritoBL;
import Controlador.SolicitudCompraBL;
import Modelo.Carrito;
import Modelo.Insumo;
import Modelo.Prioridad;
import Modelo.SolicitudCompra;
import Modelo.UnidadMedida;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author alulab14
 */
public class SolicitudesCompra extends javax.swing.JFrame {

    private final CarritoBL carritoBL = new CarritoBL();
    private final SolicitudCompraBL solcompBL = new SolicitudCompraBL();
    
    private ArrayList<Carrito> carritos = new ArrayList<>();
    private ArrayList<SolicitudCompra> solicitudes = new ArrayList<>();
    private HashMap<Integer, ArrayList<SolicitudCompra>> mapSolicitudes = new HashMap<>();
    private Carrito selectedCarrito = null;
    
    private static final String[] COLUMNAS = {"Insumo", "Volumen", "Fecha Petición",
        "Fecha límite", "Prioridad", "Proveedores"};
    
    private final SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
    
    /**
     * Creates new form FiltrarInsumo
     */
    public SolicitudesCompra() {
        initComponents();
        cleanDatos();
        addListeners();
    }
    
    private void cleanDatos() {
        carritos.clear();
        ((DefaultMutableTreeNode)treeCarritos.getModel().getRoot()).removeAllChildren();
        unselectCarrito();
        
        carritos = carritoBL.obtenerCarritosActivos();
        carritos.stream().forEach(carrito -> {
            addCarrito(carrito);
        });
        
        solicitudes = solcompBL.obtenerSolicitudesNoAsignadas();
        System.out.println(solicitudes);
        mapSolicitudes.clear();
        for(SolicitudCompra sol: solicitudes) {
            int codigoInsumo = sol.getInsumo().getCodigoInsumo();
            if(!mapSolicitudes.containsKey(codigoInsumo))
                mapSolicitudes.put(codigoInsumo, new ArrayList<>());
            mapSolicitudes.get(codigoInsumo).add(sol);
        }
        
        Object valores[][] = new Object[mapSolicitudes.size()][];
        DefaultTableModel tableModel = new DefaultTableModel(valores, COLUMNAS);
        
        int counter = 0;
        for(Map.Entry<Integer, ArrayList<SolicitudCompra>> entry: mapSolicitudes.entrySet()) {
            Insumo insumo = entry.getValue().get(0).getInsumo();
            UnidadMedida um = null; // TODO
            double volumen = 0;
            Date fechaPeticion = null;
            Date fechaLimite = null;
            Prioridad prioridad = Prioridad.BAJA;
            int numProveedores = new Random().nextInt();// TODO
            
            for(SolicitudCompra sol: entry.getValue()) {
                volumen += sol.getCantidad();
                if(fechaPeticion==null) fechaPeticion = sol.getSolSuministro().getFechaPeticion();
                else if(fechaPeticion.getTime() < sol.getSolSuministro().getFechaPeticion().getTime())
                    fechaPeticion = sol.getSolSuministro().getFechaPeticion();
                
                if(fechaLimite==null) fechaLimite = sol.getSolSuministro().getFechaLimite();
                else if(fechaLimite.getTime() > sol.getSolSuministro().getFechaLimite().getTime())
                    fechaLimite = sol.getSolSuministro().getFechaLimite();
                
                if(prioridad.getIdPrioridad() < sol.getSolSuministro().getPrioridad()) {
                    prioridad = Prioridad.getPrioridad(sol.getSolSuministro().getPrioridad());
                }
            }
            
            valores[counter] = new Object[6];
            valores[counter][0] = insumo;
            valores[counter][1] = volumen;
            valores[counter][2] = sdfr.format(fechaPeticion);
            valores[counter][3] = sdfr.format(fechaLimite);
            valores[counter][4] = prioridad.getNombre();
            valores[counter][5] = numProveedores;
                    
            counter ++;
        }
        
        dgSolicitudes.setModel(tableModel);
    }
    
    /* 
    public void simulaDatos() {
        Proveedor prov1 = new Proveedor("El proveedor!", true);
        Proveedor prov2 = new Proveedor("Proveyente", true);
        Proveedor prov3 = new Proveedor("Provss", true);
        Proveedor prov4 = new Proveedor("Wong", true);
        
        DetalleCompra detalles[] = new DetalleCompra[100];
        for(int i=0;i<100;i++) {
            Proveedor prov;
            if(i<25) prov = prov1;
            else if(i<50) prov = prov2;
            else if(i<75) prov = prov3;
            else prov = prov4;
            
            detalles[i] = new DetalleCompra(new Insumo(-1, "Insumo " + (i+1), "nnn"), prov);
        }
        
        Carrito carrito[] = new Carrito[4];
        
        try {
        
            carrito[0] = new Carrito(prov1);
            for(int i=0;i<25;i++) carrito[0].addDetalle(detalles[i]);

            carrito[1] = new Carrito(prov2);
            for(int i=25;i<50;i++) carrito[1].addDetalle(detalles[i]);
            
            carrito[2] = new Carrito(prov3);
            for(int i=50;i<75;i++) carrito[2].addDetalle(detalles[i]);
            
            carrito[3] = new Carrito(prov4);
            for(int i=75;i<100;i++) carrito[3].addDetalle(detalles[i]);
        
        } catch(Exception ex) {
            // Do nothing, I'm perfect :p
        }
        
        for(int i=0;i<4;i++) addCarrito(carrito[i]);
    }
    */
    
    public void addCarrito(Carrito carritoNuevo) {
        carritos.add(carritoNuevo);
        
        DefaultTreeModel model = (DefaultTreeModel)treeCarritos.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        
        DefaultMutableTreeNode nodeCarrito = new DefaultMutableTreeNode(carritoNuevo);
        carritoNuevo.addTreeStructure(nodeCarrito);
        
        root.add(nodeCarrito);
        model.reload(root);
        
        treeCarritos.updateUI();
    }
    
    private void selectCarrito(Carrito carrito) {
        selectedCarrito = carrito;
        bVerCarrito.setEnabled(true);
        bGenerarCompra.setEnabled(true);
        bEliminarCarrito.setEnabled(true);
    }
    
    private void unselectCarrito() {
        selectedCarrito = null;
        bVerCarrito.setEnabled(false);
        bGenerarCompra.setEnabled(false);
        bEliminarCarrito.setEnabled(false);
    }
    
    private void addListeners() {
        treeCarritos.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           treeCarritos.getLastSelectedPathComponent();

                /* if nothing is selected */ 
                if (node == null || node.getParent()==null) {
                    unselectCarrito();
                    return;
                }
                
                /* React to the node selection. */
                while(node.getParent()!=treeCarritos.getModel().getRoot()) {
                    node = (DefaultMutableTreeNode) node.getParent();
                }
                
                /* retrieve the node that was selected */ 
                Carrito carritoSeleccionado = (Carrito) node.getUserObject();
                
                selectCarrito(carritoSeleccionado);
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        treeCarritos = new javax.swing.JTree();
        bVerCarrito = new javax.swing.JButton();
        bGenerarCompra = new javax.swing.JButton();
        bEliminarCarrito = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgSolicitudes = new javax.swing.JTable();
        bSeleccionarSolicitud = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bActualizarSolicitudes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solicitudes de compra");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Carritos de compras"));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Proveedor 1");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Insumo A");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Proveedor 2");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Insumo B");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Insumo C");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Proveedor 3");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Insumo D");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Insumo E");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeCarritos.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeCarritos.setRootVisible(false);
        jScrollPane2.setViewportView(treeCarritos);

        bVerCarrito.setText("Ver carrito");
        bVerCarrito.setEnabled(false);

        bGenerarCompra.setText("Generar compra");
        bGenerarCompra.setEnabled(false);

        bEliminarCarrito.setText("Eliminar carrito");
        bEliminarCarrito.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
            .addComponent(bGenerarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bVerCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bEliminarCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bVerCarrito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bGenerarCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEliminarCarrito))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicitudes"));

        dgSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"A", "5,500 m2", "5/09/17", "11/11/17", "Alta",  new Integer(3)},
                {"B", "2,300 ml", "6/09/17", "10/10/17", "Media",  new Integer(2)},
                {"C", "2,000 L", "7/09/17", "20/10/17", "Baja",  new Integer(0)},
                {"D", "100 g", "8/09/17", "23/11/17", "Media",  new Integer(3)}
            },
            new String [] {
                "Insumo", "Volumen", "Fecha petición", "Fecha límite", "Prioridad", "Proveedores disponibles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dgSolicitudes);

        bSeleccionarSolicitud.setText("Seleccionar");
        bSeleccionarSolicitud.setEnabled(false);

        bCancelar.setText("Cancelar");

        bActualizarSolicitudes.setText("Actualizar");
        bActualizarSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarSolicitudesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bActualizarSolicitudes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSeleccionarSolicitud)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bActualizarSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar)
                    .addComponent(bSeleccionarSolicitud)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bActualizarSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarSolicitudesActionPerformed
        // TODO add your handling code here:
        cleanDatos();
    }//GEN-LAST:event_bActualizarSolicitudesActionPerformed

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
            java.util.logging.Logger.getLogger(SolicitudesCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitudesCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitudesCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitudesCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitudesCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizarSolicitudes;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bEliminarCarrito;
    private javax.swing.JButton bGenerarCompra;
    private javax.swing.JButton bSeleccionarSolicitud;
    private javax.swing.JButton bVerCarrito;
    private javax.swing.JTable dgSolicitudes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree treeCarritos;
    // End of variables declaration//GEN-END:variables
}
