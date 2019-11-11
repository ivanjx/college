/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task01_smt1;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author xanal
 */
public class Task01_smt1 {
    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }
    
    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            for(int j = i; j < arr.length; ++j) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static int minimum(int[] arr) {
        int result = arr[0];
        
        for(int i = 1; i < arr.length; ++i) {
            if(result > arr[i]) {
                result = arr[i];
            }
        }
        
        return result;
    }
    
    public static int maximum(int[] arr) {
        int result = arr[0];
        
        for(int i = 1; i < arr.length; ++i) {
            if(result < arr[i]) {
                result = arr[i];
            }
        }
        
        return result;
    }
    
    public static float avg(int[] arr) {
        float result = 0;
        
        for(int i = 0; i < arr.length; ++i) {
            result += arr[i];
        }
        
        return result / arr.length;
    }
    
    public static int range(int[] arr) {
        return maximum(arr) - minimum(arr);
    }
    
    static int indexOf(int[] arr, int val) {
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == val) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static int modus(int[] arr) {
        int[] watch = new int[arr.length];
        int[] occ = new int[arr.length];
        int current = 0;
        
        for(int i = 0; i < arr.length; ++i) {
            int watchIndex = indexOf(watch, arr[i]);
            
            if(watchIndex == -1) {
                watch[current] = arr[i];
                occ[current] = 1;
                ++current;
            } else {
                occ[watchIndex]++;
            }
        }
        
        int maxIndex = indexOf(occ, maximum(occ));
        return watch[maxIndex];
    }
    
    public static float median(int[] arr) {
        sort(arr);
        
        if(arr.length % 2 == 0) {
            int i1 = arr.length / 2 - 1;
            int i2 = i1 + 1;
            return (float)(arr[i1] + arr[i2]) / 2;
        } else {
            int i = arr.length / 2 + 1;
            return arr[i];
        }
    }
    
    public static float stdev(int[] arr) {
        float mean = avg(arr);
        float sig = 0;
        
        for(int i = 0; i < arr.length; ++i) {
            sig += Math.pow(arr[i] - mean, 2);
        }
        
        sig /= arr.length - 1;
        return (float)Math.sqrt(sig);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Jumlah angka: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; ++i) {
            System.out.print("Angka ");
            System.out.print(i + 1);
            System.out.print(": ");
            arr[i] = scanner.nextInt();
        }
        
        // Max.
        System.out.print("Max: ");
        System.out.println(maximum(arr));
        
        // Min.
        System.out.print("Min: ");
        System.out.println(minimum(arr));
        
        // Rata2.
        System.out.print("Rata-rata: ");
        System.out.println(avg(arr));
        
        // Range.
        System.out.print("Range: ");
        System.out.println(range(arr));
        
        // Modus.
        System.out.print("Modus: ");
        System.out.println(modus(arr));
        
        // Median.
        System.out.print("Median: ");
        System.out.println(median(arr));
        
        // stdv.
        System.out.print("Standard deviasi: ");
        System.out.println(stdev(arr));
    }
}
