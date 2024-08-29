package view;

import controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class coBitacoras extends javax.swing.JFrame {

    public coBitacoras() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Consultar Bitácoras");

        //listarBitacoras(); estas se listan al llamar a la ventana desde el boton en menuConsultar
        //-----------------------------------
        elimProv.setVisible(true); //visibiliza LA TABLA DE BITACORAS DE ELIMINAR PROVEEDORES
        elimClientes.setVisible(false); //clientes eliminados
        elimTrabajadores.setVisible(false); //trabajadores eliminados
        insecMate.setVisible(false);
        cambiosDep.setVisible(false);
    }
    
    public void listarBitacoras(){//****
        listarBTprovEliminado();
        listarBTclienteEliminado();
        listarBTtrabajadorEliminado();
        listarBTinsecMateriales();
        listarBTcambiosDep();     
    }
    //--------------------------------------------------------------------------
    public static void centrarTextoEnTabla(JTable table) {//metodo general para centrar texto de tablas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        // Aplicar el renderizador a todas las columnas de la tabla
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    //--------------------------------------------------------------------------
    public void listarBTprovEliminado(){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tabBTeliminarProv.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

        try {
            conn = Conexion.getConnection();

            String SQL_SELECT = 
            "SELECT id_bitacoraEliminacionProveedores, fechaHoraEliminacion, id_proveedor, nombre_proveedor, direccion, telefono, email, id_tipoProveedor FROM BitacoraEliminacionProveedores";
            
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[8];
                fila[0] = rs.getInt("id_bitacoraEliminacionProveedores");
                fila[1] = rs.getDate("fechaHoraEliminacion");
                fila[2] = rs.getInt("id_proveedor");
                fila[3] = rs.getString("nombre_proveedor");
                fila[4] = rs.getString("direccion");
                fila[5] = rs.getString("telefono");
                fila[6] = rs.getString("email");
                fila[7] = rs.getInt("id_tipoProveedor");

                modeloTabla.addRow(fila); // Agregar la fila a la tabla
            }
            
            centrarTextoEnTabla(tabBTeliminarProv);//Llama r al metodo para centrar texto en tablas
                    
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar bitácora de proveedores eliminados");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar la conexión");
                e.printStackTrace();
            }
        }    
    }
    
    public void listarBTclienteEliminado(){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tabBTEliminarClientes.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

        try {
            conn = Conexion.getConnection();

            String SQL_SELECT = 
            "SELECT id_bitacoraEliminacionClientes, fechaHoraEliminacion, id_cliente, nombre_cliente, email, telefono, id_tipoCliente FROM BitacoraEliminacionClientes";
            
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("id_bitacoraEliminacionClientes");
                fila[1] = rs.getDate("fechaHoraEliminacion");
                fila[2] = rs.getInt("id_cliente");
                fila[3] = rs.getString("nombre_cliente");
                fila[4] = rs.getString("email");
                fila[5] = rs.getString("telefono");
                fila[6] = rs.getInt("id_tipoCliente");

                modeloTabla.addRow(fila); // Agregar la fila a la tabla
            }
            
            centrarTextoEnTabla(tabBTEliminarClientes);
            
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar bitácora de clientes eliminados");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar la conexión");
                e.printStackTrace();
            }
        }    
    }
    
    public void listarBTtrabajadorEliminado(){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tabBTeliminarTrab.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

        try {
            conn = Conexion.getConnection();

            String SQL_SELECT = 
            "SELECT id_bitacoraEliminacionTrabajadores, fechaHoraEliminacion, id_trabajador, id_departamento, nombre_trabajador, apellido_1, apellido_2, cedula, telefono, email FROM BitacoraEliminacionTrabajadores";
            
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[10];
                fila[0] = rs.getInt("id_bitacoraEliminacionTrabajadores");
                fila[1] = rs.getDate("fechaHoraEliminacion");
                fila[2] = rs.getInt("id_trabajador");
                fila[3] = rs.getInt("id_departamento");
                fila[4] = rs.getString("nombre_trabajador");
                fila[5] = rs.getString("apellido_1");
                fila[6] = rs.getString("apellido_2");
                fila[7] = rs.getString("cedula");
                fila[8] = rs.getString("telefono");
                fila[9] = rs.getString("email");

                modeloTabla.addRow(fila); // Agregar la fila a la tabla
            }
            
            centrarTextoEnTabla(tabBTeliminarTrab);
            
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar bitácora de trabajadores eliminados");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar la conexión");
                e.printStackTrace();
            }
        }    
    }
    
     public void listarBTinsecMateriales(){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tabBTinsecMateriales.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

        try {
            conn = Conexion.getConnection();

            String SQL_SELECT = "SELECT id_bitacoraInsercionMateriales, fecha_insercion, id_material FROM BitacoraInsercionMateriales";
            
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("id_bitacoraInsercionMateriales");
                fila[1] = rs.getDate("fecha_insercion");
                fila[2] = rs.getInt("id_material");
                
                modeloTabla.addRow(fila); // Agregar la fila a la tabla
            }
            
            centrarTextoEnTabla(tabBTinsecMateriales);
            
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar bitácora de materiales insertados");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar la conexión");
                e.printStackTrace();
            }
        }    
    }
     
     public void listarBTcambiosDep(){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tabBTcambiosDep.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

        try {
            conn = Conexion.getConnection();

            String SQL_SELECT = 
            "SELECT id_bitacoraCambiosDepartamentos, accion, fecha, id_departamento, nombre_departamento, encargado, descripcion FROM BitacoraCambiosDepartamentos";
            
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("id_bitacoraCambiosDepartamentos");
                fila[1] = rs.getString("accion");
                fila[2] = rs.getDate("fecha");
                fila[3] = rs.getInt("id_departamento");
                fila[4] = rs.getString("nombre_departamento");
                fila[5] = rs.getString("encargado");
                fila[6] = rs.getString("descripcion");
                
                modeloTabla.addRow(fila); // Agregar la fila a la tabla
            }
            
            centrarTextoEnTabla(tabBTcambiosDep);
            
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar bitácora de cambios en departamentos");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar la conexión");
                e.printStackTrace();
            }
        }    
    }
//------------------------------------------------------------------------------    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jpSuperior = new javax.swing.JPanel();
        JLeditar = new javax.swing.JLabel();
        elimProv = new javax.swing.JScrollPane();
        tabBTeliminarProv = new javax.swing.JTable();
        btnProvElim = new javax.swing.JButton();
        btnClientesElim = new javax.swing.JButton();
        btnTrabajadoresElim = new javax.swing.JButton();
        btnInsecMateriales = new javax.swing.JButton();
        btnCambiosDep = new javax.swing.JButton();
        elimClientes = new javax.swing.JScrollPane();
        tabBTEliminarClientes = new javax.swing.JTable();
        elimTrabajadores = new javax.swing.JScrollPane();
        tabBTeliminarTrab = new javax.swing.JTable();
        insecMate = new javax.swing.JScrollPane();
        tabBTinsecMateriales = new javax.swing.JTable();
        cambiosDep = new javax.swing.JScrollPane();
        tabBTcambiosDep = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setMinimumSize(new java.awt.Dimension(800, 500));
        Fondo.setPreferredSize(new java.awt.Dimension(810, 500));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior.setBackground(new java.awt.Color(41, 56, 57));

        JLeditar.setBackground(new java.awt.Color(255, 255, 255));
        JLeditar.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JLeditar.setForeground(new java.awt.Color(255, 255, 255));
        JLeditar.setText("Bitácoras");

        javax.swing.GroupLayout jpSuperiorLayout = new javax.swing.GroupLayout(jpSuperior);
        jpSuperior.setLayout(jpSuperiorLayout);
        jpSuperiorLayout.setHorizontalGroup(
            jpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperiorLayout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(JLeditar)
                .addContainerGap(341, Short.MAX_VALUE))
        );
        jpSuperiorLayout.setVerticalGroup(
            jpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperiorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(JLeditar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Fondo.add(jpSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, -1));

        tabBTeliminarProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_bitácora", "Fecha_hora", "id_proveedor", "nombreProveedor", "dirección", "teléfono", "email", "id_tipoProv"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabBTeliminarProv.setSelectionBackground(new java.awt.Color(204, 204, 255));
        elimProv.setViewportView(tabBTeliminarProv);
        if (tabBTeliminarProv.getColumnModel().getColumnCount() > 0) {
            tabBTeliminarProv.getColumnModel().getColumn(0).setResizable(false);
            tabBTeliminarProv.getColumnModel().getColumn(1).setResizable(false);
            tabBTeliminarProv.getColumnModel().getColumn(2).setResizable(false);
            tabBTeliminarProv.getColumnModel().getColumn(3).setResizable(false);
            tabBTeliminarProv.getColumnModel().getColumn(4).setResizable(false);
            tabBTeliminarProv.getColumnModel().getColumn(5).setResizable(false);
            tabBTeliminarProv.getColumnModel().getColumn(6).setResizable(false);
            tabBTeliminarProv.getColumnModel().getColumn(7).setResizable(false);
        }

        Fondo.add(elimProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 750, 290));

        btnProvElim.setBackground(new java.awt.Color(187, 201, 170));
        btnProvElim.setText("Proveedores eliminados");
        btnProvElim.setBorder(null);
        btnProvElim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProvElim.setFocusPainted(false);
        btnProvElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvElimActionPerformed(evt);
            }
        });
        Fondo.add(btnProvElim, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 170, 30));

        btnClientesElim.setBackground(new java.awt.Color(194, 209, 202));
        btnClientesElim.setText("Clientes elim");
        btnClientesElim.setBorder(null);
        btnClientesElim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientesElim.setFocusPainted(false);
        btnClientesElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesElimActionPerformed(evt);
            }
        });
        Fondo.add(btnClientesElim, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 110, 30));

        btnTrabajadoresElim.setBackground(new java.awt.Color(187, 201, 170));
        btnTrabajadoresElim.setText("Trabajadores elim");
        btnTrabajadoresElim.setBorder(null);
        btnTrabajadoresElim.setFocusPainted(false);
        btnTrabajadoresElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabajadoresElimActionPerformed(evt);
            }
        });
        Fondo.add(btnTrabajadoresElim, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 110, 30));

        btnInsecMateriales.setBackground(new java.awt.Color(194, 209, 202));
        btnInsecMateriales.setText("Insec materiales");
        btnInsecMateriales.setBorder(null);
        btnInsecMateriales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsecMateriales.setFocusPainted(false);
        btnInsecMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsecMaterialesActionPerformed(evt);
            }
        });
        Fondo.add(btnInsecMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 110, 30));

        btnCambiosDep.setBackground(new java.awt.Color(187, 201, 170));
        btnCambiosDep.setText("Cambios departamentos");
        btnCambiosDep.setBorder(null);
        btnCambiosDep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCambiosDep.setFocusPainted(false);
        btnCambiosDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiosDepActionPerformed(evt);
            }
        });
        Fondo.add(btnCambiosDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 170, 30));

        elimClientes.setBackground(new java.awt.Color(255, 255, 255));

        tabBTEliminarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id_bitácora", "Fecha_hora", "id_cliente", "nombre_cliente", "email", "telefono", "id_tipoCliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabBTEliminarClientes.setSelectionBackground(new java.awt.Color(250, 195, 200));
        elimClientes.setViewportView(tabBTEliminarClientes);
        if (tabBTEliminarClientes.getColumnModel().getColumnCount() > 0) {
            tabBTEliminarClientes.getColumnModel().getColumn(0).setResizable(false);
            tabBTEliminarClientes.getColumnModel().getColumn(1).setResizable(false);
            tabBTEliminarClientes.getColumnModel().getColumn(2).setResizable(false);
            tabBTEliminarClientes.getColumnModel().getColumn(3).setResizable(false);
            tabBTEliminarClientes.getColumnModel().getColumn(4).setResizable(false);
            tabBTEliminarClientes.getColumnModel().getColumn(5).setResizable(false);
            tabBTEliminarClientes.getColumnModel().getColumn(6).setResizable(false);
        }

        Fondo.add(elimClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 750, 290));

        tabBTeliminarTrab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_bitácora", "Fecha_hora", "id_trabajador", "id_departamento", "nombre_trab", "apellido 1", "apellido 2", "cédula", "teléfono", "email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabBTeliminarTrab.setSelectionBackground(new java.awt.Color(204, 255, 204));
        elimTrabajadores.setViewportView(tabBTeliminarTrab);
        if (tabBTeliminarTrab.getColumnModel().getColumnCount() > 0) {
            tabBTeliminarTrab.getColumnModel().getColumn(0).setResizable(false);
            tabBTeliminarTrab.getColumnModel().getColumn(1).setResizable(false);
            tabBTeliminarTrab.getColumnModel().getColumn(2).setResizable(false);
            tabBTeliminarTrab.getColumnModel().getColumn(3).setResizable(false);
            tabBTeliminarTrab.getColumnModel().getColumn(4).setResizable(false);
            tabBTeliminarTrab.getColumnModel().getColumn(5).setResizable(false);
            tabBTeliminarTrab.getColumnModel().getColumn(6).setResizable(false);
            tabBTeliminarTrab.getColumnModel().getColumn(7).setResizable(false);
            tabBTeliminarTrab.getColumnModel().getColumn(8).setResizable(false);
            tabBTeliminarTrab.getColumnModel().getColumn(9).setResizable(false);
        }

        Fondo.add(elimTrabajadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 750, 290));

        tabBTinsecMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id_bitácora", "fecha_inserción", "id_material"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabBTinsecMateriales.setSelectionBackground(new java.awt.Color(255, 255, 204));
        insecMate.setViewportView(tabBTinsecMateriales);
        if (tabBTinsecMateriales.getColumnModel().getColumnCount() > 0) {
            tabBTinsecMateriales.getColumnModel().getColumn(0).setResizable(false);
            tabBTinsecMateriales.getColumnModel().getColumn(1).setResizable(false);
            tabBTinsecMateriales.getColumnModel().getColumn(2).setResizable(false);
        }

        Fondo.add(insecMate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 750, 290));

        tabBTcambiosDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id_bitácora", "acción", "fecha", "id_departamento", "nom_depa", "encargado", "descipcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabBTcambiosDep.setSelectionBackground(new java.awt.Color(255, 204, 255));
        cambiosDep.setViewportView(tabBTcambiosDep);

        Fondo.add(cambiosDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 750, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProvElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvElimActionPerformed

        elimProv.setVisible(true); //visibiliza LA TABLA DE BITACORAS DE ELIMINAR PROVEEDORES
        elimClientes.setVisible(false); //OCULTA LA TABLA DE BITACORAS DE ELIMINAR PROVEEDORES
        elimTrabajadores.setVisible(false); //trabajadores eliminados
        insecMate.setVisible(false);
        cambiosDep.setVisible(false);

    }//GEN-LAST:event_btnProvElimActionPerformed

    private void btnClientesElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesElimActionPerformed
        
        elimProv.setVisible(false); //OCULTA LA TABLA DE BITACORAS DE ELIMINAR PROVEEDORES
        elimClientes.setVisible(true); //visibiliza LA TABLA DE BITACORAS DE ELIMINAR clientes
        elimTrabajadores.setVisible(false); //trabajadores eliminados
        insecMate.setVisible(false);
        cambiosDep.setVisible(false);
        
    }//GEN-LAST:event_btnClientesElimActionPerformed

    private void btnCambiosDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiosDepActionPerformed
        elimProv.setVisible(false); 
        elimClientes.setVisible(false); 
        elimTrabajadores.setVisible(false); 
        insecMate.setVisible(false);
        cambiosDep.setVisible(true);//*****
    }//GEN-LAST:event_btnCambiosDepActionPerformed

    private void btnTrabajadoresElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajadoresElimActionPerformed
        
        elimProv.setVisible(false); 
        elimClientes.setVisible(false); 
        elimTrabajadores.setVisible(true); //*****
        insecMate.setVisible(false);
        cambiosDep.setVisible(false);
    }//GEN-LAST:event_btnTrabajadoresElimActionPerformed

    private void btnInsecMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsecMaterialesActionPerformed
        elimProv.setVisible(false); 
        elimClientes.setVisible(false); 
        elimTrabajadores.setVisible(false); 
        insecMate.setVisible(true);//*****
        cambiosDep.setVisible(false);
    }//GEN-LAST:event_btnInsecMaterialesActionPerformed

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
            java.util.logging.Logger.getLogger(coBitacoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(coBitacoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(coBitacoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(coBitacoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new coBitacoras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel JLeditar;
    private javax.swing.JButton btnCambiosDep;
    private javax.swing.JButton btnClientesElim;
    private javax.swing.JButton btnInsecMateriales;
    private javax.swing.JButton btnProvElim;
    private javax.swing.JButton btnTrabajadoresElim;
    private javax.swing.JScrollPane cambiosDep;
    private javax.swing.JScrollPane elimClientes;
    private javax.swing.JScrollPane elimProv;
    private javax.swing.JScrollPane elimTrabajadores;
    private javax.swing.JScrollPane insecMate;
    private javax.swing.JPanel jpSuperior;
    private javax.swing.JTable tabBTEliminarClientes;
    private javax.swing.JTable tabBTcambiosDep;
    private javax.swing.JTable tabBTeliminarProv;
    private javax.swing.JTable tabBTeliminarTrab;
    private javax.swing.JTable tabBTinsecMateriales;
    // End of variables declaration//GEN-END:variables
}
