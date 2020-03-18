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
        ArrayList<ModelNasabah> nsbAsc = new ArrayList<ModelNasabah>();
        ArrayList<ModelNasabah> nsbDesc = new ArrayList<ModelNasabah>();
        ArrayList<ModelNasabah> insAsc = new ArrayList<ModelNasabah>();
        
        System.out.println("bubblesort asc");
        nsbAsc = ns.doBubbleSort(true);
        for (int i=0;i<nsbAsc.size();i++){
            System.out.println("ID: "+nsbAsc.get(i).getId());
            System.out.println("Nama: "+nsbAsc.get(i).getNama());
        }
        
        
        System.out.println("\nInsertion sort asc");
        insAsc = ns.doInsertionSort();
        for (int i=0;i<insAsc.size();i++){
            System.out.println("ID: "+insAsc.get(i).getId());
            System.out.println("Nama: "+insAsc.get(i).getNama());
        }
        
        
        
    }
}
