package nusasort;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    //Class nasabahClass;
    //private Field id;
    //private Field name;
    //private Field nik;
    //private Field username;
    //private Field field;
    
    private ModelNasabah nsb;
    private String key;

    public NusaSorter() {

    }

    // INITIALIZE TABLE NASABAH 
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
                nsb.setNik(rs.getInt("nik"));
                nsb.setUsername(rs.getString("username_nasabah"));
                listNasabah.add(nsb);
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listNasabah;
    }

    // BUBBLE SORT
    public ArrayList<ModelNasabah> doBubbleSort(ArrayList<ModelNasabah> obj, String key) {
        listNasabah = obj;

        ModelNasabah temp = null;

        if (listNasabah.size() > 1) {
            for (int x = 0; x < listNasabah.size(); x++) {
                for (int i = 0; i < (listNasabah.size() - x - 1); i++) {

                    if (key.equalsIgnoreCase("id")) {
                        if ((listNasabah.get(i).getId()) > (listNasabah.get(i + 1).getId())) {
                            temp = (listNasabah.get(i));
                            listNasabah.set(i, listNasabah.get(i + 1));
                            listNasabah.set(i + 1, temp);
                        }
                    } else if (key.equalsIgnoreCase("name")) {
                        if ((listNasabah.get(i).getNama()).compareToIgnoreCase(listNasabah.get(i + 1).getNama()) > 0) {
                            temp = (listNasabah.get(i));
                            listNasabah.set(i, listNasabah.get(i + 1));
                            listNasabah.set(i + 1, temp);
                        }
                    } else if (key.equalsIgnoreCase("nik")) {
                        if ((listNasabah.get(i).getNik()) > (listNasabah.get(i + 1).getNik())) {
                            temp = (listNasabah.get(i));
                            listNasabah.set(i, listNasabah.get(i + 1));
                            listNasabah.set(i + 1, temp);
                        }
                    } else if (key.equalsIgnoreCase("username")) {
                        if ((listNasabah.get(i).getUsername()).compareToIgnoreCase(listNasabah.get(i + 1).getUsername()) > 0) {
                            temp = (listNasabah.get(i));
                            listNasabah.set(i, listNasabah.get(i + 1));
                            listNasabah.set(i + 1, temp);
                        }
                    }

                }

            }
        }

        return listNasabah;
    }

    // SELECTION SORT
    public ArrayList<ModelNasabah> doSelectionSort(ArrayList<ModelNasabah> obj, String key) {
        ModelNasabah nasabah = new ModelNasabah();
        listNasabah = obj;
        
        if (key.equalsIgnoreCase("id")){
            for (int i = 0; i < listNasabah.size(); i++) {
                int min = listNasabah.get(i).getId();
                int minIndex = 1;

                for (int j = i + 1; j < listNasabah.size(); j++) {
                    if (listNasabah.get(j).getId() < min) {
                        min = listNasabah.get(j).getId();
                    }
                }
                if (i != minIndex) {
                    Collections.swap(listNasabah, i, minIndex);
                }
            }
        } else if (key.equalsIgnoreCase("name")) {
            for (int i = 0; i < listNasabah.size(); i++) {
                String tempName = listNasabah.get(i).getNama();
                int minIndex = 1;

                for (int j = i + 1; j < listNasabah.size(); j++) {
                    if (listNasabah.get(j).getNama().compareToIgnoreCase(tempName)>0) {
                        tempName = listNasabah.get(j).getNama();
                    }
                }
                if (i != minIndex) {
                    Collections.swap(listNasabah, i, minIndex);
                }
            }
        } else if (key.equalsIgnoreCase("nik")) {
            for (int i = 0; i < listNasabah.size(); i++) {
                int tempNik = listNasabah.get(i).getNik();
                int minIndex = 1;

                for (int j = i + 1; j < listNasabah.size(); j++) {
                    if (listNasabah.get(j).getId() < tempNik) {
                        tempNik = listNasabah.get(j).getId();
                    }
                }
                if (i != minIndex) {
                    Collections.swap(listNasabah, i, minIndex);
                }
            }
        } else if (key.equalsIgnoreCase("username")) {
            for (int i = 0; i < listNasabah.size(); i++) {
                String tempUsername = listNasabah.get(i).getUsername();
                int minIndex = 1;

                for (int j = i + 1; j < listNasabah.size(); j++) {
                    if (listNasabah.get(j).getUsername().compareToIgnoreCase(tempUsername)>0) {
                        tempUsername = listNasabah.get(j).getUsername();
                    }
                }
                if (i != minIndex) {
                    Collections.swap(listNasabah, i, minIndex);
                }
            }
        }
        
        
        return listNasabah;
    }

    // INSERTION SORT
    public ArrayList<ModelNasabah> doInsertionSort(ArrayList<ModelNasabah> obj, String key) {

        listNasabah = getDbList();
        ModelNasabah current;
        int i, j;

        if (key.equalsIgnoreCase("id")) {
            // with int id
            for (i = 1; i < listNasabah.size(); i++) {
                current = new ModelNasabah();
                current.setNama(listNasabah.get(i).getNama());
                current.setId(listNasabah.get(i).getId());
                current.setNik(listNasabah.get(i).getNik());
                current.setUsername(listNasabah.get(i).getUsername());
                j = i;
                while ((j > 0) && (listNasabah.get(j - 1).getId() > current.getId())) {
                    listNasabah.set(i, listNasabah.get(j - 1));
                    i--;
                }
                listNasabah.set(j, current);
            }

        } else if (key.equalsIgnoreCase("name")) {
            // with string nama
            for (i = 1; i < listNasabah.size(); i++) {
                String curName;
                current = new ModelNasabah();
                current.setNama(listNasabah.get(i).getNama());
                current.setId(listNasabah.get(i).getId());
                current.setNik(listNasabah.get(i).getNik());
                current.setUsername(listNasabah.get(i).getUsername());
                curName = current.getNama();
                j = i - 1;
                while ((j >= 0) && (curName.compareToIgnoreCase(listNasabah.get(j).getNama()) < 0)) {
                    listNasabah.set(j + 1, listNasabah.get(j));
                    j--;
                }
                listNasabah.set(j + 1, current);
            }
        } else if (key.equalsIgnoreCase("nik")) {
            // with int nik
            for (i = 1; i < listNasabah.size(); i++) {
                current = new ModelNasabah();
                current.setNama(listNasabah.get(i).getNama());
                current.setId(listNasabah.get(i).getId());
                current.setNik(listNasabah.get(i).getNik());
                current.setUsername(listNasabah.get(i).getUsername());
                j = i;
                while ((j > 0) && (listNasabah.get(j - 1).getNik() > current.getNik())) {
                    listNasabah.set(i, listNasabah.get(j - 1));
                    i--;
                }
                listNasabah.set(j, current);
            }
        } else if (key.equalsIgnoreCase("username")) {
            // with string username
            for (i = 1; i < listNasabah.size(); i++) {
                current = new ModelNasabah();
                String curUsername;
                current.setNama(listNasabah.get(i).getNama());
                current.setId(listNasabah.get(i).getId());
                current.setNik(listNasabah.get(i).getNik());
                current.setUsername(listNasabah.get(i).getUsername());
                curUsername = current.getUsername();

                j = i - 1;
                while ((j >= 0) && (curUsername.compareToIgnoreCase(listNasabah.get(j).getUsername()) < 0)) {
                    listNasabah.set(j + 1, listNasabah.get(j));
                    j--;
                }
                listNasabah.set(j + 1, current);
            }

        }

        return listNasabah;
    }

    // REVERSE
    public ArrayList<ModelNasabah> doReverse() {
        listNasabah = getDbList();
        ArrayList<ModelNasabah> reversedList = new ArrayList<ModelNasabah>();
        // store arraylist as  reversed elements
        for (int i = listNasabah.size() - 1; i >= 0; i--) {
            //append the elements in reverse order
            reversedList.add(listNasabah.get(i));
        }
        return reversedList;
    }
    
    // MERGE SORT (cc: https://www.codexpedia.com/java/java-merge-sort-implementation/)
    public ArrayList<ModelNasabah> doMergeSort(ArrayList<ModelNasabah> whole) {
        //listNasabah = whole;
        ArrayList<ModelNasabah> left = new ArrayList<ModelNasabah>();
        ArrayList<ModelNasabah> right = new ArrayList<ModelNasabah>();
        int center;
 
        if (whole.size() == 1) {    
            return whole;
        } else {
            center = whole.size()/2;
            // copy the left half of whole into the left.
            for (int i=0; i<center; i++) {
                    left.add(whole.get(i));
            }
 
            //copy the right half of whole into the new arraylist.
            for (int i=center; i<whole.size(); i++) {
                    right.add(whole.get(i));
            }
 
            // Sort the left and right halves of the arraylist.
            left  = doMergeSort(left);
            right = doMergeSort(right);
 
            // Merge the results back together.
            merge(left, right, whole);
        }
        return whole;
    }
 
    private void merge(ArrayList<ModelNasabah> left, ArrayList<ModelNasabah> right, ArrayList<ModelNasabah> whole) {
        //listNasabah = whole;
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
 
        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).getNama().compareTo(right.get(rightIndex).getNama())) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
 
        ArrayList<ModelNasabah> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
 
    /*public void show() {
        System.out.println("Sorted:");
        for (int i=0; i< strList.size();i++) {
            System.out.println(strList.get(i));
        }
    }*/
}
