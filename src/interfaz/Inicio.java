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
        prodBatED = new javax.swing.JLabel();
        prodPanED = new javax.swing.JLabel();
        prodCabED = new javax.swing.JLabel();
        ensED = new javax.swing.JLabel();
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
        text1 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        text3 = new javax.swing.JLabel();
        text4 = new javax.swing.JLabel();
        prodBat1 = new javax.swing.JLabel();
        prodPan1 = new javax.swing.JLabel();
        prodCab1 = new javax.swing.JLabel();
        ensNum1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        text5 = new javax.swing.JLabel();
        text6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        batImg = new javax.swing.JLabel();
        panImg = new javax.swing.JLabel();
        batImg2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setText("Cerrar");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, 20));

        prodBatED.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        prodBatED.setText("Esperando para despedir:");
        getContentPane().add(prodBatED, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 210, 20));

        prodPanED.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        prodPanED.setText("Esperando para despedir:");
        getContentPane().add(prodPanED, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 210, 20));

        prodCabED.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        prodCabED.setText("Esperando para despedir:");
        getContentPane().add(prodCabED, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 210, 20));

        ensED.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ensED.setText("Esperando para despedir:");
        getContentPane().add(ensED, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 220, 20));

        bat.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bat.setText("0");
        getContentPane().add(bat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 30, -1));

        pan.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pan.setText("0");
        getContentPane().add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 30, -1));

        cab.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cab.setText("0");
        getContentPane().add(cab, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 30, -1));

        geren.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        geren.setText("Está dormido");
        getContentPane().add(geren, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 210, -1));

        crono.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        crono.setText("Está dormido");
        getContentPane().add(crono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 240, -1));

        diasD.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        diasD.setText("Días para el despacho:");
        getContentPane().add(diasD, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 180, 20));

        eliminarPBat.setText("-");
        eliminarPBat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPBatActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarPBat, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 40, 20));

        agregarPBat.setText("+");
        agregarPBat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPBatActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPBat, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 40, 20));

        agregarPPan.setText("+");
        agregarPPan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPPanActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 40, 20));

        eliminarPPan.setText("-");
        eliminarPPan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPPanActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarPPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 40, 20));

        agregarPCab.setText("+");
        agregarPCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPCabActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPCab, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 40, 20));

        eliminarPCab.setText("-");
        eliminarPCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPCabActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarPCab, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 40, 20));

        agregarEns.setText("+");
        agregarEns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEnsActionPerformed(evt);
            }
        });
        getContentPane().add(agregarEns, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 40, 20));

        eliminarEns.setText("-");
        eliminarEns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEnsActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarEns, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 40, 20));

        tel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tel.setText("Por despachar:");
        getContentPane().add(tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 220, 20));

        despacho.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        despacho.setText("Último despacho: ");
        getContentPane().add(despacho, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 240, -1));

        enProd.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        enProd.setText("En producción:");
        getContentPane().add(enProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 190, 20));

        text1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        text1.setText("Gerente:");
        getContentPane().add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, 20));

        text2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        text2.setText("Teléfonos:");
        getContentPane().add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 20));

        text3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        text3.setText("Productores:");
        getContentPane().add(text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        text4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        text4.setText("Almacenes: ");
        getContentPane().add(text4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        prodBat1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        prodBat1.setText("De baterías:");
        getContentPane().add(prodBat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 140, 20));

        prodPan1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        prodPan1.setText("De pantallas:");
        getContentPane().add(prodPan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 140, 20));

        prodCab1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        prodCab1.setText("De cables:");
        getContentPane().add(prodCab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 140, 20));

        ensNum1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ensNum1.setText("Cantidad:");
        getContentPane().add(ensNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 180, 20));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 510, 20));

        text5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        text5.setText("Ensambladores:");
        getContentPane().add(text5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, 20));

        text6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        text6.setText("Cronometrador:");
        getContentPane().add(text6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 20));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 510, 20));

        batImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cable.image.png"))); // NOI18N
        getContentPane().add(batImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 80, 120));

        panImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantalla.image.png"))); // NOI18N
        getContentPane().add(panImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 80, 120));

        batImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bateria.image.png"))); // NOI18N
        getContentPane().add(batImg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 120));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 470));

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
            Inicio.prodBat1.setText("De baterías: "+Main.pBat);
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
            Inicio.prodPan1.setText("De pantallas: "+Main.pPan);
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
            Inicio.prodCab1.setText("De cables: "+Main.pCab);
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
            Inicio.ensNum1.setText("Contratados: "+Main.en);
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
    private javax.swing.JLabel batImg;
    private javax.swing.JLabel batImg2;
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
    public static javax.swing.JLabel ensED;
    public static javax.swing.JLabel ensNum1;
    public static javax.swing.JLabel geren;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel pan;
    private javax.swing.JLabel panImg;
    public static javax.swing.JLabel prodBat1;
    public static javax.swing.JLabel prodBatED;
    public static javax.swing.JLabel prodCab1;
    public static javax.swing.JLabel prodCabED;
    public static javax.swing.JLabel prodPan1;
    public static javax.swing.JLabel prodPanED;
    public static javax.swing.JLabel tel;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel text4;
    private javax.swing.JLabel text5;
    private javax.swing.JLabel text6;
    // End of variables declaration//GEN-END:variables
}
