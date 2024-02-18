/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package parkinghaussystem;

import Dao.DBOperations;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author tn
 */
public class ParkplatzHinzufuegen extends javax.swing.JFrame {

    /**
     * Creates new form ParkplatzHinzufuegen
     */
    public ParkplatzHinzufuegen() {
        initComponents();
        btnSpeichern.setEnabled(false);
        fillComboBoxWithEtagenNamen();  //Füllt die Combobox mit den Namen der Etagen aus der Datenbank.
        setDefaultCloseOperation(ParkplatzHinzufuegen.DISPOSE_ON_CLOSE);
    }

    public void validateFields() {
        String parkplatz = txtParkplatzName.getText();
        if (!parkplatz.equals("")) {
            btnSpeichern.setEnabled(true);
        } else {
            btnSpeichern.setEnabled(false);
        }
    }

    private void fillComboBoxWithEtagenNamen() {
        List<String> etagenNamen = DBOperations.getAlleEtagenNamen();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String name : etagenNamen) {
            model.addElement(name);
        }
        comboboxEtage.setModel(model);
    }

    private void resetFormular() {
        txtParkplatzName.setText("");
        comboboxEtage.getSelectedItem();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboboxEtage = new javax.swing.JComboBox<>();
        txtParkplatzName = new javax.swing.JTextField();
        btnSpeichern = new javax.swing.JButton();
        btnEtfernen = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Parkplatz Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Etage");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 37, -1));

        comboboxEtage.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        getContentPane().add(comboboxEtage, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 269, -1));

        txtParkplatzName.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        txtParkplatzName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtParkplatzNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtParkplatzName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 269, -1));

        btnSpeichern.setBackground(new java.awt.Color(58, 101, 143));
        btnSpeichern.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnSpeichern.setForeground(new java.awt.Color(255, 255, 255));
        btnSpeichern.setText("Speichern");
        btnSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpeichernActionPerformed(evt);
            }
        });
        getContentPane().add(btnSpeichern, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        btnEtfernen.setBackground(new java.awt.Color(58, 101, 143));
        btnEtfernen.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnEtfernen.setForeground(new java.awt.Color(255, 255, 255));
        btnEtfernen.setText("Abbrechen");
        btnEtfernen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEtfernenActionPerformed(evt);
            }
        });
        getContentPane().add(btnEtfernen, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 20, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("_");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 30, 20));

        jButton1.setBackground(new java.awt.Color(135, 135, 79));
        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Zurück zu Admin Verwaltung Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/Design ohne Titel (4).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtParkplatzNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParkplatzNameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtParkplatzNameKeyReleased

    private void btnSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpeichernActionPerformed
        // TODO add your handling code here:
        String etagenName = (String) comboboxEtage.getSelectedItem();
        String parkplatzName = txtParkplatzName.getText();

        if (etagenName != null && !etagenName.isEmpty() && !parkplatzName.isEmpty()) {

            int etagenId = DBOperations.getEtageIdByName(etagenName);

            if (etagenId != -1) {

                String istBelegt = "Nein";
                boolean erfolgreich = DBOperations.addParkplatz(parkplatzName, etagenId, istBelegt);
// Entfernen Sie etagenName aus dem Methodenaufruf
                if (erfolgreich) {
                    JOptionPane.showMessageDialog(this, "Parkplatz erfolgreich hinzugefügt.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
                    resetFormular();

                } else {
                    JOptionPane.showMessageDialog(this, "Fehler beim Hinzufügen des Parkplatzes.", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Etage konnte nicht gefunden werden.", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bitte geben Sie alle erforderlichen Informationen ein.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSpeichernActionPerformed

    private void btnEtfernenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEtfernenActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnEtfernenActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        setExtendedState(ParkplatzHinzufuegen.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new AdminVerwaltung().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ParkplatzHinzufuegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParkplatzHinzufuegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParkplatzHinzufuegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParkplatzHinzufuegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParkplatzHinzufuegen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEtfernen;
    private javax.swing.JButton btnSpeichern;
    private javax.swing.JComboBox<String> comboboxEtage;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtParkplatzName;
    // End of variables declaration//GEN-END:variables
}
