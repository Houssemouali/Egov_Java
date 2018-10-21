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
public class Compte {

    private int id;
    private String numCompte;
    private Cin cin;
    private int montant;

    public Compte() {
    }

    public Compte(int id, String numCompte, Cin cin, int montant) {
        this.id = id;
        this.numCompte = numCompte;
        this.cin = cin;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Cin getCin() {
        return cin;
    }

    public void setCin(Cin cin) {
        this.cin = cin;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

}
