/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Maynoo
 */
public class Demande {

    private int id;
    private String type, etat, commentaire;
    private Cin cin;

    public Demande() {
    }

    public Demande(int id, String type, String etat, String commentaire, Cin cin) {
        this.id = id;
        this.type = type;
        this.etat = etat;
        this.commentaire = commentaire;
        this.cin = cin;
    }

    public Cin getCin() {
        return cin;
    }

    public void setCin(Cin cin) {
        this.cin = cin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

}
