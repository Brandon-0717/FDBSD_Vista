package view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class menuConsultar extends javax.swing.JPanel {

    coBitacoras bt = new coBitacoras();
    coProyectosEnCurso pec = new coProyectosEnCurso();
    coProyectos pr = new coProyectos();
    
    //ICONOS
    ImageIcon iconElegir = new ImageIcon("src/main/java/icons/Elegir.png");
    //-----
   
    public menuConsultar() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpSuperior = new javax.swing.JPanel();
        JLeditar = new javax.swing.JLabel();
        btnProyectos2 = new javax.swing.JButton();
        btnProyectos1 = new javax.swing.JButton();
        btnBitacora1 = new javax.swing.JButton();
        btnProyectos = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jpSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnProyectos2.setBackground(new java.awt.Color(187, 201, 170));
        btnProyectos2.setText("Salarios Trabajadores");
        btnProyectos2.setBorder(null);
        btnProyectos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProyectos2.setFocusPainted(false);
        btnProyectos2.setPreferredSize(new java.awt.Dimension(210, 100));
        btnProyectos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectos2ActionPerformed(evt);
            }
        });
        add(btnProyectos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 150, 50));

        btnProyectos1.setBackground(new java.awt.Color(187, 201, 170));
        btnProyectos1.setText("Trabajadores por departamento");
        btnProyectos1.setBorder(null);
        btnProyectos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProyectos1.setFocusPainted(false);
        btnProyectos1.setPreferredSize(new java.awt.Dimension(210, 100));
        btnProyectos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectos1ActionPerformed(evt);
            }
        });
        add(btnProyectos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 150, 50));

        btnBitacora1.setBackground(new java.awt.Color(187, 201, 170));
        btnBitacora1.setText("Bitácoras");
        btnBitacora1.setBorder(null);
        btnBitacora1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBitacora1.setFocusPainted(false);
        btnBitacora1.setPreferredSize(new java.awt.Dimension(210, 100));
        btnBitacora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBitacora1ActionPerformed(evt);
            }
        });
        add(btnBitacora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 150, 50));

        btnProyectos.setBackground(new java.awt.Color(187, 201, 170));
        btnProyectos.setText("Proyectos");
        btnProyectos.setBorder(null);
        btnProyectos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProyectos.setFocusPainted(false);
        btnProyectos.setPreferredSize(new java.awt.Dimension(210, 100));
        btnProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectosActionPerformed(evt);
            }
        });
        add(btnProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 98, 150, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectosActionPerformed
        String mopt [] = {"Proyectos","Proyectos en curso"};
        int opt = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Selección",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, iconElegir, mopt, mopt[0]);

        switch(opt){
            case 0:
                pr.setVisible(true);
                pr.listarProyectos();
                break;        
            case 1:
                pec.setVisible(true);
                pec.listarProyectosEnCurso();
                break;     
        }
        
    }//GEN-LAST:event_btnProyectosActionPerformed

    private void btnBitacora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBitacora1ActionPerformed
        
        bt.setVisible(true);
        bt.listarBitacoras();
        
    }//GEN-LAST:event_btnBitacora1ActionPerformed

    private void btnProyectos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProyectos1ActionPerformed

    private void btnProyectos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProyectos2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLeditar;
    private javax.swing.JButton btnBitacora1;
    private javax.swing.JButton btnProyectos;
    private javax.swing.JButton btnProyectos1;
    private javax.swing.JButton btnProyectos2;
    private javax.swing.JPanel jpSuperior;
    // End of variables declaration//GEN-END:variables
}
