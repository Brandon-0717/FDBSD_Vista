package view;

import controller.Conexion;
import domain.Salarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SalariosDAO;
import static view.coBitacoras.centrarTextoEnTabla;

public class agSalarios extends javax.swing.JFrame {

    SalariosDAO sld = new SalariosDAO();

    //ICONOS
    ImageIcon iconCheck = new ImageIcon("src/main/java/icons/check.png");
    ImageIcon iconError = new ImageIcon("src/main/java/icons/error.png");
    ImageIcon iconWarning = new ImageIcon("src/main/java/icons/warning.png");
    //-----

    public agSalarios() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Agregar Salarios");
    }

    public void limpiar() {
        txtDia.setText("");
        txtMes.setText("");
        txtAño.setText("");
        txtMonto.setText("");
        txtPeriodo.setText("");
        auxID.setText("");
    }

    public void listarTrabajadores() {//Se listan al abrir esta ventana desde menu agregar

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tabTrabajadores.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

        try {
            conn = Conexion.getConnection();

            // Consulta SQL para obtener los datos requeridos
            String SQL_SELECT
                    = "SELECT t.id_trabajador, d.nombre_departamento, t.nombre_trabajador, t.cedula "
                    + "FROM Trabajadores t "
                    + "JOIN Departamentos d ON t.id_departamento = d.id_departamento";

            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("id_trabajador");
                fila[1] = rs.getString("nombre_departamento");
                fila[2] = rs.getString("nombre_trabajador");
                fila[3] = rs.getString("cedula");

                modeloTabla.addRow(fila); // Agregar la fila a la tabla
            }

            // Centrar el texto en la tabla
            centrarTextoEnTabla(tabTrabajadores);//Este metodo esta estatico en "coBitacoras"

        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar trabajadores");
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

    // Métodos para obtener la fecha desde JTextField
    public Date obtenerFecha() {
        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int ano = Integer.parseInt(txtAño.getText());

        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {//si la fecha es invalida no se retorna una fecha y se retorna null
            JOptionPane.showMessageDialog(null, "Fecha inválida", "Error de fecha", JOptionPane.INFORMATION_MESSAGE, iconError);
            return null;
        }

        try {
            // Crear una instancia de LocalDate
            LocalDate localDate = LocalDate.of(ano, mes, dia);
            // Convertir LocalDate a java.sql.Date
            return Date.valueOf(localDate);
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida", "Error de fecha", JOptionPane.INFORMATION_MESSAGE, iconError);
            return null;
        }
    }

    public boolean camposVacios() {

        if (txtDia.getText().isEmpty() || txtMes.getText().isEmpty() || txtAño.getText().isEmpty()
                || txtMonto.getText().isEmpty() || txtPeriodo.getText().isEmpty() || auxID.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public void guardarSalario() {

        if (!camposVacios()) {// si no hay campos vacios se sigue

            Date fecha = obtenerFecha();

            if (fecha != null) {// si la fecha no es null se sigue

                float monto = Float.parseFloat(txtMonto.getText());
                String periodo = txtPeriodo.getText();
                int auxIdTrabajador = Integer.parseInt(auxID.getText());

                //Tras validar que la fecha este bien y no haya campos vacios se crea un salario para agregar sus datos
                Salarios salario = new Salarios();

                salario.setIdTrabajador(auxIdTrabajador);
                salario.setFechaPago(fecha);
                salario.setMonto(monto);
                salario.setPeriodo(periodo);

                sld.agregarSalario(salario);//Y por ultimo se agrega el salario
                limpiar();
                JOptionPane.showMessageDialog(null, "Salario guardado", "Salario almacenado", JOptionPane.INFORMATION_MESSAGE, iconCheck);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Campos invalidos", JOptionPane.INFORMATION_MESSAGE, iconWarning);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jpSuperior3 = new javax.swing.JPanel();
        JLeditar3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabTrabajadores = new javax.swing.JTable();
        txtMonto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtAño = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPeriodo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        auxID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior3.setBackground(new java.awt.Color(41, 56, 57));

        JLeditar3.setBackground(new java.awt.Color(255, 255, 255));
        JLeditar3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JLeditar3.setForeground(new java.awt.Color(255, 255, 255));
        JLeditar3.setText("Salarios");

        javax.swing.GroupLayout jpSuperior3Layout = new javax.swing.GroupLayout(jpSuperior3);
        jpSuperior3.setLayout(jpSuperior3Layout);
        jpSuperior3Layout.setHorizontalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperior3Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(JLeditar3)
                .addContainerGap(288, Short.MAX_VALUE))
        );
        jpSuperior3Layout.setVerticalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperior3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(JLeditar3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Fondo.add(jpSuperior3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 80));

        tabTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_trabajador", "Departamento", "Nom_trabajador", "cedula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabTrabajadores.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tabTrabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTrabajadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabTrabajadores);
        if (tabTrabajadores.getColumnModel().getColumnCount() > 0) {
            tabTrabajadores.getColumnModel().getColumn(0).setResizable(false);
            tabTrabajadores.getColumnModel().getColumn(1).setResizable(false);
            tabTrabajadores.getColumnModel().getColumn(2).setResizable(false);
            tabTrabajadores.getColumnModel().getColumn(3).setResizable(false);
        }

        Fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 640, 150));

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        Fondo.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 180, -1));

        jLabel1.setText("Monto:");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        txtDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Fondo.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 70, -1));

        txtMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Fondo.add(txtMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 70, -1));

        txtAño.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Fondo.add(txtAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 70, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Día");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 40, -1));

        jLabel3.setText("Mes");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        jLabel4.setText("Año");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        jLabel6.setText("Periodo:");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));
        Fondo.add(txtPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 180, -1));

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
        Fondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 90, 30));

        auxID.setEditable(false);
        auxID.setBackground(new java.awt.Color(255, 255, 255));
        auxID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Fondo.add(auxID, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 40, -1));

        jLabel7.setText("Trabajadores");
        Fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        guardarSalario();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tabTrabajadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTrabajadoresMouseClicked

        int fila = tabTrabajadores.rowAtPoint(evt.getPoint());
        auxID.setText(tabTrabajadores.getValueAt(fila, 0).toString());

    }//GEN-LAST:event_tabTrabajadoresMouseClicked

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
            java.util.logging.Logger.getLogger(agSalarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agSalarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agSalarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agSalarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agSalarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel JLeditar3;
    private javax.swing.JTextField auxID;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpSuperior3;
    private javax.swing.JTable tabTrabajadores;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
