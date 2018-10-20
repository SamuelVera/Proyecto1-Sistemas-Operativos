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
        m.initiate();
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
        diasD = new javax.swing.JLabel();
        eliminarPBat = new javax.swing.JButton();
        agregarPBat = new javax.swing.JButton();
        agregarPPan = new javax.swing.JButton();
        eliminarPPan = new javax.swing.JButton();
        agregarPCab = new javax.swing.JButton();
        eliminarPCab = new javax.swing.JButton();
        agregarEns = new javax.swing.JButton();
        eliminarEns = new javax.swing.JButton();
        tel = new javax.swing.JLabel();
        despacho = new javax.swing.JLabel();
        enProd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setText("Cerrar");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        prodBat.setText("Productores de baterías:");
        getContentPane().add(prodBat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 20));

        prodPan.setText("Productores de pantallas:");
        getContentPane().add(prodPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 20));

        prodCab.setText("Productores de cables");
        getContentPane().add(prodCab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 20));

        ensNum.setText("Ensambladores");
        getContentPane().add(ensNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 180, 20));

        bat.setText("Baterías: ");
        getContentPane().add(bat, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 220, -1));

        pan.setText("Pantallas:");
        getContentPane().add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 220, -1));

        cab.setText("Cables:");
        getContentPane().add(cab, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 220, -1));

        geren.setText("El gerente está dormido");
        getContentPane().add(geren, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 290, -1));

        crono.setText("El cronometrador está dormido");
        getContentPane().add(crono, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 290, -1));

        diasD.setText("Días para el despacho:");
        getContentPane().add(diasD, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 240, -1));

        eliminarPBat.setText("-");
        eliminarPBat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPBatActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarPBat, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 40, -1));

        agregarPBat.setText("+");
        agregarPBat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPBatActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPBat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 40, -1));

        agregarPPan.setText("+");
        agregarPPan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPPanActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 40, -1));

        eliminarPPan.setText("-");
        eliminarPPan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPPanActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarPPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 40, -1));

        agregarPCab.setText("+");
        agregarPCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPCabActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPCab, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 40, -1));

        eliminarPCab.setText("-");
        eliminarPCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPCabActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarPCab, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 40, -1));

        agregarEns.setText("+");
        agregarEns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEnsActionPerformed(evt);
            }
        });
        getContentPane().add(agregarEns, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 40, -1));

        eliminarEns.setText("-");
        eliminarEns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEnsActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarEns, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 40, -1));

        tel.setText("Teléfonos:");
        getContentPane().add(tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 220, -1));

        despacho.setText("Último despacho: ");
        getContentPane().add(despacho, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 240, -1));

        enProd.setText("Teléfonos en producción:");
        getContentPane().add(enProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 190, 20));

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
        if(Main.pBat+1 > m.data[4]){
            System.out.println("Máximo de productores de bateria alcanzado"); //Cambiar por un JOptionPane
        }else{
            m.newT(0);
            Main.pBat++;
            Inicio.prodBat.setText("Productores de baterías: "+Main.pBat);
        }
    }//GEN-LAST:event_agregarPBatActionPerformed

    private void eliminarPBatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPBatActionPerformed
        if(Main.pBat-1 < 0){
            System.out.println("Error: Productores negativos"); //Cambiar por un JOptionPane
        }else{
            m.closeT(0);
        }
    }//GEN-LAST:event_eliminarPBatActionPerformed

    private void agregarPPanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPPanActionPerformed
        if(Main.pPan+1 > m.data[5]){
            System.out.println("Máximo de productores de pantallas alcanzado"); //Cambiar por un JOptionPane
        }else{
            m.newT(1);
            Main.pPan++;
            Inicio.prodPan.setText("Productores de pantallas: "+Main.pPan);
        }
    }//GEN-LAST:event_agregarPPanActionPerformed

    private void eliminarPPanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPPanActionPerformed
        if(Main.pPan-1 < 0){
            System.out.println("Error: Productores negativos"); //Cambiar por un JOptionPane
        }else{
            m.closeT(1);
        }
    }//GEN-LAST:event_eliminarPPanActionPerformed

    private void agregarPCabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPCabActionPerformed
        if(Main.pCab+1 > m.data[6]){
            System.out.println("Máximo de productores de cables alcanzado"); //Cambiar por un JOptionPane
        }else{
            m.newT(2);
            Main.pCab++;
            Inicio.prodCab.setText("Productores de cables: "+Main.pCab);
        }
    }//GEN-LAST:event_agregarPCabActionPerformed

    private void eliminarPCabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPCabActionPerformed
        if(Main.pCab-1 < 0){
            System.out.println("Error: Productores negativos"); //Cambiar por un JOptionPane
        }else{
            m.closeT(2);
        }
    }//GEN-LAST:event_eliminarPCabActionPerformed

    private void agregarEnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEnsActionPerformed
        if(Main.en+1 > m.data[11]){
            System.out.println("Máximo de ensambladores alcanzado"); //Cambiar por un JOptionPane
        }else{
            m.newT(3);
            Main.en++;
            Inicio.ensNum.setText("Ensambladores: "+Main.en);
        }
    }//GEN-LAST:event_agregarEnsActionPerformed

    private void eliminarEnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEnsActionPerformed
        if(Main.en-1 < 0){
            System.out.println("Error: número negativo de ensambladores"); //Cambiar por un JOptionPane
        }else{
            m.closeT(3);
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
    public static javax.swing.JLabel despacho;
    public static javax.swing.JLabel diasD;
    private javax.swing.JButton eliminarEns;
    private javax.swing.JButton eliminarPBat;
    private javax.swing.JButton eliminarPCab;
    private javax.swing.JButton eliminarPPan;
    public static javax.swing.JLabel enProd;
    public static javax.swing.JLabel ensNum;
    public static javax.swing.JLabel geren;
    public static javax.swing.JLabel pan;
    public static javax.swing.JLabel prodBat;
    public static javax.swing.JLabel prodCab;
    public static javax.swing.JLabel prodPan;
    public static javax.swing.JLabel tel;
    // End of variables declaration//GEN-END:variables
}
