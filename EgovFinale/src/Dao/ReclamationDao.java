/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cin;
import Entities.Reclamation;
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
public class ReclamationDao {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public ReclamationDao() {
        connection = (DataBase.getInstance()).getConnection();
    }

    public void add(Reclamation t) {
        try {
            String req = "insert into reclamation (objet,description,utilisateur) values (?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setString(1, t.getObjet());
            pst.setString(2, t.getDescription());
            pst.setInt(3, t.getUtilisateur().getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Modifier(Reclamation t) {

        try {
            String req = "UPDATE `reclamation` SET `objet`=?,`description`=?,`utilisateur`=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(req);

            pst.setString(1, t.getObjet());
            pst.setString(2, t.getDescription());
            pst.setInt(3, t.getUtilisateur().getId());
            pst.setInt(4, t.getId());

            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour" + ex.getMessage());
        }
    }

    public void Supprimer(Reclamation t) {
        String req = "DELETE FROM `reclamation`WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, t.getId());
            ps.executeUpdate();
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression" + ex.getStackTrace());
        }
    }

    public Reclamation RechercherParId(int id) {

        try {

            Reclamation ext = new Reclamation();
            String req = "select * from reclamation where id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                ext.setObjet(rs.getString("objet"));
                ext.setDescription(rs.getString("description"));
                CinDao cd = new CinDao();
                Cin cin = cd.RechercherParId(rs.getInt("utilisateur"));
                ext.setUtilisateur(cin);
            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    public List<Reclamation> findAll() {
        List<Reclamation> listeext = new ArrayList<>();

        try {
            String requete = "select * from cin";
            Statement statement = connection
                    .createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {
                Reclamation ext = new Reclamation();

                ext.setId(rs.getInt("id"));
                ext.setObjet(rs.getString("objet"));
                ext.setDescription(rs.getString("description"));
                CinDao cd = new CinDao();
                Cin cin = cd.RechercherParId(rs.getInt("utilisateur"));
                ext.setUtilisateur(cin);

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

}
