/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Scanner;

/**
 *
 * @author xanal
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int total = 0;
        int jumlah = 0;
        
        while(true){
            System.out.print("Angka: ");
            int angka = scanner.nextInt();
            
            if(angka == 0) {
                // Di sini kita mendapat nilai 0.
                break;
            } else {
                // Naikkan nilai jumlah.
                jumlah++; // Naikkan jumlah sebesar 1.
                
                // Tambah angka ke dalam total.
                total += angka; // total = total + angka.
            }
        }
        
        // Di sini kita sudah berada di luar blok while.
        System.out.println("Sudah berada di luar blok while");
        
        // Hitung rata2.
        int rata2 = total / jumlah;
        
        // Print.
        System.out.print("Rata-rata: ");
        System.out.println(rata2);
    }
    
}
