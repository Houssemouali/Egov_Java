/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.util.logging.Logger;

/**
 *
 * @author Maynoo
 */
public class Cin {

    private int id;
    private String adresse, profession, lieuCreation, photo, empreinte, numCin;
    private ExtraitNaissance extrait;
    private Date dateCreation;

    public Cin() {
    }

    public Cin(int id, String adresse, String profession, String lieuCreation, String photo, String empreinte, String numCin, ExtraitNaissance extrait, Date dateCreation) {
        this.id = id;
        this.adresse = adresse;
        this.profession = profession;
        this.lieuCreation = lieuCreation;
        this.photo = photo;
        this.empreinte = empreinte;
        this.numCin = numCin;
        this.extrait = extrait;
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLieuCreation() {
        return lieuCreation;
    }

    public void setLieuCreation(String lieuCreation) {
        this.lieuCreation = lieuCreation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmpreinte() {
        return empreinte;
    }

    public void setEmpreinte(String empreinte) {
        this.empreinte = empreinte;
    }

    public String getNumCin() {
        return numCin;
    }

    public void setNumCin(String numCin) {
        this.numCin = numCin;
    }

    public ExtraitNaissance getExtrait() {
        return extrait;
    }

    public void setExtrait(ExtraitNaissance extrait) {
        this.extrait = extrait;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    private static final Logger LOG = Logger.getLogger(Cin.class.getName());
    

}
