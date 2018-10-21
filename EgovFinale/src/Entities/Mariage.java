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
public class Mariage {

    private int id;
    private Cin homme, femme;
    private Date dateMariage;

    public Mariage() {
    }

    public Mariage(int id, Cin homme, Cin femme, Date dateMariage) {
        this.id = id;
        this.homme = homme;
        this.femme = femme;
        this.dateMariage = dateMariage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cin getHomme() {
        return homme;
    }

    public void setHomme(Cin homme) {
        this.homme = homme;
    }

    public Cin getFemme() {
        return femme;
    }

    public void setFemme(Cin femme) {
        this.femme = femme;
    }

    public Date getDateMariage() {
        return dateMariage;
    }

    public void setDateMariage(Date dateMariage) {
        this.dateMariage = dateMariage;
    }

}
