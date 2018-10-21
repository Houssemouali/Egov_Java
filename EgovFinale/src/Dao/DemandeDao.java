/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cin;
import Entities.Demande;
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
public class DemandeDao {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DemandeDao() {
        connection = (DataBase.getInstance()).getConnection();
    }

    public void add(Demande t) {
        try {
            String req = "insert into demande (type,cin,etat,commentaire) values (?,?,?,?)";
            pst = connection.prepareStatement(req);

            pst.setString(1, t.getType());
            pst.setInt(2, t.getCin().getId());
            pst.setString(3, t.getEtat());
            pst.setString(4, t.getCommentaire());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DemandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Modifier(Demande t) {

        try {
            String req = "UPDATE `demande` SET `type`=?,`cin`=?,`etat`=?,`commentaire`=? WHERE id=?";
            pst = connection.prepareStatement(req);

            pst.setString(1, t.getType());
            pst.setInt(2, t.getCin().getId());
            pst.setString(3, t.getEtat());
            pst.setString(4, t.getCommentaire());

            pst.setInt(5, t.getId());

            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour" + ex.getMessage());
        }
    }

    public void Supprimer(Demande t) {
        String req = "DELETE FROM `demande`WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, t.getId());
            ps.executeUpdate();
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression" + ex.getStackTrace());
        }
    }

    public Demande RechercherParId(int id) {

        try {

            Demande ext = new Demande();
            String req = "select * from demande where id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                ext.setType(rs.getString("type"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin);;
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));
            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    public List<Demande> findAll() {
        List<Demande> listeext = new ArrayList<>();

        try {
            String requete = "select * from demande";
            Statement statement = connection
                        .createStatement();
            rs = statement.executeQuery(requete);

            while (rs.next()) {
                Demande ext = new Demande();

                ext.setId(rs.getInt("id"));
                ext.setType(rs.getString("type"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin);;
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DemandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

    public List<Demande> findAll(String type) {
        List<Demande> listeext = new ArrayList<>();

        try {
            String requete = "select * from demande where type='" + type + "'";
            Statement statement = connection
                        .createStatement();
            rs = statement.executeQuery(requete);

            while (rs.next()) {
                Demande ext = new Demande();

                ext.setId(rs.getInt("id"));
                ext.setType(rs.getString("type"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin);;
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DemandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }
    
    public List<Demande> findByCin(String cinn) {
        List<Demande> listeext = new ArrayList<>();

        try {
            String requete = "select * from demande where cin='" + cinn + "'";
            Statement statement = connection
                        .createStatement();
            rs = statement.executeQuery(requete);

            while (rs.next()) {
                Demande ext = new Demande();

                ext.setId(rs.getInt("id"));
                ext.setType(rs.getString("type"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin);;
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DemandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

}
