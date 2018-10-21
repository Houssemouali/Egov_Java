/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Dao.AutorisationDao;
import Entities.Demandeautorisation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class AdapterAutorisation extends AbstractTableModel {
    
    String[] headers;
    List<Demandeautorisation> listeDemande = new ArrayList<>();
    AutorisationDao dd;

    public AdapterAutorisation() {

        this.headers = new String[]{"ID","Cin", "CarteGrise", "cpp", "FinAutorisation", "etat", "commentaire"};
        dd = new AutorisationDao();
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
                return listeDemande.get(rowIndex).getCarteGrise();
            case 3:
                return listeDemande.get(rowIndex).getCpp().getNumCompte();
            case 4:
                return listeDemande.get(rowIndex).getFinAutorisation();
            case 5:
                return listeDemande.get(rowIndex).getEtat();
            case 6:
                return listeDemande.get(rowIndex).getCommentaire();
            default:
                return null;
        }
    }

    
}
