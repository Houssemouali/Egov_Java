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
public class ExtraitNaissance {

    private String nom, prenom, sexe, villeNaissance, etatCivile, pere, mere;
    private int id;
    private Date dateNaissance;

    public ExtraitNaissance() {
    }

    public ExtraitNaissance(String nom, String prenom, String sexe, String villeNaissance, String etatCivile, int id, String pere, String mere, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.villeNaissance = villeNaissance;
        this.etatCivile = etatCivile;
        this.id = id;
        this.pere = pere;
        this.mere = mere;
        this.dateNaissance = dateNaissance;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getVilleNaissance() {
        return villeNaissance;
    }

    public void setVilleNaissance(String villeNaissance) {
        this.villeNaissance = villeNaissance;
    }

    public String getEtatCivile() {
        return etatCivile;
    }

    public void setEtatCivile(String etatCivile) {
        this.etatCivile = etatCivile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPere() {
        return pere;
    }

    public void setPere(String pere) {
        this.pere = pere;
    }

    public String getMere() {
        return mere;
    }

    public void setMere(String mere) {
        this.mere = mere;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

}
