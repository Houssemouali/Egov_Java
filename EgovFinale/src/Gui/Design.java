/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class Design {

    public static Image menu, titre;

    public Design() {
    }

    
    public static void setBackground() {
        try {
            File sourceimage = new File("C:/Users/USER/Desktop/PI/menu.png");
            menu = ImageIO.read(sourceimage);
            sourceimage = new File("C:/Users/USER/Desktop/PI/titre.png");
            titre = ImageIO.read(sourceimage);
        } catch (IOException ex) {
            Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Image getTitre() {
        return titre;
    }

    public static Image getMenu() {
        return menu;
    }

    public static void fillMenu(JPanel menuPanel, JFrame f) {

        setBackground();

        menuPanel.setLayout(null);
        int y = 160;
//////////////////////////////////////////////////Menu Agent
        if (loginInfo.getUtilisateur().getRoles().equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}")) {

            if (loginInfo.getUtilisateur().getPoste().equals("Poste")) {
                /////////////////////
                if (loginInfo.getUtilisateur().getCin().getId() != 0) {
                    JButton compte = new JButton("Valider Compte Courant");
                    menuPanel.add(compte);
                    compte.setBounds(24, y, 192, 36);
                    compte.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.dispose();
                            new ValiderCompteCourant().setVisible(true);
                        }
                    });
                    y = y + 40;
                }
            }
            if (loginInfo.getUtilisateur().getPoste().equals("Muni")) {
                /////////////////////-
                if (loginInfo.getUtilisateur().getCin().getId() != 0) {
                    JButton compte = new JButton("Valider Extrait Naissance");
                    menuPanel.add(compte);
                    compte.setBounds(24, y, 192, 36);
                    compte.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.dispose();
                            new ValiderExtraitNaissance().setVisible(true);
                        }
                    });
                    y = y + 40;
                }
            }
            if (loginInfo.getUtilisateur().getPoste().equals("Inter")) {
                /////////////////////-
                if (loginInfo.getUtilisateur().getCin().getId() != 0) {
                    JButton compte = new JButton("Valider CIN");
                    menuPanel.add(compte);
                    compte.setBounds(24, y, 192, 36);
                    compte.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.dispose();
                            new ValiderCin().setVisible(true);
                        }
                    });
                    y = y + 40;
                }
            }
            if (loginInfo.getUtilisateur().getPoste().equals("Inter")) {
                /////////////////////-
                if (loginInfo.getUtilisateur().getCin().getId() != 0) {
                    JButton compte = new JButton("Valider B3");
                    menuPanel.add(compte);
                    compte.setBounds(24, y, 192, 36);
                    compte.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.dispose();
                            new ValiderB3().setVisible(true);
                        }
                    });
                    y = y + 40;
                }
            }
            if (loginInfo.getUtilisateur().getPoste().equals("Indus")) {
                /////////////////////
                if (loginInfo.getUtilisateur().getCin().getId() != 0) {
                    JButton compte = new JButton("Valider Autorisation");
                    menuPanel.add(compte);
                    compte.setBounds(24, y, 192, 36);
                    compte.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.dispose();
                            new ValiderAutorisation().setVisible(true);
                        }
                    });
                    y = y + 40;
                }
            }

            if (loginInfo.getUtilisateur().getPoste().equals("Indus")) {
                /////////////////////
                if (loginInfo.getUtilisateur().getCin().getId() != 0) {
                    JButton compte = new JButton("Valider Facture");
                    menuPanel.add(compte);
                    compte.setBounds(24, y, 192, 36);
                    compte.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.dispose();
                            new ValiderFacture().setVisible(true);
                        }
                    });
                    y = y + 40;
                }
            }
        } //////////////////////////////////////////////////Menu Citoyen
        else {
/////////////////////
            if (loginInfo.getUtilisateur().getCin().getId() != 0) {
                JButton compte = new JButton("Demander Compte Courant");
                menuPanel.add(compte);
                compte.setBounds(24, y, 192, 36);
                compte.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.dispose();
                        new DemanderCompteCourant().setVisible(true);
                    }
                });
                y = y + 40;
            }

/////////////////////
            JButton extrait = new JButton("Demander Extrait Naissance");
            menuPanel.add(extrait);
            extrait.setBounds(24, y, 192, 36);
            extrait.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new DemanderExtraitNaissance().setVisible(true);
                }
            });
            y = y + 40;

/////////////////////
            JButton cin = new JButton("Demander CIN");
            menuPanel.add(cin);
            cin.setBounds(24, y, 192, 36);
            cin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new DemanderCin().setVisible(true);
                }
            });
            y = y + 40;
/////////////////////
            if (loginInfo.getUtilisateur().getCin().getId() != 0) {
                JButton b3 = new JButton("Demander B3");
                menuPanel.add(b3);
                b3.setBounds(24, y, 192, 36);
                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.dispose();
                        new DemanderB3().setVisible(true);
                    }
                });
                y = y + 40;
            }
            if (loginInfo.getUtilisateur().getCin().getId() != 0) {
                JButton b3 = new JButton("Mes Demandes");
                menuPanel.add(b3);
                b3.setBounds(24, y, 192, 36);
                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.dispose();
                        new ConsulterDemande().setVisible(true);
                    }
                });
                y = y + 40;
            }
/////////////////////
        }
///////////////////////////////////////////////////////////

        JButton acceuil = new JButton("Deconnextion");

        menuPanel.add(acceuil);

        acceuil.setBounds(
                24, y, 192, 36);
        acceuil.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        f.dispose();
                        new Authentification().setVisible(true);
                    }
                }
        );
        y = y + 40;
////////////////////////

        JLabel background = new JLabel();

        background.setIcon(
                new ImageIcon(menu));
        menuPanel.add(background);

        background.setBounds(
                0, 0, 240, 720);

    }

}
