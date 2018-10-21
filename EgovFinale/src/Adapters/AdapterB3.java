/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Dao.DemandeDao;
import Entities.Demande;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sami
 */
public class AdapterB3 extends AbstractTableModel {

    String[] headers;
    List<Demande> listeDemande = new ArrayList<>();
    DemandeDao dd;

    public AdapterB3() {

        this.headers = new String[]{"ID","Cin", "Nom", "Prenom", "Adresse", "Profession", "Etat", "Commentaire"};
        dd = new DemandeDao();
        listeDemande = dd.findAll("B3");
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
                return listeDemande.get(rowIndex).getCin().getNumCin();
            case 2:
                return listeDemande.get(rowIndex).getCin().getExtrait().getNom();
            case 3:
                return listeDemande.get(rowIndex).getCin().getExtrait().getPrenom();
            case 4:
                return listeDemande.get(rowIndex).getCin().getAdresse();
            case 5:
                return listeDemande.get(rowIndex).getCin().getProfession();
            case 6:
                return listeDemande.get(rowIndex).getEtat();
            case 7:
                return listeDemande.get(rowIndex).getCommentaire();
            default:
                return null;
        }
    }

}
