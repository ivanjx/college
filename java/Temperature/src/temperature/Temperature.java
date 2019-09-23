/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature;

import java.util.Scanner;

/**
 *
 * @author Ivan Kara
 */
public class Temperature {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initializing scanner.
        Scanner scanner = new Scanner(System.in);
        
        // Asking inputs.
        System.out.print("Celcius: ");
        float C = scanner.nextFloat();
        
        // Converting to Kelvin.
        float K = C + 273;
        
        // Converting to Reamur.
        float R = C * 4 / 5;
        
        // Converting to Fahrenheit.
        float F = C * 9 / 5 + 32;
        
        System.out.printf("Kelvin: %.2f\n", K);
        System.out.printf("Reamur: %.2f\n", R);
        System.out.printf("Fahrenheit: %.2f\n", F);
        
        // Done.
    }
}
