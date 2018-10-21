/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cin;
import Entities.DemandeExtrait;
import Technique.DataBase;
import java.sql.Connection;
import java.sql.Date;
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
public class DemandeExtraitDao {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DemandeExtraitDao() {
        connection = (DataBase.getInstance()).getConnection();
    }

    public void add(DemandeExtrait t) {
        try {
            String req = "insert into demandeextrait (nom,prenom,lieu_naissance,date_naissance,cin_pere,cin_mere,etat,commentaire) values (?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);

            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getLieuNaissance());
            pst.setDate(4, t.getDateNaissance());
            pst.setInt(5, t.getPere().getId());
            pst.setInt(6, t.getMere().getId());
            pst.setString(7, t.getEtat());
            pst.setString(8, t.getCommentaire());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DemandeExtraitDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Modifier(DemandeExtrait t) {

        try {
            String req = "UPDATE `demandeextrait`SET`nom`=?,`prenom`=?,`lieu_naissance`=?,`date_naissance`=?,`cin_pere`=?,`cin_mere`=?,`etat`=?,`commentaire`=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(req);

            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getLieuNaissance());
            pst.setDate(4, t.getDateNaissance());
            pst.setInt(5, t.getPere().getId());
            pst.setInt(6, t.getMere().getId());
            pst.setString(7, t.getEtat());
            pst.setString(8, t.getCommentaire());

            pst.setInt(9, t.getId());

            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour" + ex.getMessage());
        }
    }

    public void Supprimer(DemandeExtrait t) {
        String req = "DELETE FROM `demandeextrait`WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, t.getId());
            ps.executeUpdate();
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression" + ex.getStackTrace());
        }
    }

    public DemandeExtrait RechercherParId(int id) {

        try {

            DemandeExtrait ext = new DemandeExtrait();
            String req = "select * from demandeextrait where id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                ext.setNom(rs.getString("nom"));
                ext.setPrenom(rs.getString("prenom"));
                ext.setLieuNaissance(rs.getString("lieu_naissance"));
                ext.setDateNaissance(rs.getDate("date_naissance"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin_pere"));
                ext.setPere(cin);
                cin = enc.RechercherParId(rs.getInt("cin_mere"));
                ext.setMere(cin);
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));
            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    public List<DemandeExtrait> findAll() {
        List<DemandeExtrait> listeext = new ArrayList<>();

        try {
            String requete = "select * from demandeextrait";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while (rs.next()) {
                DemandeExtrait ext = new DemandeExtrait();

                ext.setId(rs.getInt("id"));
                ext.setNom(rs.getString("nom"));
                ext.setPrenom(rs.getString("prenom"));
                ext.setLieuNaissance(rs.getString("lieu_naissance"));
                ext.setDateNaissance(rs.getDate("date_naissance"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin_pere"));
                ext.setPere(cin);
                cin = enc.RechercherParId(rs.getInt("cin_mere"));
                ext.setMere(cin);
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DemandeExtraitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

    public List<DemandeExtrait> findByCitoyen(String nom, String prenom, String lieu, Date date) {
        List<DemandeExtrait> listeext = new ArrayList<>();

        try {
            String req = "select * from demandeextrait where nom=? and prenom=? and lieu_naissance=? and date_naissance=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, lieu);
            ps.setDate(4, date);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                DemandeExtrait ext = new DemandeExtrait();

                ext.setId(rs.getInt("id"));
                ext.setNom(rs.getString("nom"));
                ext.setPrenom(rs.getString("prenom"));
                ext.setLieuNaissance(rs.getString("lieu_naissance"));
                ext.setDateNaissance(rs.getDate("date_naissance"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin_pere"));
                ext.setPere(cin);
                cin = enc.RechercherParId(rs.getInt("cin_mere"));
                ext.setMere(cin);
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DemandeExtraitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

}
