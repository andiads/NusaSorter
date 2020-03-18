/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nusasort;

import java.util.ArrayList;
import nusasort.DBConnection;
import nusasort.ModelNasabah;
import nusasort.NusaSorter;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class Main {
    public static void main(String[]args){
        NusaSorter ns = new NusaSorter();
        ArrayList<ModelNasabah> bubbleAsc = new ArrayList<ModelNasabah>();
        ArrayList<ModelNasabah> insAsc = new ArrayList<ModelNasabah>();
        ArrayList<ModelNasabah> selAsc = new ArrayList<ModelNasabah>();
        ArrayList<ModelNasabah> reversed = new ArrayList<ModelNasabah>();
        
        System.out.println("-----------------------------------------------");
         System.out.println("bubblesort by Username");
        System.out.println("+ID\t|\tNAME\t\t|\tNIK\t\t|\tUSERNAME\t\t");
        
        bubbleAsc = ns.doBubbleSort(ns.getDbList(), "username");
        
        for (int i=0;i<bubbleAsc.size();i++){
            System.out.println("+"+bubbleAsc.get(i).getId()
                    +"\t|"+bubbleAsc.get(i).getNama()
                    +"\t\t\t|"+bubbleAsc.get(i).getNik()
                    +"\t\t|"+bubbleAsc.get(i).getUsername());
        }
        
        System.out.println("-----------------------------------------------");
        System.out.println("Insertion sort by NAME");
        System.out.println("+ID\t|\tNAME\t\t|\tNIK\t\t|\tUSERNAME\t\t");
        
        insAsc = ns.doInsertionSort(ns.getDbList(), "name");
        
        for (int i=0;i<insAsc.size();i++){
           System.out.println("+"+insAsc.get(i).getId()
                    +"\t|"+insAsc.get(i).getNama()
                    +"\t\t\t|"+insAsc.get(i).getNik()
                    +"\t\t|"+insAsc.get(i).getUsername());
        }
        
        System.out.println("-----------------------------------------------");
        System.out.println("Selection sort by NIK");
        System.out.println("+ID\t|\tNAME\t\t|\tNIK\t\t|\tUSERNAME\t\t");
        
        selAsc = ns.doSelectionSort(ns.getDbList(), "nik");
        
        for (int i=0; i<selAsc.size(); i++) {
            System.out.println("+"+insAsc.get(i).getId()
                    +"\t|"+selAsc.get(i).getNama()
                    +"\t\t\t|"+selAsc.get(i).getNik()
                    +"\t\t|"+selAsc.get(i).getUsername());
        }
        
        System.out.println("-----------------------------------------------");
        System.out.println("Reversed/Descending by ID");
        System.out.println("+ID\t|\tNAME\t\t");
        reversed = ns.doReverse();
        for (int i=0; i<selAsc.size(); i++) {
            System.out.println("+"+reversed.get(i).getId()
                    +"\t|"+reversed.get(i).getNama()
                    +"\t\t\t|"+reversed.get(i).getNik()
                    +"\t\t|"+reversed.get(i).getUsername());
        }
        System.out.println("-----------------------------------------------");
    }
}
