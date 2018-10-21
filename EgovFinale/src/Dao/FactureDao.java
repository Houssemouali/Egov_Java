/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cin;
import Entities.Compte;
import Entities.Facture;
//import Entities.Demandeautorisation;
import Technique.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iheb
 */
public class FactureDao {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public FactureDao() {
        connection = (DataBase.getInstance()).getConnection();
    }

    public void add(Facture ac) {
        try {
            String req = "insert into facture (cin,Type,Montant,PayerAvant,etat,commentaire) values (?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, ac.getCin().getId());
            pst.setString(2, ac.getType());
            pst.setInt(3, ac.getMontant());
            pst.setDate(4, ac.getPayerAvant());
            pst.setString(5, ac.getEtat());
            pst.setString(6, ac.getCommentaire());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FactureDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Modifier(Facture ac) {

        try {
            String req = "UPDATE `facture` SET `cin`=?,`Type`=?,`Montant`=?,`PayerAvant`=?,`etat`=?,`commentaire`=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(req);

            pst.setInt(1, ac.getCin().getId());
            pst.setString(2, ac.getType());
            pst.setInt(3, ac.getMontant());
            pst.setDate(4, ac.getPayerAvant());
            pst.setString(5, ac.getEtat());
            pst.setString(6, ac.getCommentaire());
            pst.setInt(7, ac.getId());
            
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour" + ex.getMessage());
        }
    }

    public void Supprimer(Facture ac) {
        String req = "DELETE FROM `facture` WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, ac.getId());
            ps.executeUpdate();
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression" + ex.getStackTrace());
        }
    }

    public Facture RechercherParId(int id) {

        try {

            Facture ext = new Facture();
            String req = "select * from facture where id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                CinDao cd = new CinDao();
                Cin cin = cd.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin);
                ext.setType(rs.getString("Type"));
                ext.setMontant(rs.getInt("Montant"));
                ext.setPayerAvant(rs.getDate("PayerAvant"));
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));

            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    public List<Facture> findAll() {
        List<Facture> listeext = new ArrayList<>();

        try {
            String requete = "select * from facture";
            Statement statement = connection
                    .createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while (rs.next()) {
                Facture ext = new Facture();

                ext.setId(rs.getInt("id"));
                CinDao cd = new CinDao();
                Cin cin = cd.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin);
                ext.setType(rs.getString("Type"));
                ext.setMontant(rs.getInt("Montant"));
                ext.setPayerAvant(rs.getDate("PayerAvant"));
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FactureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

}
