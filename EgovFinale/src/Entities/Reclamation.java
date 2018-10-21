/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author USER
 */
public class Reclamation {

    int id;
    String objet, description;
    Cin utilisateur;

    public Reclamation() {
    }

    public Reclamation(int id, Cin utilisateur, String objet, String description) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.objet = objet;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cin getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Cin utilisateur) {
        this.utilisateur = utilisateur;
    }

}
