/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cin;
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
public class CinDao {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public CinDao() {
        connection = (DataBase.getInstance()).getConnection();
    }

    public void add(Cin t) {
        try {
            String req = "insert into cin (extrait,adresse,profession,lieu_creation,date_creation,photo,empreinte,num_cin) values (?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, t.getExtrait().getId());
            pst.setString(2, t.getAdresse());
            pst.setString(3, t.getProfession());
            pst.setString(4, t.getLieuCreation());
            pst.setDate(5, t.getDateCreation());
            pst.setString(6, t.getPhoto());
            pst.setString(7, t.getEmpreinte());
            pst.setString(8, t.getNumCin());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CinDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Modifier(Cin t) {

        try {
            String req = "UPDATE `cin`SET`extrait`=?,`adresse`=?,`profession`=?,`lieu_creation`=?,`date_creation`=?,`photo`=? ,`empreinte`=? ,`num_cin`=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(req);

            pst.setInt(1, t.getExtrait().getId());
            pst.setString(2, t.getAdresse());
            pst.setString(3, t.getProfession());
            pst.setString(4, t.getLieuCreation());
            pst.setDate(5, t.getDateCreation());
            pst.setString(6, t.getPhoto());
            pst.setString(7, t.getEmpreinte());
            pst.setString(8, t.getNumCin());
            pst.setInt(9, t.getId());

            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour" + ex.getMessage());
        }
    }

    public void Supprimer(Cin t) {
        String req = "DELETE FROM `cin`WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, t.getId());
            ps.executeUpdate();
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression" + ex.getStackTrace());
        }
    }

    public Cin RechercherParId(int id) {

        try {

            Cin ext = new Cin();
            String req = "select * from cin where id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                ExtraitNaissanceDao enc = new ExtraitNaissanceDao();
                ExtraitNaissance cin = enc.RechercherParId(rs.getInt("extrait"));
                ext.setExtrait(cin);
                ext.setAdresse(rs.getString("adresse"));
                ext.setProfession(rs.getString("profession"));
                ext.setLieuCreation(rs.getString("lieu_creation"));
                ext.setDateCreation(rs.getDate("date_creation"));
                ext.setPhoto(rs.getString("photo"));
                ext.setEmpreinte(rs.getString("empreinte"));
                ext.setNumCin(rs.getString("num_cin"));
            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    public List<Cin> findAll() {
        List<Cin> listeext = new ArrayList<>();

        try {
            String requete = "select * from cin";
            Statement statement = connection
                        .createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {
                Cin ext = new Cin();

                ext.setId(rs.getInt("id"));
                ExtraitNaissanceDao enc = new ExtraitNaissanceDao();
                ExtraitNaissance cin = enc.RechercherParId(rs.getInt("extrait"));
                ext.setExtrait(cin);
                ext.setAdresse(rs.getString("adresse"));
                ext.setProfession(rs.getString("profession"));
                ext.setLieuCreation(rs.getString("lieu_creation"));
                ext.setDateCreation(rs.getDate("date_creation"));
                ext.setPhoto(rs.getString("photo"));
                ext.setEmpreinte(rs.getString("empreinte"));
                ext.setNumCin(rs.getString("num_cin"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CinDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

    public Cin RechercherParCin(String numCin) {

        try {

            Cin ext = new Cin();
            String req = "select * from cin where num_cin=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, numCin);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                ExtraitNaissanceDao enc = new ExtraitNaissanceDao();
                ExtraitNaissance cin = enc.RechercherParId(rs.getInt("extrait"));
                ext.setExtrait(cin);
                ext.setAdresse(rs.getString("adresse"));
                ext.setProfession(rs.getString("profession"));
                ext.setLieuCreation(rs.getString("lieu_creation"));
                ext.setDateCreation(rs.getDate("date_creation"));
                ext.setPhoto(rs.getString("photo"));
                ext.setEmpreinte(rs.getString("empreinte"));
                ext.setNumCin(rs.getString("num_cin"));
            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

}
