/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cin;
import Entities.Compte;
import Entities.ExtraitNaissance;
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
public class CompteDao {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public CompteDao() {
        connection = (DataBase.getInstance()).getConnection();
    }

    public void add(Compte t) {
        try {
            String req = "insert into compte (num_compte,cin,montant) values (?,?,?)";
            pst = connection.prepareStatement(req);

            pst.setString(1, t.getNumCompte());
            pst.setInt(2, t.getCin().getId());
            pst.setInt(3, t.getMontant());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Modifier(Compte t) {

        try {
            String req = "UPDATE `compte`SET `num_compte`=?,`cin`=?,`montant`=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(req);

            pst.setString(1, t.getNumCompte());
            pst.setInt(2, t.getCin().getId());
            pst.setInt(3, t.getMontant());
            pst.setInt(4, t.getId());

            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour" + ex.getMessage());
        }
    }

    public void Supprimer(Compte t) {
        String req = "DELETE FROM `compte`WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, t.getId());
            ps.executeUpdate();
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression" + ex.getStackTrace());
        }
    }

    public Compte RechercherParId(int id) {

        try {

            Compte ext = new Compte();
            String req = "select * from compte where id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                ext.setNumCompte(rs.getString("num_compte"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin);
                ext.setMontant(rs.getInt("montant"));
            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    public List<Compte> findAll() {
        List<Compte> listeext = new ArrayList<>();

        try {
            String requete = "select * from compte";
            Statement statement = connection
                        .createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {
                Compte ext = new Compte();

                ext.setId(rs.getInt("id"));
                ext.setNumCompte(rs.getString("num_compte"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin);
                ext.setMontant(rs.getInt("montant"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

    public Compte RechercherParCin(Cin cin) {

        try {

            Compte ext = new Compte();
            String req = "select * from compte where cin=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, cin.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                ext.setNumCompte(rs.getString("num_compte"));
                CinDao enc = new CinDao();
                Cin cin1 = enc.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin1);
                ext.setMontant(rs.getInt("montant"));
            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

}
