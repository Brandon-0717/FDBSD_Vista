package view;

import controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class coProyectosEnCurso extends javax.swing.JFrame {

    public coProyectosEnCurso() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Consultar Proyectos en curso");
        listarProyectosEnCurso();
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

    public void listarProyectosEnCurso() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tabProyectosEnCurso.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

        try {
            conn = Conexion.getConnection();

            // Consulta SQL para obtener los nombres en lugar de los IDs
            String SQL_SELECT
                    = "SELECT p.id_poyectoEnCurso, pr.nombre_proyecto, m.nombre_material, h.nombre_herramienta, q.nombre_maquinaria "
                    + "FROM ProyectosEnCurso p "
                    + "JOIN Proyectos pr ON p.id_proyecto = pr.id_proyecto "
                    + "JOIN Materiales m ON p.id_material = m.id_material "
                    + "JOIN Herramientas h ON p.id_herramienta = h.id_herramienta "
                    + "JOIN Maquinarias q ON p.id_maquinaria = q.id_maquinaria";

            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Crear la fila con los nombres en lugar de los IDs
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_poyectoEnCurso");
                fila[1] = rs.getString("nombre_proyecto");
                fila[2] = rs.getString("nombre_material");
                fila[3] = rs.getString("nombre_herramienta");
                fila[4] = rs.getString("nombre_maquinaria");

                modeloTabla.addRow(fila); // Agregar la fila a la tabla
            }

            // Centrar el texto en la tabla
            centrarTextoEnTabla(tabProyectosEnCurso);

        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar proyectos en curso");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jpSuperior = new javax.swing.JPanel();
        JLeditar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabProyectosEnCurso = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setMinimumSize(new java.awt.Dimension(800, 450));
        Fondo.setPreferredSize(new java.awt.Dimension(800, 500));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior.setBackground(new java.awt.Color(41, 56, 57));

        JLeditar.setBackground(new java.awt.Color(255, 255, 255));
        JLeditar.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JLeditar.setForeground(new java.awt.Color(255, 255, 255));
        JLeditar.setText("Proyectos en curso");

        javax.swing.GroupLayout jpSuperiorLayout = new javax.swing.GroupLayout(jpSuperior);
        jpSuperior.setLayout(jpSuperiorLayout);
        jpSuperiorLayout.setHorizontalGroup(
            jpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSuperiorLayout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(JLeditar)
                .addGap(230, 230, 230))
        );
        jpSuperiorLayout.setVerticalGroup(
            jpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperiorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(JLeditar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Fondo.add(jpSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        tabProyectosEnCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_ProyEnCurso", "NombreProyecto", "Nom_material", "Nom_herramienta", "Nom_maquinaria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabProyectosEnCurso.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setViewportView(tabProyectosEnCurso);
        if (tabProyectosEnCurso.getColumnModel().getColumnCount() > 0) {
            tabProyectosEnCurso.getColumnModel().getColumn(0).setResizable(false);
            tabProyectosEnCurso.getColumnModel().getColumn(1).setResizable(false);
            tabProyectosEnCurso.getColumnModel().getColumn(2).setResizable(false);
            tabProyectosEnCurso.getColumnModel().getColumn(3).setResizable(false);
            tabProyectosEnCurso.getColumnModel().getColumn(4).setResizable(false);
        }

        Fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 760, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(coProyectosEnCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(coProyectosEnCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(coProyectosEnCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(coProyectosEnCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new coProyectosEnCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel JLeditar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpSuperior;
    private javax.swing.JTable tabProyectosEnCurso;
    // End of variables declaration//GEN-END:variables
}
