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
public class User {

    private int id, numtel;
    private String username, email, password, roles, poste;
    private Cin cin;
    private ExtraitNaissance extrait;

    public User() {
    }

    public User(int id, int numtel, String username, String email, String password, String roles, String poste, Cin cin, ExtraitNaissance extrait) {
        this.id = id;
        this.numtel = numtel;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.poste = poste;
        this.cin = cin;
        this.extrait = extrait;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Cin getCin() {
        return cin;
    }

    public void setCin(Cin cin) {
        this.cin = cin;
    }

    public ExtraitNaissance getExtrait() {
        return extrait;
    }

    public void setExtrait(ExtraitNaissance extrait) {
        this.extrait = extrait;
    }

}
