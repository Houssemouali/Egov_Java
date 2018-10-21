/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Adapters.AdapterCin;
import Adapters.AdapterCompteCourant;
import Dao.DemandeDao;
import Entities.Demande;
import java.awt.Image;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maynoo
 */
public class ValiderCin extends javax.swing.JFrame {

    /**
     * Creates new form Authentification
     */
    public ValiderCin() {

        initComponents();
        Design.setBackground();
        Image titreimg = Design.getTitre();

        this.setTitle("Valider Carte d'identité nationale");
        titreLabel.setText("Valider Carte d'identité nationale");
        titreBack.setIcon(new ImageIcon(titreimg));

        AdapterCin tableAdapter = new AdapterCin();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Vector column_name = new Vector();
        Vector data_row = new Vector();
        for (int i = 0; i < tableAdapter.getColumnCount(); i++) {
            column_name.addElement(tableAdapter.getColumnName(i));
            model.setColumnIdentifiers(column_name);
        }
        for (int k = 0; k < tableAdapter.getRowCount(); k++) {
            data_row = new Vector();
            data_row.addElement(tableAdapter.getValueAt(k, 0));
            data_row.addElement(tableAdapter.getValueAt(k, 1));
            data_row.addElement(tableAdapter.getValueAt(k, 2));
            data_row.addElement(tableAdapter.getValueAt(k, 3));
            data_row.addElement(tableAdapter.getValueAt(k, 4));
            data_row.addElement(tableAdapter.getValueAt(k, 5));
            data_row.addElement(tableAdapter.getValueAt(k, 6));
            data_row.addElement(tableAdapter.getValueAt(k, 7));
            model.addRow(data_row);
        }
        table.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titre = new javax.swing.JPanel();
        titreLabel = new javax.swing.JLabel();
        titreBack = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        commentaire = new javax.swing.JTextField();
        commenter = new javax.swing.JButton();
        valider = new javax.swing.JButton();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        titre.setBackground(new java.awt.Color(255, 255, 255));
        titre.setPreferredSize(new java.awt.Dimension(1040, 97));
        titre.setLayout(null);

        titreLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titreLabel.setText("Authentification");
        titre.add(titreLabel);
        titreLabel.setBounds(16, 24, 600, 50);

        titreBack.setText("Titre Back");
        titreBack.setMaximumSize(new java.awt.Dimension(1040, 97));
        titreBack.setMinimumSize(new java.awt.Dimension(1040, 97));
        titreBack.setPreferredSize(new java.awt.Dimension(1040, 97));
        titre.add(titreBack);
        titreBack.setBounds(0, 0, 1040, 97);

        getContentPane().add(titre);
        titre.setBounds(240, 0, 1040, 97);

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setMaximumSize(new java.awt.Dimension(240, 720));
        menu.setPreferredSize(new java.awt.Dimension(240, 720));
        menu.setLayout(null);
        getContentPane().add(menu);
        menu.setBounds(0, 0, 240, 720);
        Design.fillMenu(menu,this);

        container.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        commentaire.setPreferredSize(new java.awt.Dimension(196, 39));

        commenter.setText("Commenter");
        commenter.setPreferredSize(new java.awt.Dimension(196, 39));
        commenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commenterActionPerformed(evt);
            }
        });

        valider.setText("Valider Demande");
        valider.setPreferredSize(new java.awt.Dimension(196, 39));
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(commentaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(commenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commentaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        getContentPane().add(container);
        container.setBounds(240, 97, 1040, 603);
        getContentPane().add(id);
        id.setBounds(100, 490, 66, 55);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        id.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
        commentaire.setText(model.getValueAt(table.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void commenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commenterActionPerformed
        DemandeDao dd = new DemandeDao();
        Demande d = dd.RechercherParId(Integer.parseInt(id.getText()));
        d.setCommentaire(commentaire.getText());
        dd.Modifier(d);
    }//GEN-LAST:event_commenterActionPerformed

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed

        DemandeDao dd = new DemandeDao();
        Demande d = dd.RechercherParId(Integer.parseInt(id.getText()));
        d.setEtat("Validé");
        dd.Modifier(d);
    }//GEN-LAST:event_validerActionPerformed

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
            java.util.logging.Logger.getLogger(ValiderCin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValiderCin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValiderCin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValiderCin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValiderCin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField commentaire;
    private javax.swing.JButton commenter;
    private javax.swing.JPanel container;
    private javax.swing.JLabel id;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menu;
    private javax.swing.JTable table;
    private javax.swing.JPanel titre;
    private javax.swing.JLabel titreBack;
    private javax.swing.JLabel titreLabel;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
