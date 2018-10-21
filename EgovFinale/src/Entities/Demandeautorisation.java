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
public class Demandeautorisation {

    private int id;
    private int CarteGrise;
    private Cin cin;
    private Compte cpp;
    private Date FinAutorisation;
    private String etat, commentaire;

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

    public Demandeautorisation() {
    }

    public Demandeautorisation(int id, int CarteGrise, Compte cpp, Date FinAutorisation, Cin cin) {
        this.id = id;
        this.CarteGrise = CarteGrise;
        this.cpp = cpp;
        this.FinAutorisation = FinAutorisation;
        this.cin = cin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarteGrise() {
        return CarteGrise;
    }

    public void setCarteGrise(int CarteGrise) {
        this.CarteGrise = CarteGrise;
    }

    public Compte getCpp() {
        return cpp;
    }

    public void setCpp(Compte cpp) {
        this.cpp = cpp;
    }

    public Cin getCin() {
        return cin;
    }

    public void setCin(Cin cin) {
        this.cin = cin;
    }

    public Date getFinAutorisation() {
        return FinAutorisation;
    }

    public void setFinAutorisation(Date FinAutorisation) {
        this.FinAutorisation = FinAutorisation;
    }

}
