/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.User;

/**
 *
 * @author Maynoo
 */
public class loginInfo {
    public static User utilisateur;

    public static User getUtilisateur() {
        return utilisateur;
    }

    public static void setUtilisateur(User utilisateur) {
        loginInfo.utilisateur = utilisateur;
    }
    
    
}
