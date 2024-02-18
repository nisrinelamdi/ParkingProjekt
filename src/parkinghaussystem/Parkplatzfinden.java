/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package parkinghaussystem;

import Dao.DBOperations;
import ParkhausClasses.Parkplatz;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tn
 */
public class Parkplatzfinden extends javax.swing.JFrame {

    private int selectedParkplatzId = -1;

    public Parkplatzfinden() {
        initComponents();
        btnParken.setEnabled(false);
        refreshFreieParkplaetze(); // Zeigt die Liste der freien Parkplätze an.
        setDefaultCloseOperation(Parkplatzfinden.DISPOSE_ON_CLOSE);

    }

    public void validateFields() {
        String besitzer = txtBesitzerName.getText();
        String nachname = txtBesitzerNachname.getText();
        String nummerschild = txtNummerschild.getText();

        if (!besitzer.equals("") && !nummerschild.equals("") && !nachname.equals("")) {
            btnParken.setEnabled(true);
        } else {
            btnParken.setEnabled(false);

        }
    }

    public void clear() {
        txtBesitzerName.setText("");
        txtNummerschild.setText("");
        btnParken.setEnabled(false);
    }

    // Diese Methode wird aufgerufen, wenn das Formular angezeigt wird oder wenn Sie die Liste aktualisieren möchten.
    public void refreshFreieParkplaetze() {
        List<Parkplatz> freiePlaetze = DBOperations.getVerfuegbareParkplaetze();
        DefaultTableModel model = (DefaultTableModel) jTableFreiePlaetze.getModel();
        model.setRowCount(0); // Bestehende Zeilen löschen

        for (Parkplatz parkplatz : freiePlaetze) {
            model.addRow(new Object[]{
                parkplatz.getParkplatzname(),
                parkplatz.getEtagenname()
            });
        }
    }

    private void resetFormular() {
        txtBesitzerName.setText("");
        txtBesitzerNachname.setText("");
        txtNummerschild.setText("");
        comboboxFahrzeug.setSelectedIndex(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBesitzerName = new javax.swing.JTextField();
        txtNummerschild = new javax.swing.JTextField();
        btnParken = new javax.swing.JButton();
        btnBeenden = new javax.swing.JButton();
        comboboxFahrzeug = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFreiePlaetze = new javax.swing.JTable();
        txtBesitzerNachname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Wählen Sie Ihren Parkplatz");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, 190, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Fahrzeug");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 110, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nummerschild");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 130, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Name der Besitzer*in");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 180, 20));

        txtBesitzerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBesitzerNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtBesitzerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 370, -1));

        txtNummerschild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNummerschildKeyReleased(evt);
            }
        });
        getContentPane().add(txtNummerschild, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 370, -1));

        btnParken.setBackground(new java.awt.Color(58, 101, 143));
        btnParken.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnParken.setForeground(new java.awt.Color(255, 255, 255));
        btnParken.setText("Parken");
        btnParken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParkenActionPerformed(evt);
            }
        });
        getContentPane().add(btnParken, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 100, -1));

        btnBeenden.setBackground(new java.awt.Color(58, 101, 143));
        btnBeenden.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnBeenden.setForeground(new java.awt.Color(255, 255, 255));
        btnBeenden.setText("Abbrechen");
        btnBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeendenActionPerformed(evt);
            }
        });
        getContentPane().add(btnBeenden, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 120, -1));

        comboboxFahrzeug.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        comboboxFahrzeug.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auto", "Moto" }));
        getContentPane().add(comboboxFahrzeug, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 370, -1));

        jTableFreiePlaetze.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jTableFreiePlaetze.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Parkplatz", "Etage"
            }
        ));
        jTableFreiePlaetze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFreiePlaetzeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFreiePlaetze);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, -1, -1));

        txtBesitzerNachname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBesitzerNachnameKeyReleased(evt);
            }
        });
        getContentPane().add(txtBesitzerNachname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 370, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nachname");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, 20));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 20, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("_");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, -10, 20, 30));

        jButton1.setBackground(new java.awt.Color(135, 135, 79));
        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Zurück zu Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 553, -1, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/Background_Big.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnParkenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParkenActionPerformed
        // TODO add your handling code here:
        String besitzerVorname = txtBesitzerName.getText();
        String nachname = txtBesitzerNachname.getText();
        String fahrzeugtyp = (String) comboboxFahrzeug.getSelectedItem();
        String nummernschild = txtNummerschild.getText();

        // Verwenden Sie das aktuelle Datum und die Uhrzeit
        Date jetzt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String parkZeitpunkt = dateFormat.format(jetzt);

        if (selectedParkplatzId < 0) {
            JOptionPane.showMessageDialog(this, "Bitte wählen Sie einen Parkplatz aus der Liste.", "Kein Parkplatz ausgewählt", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean parkenErfolgreich = false;

        if (!DBOperations.istSchildnummerVerfuegbar(nummernschild)) {
            JOptionPane.showMessageDialog(this, "Diese Schildnummer ist bereits im Gebrauch.", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        parkenErfolgreich = DBOperations.parkFahrzeug(selectedParkplatzId, besitzerVorname, nachname, fahrzeugtyp, nummernschild, parkZeitpunkt);

        if (parkenErfolgreich) {
            JOptionPane.showMessageDialog(this, "Fahrzeug wurde erfolgreich geparkt.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);

            refreshFreieParkplaetze();
            resetFormular(); // Setzen Sie das Formular zurück
        } else {
            JOptionPane.showMessageDialog(this, "Fehler beim Parken des Fahrzeugs.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnParkenActionPerformed

    private void btnBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeendenActionPerformed
        // TODO add your handling code here:

        System.exit(0);

    }//GEN-LAST:event_btnBeendenActionPerformed

    private void txtNummerschildKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNummerschildKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtNummerschildKeyReleased

    // Speichert die ausgewählte Parkplatz-ID für das Parken
    private void jTableFreiePlaetzeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFreiePlaetzeMouseClicked
        // TODO add your handling code here:
        int row = jTableFreiePlaetze.getSelectedRow();
        if (row >= 0) { // Sicherstellen, dass eine Zeile ausgewählt wurde
            String parkplatzName = (String) jTableFreiePlaetze.getValueAt(row, 0); // Annahme: Spalte 0 enthält den Parkplatznamen
            if (parkplatzName != null && !parkplatzName.isEmpty()) {

                selectedParkplatzId = DBOperations.getParkplatzIdByName(parkplatzName);
                if (selectedParkplatzId != -1) {

                } else {

                    JOptionPane.showMessageDialog(this, "Parkplatz-ID konnte nicht gefunden werden.", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jTableFreiePlaetzeMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txtBesitzerNachnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBesitzerNachnameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtBesitzerNachnameKeyReleased

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        setExtendedState(Parkplatzfinden.ICONIFIED);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBesitzerNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBesitzerNameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtBesitzerNameKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parkplatzfinden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBeenden;
    private javax.swing.JButton btnParken;
    private javax.swing.JComboBox<String> comboboxFahrzeug;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFreiePlaetze;
    private javax.swing.JTextField txtBesitzerNachname;
    private javax.swing.JTextField txtBesitzerName;
    private javax.swing.JTextField txtNummerschild;
    // End of variables declaration//GEN-END:variables
}
