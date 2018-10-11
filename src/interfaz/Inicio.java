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

        close = new javax.swing.JButton();
        prodBat = new javax.swing.JLabel();
        prodPan = new javax.swing.JLabel();
        prodCab = new javax.swing.JLabel();
        ensNum = new javax.swing.JLabel();
        bat = new javax.swing.JLabel();
        pan = new javax.swing.JLabel();
        cab = new javax.swing.JLabel();
        geren = new javax.swing.JLabel();
        crono = new javax.swing.JLabel();
        j = new javax.swing.JLabel();
        eliminarPBat = new javax.swing.JButton();
        agregarPBat = new javax.swing.JButton();
        agregarPPan = new javax.swing.JButton();
        eliminarPPan = new javax.swing.JButton();
        agregarPCab = new javax.swing.JButton();
        eliminarPCab = new javax.swing.JButton();
        agregarEns = new javax.swing.JButton();
        eliminarEns = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setText("Cerrar");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));
        getContentPane().add(prodBat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 280, 10));
        getContentPane().add(prodPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 290, 10));
        getContentPane().add(prodCab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 290, 10));
        getContentPane().add(ensNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 290, 10));

        bat.setText("Baterías: ");
        getContentPane().add(bat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 290, -1));

        pan.setText("Pantallas:");
        getContentPane().add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 290, -1));

        cab.setText("Cables:");
        getContentPane().add(cab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 290, -1));

        geren.setText("El gerente esta");
        getContentPane().add(geren, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 290, -1));

        crono.setText("El cronometrador está haciendo es NADA");
        getContentPane().add(crono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 290, -1));

        j.setText("jLabel1");
        getContentPane().add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 290, -1));

        eliminarPBat.setText("-");
        eliminarPBat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPBatActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarPBat, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 40, -1));

        agregarPBat.setText("+");
        agregarPBat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPBatActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPBat, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 40, -1));

        agregarPPan.setText("+");
        agregarPPan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPPanActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 40, -1));

        eliminarPPan.setText("-");
        eliminarPPan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPPanActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarPPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 40, -1));

        agregarPCab.setText("+");
        agregarPCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPCabActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPCab, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 40, -1));

        eliminarPCab.setText("-");
        eliminarPCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPCabActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarPCab, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        agregarEns.setText("+");
        agregarEns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEnsActionPerformed(evt);
            }
        });
        getContentPane().add(agregarEns, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 40, -1));

        eliminarEns.setText("-");
        eliminarEns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEnsActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarEns, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 40, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        try {
            m.terminate();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_closeActionPerformed

    private void agregarPBatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPBatActionPerformed
        if(m.pBat+1 > m.productoresMaxBat[0]){
            System.out.println("Máximo de productores de bateria alcanzado"); //Cambiar por un JOptionPane
        }else{
            m.pBat++;
            Inicio.prodBat.setText("Productores de baterías: "+m.pBat);
        }
    }//GEN-LAST:event_agregarPBatActionPerformed

    private void eliminarPBatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPBatActionPerformed
        if(m.pBat-1 < 0){
            System.out.println("Error: Productores negativos"); //Cambiar por un JOptionPane
        }else{
            m.pBat--;
            Inicio.prodBat.setText("Productores de baterías: "+m.pBat);
        }
    }//GEN-LAST:event_eliminarPBatActionPerformed

    private void agregarPPanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPPanActionPerformed
        if(m.pPan+1 > m.productoresMaxPan[0]){
            System.out.println("Máximo de productores de pantallas alcanzado"); //Cambiar por un JOptionPane
        }else{
            m.pPan++;
            Inicio.prodPan.setText("Productores de pantallas: "+m.pPan);
        }
    }//GEN-LAST:event_agregarPPanActionPerformed

    private void eliminarPPanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPPanActionPerformed
        if(m.pPan-1 < 0){
            System.out.println("Error: Productores negativos"); //Cambiar por un JOptionPane
        }else{
            m.pPan--;
            Inicio.prodPan.setText("Productores de pantallas: "+m.pPan);
        }
    }//GEN-LAST:event_eliminarPPanActionPerformed

    private void agregarPCabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPCabActionPerformed
        if(m.pCab+1 > m.productoresMaxCab[0]){
            System.out.println("Máximo de productores de cables alcanzado"); //Cambiar por un JOptionPane
        }else{
            m.pCab++;
            Inicio.prodCab.setText("Productores de cables: "+m.pCab);
        }
    }//GEN-LAST:event_agregarPCabActionPerformed

    private void eliminarPCabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPCabActionPerformed
        if(m.pCab-1 < 0){
            System.out.println("Error: Productores negativos"); //Cambiar por un JOptionPane
        }else{
            m.pCab--;
            Inicio.prodCab.setText("Productores de cables: "+m.pCab);
        }
    }//GEN-LAST:event_eliminarPCabActionPerformed

    private void agregarEnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEnsActionPerformed
        if(m.en+1 > m.maxEnsambla[0]){
            System.out.println("Máximo de ensambladores alcanzado"); //Cambiar por un JOptionPane
        }else{
            m.en++;
            Inicio.ensNum.setText("Ensambladores: "+m.en);
        }
    }//GEN-LAST:event_agregarEnsActionPerformed

    private void eliminarEnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEnsActionPerformed
        if(m.en-1 < 0){
            System.out.println("Error: número negativo de ensambladores"); //Cambiar por un JOptionPane
        }else{
            m.en--;
            Inicio.ensNum.setText("Ensambladores: "+m.en);
        }
    }//GEN-LAST:event_eliminarEnsActionPerformed

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
    private javax.swing.JButton agregarEns;
    private javax.swing.JButton agregarPBat;
    private javax.swing.JButton agregarPCab;
    private javax.swing.JButton agregarPPan;
    public static javax.swing.JLabel bat;
    public static javax.swing.JLabel cab;
    private javax.swing.JButton close;
    public static javax.swing.JLabel crono;
    private javax.swing.JButton eliminarEns;
    private javax.swing.JButton eliminarPBat;
    private javax.swing.JButton eliminarPCab;
    private javax.swing.JButton eliminarPPan;
    public static javax.swing.JLabel ensNum;
    public static javax.swing.JLabel geren;
    public static javax.swing.JLabel j;
    public static javax.swing.JLabel pan;
    public static javax.swing.JLabel prodBat;
    public static javax.swing.JLabel prodCab;
    public static javax.swing.JLabel prodPan;
    // End of variables declaration//GEN-END:variables
}
