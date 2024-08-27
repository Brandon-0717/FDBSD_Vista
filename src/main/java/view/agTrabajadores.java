package view;

import controller.Conexion;
import model.*;
import domain.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class agTrabajadores extends javax.swing.JFrame {

    TrabajadoresDAO tbd = new TrabajadoresDAO();
    private Map<String, Integer> departamentosMAP = new HashMap<>();
    private int idDepartamentoMAP;
    
    //ICONOS
    ImageIcon iconCheck = new ImageIcon("src/main/java/icons/check.png");
    ImageIcon iconError = new ImageIcon("src/main/java/icons/error.png");
    ImageIcon iconWarning = new ImageIcon("src/main/java/icons/warning.png");
    //-----

    public agTrabajadores() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //setSize(700, 540);
        validate();
        setTitle("Agregar Trabajadores");
        listarDepartamentos();
    }
//------------------------------------------------------------------------------

    private void listarDepartamentos() {
        //Este metodo lista los Tipos de usuario  y los almacena en una HashMAP y pone como opcion la descripcion del tipo de cliente
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String SQL_SELECT = "SELECT id_departamento, nombre_departamento FROM Departamentos";

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_departamento");
                String nombreDep = rs.getString("nombre_departamento");
                departamentosMAP.put(nombreDep, id);
                jComboBox1.addItem(nombreDep);
            }

        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar departamentos");
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
        if (txtNombre.getText().isEmpty() ||txtApellido1.getText().isEmpty() ||txtApellido2.getText().isEmpty() || txtCedula.getText().isEmpty() || 
                txtTelefono.getText().isEmpty()|| txtEmail.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void limpiar() {
        txtNombre.setText("");
        txtApellido1.setText("");
        txtApellido2.setText("");
        txtCedula.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        idDepartamentoMAP = 0;
    }

    public void guardarTrabajador() {

        if (!validarCamposVacios()) {
            String nom = txtNombre.getText();
            String ap1 = txtApellido1.getText();
            String ap2 = txtApellido2.getText();
            String ced = txtCedula.getText();
            String tel = txtTelefono.getText();
            String email = txtEmail.getText();
            

            Trabajador tb = new Trabajador();
            tb.setNombreTrabajador(nom);
            tb.setApellido1(ap1);
            tb.setApellido2(ap2);
            tb.setCedula(ced);
            tb.setTelefono(tel);
            tb.setEmail(email);
            tb.setIdDepartamento(idDepartamentoMAP);

            tbd.agregarTrabajador(tb);
           
            limpiar();
            JOptionPane.showMessageDialog(null, "Trabajador guardado", "Trabajador usuario", JOptionPane.INFORMATION_MESSAGE, iconCheck);

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
        txtApellido2 = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        test = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

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
        JLeditar3.setText("Trabajadores");

        javax.swing.GroupLayout jpSuperior3Layout = new javax.swing.GroupLayout(jpSuperior3);
        jpSuperior3.setLayout(jpSuperior3Layout);
        jpSuperior3Layout.setHorizontalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperior3Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(JLeditar3)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jpSuperior3Layout.setVerticalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperior3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(JLeditar3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Fondo.add(jpSuperior3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 80));

        txtApellido2.setBackground(new java.awt.Color(194, 209, 202));
        txtApellido2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellido2.setBorder(null);
        Fondo.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 80, 30));

        txtEmail.setBackground(new java.awt.Color(194, 209, 202));
        txtEmail.setActionCommand("<Not Set>");
        txtEmail.setBorder(null);
        Fondo.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 280, 30));

        txtTelefono.setBackground(new java.awt.Color(194, 209, 202));
        txtTelefono.setBorder(null);
        Fondo.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 280, 30));

        jComboBox1.setBackground(new java.awt.Color(194, 209, 202));
        jComboBox1.setBorder(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        Fondo.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 200, 30));

        jLabel1.setText("Ap2:");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, 30));

        jLabel2.setText("Email:");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 40, 30));

        jLabel3.setText("Telefono:");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Departamento:");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 100, 30));

        btnGuardar.setBackground(new java.awt.Color(118, 202, 230));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        Fondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 90, 30));

        test.setEditable(false);
        test.setBackground(new java.awt.Color(194, 209, 202));
        test.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        test.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        test.setFocusable(false);
        Fondo.add(test, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 40, 30));

        txtNombre.setBackground(new java.awt.Color(194, 209, 202));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre.setBorder(null);
        Fondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 120, 30));

        txtApellido1.setBackground(new java.awt.Color(194, 209, 202));
        txtApellido1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellido1.setBorder(null);
        Fondo.add(txtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 80, 30));

        jLabel5.setText("Nombre:");
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 30));

        jLabel6.setText("Ap1:");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, 30));

        txtCedula.setBackground(new java.awt.Color(194, 209, 202));
        txtCedula.setBorder(null);
        Fondo.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 280, 30));

        jLabel7.setText("Cédula:");
        Fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, 30));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        String nombreDepartamento = (String) jComboBox1.getSelectedItem();
        idDepartamentoMAP = departamentosMAP.get(nombreDepartamento);
        test.setText(Integer.toString(idDepartamentoMAP));
        //System.out.println("ID seleccionado: " + idTipoCliente);

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    
        guardarTrabajador();
        
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
            java.util.logging.Logger.getLogger(agTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agTrabajadores().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jpSuperior3;
    private javax.swing.JTextField test;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
