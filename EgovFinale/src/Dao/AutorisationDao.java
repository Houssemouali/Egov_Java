/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cin;
import Entities.Compte;
import Entities.Reclamation;
import Entities.Demandeautorisation;
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
public class AutorisationDao {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public AutorisationDao() {
        connection = (DataBase.getInstance()).getConnection();
    }

    public void add(Demandeautorisation ac) {
        try {
            String req = "insert into autorisationcirculation (cin,CarteGrise,cpp,FinAutorisation,etat,commentaire) values (?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, ac.getCin().getId());
            pst.setInt(2, ac.getCarteGrise());
            pst.setInt(3, ac.getCpp().getId());
            pst.setDate(4, ac.getFinAutorisation());
            pst.setString(5, ac.getEtat());
            pst.setString(6, ac.getCommentaire());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AutorisationDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Modifier(Demandeautorisation ac) {

        try {
            String req = "UPDATE `autorisationcirculation` SET `cin`=?,`CarteGrise`=?,`cpp`=?,`FinAutorisation`=?,`etat`=?,`commentaire`=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(req);

            pst.setInt(1, ac.getCin().getId());
            pst.setInt(2, ac.getCarteGrise());
            pst.setInt(3, ac.getCpp().getId());
            pst.setDate(4, ac.getFinAutorisation());
            pst.setString(5, ac.getEtat());
            pst.setString(6, ac.getCommentaire());
            pst.setInt(7, ac.getId());

            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour" + ex.getMessage());
        }
    }

    public void Supprimer(Demandeautorisation ac) {
        String req = "DELETE FROM `autorisationcirculation` WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, ac.getId());
            ps.executeUpdate();
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression" + ex.getStackTrace());
        }
    }

    public Demandeautorisation RechercherParId(int id) {

        try {

            Demandeautorisation ext = new Demandeautorisation();
            String req = "select * from autorisationcirculation where id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                CinDao cd = new CinDao();
                Cin cin = cd.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin);
                ext.setCarteGrise(rs.getInt("CarteGrise"));
                CompteDao comptedao=new CompteDao();
                Compte c = comptedao.RechercherParId(rs.getInt("cpp"));
                ext.setCpp(c);
                ext.setFinAutorisation(rs.getDate("FinAutorisation"));
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));

            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    public List<Demandeautorisation> findAll() {
        List<Demandeautorisation> listeext = new ArrayList<>();

        try {
            String requete = "select * from autorisationcirculation";
            Statement statement = connection
                    .createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while (rs.next()) {
                Demandeautorisation ext = new Demandeautorisation();

                ext.setId(rs.getInt("id"));
                CinDao cd = new CinDao();
                Cin cin = cd.RechercherParId(rs.getInt("cin"));
                ext.setCin(cin);
                ext.setCarteGrise(rs.getInt("CarteGrise"));
                CompteDao comptedao=new CompteDao();
                Compte c = comptedao.RechercherParId(rs.getInt("cpp"));
                ext.setCpp(c);
                ext.setFinAutorisation(rs.getDate("FinAutorisation"));
                ext.setEtat(rs.getString("etat"));
                ext.setCommentaire(rs.getString("commentaire"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AutorisationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

}
