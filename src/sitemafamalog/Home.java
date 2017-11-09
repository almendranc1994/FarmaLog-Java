/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitemafamalog;

//Hace el import de Vista.CarritoCompras
//Hacer el import de Vista.RecepcionInsumos

import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pnlCompraInsumo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlGestionInsumos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlProveedor = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlGestionSolicitudes = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnlCarritoCompras = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pnlSolicitudesCompra = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnlComprasRealizadas = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(24, 47, 139));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Global Mix Farma");

        exit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Sistema FarmaLogs");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(699, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(689, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(exit)
                .addGap(94, 94, 94)
                .addComponent(jLabel15)
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(93, Short.MAX_VALUE)
                    .addComponent(jLabel24)
                    .addGap(88, 88, 88)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 210));

        pnlCompraInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCompraInsumoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCompraInsumoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlCompraInsumoMousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sitemafamalog/images/icons8-Agregar a carrito de compras-26.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Gestión Compra");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Insumos");

        javax.swing.GroupLayout pnlCompraInsumoLayout = new javax.swing.GroupLayout(pnlCompraInsumo);
        pnlCompraInsumo.setLayout(pnlCompraInsumoLayout);
        pnlCompraInsumoLayout.setHorizontalGroup(
            pnlCompraInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompraInsumoLayout.createSequentialGroup()
                .addGroup(pnlCompraInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCompraInsumoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(pnlCompraInsumoLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addGroup(pnlCompraInsumoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCompraInsumoLayout.setVerticalGroup(
            pnlCompraInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompraInsumoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(pnlCompraInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 110, 110));

        pnlGestionInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlGestionInsumosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlGestionInsumosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlGestionInsumosMousePressed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sitemafamalog/images/icons8-Carretilla elevadora-50.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gestión");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("Insumos");

        javax.swing.GroupLayout pnlGestionInsumosLayout = new javax.swing.GroupLayout(pnlGestionInsumos);
        pnlGestionInsumos.setLayout(pnlGestionInsumosLayout);
        pnlGestionInsumosLayout.setHorizontalGroup(
            pnlGestionInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestionInsumosLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(pnlGestionInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGestionInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        pnlGestionInsumosLayout.setVerticalGroup(
            pnlGestionInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGestionInsumosLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(pnlGestionInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 110, 110));

        pnlProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlProveedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlProveedorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlProveedorMousePressed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sitemafamalog/images/icons8-Proveedor-50.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Gestión");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("Proveedores");

        javax.swing.GroupLayout pnlProveedorLayout = new javax.swing.GroupLayout(pnlProveedor);
        pnlProveedor.setLayout(pnlProveedorLayout);
        pnlProveedorLayout.setHorizontalGroup(
            pnlProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProveedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProveedorLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlProveedorLayout.setVerticalGroup(
            pnlProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProveedorLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(pnlProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        pnlGestionSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlGestionSolicitudesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlGestionSolicitudesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlGestionSolicitudesMousePressed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sitemafamalog/images/icons8-Hoja de papel-50.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Gestión");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 255));
        jLabel12.setText("Solicitudes");

        javax.swing.GroupLayout pnlGestionSolicitudesLayout = new javax.swing.GroupLayout(pnlGestionSolicitudes);
        pnlGestionSolicitudes.setLayout(pnlGestionSolicitudesLayout);
        pnlGestionSolicitudesLayout.setHorizontalGroup(
            pnlGestionSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestionSolicitudesLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnlGestionSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGestionSolicitudesLayout.createSequentialGroup()
                        .addGroup(pnlGestionSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGestionSolicitudesLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        pnlGestionSolicitudesLayout.setVerticalGroup(
            pnlGestionSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGestionSolicitudesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(pnlGestionSolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 110, -1));

        pnlCarritoCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCarritoComprasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCarritoComprasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlCarritoComprasMousePressed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sitemafamalog/images/icons8-Carrito de la compra cargado-50.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Carrito");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Compras");

        javax.swing.GroupLayout pnlCarritoComprasLayout = new javax.swing.GroupLayout(pnlCarritoCompras);
        pnlCarritoCompras.setLayout(pnlCarritoComprasLayout);
        pnlCarritoComprasLayout.setHorizontalGroup(
            pnlCarritoComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCarritoComprasLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnlCarritoComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        pnlCarritoComprasLayout.setVerticalGroup(
            pnlCarritoComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCarritoComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addContainerGap())
        );

        jPanel1.add(pnlCarritoCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));

        pnlSolicitudesCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSolicitudesCompraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSolicitudesCompraMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSolicitudesCompraMousePressed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sitemafamalog/images/icons8-Orden de compra-50.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Gestión");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Sol. Compras");

        javax.swing.GroupLayout pnlSolicitudesCompraLayout = new javax.swing.GroupLayout(pnlSolicitudesCompra);
        pnlSolicitudesCompra.setLayout(pnlSolicitudesCompraLayout);
        pnlSolicitudesCompraLayout.setHorizontalGroup(
            pnlSolicitudesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSolicitudesCompraLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnlSolicitudesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(28, 28, 28))
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSolicitudesCompraLayout.setVerticalGroup(
            pnlSolicitudesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSolicitudesCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addContainerGap())
        );

        jPanel1.add(pnlSolicitudesCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 110, 110));

        pnlComprasRealizadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlComprasRealizadasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlComprasRealizadasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlComprasRealizadasMousePressed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sitemafamalog/images/icons8-Historial de pedidos-50.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Compras");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Históricas");

        javax.swing.GroupLayout pnlComprasRealizadasLayout = new javax.swing.GroupLayout(pnlComprasRealizadas);
        pnlComprasRealizadas.setLayout(pnlComprasRealizadasLayout);
        pnlComprasRealizadasLayout.setHorizontalGroup(
            pnlComprasRealizadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComprasRealizadasLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(28, 28, 28))
            .addGroup(pnlComprasRealizadasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlComprasRealizadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlComprasRealizadasLayout.setVerticalGroup(
            pnlComprasRealizadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComprasRealizadasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(12, 12, 12)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addContainerGap())
        );

        jPanel1.add(pnlComprasRealizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 110, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlProveedorMouseEntered
        // TODO add your handling code here:
        setColor(pnlProveedor);
    }//GEN-LAST:event_pnlProveedorMouseEntered

    private void pnlProveedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlProveedorMouseExited
        // TODO add your handling code here:
        resetColor(pnlProveedor);
    }//GEN-LAST:event_pnlProveedorMouseExited

    private void pnlCompraInsumoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCompraInsumoMouseEntered
        // TODO add your handling code here:
        setColor(pnlCompraInsumo);
    }//GEN-LAST:event_pnlCompraInsumoMouseEntered

    private void pnlCompraInsumoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCompraInsumoMouseExited
        // TODO add your handling code here:
        resetColor(pnlCompraInsumo);
    }//GEN-LAST:event_pnlCompraInsumoMouseExited

    private void pnlGestionInsumosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGestionInsumosMouseExited
        // TODO add your handling code here:
        resetColor(pnlGestionInsumos);
    }//GEN-LAST:event_pnlGestionInsumosMouseExited

    private void pnlGestionInsumosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGestionInsumosMouseEntered
        // TODO add your handling code here:
        setColor(pnlGestionInsumos);
    }//GEN-LAST:event_pnlGestionInsumosMouseEntered

    private void pnlGestionSolicitudesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGestionSolicitudesMouseEntered
        // TODO add your handling code here:
        setColor(pnlGestionSolicitudes);
    }//GEN-LAST:event_pnlGestionSolicitudesMouseEntered

    private void pnlGestionSolicitudesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGestionSolicitudesMouseExited
        // TODO add your handling code here:
        resetColor(pnlGestionSolicitudes);
    }//GEN-LAST:event_pnlGestionSolicitudesMouseExited

    private void pnlCarritoComprasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCarritoComprasMouseEntered
        // TODO add your handling code here:
        setColor(pnlCarritoCompras);
    }//GEN-LAST:event_pnlCarritoComprasMouseEntered

    private void pnlCarritoComprasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCarritoComprasMouseExited
        // TODO add your handling code here:
        resetColor(pnlCarritoCompras);
    }//GEN-LAST:event_pnlCarritoComprasMouseExited

    private void pnlProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlProveedorMousePressed
        // TODO add your handling code here:
        RegistroProveedor frmNewProveedor = new RegistroProveedor();
        frmNewProveedor.setVisible(true);
    }//GEN-LAST:event_pnlProveedorMousePressed

    private void pnlCompraInsumoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCompraInsumoMousePressed
        // TODO add your handling code here:
        CompraDeInsumos frmNewCompIns = new CompraDeInsumos();
        frmNewCompIns.setVisible(true);
    }//GEN-LAST:event_pnlCompraInsumoMousePressed

    private void pnlGestionInsumosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGestionInsumosMousePressed
        // TODO add your handling code here:
        RegistroNuevoInsumo frmNewInsumo = new RegistroNuevoInsumo();
        frmNewInsumo.setVisible(true);
    }//GEN-LAST:event_pnlGestionInsumosMousePressed

    private void pnlGestionSolicitudesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGestionSolicitudesMousePressed
        // TODO add your handling code here:
        ListaSolicitudesSuministro frmNewSol = new ListaSolicitudesSuministro();
        frmNewSol.setVisible(true);
    }//GEN-LAST:event_pnlGestionSolicitudesMousePressed

    private void pnlCarritoComprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCarritoComprasMousePressed
        // TODO add your handling code here:
        //CarritoCompras frmCarrito = new CarritoCompras();
        //frmCarrito.setVisible(true);
    }//GEN-LAST:event_pnlCarritoComprasMousePressed

    private void pnlSolicitudesCompraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSolicitudesCompraMouseEntered
        // TODO add your handling code here:
        setColor(pnlSolicitudesCompra);
    }//GEN-LAST:event_pnlSolicitudesCompraMouseEntered

    private void pnlSolicitudesCompraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSolicitudesCompraMouseExited
        // TODO add your handling code here:
        resetColor(pnlSolicitudesCompra);
    }//GEN-LAST:event_pnlSolicitudesCompraMouseExited

    private void pnlSolicitudesCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSolicitudesCompraMousePressed
        // TODO add your handling code here:
        //SolicitudesCompras frmSolCompras = new SolicitudesCompras();
        //frmSolCompras.setVisible(true);
    }//GEN-LAST:event_pnlSolicitudesCompraMousePressed

    private void pnlComprasRealizadasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlComprasRealizadasMouseEntered
        // TODO add your handling code here:
        setColor(pnlComprasRealizadas);
    }//GEN-LAST:event_pnlComprasRealizadasMouseEntered

    private void pnlComprasRealizadasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlComprasRealizadasMouseExited
        // TODO add your handling code here:
        resetColor(pnlComprasRealizadas);
    }//GEN-LAST:event_pnlComprasRealizadasMouseExited

    private void pnlComprasRealizadasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlComprasRealizadasMousePressed
        // TODO add your handling code here:
        //ComprasRealizadas frmComprasRea = new ComprasRealizadas();
        //frmComprasRea.setVisible(true);
    }//GEN-LAST:event_pnlComprasRealizadasMousePressed

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMousePressed
    
    public void setColor(JPanel panel){
        panel.setBackground(new java.awt.Color(156,156,156));
    }
    
    public void resetColor(JPanel panel){
        panel.setBackground(new java.awt.Color(240,240,240));
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlCarritoCompras;
    private javax.swing.JPanel pnlCompraInsumo;
    private javax.swing.JPanel pnlComprasRealizadas;
    private javax.swing.JPanel pnlGestionInsumos;
    private javax.swing.JPanel pnlGestionSolicitudes;
    private javax.swing.JPanel pnlProveedor;
    private javax.swing.JPanel pnlSolicitudesCompra;
    // End of variables declaration//GEN-END:variables
}
