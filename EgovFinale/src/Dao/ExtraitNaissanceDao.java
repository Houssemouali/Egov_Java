/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

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
public class ExtraitNaissanceDao {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public ExtraitNaissanceDao() {
        connection = (DataBase.getInstance()).getConnection();
    }

    public void add(ExtraitNaissance t) {
        try {
            String req = "insert into extraitnaissances (nom,prenom,sexe,ville_naissance,date_naissance,pere,mere,etat_civile) values (?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getSexe());
            pst.setString(4, t.getVilleNaissance());
            pst.setDate(5, t.getDateNaissance());
            pst.setString(6, t.getPere());
            pst.setString(7, t.getMere());
            pst.setString(8, t.getEtatCivile());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExtraitNaissanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public void createPdf(int id) {
//        try {
//
//            ExtraitNaissanceDao dao = new ExtraitNaissanceDao();
//            ExtraitNaissance extrait
//                        = dao.RechercherParId(id);
//            OutputStream file = new FileOutputStream(new File("C:\\Users\\iheb\\Desktop\\iheb.pdf"));
//            Document document = new Document();
//            PdfWriter.getInstance(document, file);
//
//            document.open();
//            document.addAuthor("Iheb jemai ");
//            document.addCreationDate();
//            document.addCreator("Anuj Patel");
//            document.addTitle("List des Extraits naissance : ");
//            document.add(new Anchor("                     Extrait de naissance"));
//            document.add(new Paragraph("Num d'extrait de naissance :" + extrait.getNum_extrait()));
//            document.add(new Paragraph("Nom :" + extrait.getNom()));
//            document.add(new Paragraph("Prenom :" + extrait.getPrenom()));
//            document.add(new Paragraph("Nom du pere :" + extrait.getNomPere()));
//            document.add(new Paragraph("Nom de la mere :" + extrait.getNomMere()));
//            document.add(new Paragraph("adresse de naissance :" + extrait.getAdresse_naissance()));
//            document.add(new Paragraph("sex :" + extrait.getSex()));
//            document.add(new Paragraph("date de naissance :" + extrait.getDate_naissance()));
//            document.add(new Paragraph("Nationalite :" + extrait.getNationalite()));
//            document.add(new Paragraph(new Date().toString()));
//            document.close();
//            file.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void Modifier(ExtraitNaissance t) {

        try {
            String req = "UPDATE `extraitnaissances`SET`nom`=?,`prenom`=?,`sexe`=?,`vile_naissance`=?,`date_naissance`=?,`pere`=? ,`mere`=? ,`etat_civile`=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(req);

            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getSexe());
            pst.setString(4, t.getVilleNaissance());
            pst.setDate(5, t.getDateNaissance());
            pst.setString(6, t.getPere());
            pst.setString(7, t.getMere());
            pst.setString(8, t.getEtatCivile());
            pst.setInt(9, t.getId());

            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour" + ex.getMessage());
        }
    }

    public void Supprimer(ExtraitNaissance t) {
        String req = "DELETE FROM `extraitnaissances`WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setInt(1, t.getId());
            ps.executeUpdate();
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression" + ex.getStackTrace());
        }
    }

    public ExtraitNaissance RechercherParId(int id) {

        try {

            ExtraitNaissance ext = new ExtraitNaissance();
            String req = "select * from extraitnaissances where id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ext.setId(rs.getInt("id"));
                ext.setNom(rs.getString("nom"));
                ext.setPrenom(rs.getString("prenom"));
                ext.setSexe(rs.getString("sexe"));
                ext.setVilleNaissance(rs.getString("ville_naissance"));
                ext.setDateNaissance(rs.getDate("date_naissance"));
                ext.setPere(rs.getString("pere"));
                ext.setMere(rs.getString("mere"));
                ext.setEtatCivile(rs.getString("etat_civile"));
            }
            return ext;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    public List<ExtraitNaissance> findAll() {
        List<ExtraitNaissance> listeext = new ArrayList<>();

        try {
            String requete = "select * from extraitnaissances";
            Statement statement = connection
                        .createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {
                ExtraitNaissance ext = new ExtraitNaissance();

                ext.setId(rs.getInt("id"));
                ext.setNom(rs.getString("nom"));
                ext.setPrenom(rs.getString("prenom"));
                ext.setPrenom(rs.getString("sexe"));
                ext.setVilleNaissance(rs.getString("ville_naissance"));
                ext.setDateNaissance(rs.getDate("date_naissance"));
                ext.setPere(rs.getString("pere"));
                ext.setMere(rs.getString("mere"));
                ext.setEtatCivile(rs.getString("etat_civile"));

                listeext.add(ext);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExtraitNaissanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeext;
    }

}
