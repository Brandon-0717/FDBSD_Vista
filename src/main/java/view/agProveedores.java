package view;

import controller.Conexion;
import model.*;
import domain.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class agProveedores extends javax.swing.JFrame {

    ProveedoresDAO prd = new ProveedoresDAO();
    private Map<String, Integer> tiposProveedoresMap = new HashMap<>();
    private int idTipoProveedor;
    
    //ICONOS
    ImageIcon iconCheck = new ImageIcon("src/main/java/icons/check.png");
    ImageIcon iconError = new ImageIcon("src/main/java/icons/error.png");
    ImageIcon iconWarning = new ImageIcon("src/main/java/icons/warning.png");
    //-----

    public agProveedores() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 540);
        validate();
        setTitle("Agregar Proveedores");
        listarTipoProveedor();
        
    }
//------------------------------------------------------------------------------
    private void listarTipoProveedor() {
        //Este metodo lista los Tipos de usuario  y los almacena en una HashMAP y pone como opcion la descripcion del tipo de cliente
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String SQL_SELECT = "SELECT id_tipoProveedor, descripcion FROM Tipo_Proveedor";

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_tipoProveedor");
                String descripcion = rs.getString("descripcion");
                tiposProveedoresMap.put(descripcion, id); //esto agrega el tipo de cliente al MAP
                jComboBox1.addItem(descripcion);
            }

        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar tipos de proveedores");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(conn);
                Conexion.close(ps);
                Conexion.close(rs);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar conexión");
            }
        }
    }

    public boolean validarCamposVacios() {
        if (txtNombre.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtTelefono.getText().isEmpty()|| txtEmail.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void limpiar() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        test.setText("");
        idTipoProveedor = 0;
    }

    public void guardarProveedor() {

        if (!validarCamposVacios()) {

            String nom = txtNombre.getText();
            String dir = txtDireccion.getText();
            String tel = txtTelefono.getText();
            String email = txtEmail.getText();

            Proveedores pr = new Proveedores();
            
            pr.setNombreProveedor(nom);
            pr.setDireccion(dir);
            pr.setTelefono(tel);
            pr.setEmail(email);
            pr.setIdTipoProveedor(idTipoProveedor);

            prd.agregarProveedor(pr);
           
            limpiar();
            JOptionPane.showMessageDialog(null, "Proveedor guardado", "Agregar Proveedor", JOptionPane.INFORMATION_MESSAGE, iconCheck);

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
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        test = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setMinimumSize(new java.awt.Dimension(700, 600));
        Fondo.setPreferredSize(new java.awt.Dimension(700, 500));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior3.setBackground(new java.awt.Color(41, 56, 57));

        JLeditar3.setBackground(new java.awt.Color(255, 255, 255));
        JLeditar3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JLeditar3.setForeground(new java.awt.Color(255, 255, 255));
        JLeditar3.setText("Proveedores");

        javax.swing.GroupLayout jpSuperior3Layout = new javax.swing.GroupLayout(jpSuperior3);
        jpSuperior3.setLayout(jpSuperior3Layout);
        jpSuperior3Layout.setHorizontalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperior3Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(JLeditar3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpSuperior3Layout.setVerticalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperior3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(JLeditar3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Fondo.add(jpSuperior3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 80));

        txtNombre.setBackground(new java.awt.Color(194, 209, 202));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre.setBorder(null);
        Fondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 280, 30));

        txtDireccion.setBackground(new java.awt.Color(194, 209, 202));
        txtDireccion.setActionCommand("<Not Set>");
        txtDireccion.setBorder(null);
        Fondo.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 280, 30));

        jLabel1.setText("Nombre:");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, 30));

        jLabel2.setText("Dirección:");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 60, 30));

        jLabel3.setText("Tipo:");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 50, 30));

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
        Fondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 90, 30));

        txtTelefono.setBackground(new java.awt.Color(194, 209, 202));
        txtTelefono.setBorder(null);
        Fondo.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 280, 30));

        jLabel5.setText("Telefono:");
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, 30));

        txtEmail.setBackground(new java.awt.Color(194, 209, 202));
        txtEmail.setBorder(null);
        Fondo.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 280, 30));

        jLabel4.setText("Email:");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 50, 30));

        jComboBox1.setBackground(new java.awt.Color(194, 209, 202));
        jComboBox1.setBorder(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        Fondo.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 180, 30));

        test.setEditable(false);
        test.setBackground(new java.awt.Color(194, 209, 202));
        test.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        test.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        test.setFocusable(false);
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });
        Fondo.add(test, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 40, 30));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        guardarProveedor();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        String descTipoProveedor = (String) jComboBox1.getSelectedItem();
        idTipoProveedor = tiposProveedoresMap.get(descTipoProveedor);
        test.setText(Integer.toString(idTipoProveedor));
        //System.out.println("ID seleccionado: " + idTipoCliente);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testActionPerformed

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
            java.util.logging.Logger.getLogger(agProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel JLeditar3;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jpSuperior3;
    private javax.swing.JTextField test;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
