package view;

import controller.Conexion;
import model.*;
import domain.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class agClientes extends javax.swing.JFrame {

    ClienteDAO cld = new ClienteDAO();
    private Map<String, Integer> tiposClienteMap = new HashMap<>();
    private int idTipoCliente;
    
    //ICONOS
    ImageIcon iconCheck = new ImageIcon("src/main/java/icons/check.png");
    ImageIcon iconError = new ImageIcon("src/main/java/icons/error.png");
    ImageIcon iconWarning = new ImageIcon("src/main/java/icons/warning.png");
    //-----

    public agClientes() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 500);
        validate();
        setTitle("Agregar Clientes");
        listarTipoCliente();
    }
//------------------------------------------------------------------------------

    private void listarTipoCliente() {
        //Este metodo lista los Tipos de usuario  y los almacena en una HashMAP y pone como opcion la descripcion del tipo de cliente
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String SQL_SELECT = "SELECT id_tipoCliente, descripcion FROM Tipo_Cliente";

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_tipoCliente");
                String descripcion = rs.getString("descripcion");
                tiposClienteMap.put(descripcion, id);
                jComboBox1.addItem(descripcion);
            }

        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar tipos de usuario");
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
        if (txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void limpiar() {
        txtNombre.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        idTipoCliente = 0;
    }

    public void guardarCliente() {

        if (!validarCamposVacios()) {

            String nom = txtNombre.getText();
            String email = txtEmail.getText();
            String tel = txtTelefono.getText();

            Cliente cl = new Cliente();
            cl.setNombreCliente(nom);
            cl.setEmail(email);
            cl.setTelefono(tel);
            cl.setIdTipoCliente(idTipoCliente);

            cld.agregarCliente(cl);
           
            limpiar();
            JOptionPane.showMessageDialog(null, "Usuario guardado", "Agregar usuario", JOptionPane.INFORMATION_MESSAGE, iconCheck);

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
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        test = new javax.swing.JTextField();

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
        JLeditar3.setText("Clientes");

        javax.swing.GroupLayout jpSuperior3Layout = new javax.swing.GroupLayout(jpSuperior3);
        jpSuperior3.setLayout(jpSuperior3Layout);
        jpSuperior3Layout.setHorizontalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSuperior3Layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(JLeditar3)
                .addGap(277, 277, 277))
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

        txtEmail.setBackground(new java.awt.Color(194, 209, 202));
        txtEmail.setActionCommand("<Not Set>");
        txtEmail.setBorder(null);
        Fondo.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 280, 30));

        txtTelefono.setBackground(new java.awt.Color(194, 209, 202));
        txtTelefono.setBorder(null);
        Fondo.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 280, 30));

        jComboBox1.setBackground(new java.awt.Color(194, 209, 202));
        jComboBox1.setBorder(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        Fondo.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 150, 30));

        jLabel1.setText("Nombre:");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, 30));

        jLabel2.setText("Email:");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 190, 40, 30));

        jLabel3.setText("Telefono:");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tipo cliente");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 150, -1));

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
        Fondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 90, 30));

        test.setEditable(false);
        test.setBackground(new java.awt.Color(194, 209, 202));
        test.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        test.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        test.setFocusable(false);
        Fondo.add(test, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 342, 40, 30));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        String descTipoCliente = (String) jComboBox1.getSelectedItem();
        idTipoCliente = tiposClienteMap.get(descTipoCliente);
        test.setText(Integer.toString(idTipoCliente));
        //System.out.println("ID seleccionado: " + idTipoCliente);

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    
        guardarCliente();
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(agClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agClientes().setVisible(true);
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
    private javax.swing.JPanel jpSuperior3;
    private javax.swing.JTextField test;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
