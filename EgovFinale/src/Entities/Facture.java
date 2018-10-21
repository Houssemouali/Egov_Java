/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Facture {

    
    private int id;
    private int Montant;
    private String Type;
    private Cin cin;
    private Compte cpp;
    private Date PayerAvant;
    private String etat, commentaire;
    
    public Facture(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return Montant;
    }

    public void setMontant(int Montant) {
        this.Montant = Montant;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public Cin getCin() {
        return cin;
    }

    public void setCin(Cin cin) {
        this.cin = cin;
    }

    public Compte getCpp() {
        return cpp;
    }

    public void setCpp(Compte cpp) {
        this.cpp = cpp;
    }

    public Date getPayerAvant() {
        return PayerAvant;
    }

    public void setPayerAvant(Date PayerAvant) {
        this.PayerAvant = PayerAvant;
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
    
    public Facture(int id, int montant, String type, Date PayerAvant, Cin cin) {
        this.id = id;
        this.Montant = Montant;
        this.Type = Type;
        this.PayerAvant = PayerAvant;
        this.cin = cin;
    }
    
}
