/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;
import java.util.Scanner;

/**
 *
 * @author xanal
 */
public class Method {
    
    static int simpleAdd(int n) {
        if(n == 0) {
            return n;
        }
        
        return simpleAdd(n - 1) + n;
    }

    static int factorial(int n) {
        if(n == 1) {
            return n;
        }
        
        return factorial(n - 1) * n;
    }
    
    static double power(int a, int n) {
        if(n == 0) {
            return Math.pow(a, n); // 1.
        }
        
        return power(a, n - 1) * Math.pow(a, n);
    }
    
    static int fib(int n) {
        if(n == 1 || n == 0) {
            return n;
        }
        
        return fib(n - 1) + fib(n - 2);
    }
    
    static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    static double resistanceSerial(double r1, double r2, double r3) {
        return r1 + r2 + r3;
    }
    
    static double resistanceParalel(double r1, double r2, double r3) {
        return 1 / (1 / r1 + 1 / r2 + 1 / r3);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initializing scanner.
        Scanner scanner = new Scanner(System.in);
        
        // Getting input.
        System.out.print("R1: ");
        double r1 = scanner.nextDouble();
        
        System.out.print("R2: ");
        double r2 = scanner.nextDouble();
        
        System.out.print("R3: ");
        double r3 = scanner.nextDouble();
        
        // Calculating.
        double serial = resistanceSerial(r1, r2, r3);
        double paralel = resistanceParalel(r1, r2, r3);
        
        // Printing.
        System.out.println("Serial: " + serial);
        System.out.println("Paralel: " + paralel);
    }
    
}
