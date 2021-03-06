/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoria.gui;

/**
 *
 * @author Beatriz
 */
import tutoria.acceso.bd.Base;

public class ObjetosAprendizaje extends javax.swing.JFrame {

    /**
     * Creates new form ObjetosAprendizaje
     */
    public ObjetosAprendizaje() {
        initComponents();
    }

    public void setUsuario(String usuario) {
        LblUsuario.setText(usuario);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtOA1 = new javax.swing.JButton();
        BtOA2 = new javax.swing.JButton();
        BtOA3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BtOA4 = new javax.swing.JButton();
        BtOA5 = new javax.swing.JButton();
        BtOA6 = new javax.swing.JButton();
        BtOA7 = new javax.swing.JButton();
        BtSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Unidad 1 - Simulacion y Modelos")));

        BtOA1.setText("OA01: Definicion de Simulacion");
        BtOA1.setToolTipText("BtOA1");
        BtOA1.setName("Definicion de Simulacion"); // NOI18N
        BtOA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtOA1ActionPerformed(evt);
            }
        });

        BtOA2.setText("OA02: Definicion de Modelos");
        BtOA2.setName("Definición de Modelos"); // NOI18N
        BtOA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtOA2ActionPerformed(evt);
            }
        });

        BtOA3.setText("OA03: Lenguajes de Programacion de Simulación");
        BtOA3.setToolTipText("");
        BtOA3.setActionCommand("OA03: Lenguajes de Programacion de Simulación");
        BtOA3.setName("Lenguajes de Programacion de Simulación"); // NOI18N
        BtOA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtOA3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtOA3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtOA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtOA1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtOA1)
                .addGap(17, 17, 17)
                .addComponent(BtOA2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtOA3)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidad 2 - Etapas del Desarrollo de Experimentos de Simulacion"));

        BtOA4.setText("OA04: Identificacion de problemas y objetivos");
        BtOA4.setName("Identificacion de problemas y objetivos"); // NOI18N
        BtOA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtOA4ActionPerformed(evt);
            }
        });

        BtOA5.setText("OA05: Diseño y construccion del modelo");
        BtOA5.setActionCommand("OA05: Diseño y construccion del modelo");
        BtOA5.setName("Diseño y construccion del modelo"); // NOI18N
        BtOA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtOA5ActionPerformed(evt);
            }
        });

        BtOA6.setText("OA06: Diseño de experimentos");
        BtOA6.setActionCommand("OA06: Diseño de experimentos");
        BtOA6.setName("Diseño de experimentos"); // NOI18N
        BtOA6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtOA6ActionPerformed(evt);
            }
        });

        BtOA7.setText("OA07: Complementacion e implementacion del proyecto");
        BtOA7.setActionCommand("OA07: Complementacion e implementacion del proyecto");
        BtOA7.setName("Complementacion e implementacion del proyecto"); // NOI18N
        BtOA7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtOA7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtOA5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtOA4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtOA6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtOA7))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BtOA4)
                .addGap(18, 18, 18)
                .addComponent(BtOA5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtOA6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtOA7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtSalir.setText("Salir");
        BtSalir.setToolTipText("BtSalir");
        BtSalir.setName("BtSalir"); // NOI18N
        BtSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtSalir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(LblUsuario)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_BtSalirActionPerformed

    private void BtOA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtOA1ActionPerformed
        Base oBase = new Base();
        oBase.InsertarLog(BtOA1.getName(), LblUsuario.getText());
    }//GEN-LAST:event_BtOA1ActionPerformed

    private void BtOA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtOA2ActionPerformed
        Base oBase = new Base();
        oBase.InsertarLog(BtOA2.getName(), LblUsuario.getText()); 
    }//GEN-LAST:event_BtOA2ActionPerformed

    private void BtOA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtOA3ActionPerformed
        Base oBase = new Base();
        oBase.InsertarLog(BtOA3.getName(), LblUsuario.getText()); 
    }//GEN-LAST:event_BtOA3ActionPerformed

    private void BtOA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtOA4ActionPerformed
        Base oBase = new Base();
        oBase.InsertarLog(BtOA4.getName(), LblUsuario.getText()); 
    }//GEN-LAST:event_BtOA4ActionPerformed

    private void BtOA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtOA5ActionPerformed
        Base oBase = new Base();
        oBase.InsertarLog(BtOA5.getName(), LblUsuario.getText()); 
    }//GEN-LAST:event_BtOA5ActionPerformed

    private void BtOA6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtOA6ActionPerformed
        Base oBase = new Base();
        oBase.InsertarLog(BtOA6.getName(), LblUsuario.getText()); 
    }//GEN-LAST:event_BtOA6ActionPerformed

    private void BtOA7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtOA7ActionPerformed
        Base oBase = new Base();
        oBase.InsertarLog(BtOA7.getName(), LblUsuario.getText()); 
    }//GEN-LAST:event_BtOA7ActionPerformed

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
            java.util.logging.Logger.getLogger(ObjetosAprendizaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObjetosAprendizaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObjetosAprendizaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObjetosAprendizaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ObjetosAprendizaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtOA1;
    private javax.swing.JButton BtOA2;
    private javax.swing.JButton BtOA3;
    private javax.swing.JButton BtOA4;
    private javax.swing.JButton BtOA5;
    private javax.swing.JButton BtOA6;
    private javax.swing.JButton BtOA7;
    private javax.swing.JButton BtSalir;
    private javax.swing.JLabel LblUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
