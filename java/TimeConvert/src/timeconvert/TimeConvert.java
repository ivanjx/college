/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeconvert;

import java.util.Scanner;

/**
 *
 * @author Ivan Kara
 */
public class TimeConvert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
    
}
