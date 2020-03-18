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
        
        System.out.println("-------------------------------");
         System.out.println("bubblesort asc by NAME");
        System.out.println("+ID\t|\tNAME\t\t");
        bubbleAsc = ns.doBubbleSort(true);
        for (int i=0;i<bubbleAsc.size();i++){
            System.out.println("+"+bubbleAsc.get(i).getId()+"\t|"+bubbleAsc.get(i).getNama());
        }
        
        System.out.println("-------------------------------");
        System.out.println("Insertion sort asc by NAME");
        System.out.println("+ID\t|\tNAME\t\t");
        insAsc = ns.doInsertionSort();
        for (int i=0;i<insAsc.size();i++){
            System.out.println("+"+insAsc.get(i).getId()+"\t|"+insAsc.get(i).getNama());
        }
        
        System.out.println("-------------------------------");
        System.out.println("Selection sort asc by NAME");
        System.out.println("+ID\t|\tNAME\t\t");
        selAsc = ns.doSelectionSort();
        for (int i=0; i<selAsc.size(); i++) {
            System.out.println("+"+selAsc.get(i).getId()+"\t|"+selAsc.get(i).getNama());
        }
        
        System.out.println("-------------------------------");
        System.out.println("Reversed/Descending by ID");
        System.out.println("+ID\t|\tNAME\t\t");
        reversed = ns.doReverse();
        for (int i=0; i<selAsc.size(); i++) {
            System.out.println("+"+reversed.get(i).getId()+"\t|"+reversed.get(i).getNama());
        }
    }
}
