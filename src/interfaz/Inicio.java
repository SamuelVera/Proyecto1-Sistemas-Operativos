package interfaz;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.Main;

public class Inicio extends javax.swing.JFrame {

    public Inicio() throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        m = new Main();
        m.execute();
    }

    public Main m;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text1 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        eliminate = new javax.swing.JButton();
        add = new javax.swing.JButton();
        text3 = new javax.swing.JLabel();
        text4 = new javax.swing.JLabel();
        text5 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        text1.setText("Productores:");
        getContentPane().add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 140, 20));

        text2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        text2.setText("Almacen");
        getContentPane().add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 70, 20));

        eliminate.setText("-");
        eliminate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminateActionPerformed(evt);
            }
        });
        getContentPane().add(eliminate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        add.setText("+");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        text3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        getContentPane().add(text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 100, 20));

        text4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        text4.setText("Baterías:");
        getContentPane().add(text4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 100, 20));

        text5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        getContentPane().add(text5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 100, 20));

        close.setText("Cerrar");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if(m.productores[0] == 4){
            
        }else{
            m.productores[0]++;
            Inicio.text1.setText("Productores: "+m.productores[0]);
            //Código para abrir hilos
        }
    }//GEN-LAST:event_addActionPerformed

    private void eliminateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminateActionPerformed
        if(m.productores[0] == 0){
            
        }else{
            m.productores[0]--;
            Inicio.text1.setText("Productores: "+m.productores[0]);
            //Código para cerrar hilos
        }
    }//GEN-LAST:event_eliminateActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        try {
            m.terminate();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_closeActionPerformed

    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inicio().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton close;
    private javax.swing.JButton eliminate;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    public static javax.swing.JLabel text3;
    public static javax.swing.JLabel text4;
    public static javax.swing.JLabel text5;
    // End of variables declaration//GEN-END:variables
}
