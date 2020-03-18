package nusasort;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import nusasort.ModelNasabah;
import nusasort.DBConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class NusaSorter {

    private ArrayList<ModelNasabah> listNasabah;
    private boolean isSorted;
    private ModelNasabah nsb;

    public NusaSorter() {

    }

    public ArrayList<ModelNasabah> getDbList() {
        listNasabah = new ArrayList<ModelNasabah>();
        try {
            PreparedStatement ps = DBConnection.getConnection()
                    .prepareStatement("select*from nasabah");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nsb = new ModelNasabah();
                nsb.setId(rs.getInt("id_nasabah"));
                nsb.setNama(rs.getString("nama"));
                listNasabah.add(nsb);
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listNasabah;
    }

    public ArrayList<ModelNasabah> doBubbleSort(boolean ascending) {

        listNasabah = getDbList();

        ModelNasabah temp = null;
        // algo
        if (listNasabah.size() > 1) {
            for (int x = 0; x < listNasabah.size(); x++) {
                isSorted = true;
                for (int i = 0; i < (listNasabah.size() - x - 1); i++) {

                    if ((listNasabah.get(i).getNama()).compareToIgnoreCase(listNasabah.get(i+1).getNama()) > 0) {
                        temp = (listNasabah.get(i));
                        listNasabah.set(i, listNasabah.get(i + 1));
                        listNasabah.set(i + 1, temp);
                    }

                }

            }
        }

        return listNasabah;
    }

    public ArrayList<ModelNasabah> doSelectionSort() {
        ModelNasabah nasabah = new ModelNasabah();
        listNasabah = getDbList();
        for (int i=0; i<listNasabah.size();i++){
            int min = listNasabah.get(i).getId();
            int minIndex = 1;
            
            for (int j = i+1; j < listNasabah.size(); j++) {
                if (listNasabah.get(j).getId() < min) {
                    min = listNasabah.get(j).getId();
                }
            }
            if (i != minIndex) {
                Collections.swap(listNasabah, i, minIndex);
            }
        }
        return listNasabah;
    }

    public ArrayList<ModelNasabah> doInsertionSort() {
        ModelNasabah current = new ModelNasabah();
        listNasabah = getDbList();

        for (int j = 1; j < listNasabah.size(); j++) {
            current.setNama(listNasabah.get(j).getNama());
            current.setId(listNasabah.get(j).getId());
            int i = j;
            while ((i > 0) && (listNasabah.get(i - 1).getId() > current.getId())) {
                listNasabah.set(i, listNasabah.get(i - 1));
                i--;
            }
            listNasabah.set(i, current);
        }
        return listNasabah;
    }

    public void doMergeSort() {

    }
}
