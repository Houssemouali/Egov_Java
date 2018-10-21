/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Dao.DemandeDao;
import Dao.DemandeExtraitDao;
import Entities.Demande;
import Entities.DemandeExtrait;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sami
 */
public class AdapterExtraitNaissance extends AbstractTableModel {

    String[] headers;
    List<DemandeExtrait> listeDemande = new ArrayList<>();
    DemandeExtraitDao dd;

    public AdapterExtraitNaissance() {

        this.headers = new String[]{"ID", "Nom", "Prenom", "Lieu Naissance", "date Naissance", "Pere", "Mere", "Etat", "Commentaire"};
        dd = new DemandeExtraitDao();
        listeDemande = dd.findAll();
    }

    @Override
    public int getRowCount() {
        return listeDemande.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int i) {
        return headers[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int colmunIndex) {
        switch (colmunIndex) {
            case 0:
                return listeDemande.get(rowIndex).getId();
            case 1:
                return listeDemande.get(rowIndex).getNom();
            case 2:
                return listeDemande.get(rowIndex).getPrenom();
            case 3:
                return listeDemande.get(rowIndex).getLieuNaissance();
            case 4:
                return listeDemande.get(rowIndex).getDateNaissance();
            case 5:
                return listeDemande.get(rowIndex).getPere().getExtrait().getNom() + " " + listeDemande.get(rowIndex).getPere().getExtrait().getPrenom();
            case 6:
                return listeDemande.get(rowIndex).getMere().getExtrait().getNom() + " " + listeDemande.get(rowIndex).getMere().getExtrait().getPrenom();
            case 7:
                return listeDemande.get(rowIndex).getEtat();
            case 8:
                return listeDemande.get(rowIndex).getCommentaire();
            default:
                return null;
        }
    }

}
