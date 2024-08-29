package view;

import controller.Conexion;
import model.*;
import domain.*;
import java.sql.*;
import java.time.DateTimeException;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static view.coBitacoras.centrarTextoEnTabla;

public class agProyectos extends javax.swing.JFrame {

    ProyectosDAO prd = new ProyectosDAO();

    //ICONOS
    ImageIcon iconCheck = new ImageIcon("src/main/java/icons/check.png");
    ImageIcon iconError = new ImageIcon("src/main/java/icons/error.png");
    ImageIcon iconWarning = new ImageIcon("src/main/java/icons/warning.png");
    //-----

    public agProyectos() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //setSize(700, 500);
        //validate();
        setTitle("Agregar proyectos");
        
    }
//------------------------------------------------------------------------------

    public void limpiar() {
        txtDi.setText("");
        txtDf.setText("");
        txtMi.setText("");
        txtMf.setText("");
        txtAi.setText("");
        txtAf.setText("");
        txtNombre.setText("");
        txtPresupuesto.setText("");
        test.setText("");
    }

    public void listarClientes() {//Se listan al abrir esta ventana desde menu agregar
        //ESTE SE LISTA AL LLAMAR LA VENTANA DESDE MENU AGREGAR
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tabClientes.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

        try {
            conn = Conexion.getConnection();

            // Consulta SQL para obtener los datos requeridos
            String SQL_SELECT
                    = "SELECT c.id_cliente, c.nombre_cliente, t.descripcion AS tipo_cliente "
                    + "FROM Clientes c "
                    + "JOIN Tipo_Cliente t ON c.id_tipoCliente = t.id_tipoCliente";

            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("id_cliente");
                fila[1] = rs.getString("nombre_cliente");
                fila[2] = rs.getString("tipo_cliente");

                modeloTabla.addRow(fila); // Agregar la fila a la tabla
            }

            // Centrar el texto en la tabla
            centrarTextoEnTabla(tabClientes);//Este metodo esta estatico en "coBitacoras"

        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar clientes");
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

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public Date obtenerFechaInicio() { //OBTENER FECHA DE INICIO DE MANERA CORRECTA
        int dia = Integer.parseInt(txtDi.getText());
        int mes = Integer.parseInt(txtMi.getText());
        int ano = Integer.parseInt(txtAi.getText());

        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {//si la fecha es invalida no se retorna una fecha y se retorna null
            JOptionPane.showMessageDialog(null, "Fecha de inicio inválida", "Error de fecha", JOptionPane.INFORMATION_MESSAGE, iconError);
            return null;
        }

        try {
            // Crear una instancia de LocalDate
            LocalDate localDate = LocalDate.of(ano, mes, dia);
            // Convertir LocalDate a java.sql.Date
            return Date.valueOf(localDate);
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Fecha de inicio  inválida", "Error de fecha", JOptionPane.INFORMATION_MESSAGE, iconError);
            return null;
        }
    }

    public Date obtenerFechaFin() { //OBTENER FECHA DE FIN DE MANERA CORRECTA
        int dia = Integer.parseInt(txtDf.getText());
        int mes = Integer.parseInt(txtMf.getText());
        int ano = Integer.parseInt(txtAf.getText());

        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {//si la fecha es invalida no se retorna una fecha y se retorna null
            JOptionPane.showMessageDialog(null, "Fecha de fin inválida", "Error de fecha", JOptionPane.INFORMATION_MESSAGE, iconError);
            return null;
        }

        try {
            // Crear una instancia de LocalDate
            LocalDate localDate = LocalDate.of(ano, mes, dia);
            // Convertir LocalDate a java.sql.Date
            return Date.valueOf(localDate);
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Fecha de fin inválida", "Error de fecha", JOptionPane.INFORMATION_MESSAGE, iconError);
            return null;
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean validarCamposVacios() {
        if (txtDi.getText().isEmpty() || txtDf.getText().isEmpty() || txtMi.getText().isEmpty() || txtMf.getText().isEmpty() || txtAi.getText().isEmpty()
                || txtAf.getText().isEmpty() || txtNombre.getText().isEmpty() || txtPresupuesto.getText().isEmpty() || test.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void guardarProyecto() {

        if (!validarCamposVacios()) {

            Date fechaInicio = obtenerFechaInicio();
            Date fechaFin = obtenerFechaFin();

            if (fechaInicio != null && fechaFin != null) {//Si ambas fechas son validas se prosigue
                String nom = txtNombre.getText();
                float presupuesto = Float.parseFloat(txtPresupuesto.getText());
                int auxIdCliente = Integer.parseInt(test.getText());
                
                Proyectos p = new Proyectos();
                p.setIdCliente(auxIdCliente);
                p.setNombreProyecto(nom);
                p.setFechaInicio(fechaInicio);
                p.setFechaFin(fechaFin);
                p.setPresupuesto(presupuesto);
                
                prd.agregarProyecto(p);
                limpiar();
                JOptionPane.showMessageDialog(null, "Proyecto guardado", "Agregar proyecto", JOptionPane.INFORMATION_MESSAGE, iconCheck);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Advertencia", JOptionPane.INFORMATION_MESSAGE, iconWarning);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jpSuperior3 = new javax.swing.JPanel();
        JLeditar3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        test = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabClientes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtPresupuesto = new javax.swing.JTextField();
        txtDi = new javax.swing.JTextField();
        txtMi = new javax.swing.JTextField();
        txtAi = new javax.swing.JTextField();
        txtDf = new javax.swing.JTextField();
        txtMf = new javax.swing.JTextField();
        txtAf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setMinimumSize(new java.awt.Dimension(700, 600));
        Fondo.setPreferredSize(new java.awt.Dimension(700, 600));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior3.setBackground(new java.awt.Color(41, 56, 57));

        JLeditar3.setBackground(new java.awt.Color(255, 255, 255));
        JLeditar3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JLeditar3.setForeground(new java.awt.Color(255, 255, 255));
        JLeditar3.setText("Proyectos");

        javax.swing.GroupLayout jpSuperior3Layout = new javax.swing.GroupLayout(jpSuperior3);
        jpSuperior3.setLayout(jpSuperior3Layout);
        jpSuperior3Layout.setHorizontalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSuperior3Layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addComponent(JLeditar3)
                .addGap(266, 266, 266))
        );
        jpSuperior3Layout.setVerticalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperior3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JLeditar3)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Fondo.add(jpSuperior3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 80));

        jLabel1.setText("Presupuesto:");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, 20));

        btnGuardar.setBackground(new java.awt.Color(118, 202, 230));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        Fondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 90, 30));

        test.setEditable(false);
        test.setBackground(new java.awt.Color(255, 255, 255));
        test.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        test.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        test.setFocusable(false);
        Fondo.add(test, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 30, 20));

        tabClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id_cliente", "Nom_cliente", "Tipo_cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabClientes);
        if (tabClientes.getColumnModel().getColumnCount() > 0) {
            tabClientes.getColumnModel().getColumn(0).setResizable(false);
            tabClientes.getColumnModel().getColumn(1).setResizable(false);
            tabClientes.getColumnModel().getColumn(2).setResizable(false);
        }

        Fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 640, 170));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Clientes");
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 85, -1, 30));

        txtPresupuesto.setBackground(new java.awt.Color(194, 209, 202));
        txtPresupuesto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPresupuesto.setBorder(null);
        Fondo.add(txtPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 160, 20));

        txtDi.setBackground(new java.awt.Color(194, 209, 202));
        txtDi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDi.setBorder(null);
        Fondo.add(txtDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 30, 20));

        txtMi.setBackground(new java.awt.Color(194, 209, 202));
        txtMi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMi.setBorder(null);
        Fondo.add(txtMi, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 30, 20));

        txtAi.setBackground(new java.awt.Color(194, 209, 202));
        txtAi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAi.setBorder(null);
        Fondo.add(txtAi, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 30, 20));

        txtDf.setBackground(new java.awt.Color(194, 209, 202));
        txtDf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDf.setBorder(null);
        Fondo.add(txtDf, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 30, 20));

        txtMf.setBackground(new java.awt.Color(194, 209, 202));
        txtMf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMf.setBorder(null);
        Fondo.add(txtMf, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 30, 20));

        txtAf.setBackground(new java.awt.Color(194, 209, 202));
        txtAf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAf.setBorder(null);
        Fondo.add(txtAf, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 30, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Día");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 30, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mes");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 30, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Año");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 30, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Día");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 30, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mes");
        Fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 30, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Año");
        Fondo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 30, -1));

        jLabel9.setText("Fecha de fin:");
        Fondo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, 10));

        jLabel10.setText("Fecha de inicio:");
        Fondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, 10));

        txtNombre.setBackground(new java.awt.Color(194, 209, 202));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre.setBorder(null);
        Fondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 160, 20));

        jLabel11.setText("Nombre:");
        Fondo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, 20));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

       guardarProyecto();
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tabClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabClientesMouseClicked
               
        int fila = tabClientes.rowAtPoint(evt.getPoint());
        test.setText(tabClientes.getValueAt(fila, 0).toString());
        
    }//GEN-LAST:event_tabClientesMouseClicked

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
            java.util.logging.Logger.getLogger(agProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agProyectos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel JLeditar3;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpSuperior3;
    private javax.swing.JTable tabClientes;
    private javax.swing.JTextField test;
    private javax.swing.JTextField txtAf;
    private javax.swing.JTextField txtAi;
    private javax.swing.JTextField txtDf;
    private javax.swing.JTextField txtDi;
    private javax.swing.JTextField txtMf;
    private javax.swing.JTextField txtMi;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPresupuesto;
    // End of variables declaration//GEN-END:variables
}
