package Vistas;

import Modelos.Conexion;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sala221
 */
public class FrmIngreso extends javax.swing.JFrame {
//    private Conexion miConexion = new Conexion();
//    private Connection objconexion =  miConexion.Conectar();
//    private String Registro = "";

    /**
     * Creates new form FrmIngreso
     */
    public FrmIngreso() {
      
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo_botones = new javax.swing.ButtonGroup();
        jLabelUsu = new javax.swing.JLabel();
        jLabelcontras = new javax.swing.JLabel();
        jTextUsu = new javax.swing.JTextField();
        jButtonIngreso = new javax.swing.JButton();
        jPasswordContr = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUsu.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabelUsu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsu.setText("Usuario");
        getContentPane().add(jLabelUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 80, -1));

        jLabelcontras.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabelcontras.setForeground(new java.awt.Color(255, 255, 255));
        jLabelcontras.setText("Contraseña");
        getContentPane().add(jLabelcontras, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 100, -1));

        jTextUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUsuActionPerformed(evt);
            }
        });
        getContentPane().add(jTextUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 130, 30));

        jButtonIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sin nombre1.png"))); // NOI18N
        jButtonIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonIngresoMouseClicked(evt);
            }
        });
        jButtonIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 90, 30));

        jPasswordContr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordContrFocusGained(evt);
            }
        });
        jPasswordContr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordContrActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordContr, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 130, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingreso Al Sistema");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 180, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Juridi3.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUsuActionPerformed

    private void jPasswordContrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordContrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordContrActionPerformed

    private void jButtonIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresoActionPerformed
         FormularioUsuarios vtnUsuarios =new FormularioUsuarios();
        vtnUsuarios.setLocationRelativeTo(this);
        vtnUsuarios.setVisible(true);
        
            
    }//GEN-LAST:event_jButtonIngresoActionPerformed

    private void jButtonIngresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonIngresoMouseClicked
         
    }//GEN-LAST:event_jButtonIngresoMouseClicked

    private void jPasswordContrFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordContrFocusGained
       this.jPasswordContr.selectAll();
    }//GEN-LAST:event_jPasswordContrFocusGained

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
            java.util.logging.Logger.getLogger(FrmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmIngreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grupo_botones;
    public javax.swing.JButton jButtonIngreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelUsu;
    private javax.swing.JLabel jLabelcontras;
    public javax.swing.JPasswordField jPasswordContr;
    public javax.swing.JTextField jTextUsu;
    // End of variables declaration//GEN-END:variables
}
