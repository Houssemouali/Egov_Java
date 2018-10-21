/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cin;
import Entities.Mariage;
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
public class MariageDao {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public MariageDao() {
        connection = (DataBase.getInstance()).getConnection();
    }

    public void add(Mariage t) {
        try {
            String req = "insert into mariage (cin_homme,cin_femme,date_mariage) values (?,?,?)";
            pst = connection.prepareStatement(req);

            pst.setInt(1, t.getHomme().getId());
            pst.setInt(2, t.getFemme().getId());
            pst.setDate(3, t.getDateMariage());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MariageDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Modifier(Mariage t) {

        try {
            String req = "UPDATE `mariage`SET `cin_homme`=?,`cin_femme`=?,`date_mariage`=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(req);

            pst.setInt(1, t.getHomme().getId());
            pst.setInt(2, t.getFemme().getId());
            pst.setDate(3, t.getDateMariage());
            pst.setInt(4, t.getId());

            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour" + ex.getMessage());
        }
    }

    public void Supprimer(Mariage t) {
        String req = "DELETE FROM `mariage`WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, t.getId());
            ps.executeUpdate();
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression" + ex.getStackTrace());
        }
    }

    public Mariage RechercherParId(int id) {

        try {

            Mariage ext = new Mariage();
            String req = "select * from mariage where id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin_homme"));
                ext.setHomme(cin);
                cin = enc.RechercherParId(rs.getInt("cin_femme"));
                ext.setFemme(cin);
                ext.setDateMariage(rs.getDate("date_mariage"));
            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    public List<Mariage> findAll() {
        List<Mariage> listeext = new ArrayList<>();

        try {
            String requete = "select * from mariage";
            Statement statement = connection
                        .createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {
                Mariage ext = new Mariage();

                ext.setId(rs.getInt("id"));
                CinDao enc = new CinDao();
                Cin cin = enc.RechercherParId(rs.getInt("cin_homme"));
                ext.setHomme(cin);
                cin = enc.RechercherParId(rs.getInt("cin_femme"));
                ext.setFemme(cin);
                ext.setDateMariage(rs.getDate("date_mariage"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MariageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

}
