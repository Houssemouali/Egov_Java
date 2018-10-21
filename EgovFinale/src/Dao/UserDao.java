/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cin;
import Entities.ExtraitNaissance;
import Entities.User;
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
public class UserDao {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public UserDao() {
        connection = (DataBase.getInstance()).getConnection();
    }

    public void add(User t) {
        try {
            String req = "INSERT INTO `fos_user`(`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `locked`, `expired`, `expires_at`, `confirmation_token`, `password_requested_at`, `roles`, `credentials_expired`, `credentials_expire_at`, `cin`, `extraitnaissance`, `numtel`, `poste`,`nopass`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getEmail());
            pst.setInt(5, 1);
            pst.setString(6, "");
            pst.setString(7, "");
            pst.setDate(8, null);
            pst.setInt(9, 0);
            pst.setInt(10, 0);
            pst.setDate(11, null);
            pst.setString(12, null);
            pst.setDate(13, null);
            pst.setString(14, t.getRoles());
            pst.setInt(15, 0);
            pst.setDate(16, null);
            pst.setInt(17, t.getCin().getId());
            pst.setInt(18, t.getExtrait().getId());
            pst.setInt(19, t.getNumtel());
            pst.setString(20, t.getPoste());
            pst.setString(21, t.getPassword());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Modifier(User t) {

        try {
            String req = "UPDATE `fos_user`SET `username`=?,`username_canonical`=?,`email`=?,`email_canonical`=?,`roles`=?,`cin`=?,`extraitnaissance`=?,`numtel`=?,`poste`=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(req);

            pst.setString(1, t.getUsername());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getEmail());
            pst.setString(5, t.getRoles());
            pst.setInt(6, t.getCin().getId());
            pst.setInt(7, t.getExtrait().getId());
            pst.setInt(8, t.getNumtel());
            pst.setString(9, t.getPoste());

            pst.setInt(10, t.getId());

            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour" + ex.getMessage());
        }
    }

    public void Supprimer(User t) {
        String req = "DELETE FROM `fos_user`WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, t.getId());
            ps.executeUpdate();
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression" + ex.getStackTrace());
        }
    }

    public User RechercherParId(int id) {

        try {

            User ext = new User();
            String req = "select * from fos_user where id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));

                ext.setUsername(rs.getString("username"));
                ext.setEmail(rs.getString("email"));
                ext.setRoles(rs.getString("roles"));

                ExtraitNaissanceDao enc = new ExtraitNaissanceDao();
                ExtraitNaissance cin = enc.RechercherParId(rs.getInt("cin"));
                ext.setExtrait(cin);

                CinDao enc1 = new CinDao();
                Cin cin1 = enc1.RechercherParId(rs.getInt("extraitnaissance"));
                ext.setCin(cin1);

                ext.setNumtel(rs.getInt("numtel"));
                ext.setPoste(rs.getString("poste"));
                ext.setPassword(rs.getString("nopass"));

            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    public List<User> findAll() {
        List<User> listeext = new ArrayList<>();

        try {
            String requete = "select * from fos_user";
            Statement statement = connection
                        .createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {
                User ext = new User();

                ext.setId(rs.getInt("id"));

                ext.setUsername(rs.getString("username"));
                ext.setEmail(rs.getString("email"));
                ext.setRoles(rs.getString("roles"));

                ExtraitNaissanceDao enc = new ExtraitNaissanceDao();
                ExtraitNaissance cin = enc.RechercherParId(rs.getInt("cin"));
                ext.setExtrait(cin);

                CinDao enc1 = new CinDao();
                Cin cin1 = enc1.RechercherParId(rs.getInt("extraitnaissance"));
                ext.setCin(cin1);

                ext.setNumtel(rs.getInt("numtel"));
                ext.setPoste(rs.getString("poste"));
                ext.setPassword(rs.getString("nopass"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

    public User RechercherParUsername(String username) {

        try {

            User ext = new User();
            String req = "select * from fos_user where username=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));

                ext.setUsername(rs.getString("username"));
                ext.setEmail(rs.getString("email"));
                ext.setRoles(rs.getString("roles"));

                ExtraitNaissanceDao enc = new ExtraitNaissanceDao();
                ExtraitNaissance cin = enc.RechercherParId(rs.getInt("cin"));
                ext.setExtrait(cin);

                CinDao enc1 = new CinDao();
                Cin cin1 = enc1.RechercherParId(rs.getInt("extraitnaissance"));
                ext.setCin(cin1);

                ext.setNumtel(rs.getInt("numtel"));
                ext.setPoste(rs.getString("poste"));
                ext.setPassword(rs.getString("nopass"));

            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

}
