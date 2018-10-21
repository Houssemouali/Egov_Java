/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Dao.AutorisationDao;
import Dao.FactureDao;
import Entities.Facture;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class AdapterFacture extends AbstractTableModel {
    
     String[] headers;
    List<Facture> listeDemande = new ArrayList<>();
    FactureDao dd;
    
public AdapterFacture() {

        this.headers = new String[]{"ID","Cin", "Type", "Montant", "PayerAvant", "etat", "commentaire"};
        dd = new FactureDao();
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
                return listeDemande.get(rowIndex).getCin().getNumCin();
            case 2:
                return listeDemande.get(rowIndex).getType();
            case 3:
                return listeDemande.get(rowIndex).getMontant();
            case 4:
                return listeDemande.get(rowIndex).getPayerAvant();
            case 5:
                return listeDemande.get(rowIndex).getEtat();
            case 6:
                return listeDemande.get(rowIndex).getCommentaire();
            default:
                return null;
        }
    }

    
}
