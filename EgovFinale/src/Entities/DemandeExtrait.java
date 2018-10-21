/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Maynoo
 */
public class DemandeExtrait {

    private int id;
    private String nom, prenom, lieuNaissance, etat, commentaire;
    private Cin pere, mere;
    private Date dateNaissance;

    public DemandeExtrait() {
    }

    public DemandeExtrait(int id, String nom, String prenom, String lieuNaissance, String etat, String commentaire, Cin pere, Cin mere, Date dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.lieuNaissance = lieuNaissance;
        this.etat = etat;
        this.commentaire = commentaire;
        this.pere = pere;
        this.mere = mere;
        this.dateNaissance = dateNaissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Cin getPere() {
        return pere;
    }

    public void setPere(Cin pere) {
        this.pere = pere;
    }

    public Cin getMere() {
        return mere;
    }

    public void setMere(Cin mere) {
        this.mere = mere;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

}
