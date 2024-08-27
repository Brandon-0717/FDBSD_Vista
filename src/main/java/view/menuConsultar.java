package view;

public class menuConsultar extends javax.swing.JPanel {

    public menuConsultar() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jpSuperior = new javax.swing.JPanel();
        JLeditar = new javax.swing.JLabel();
        btnProyectos = new javax.swing.JButton();
        btnBitacora1 = new javax.swing.JButton();
        btnProyectos1 = new javax.swing.JButton();
        btnProyectos2 = new javax.swing.JButton();

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior.setBackground(new java.awt.Color(41, 56, 57));

        JLeditar.setBackground(new java.awt.Color(255, 255, 255));
        JLeditar.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JLeditar.setForeground(new java.awt.Color(255, 255, 255));
        JLeditar.setText("Consultar");

        javax.swing.GroupLayout jpSuperiorLayout = new javax.swing.GroupLayout(jpSuperior);
        jpSuperior.setLayout(jpSuperiorLayout);
        jpSuperiorLayout.setHorizontalGroup(
            jpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperiorLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(JLeditar)
                .addContainerGap(285, Short.MAX_VALUE))
        );
        jpSuperiorLayout.setVerticalGroup(
            jpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperiorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(JLeditar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Fondo.add(jpSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnProyectos.setBackground(new java.awt.Color(187, 201, 170));
        btnProyectos.setText("Proyectos");
        btnProyectos.setBorder(null);
        btnProyectos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProyectos.setPreferredSize(new java.awt.Dimension(210, 100));
        btnProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectosActionPerformed(evt);
            }
        });
        Fondo.add(btnProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 98, 150, 50));

        btnBitacora1.setBackground(new java.awt.Color(187, 201, 170));
        btnBitacora1.setText("Bitácoras");
        btnBitacora1.setBorder(null);
        btnBitacora1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBitacora1.setPreferredSize(new java.awt.Dimension(210, 100));
        btnBitacora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBitacora1ActionPerformed(evt);
            }
        });
        Fondo.add(btnBitacora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 418, 150, 50));

        btnProyectos1.setBackground(new java.awt.Color(187, 201, 170));
        btnProyectos1.setText("Trabajadores por departamento");
        btnProyectos1.setBorder(null);
        btnProyectos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProyectos1.setPreferredSize(new java.awt.Dimension(210, 100));
        btnProyectos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectos1ActionPerformed(evt);
            }
        });
        Fondo.add(btnProyectos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 98, 150, 50));

        btnProyectos2.setBackground(new java.awt.Color(187, 201, 170));
        btnProyectos2.setText("Proyectos por cliente");
        btnProyectos2.setBorder(null);
        btnProyectos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProyectos2.setPreferredSize(new java.awt.Dimension(210, 100));
        btnProyectos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectos2ActionPerformed(evt);
            }
        });
        Fondo.add(btnProyectos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 98, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProyectosActionPerformed

    private void btnBitacora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBitacora1ActionPerformed
        
        
        
    }//GEN-LAST:event_btnBitacora1ActionPerformed

    private void btnProyectos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProyectos1ActionPerformed

    private void btnProyectos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProyectos2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel JLeditar;
    private javax.swing.JButton btnBitacora1;
    private javax.swing.JButton btnProyectos;
    private javax.swing.JButton btnProyectos1;
    private javax.swing.JButton btnProyectos2;
    private javax.swing.JPanel jpSuperior;
    // End of variables declaration//GEN-END:variables
}
