/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.s01a1;

import java.util.Scanner;

public class S01A1 {
    static void m1() {
        // Initializing scanner.
        Scanner scanner = new Scanner(System.in);
        
        // Asking inputs.
        System.out.print("Celcius: ");
        float C = scanner.nextFloat();
        
        // Converting to Kelvin.
        float K = C + 273;
        System.out.printf("Kelvin: %.2f\n", K);
        
        // Converting to Reamur.
        float R = C * 4 / 5;
        System.out.printf("Reamur: %.2f\n", R);
        
        // Converting to Fahrenheit.
        float F = C * 9 / 5 + 32;
        System.out.printf("Fahrenheit: %.2f\n", F);
        
        // Done.
    }
    
    static void m2() {
        // Initializing scanner.
        Scanner scanner = new Scanner(System.in);
        
        // Getting secs.
        System.out.print("Second: ");
        int sec = scanner.nextInt();
        
        // Converting.
        int remainder = sec;
        final int TOTAL_SECS_IN_DAY = 24 * 60 * 60;
        final int TOTAL_SECS_IN_HOUR = 60 * 60;
        final int TOTAL_SECS_IN_MIN = 60;
        
        // Getting day.
        int day = remainder / TOTAL_SECS_IN_DAY;
        remainder = remainder - day * TOTAL_SECS_IN_DAY;
        
        // Getting hour.
        int hour = remainder / TOTAL_SECS_IN_HOUR;
        remainder = remainder - hour * TOTAL_SECS_IN_HOUR;
        
        // Getting min.
        int min = remainder / TOTAL_SECS_IN_MIN;
        remainder = remainder - min * TOTAL_SECS_IN_MIN;
        
        // Printing.
        System.out.printf("%d Day, %d Hour, %d Min, %d Sec", day, hour, min, remainder);
    }
    
    static void m3()
        throws Exception{
        // Initializing scanner.
        Scanner scanner = new Scanner(System.in);
        
        // Getting a.
        System.out.print("a-> ");
        int a = scanner.nextInt();
        
        // Getting b.
        System.out.print("b-> ");
        int b = scanner.nextInt();
        
        // Getting c.
        System.out.print("c-> ");
        int c = scanner.nextInt();
        
        // Validating.
        if(a == 0) {
            if(b == 0) {
                if(c == 0) {
                    throw new Exception("Solusi tak berhingga");
                }
            } else {
                throw new Exception("Bukan persamaan kuadrat");
            }
        } else {
            System.out.println("Valid");
        }
    }
    
    public static void main(String[] args) {
        try {
            m3();
        } catch(Exception ex) {
            System.out.printf("Error: %s", ex.toString());
        }
    }
}
