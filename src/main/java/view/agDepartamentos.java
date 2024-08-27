package view;

import controller.Conexion;
import model.*;
import domain.*;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class agDepartamentos extends javax.swing.JFrame {

    DepartamentoDAO dpd = new DepartamentoDAO();
    
    //ICONOS
    ImageIcon iconCheck = new ImageIcon("src/main/java/icons/check.png");
    ImageIcon iconError = new ImageIcon("src/main/java/icons/error.png");
    ImageIcon iconWarning = new ImageIcon("src/main/java/icons/warning.png");
    //-----

    public agDepartamentos() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 450);
        validate();
        setTitle("Agregar Departamentos");
    }

    

    public boolean validarCamposVacios() {
        if (txtNombre.getText().isEmpty() || txtEncargado.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void limpiar() {
        txtNombre.setText("");
        txtEncargado.setText("");
        txtDescripcion.setText("");
    }

    public void guardarDepartamento() {

        if (!validarCamposVacios()) {

            String nom = txtNombre.getText();
            String enc = txtEncargado.getText();
            String desc = txtDescripcion.getText();

            Departamento dp = new Departamento();
            dp.setNombreDepartamento(nom);
            dp.setEncargado(enc);
            dp.setDescripcion(desc);

            dpd.agregarDepartamento(dp);
           
            limpiar();
            JOptionPane.showMessageDialog(null, "Departamento guardado", "Agregar departamento", JOptionPane.INFORMATION_MESSAGE, iconCheck);

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
        txtEncargado = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

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
        JLeditar3.setText("Departamentos");

        javax.swing.GroupLayout jpSuperior3Layout = new javax.swing.GroupLayout(jpSuperior3);
        jpSuperior3.setLayout(jpSuperior3Layout);
        jpSuperior3Layout.setHorizontalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSuperior3Layout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(JLeditar3)
                .addGap(218, 218, 218))
        );
        jpSuperior3Layout.setVerticalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSuperior3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(JLeditar3)
                .addGap(15, 15, 15))
        );

        Fondo.add(jpSuperior3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 80));

        txtNombre.setBackground(new java.awt.Color(194, 209, 202));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre.setBorder(null);
        Fondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 280, 30));

        txtEncargado.setBackground(new java.awt.Color(194, 209, 202));
        txtEncargado.setActionCommand("<Not Set>");
        txtEncargado.setBorder(null);
        Fondo.add(txtEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 280, 30));

        txtDescripcion.setBackground(new java.awt.Color(194, 209, 202));
        txtDescripcion.setBorder(null);
        Fondo.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 280, 30));

        jLabel1.setText("Nombre:");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 30));

        jLabel2.setText("Encargado:");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 70, 30));

        jLabel3.setText("Descripción:");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, 30));

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
        Fondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 90, 30));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    
        guardarDepartamento();
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
            java.util.logging.Logger.getLogger(agDepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agDepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agDepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agDepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agDepartamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel JLeditar3;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jpSuperior3;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEncargado;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
