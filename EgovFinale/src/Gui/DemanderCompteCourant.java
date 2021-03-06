/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Dao.CompteDao;
import Dao.DemandeDao;
import Entities.Compte;
import Entities.Demande;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Maynoo
 */
public class DemanderCompteCourant extends javax.swing.JFrame {

    /**
     * Creates new form Authentification
     */
    public DemanderCompteCourant() {

        initComponents();
        Design.setBackground();
        Image titreimg = Design.getTitre();

        this.setTitle("Compte Courant");
        titreLabel.setText("Compte Courant");
        titreBack.setIcon(new ImageIcon(titreimg));

        CompteDao cd = new CompteDao();
        Compte c = cd.RechercherParCin(loginInfo.getUtilisateur().getCin());

        if (c.getId() != 0) {
            JLabel message = new JLabel("Votre numero de compte est: " + c.getNumCompte());
            JLabel montant = new JLabel("Votre Compte Courant Contient: " +c.getMontant());

            message.setFont(new Font(" TimesRoman ", Font.BOLD, 30));
            montant.setFont(new Font(" TimesRoman ", Font.BOLD, 30));
            
            container.add(message);
            message.setBounds(0, 280, 1040, 36);
            
            container.add(montant);
            montant.setBounds(0, 320, 1040, 36);
            
        } else {
            JButton cree = new JButton("Crée Compte Courant");
            JLabel message = new JLabel("Vous N'avez pas de compte courant");

            container.add(message);
            message.setBounds(422, 280, 300, 36);
            container.add(cree);
            cree.setBounds(422, 320, 196, 36);

            cree.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int n = JOptionPane.showConfirmDialog(
                            getContentPane(),
                            "Confirmer la Demande pour votre Compte Courant?",
                            "Confirmer",
                            JOptionPane.YES_NO_OPTION);

                    if (n == 0) {
                        Demande d = new Demande();
                        d.setType("CPP");
                        d.setCin(loginInfo.getUtilisateur().getCin());
                        d.setEtat("En Cours");
                        d.setCommentaire("");

                        DemandeDao dd = new DemandeDao();
                        dd.add(d);
                    }
                }
            });
        }

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));
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
        container.setLayout(null);
        getContentPane().add(container);
        container.setBounds(240, 97, 1040, 603);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DemanderCompteCourant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemanderCompteCourant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemanderCompteCourant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemanderCompteCourant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DemanderCompteCourant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel titre;
    private javax.swing.JLabel titreBack;
    private javax.swing.JLabel titreLabel;
    // End of variables declaration//GEN-END:variables
}
