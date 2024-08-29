package view;

import controller.Conexion;
import domain.Cliente;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class EditarClientes extends javax.swing.JFrame {

    ClienteDAO cd = new ClienteDAO();

    //ICONOS
    ImageIcon iconCheck = new ImageIcon("src/main/java/icons/check.png");
    ImageIcon iconError = new ImageIcon("src/main/java/icons/error.png");
    ImageIcon iconWarning = new ImageIcon("src/main/java/icons/warning.png");
    //-----

    public EditarClientes() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Editar Clientes");
        listarClientes();
    }

    public void limpiar() {
        auxIDcliente.setText("");
        ecTxtNombre.setText("");
        ecTxtEmail.setText("");
        ecTxtTelefono.setText("");
        ecTxtTipoCliente.setText("");

    }
//------------------------------------------------------------------------------

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
    
    public void listarClientes() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) ecTablaClientes.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

        try {
            conn = Conexion.getConnection();

            String SQL_SELECT = "SELECT id_cliente, nombre_cliente, email, telefono, id_tipoCliente FROM Clientes";
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_cliente");
                fila[1] = rs.getString("nombre_cliente");
                fila[2] = rs.getString("email");
                fila[3] = rs.getString("telefono");
                fila[4] = rs.getInt("id_tipoCliente");

                modeloTabla.addRow(fila); // Agregar la fila a la tabla
            }
            
            centrarTextoEnTabla(ecTablaClientes);
            
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

    public boolean camposVacios() {

        if (auxIDcliente.getText().isEmpty() || ecTxtNombre.getText().isEmpty() || ecTxtEmail.getText().isEmpty() || ecTxtTelefono.getText().isEmpty() || ecTxtTipoCliente.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void edEditar() {
        // Obtener los datos de los text field
        if (!camposVacios()) {
            int idCliente = Integer.parseInt(auxIDcliente.getText());
            String nombre = ecTxtNombre.getText();
            String email = ecTxtEmail.getText();
            String tel = ecTxtTelefono.getText();
            int idTipCliente = Integer.parseInt(ecTxtTipoCliente.getText());

            Cliente cl = new Cliente();
            cl.setIdCliente(idCliente);
            cl.setNombreCliente(nombre);
            cl.setEmail(email);
            cl.setTelefono(tel);
            cl.setIdTipoCliente(idTipCliente);

            cd.actualizarCliente(cl);
            listarClientes();
            JOptionPane.showMessageDialog(null, "Cliente actualizado", "Actualizar", JOptionPane.INFORMATION_MESSAGE, iconCheck);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no seleccionado", "Advertencia", JOptionPane.INFORMATION_MESSAGE, iconWarning);
        }

    }

    public void edEliminarClientes() {
        //Obtener los datos de los text field
        if (!camposVacios()) {
            int idCliente = Integer.parseInt(auxIDcliente.getText());
            String nombre = ecTxtNombre.getText();
            String email = ecTxtEmail.getText();
            String tel = ecTxtTelefono.getText();
            int idTipCliente = Integer.parseInt(ecTxtTipoCliente.getText());

            Cliente cl = new Cliente();//Crear un usuario temporal
            cl.setIdCliente(idCliente);
            cl.setNombreCliente(nombre);
            cl.setEmail(email);
            cl.setTelefono(tel);
            cl.setIdTipoCliente(idTipCliente);

            cd.eliminarCliente(cl);
            listarClientes();
            JOptionPane.showMessageDialog(null, "Usuario eliminado", "Eliminar", JOptionPane.INFORMATION_MESSAGE, iconCheck);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no seleccionado", "Advertencia", JOptionPane.INFORMATION_MESSAGE, iconWarning);
        }

    }

//------------------------------------------------------------------------------    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jpSuperior3 = new javax.swing.JPanel();
        JLeditar5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ecTablaClientes = new javax.swing.JTable();
        ecTxtNombre = new javax.swing.JTextField();
        ecTxtTipoCliente = new javax.swing.JTextField();
        ecTxtEmail = new javax.swing.JTextField();
        ecTxtTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        auxIDcliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior3.setBackground(new java.awt.Color(41, 56, 57));

        JLeditar5.setBackground(new java.awt.Color(255, 255, 255));
        JLeditar5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JLeditar5.setForeground(new java.awt.Color(255, 255, 255));
        JLeditar5.setText("Editar Clientes");

        javax.swing.GroupLayout jpSuperior3Layout = new javax.swing.GroupLayout(jpSuperior3);
        jpSuperior3.setLayout(jpSuperior3Layout);
        jpSuperior3Layout.setHorizontalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSuperior3Layout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addComponent(JLeditar5)
                .addGap(223, 223, 223))
        );
        jpSuperior3Layout.setVerticalGroup(
            jpSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSuperior3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(JLeditar5)
                .addGap(15, 15, 15))
        );

        Fondo.add(jpSuperior3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 80));

        ecTablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id_Cliente", "Nombre", "Email", "Telefono", "Id_TipoCliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ecTablaClientes.setGridColor(new java.awt.Color(255, 255, 255));
        ecTablaClientes.setSelectionBackground(new java.awt.Color(250, 195, 200));
        ecTablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ecTablaClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ecTablaClientes);

        Fondo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 680, 240));

        ecTxtNombre.setBackground(new java.awt.Color(194, 209, 202));
        ecTxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ecTxtNombre.setBorder(null);
        Fondo.add(ecTxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 120, 20));

        ecTxtTipoCliente.setBackground(new java.awt.Color(194, 209, 202));
        ecTxtTipoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ecTxtTipoCliente.setBorder(null);
        Fondo.add(ecTxtTipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 120, 20));

        ecTxtEmail.setBackground(new java.awt.Color(194, 209, 202));
        ecTxtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ecTxtEmail.setBorder(null);
        Fondo.add(ecTxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 120, 20));

        ecTxtTelefono.setBackground(new java.awt.Color(194, 209, 202));
        ecTxtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ecTxtTelefono.setBorder(null);
        Fondo.add(ecTxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 120, 20));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Id Tipo Cliente");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 120, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 380, 120, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Email");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 120, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Telefono");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 120, -1));

        auxIDcliente.setEditable(false);
        auxIDcliente.setBackground(new java.awt.Color(194, 209, 202));
        auxIDcliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        auxIDcliente.setBorder(null);
        auxIDcliente.setFocusable(false);
        Fondo.add(auxIDcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 40, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Id_Cliente");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 420, 60, -1));

        btnEliminar.setBackground(new java.awt.Color(118, 202, 230));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        Fondo.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 110, 50));

        btnEditar.setBackground(new java.awt.Color(118, 202, 230));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        Fondo.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 110, 50));

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

    private void ecTablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ecTablaClientesMouseClicked

        int fila = ecTablaClientes.rowAtPoint(evt.getPoint());

        auxIDcliente.setText(ecTablaClientes.getValueAt(fila, 0).toString());
        ecTxtNombre.setText(ecTablaClientes.getValueAt(fila, 1).toString());
        ecTxtEmail.setText(ecTablaClientes.getValueAt(fila, 2).toString());
        ecTxtTelefono.setText(ecTablaClientes.getValueAt(fila, 3).toString());
        ecTxtTipoCliente.setText(ecTablaClientes.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_ecTablaClientesMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        edEliminarClientes();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        edEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel JLeditar5;
    private javax.swing.JTextField auxIDcliente;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JTable ecTablaClientes;
    private javax.swing.JTextField ecTxtEmail;
    private javax.swing.JTextField ecTxtNombre;
    private javax.swing.JTextField ecTxtTelefono;
    private javax.swing.JTextField ecTxtTipoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpSuperior3;
    // End of variables declaration//GEN-END:variables
}
