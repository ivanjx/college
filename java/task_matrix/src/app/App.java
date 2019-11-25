package app;

public class App {
    static void print(int[][] matrix) {
        for(int v = 0; v < matrix.length; ++v) {
            for(int h = 0; h < matrix[v].length; ++h) {
                System.out.print(matrix[v][h]);
                System.out.print(" ");
            }
            
            System.out.println();
        }
    }
    
    static int[][] add(int[][] m1, int[][] m2) {
        int[][] result = new int[m1.length][m1[0].length];
        
        for(int v = 0; v < result.length; ++v) {
            for(int h = 0; h < result[v].length; ++h) {
                result[v][h] = m1[v][h] + m2[v][h];
            }
        }
        
        return result;
    }
    
    static int[][] transpose(int[][] matrix) {
        int srcV = matrix.length;
        int srcH = matrix[0].length;
        int[][] result = new int[srcH][srcV];
        
        for(int v = 0; v < srcV; ++v) {
            for(int h = 0; h < srcH; ++h) {
                result[h][v] = matrix[v][h];
            }
        }
        
        return result;
    }
    
    static int[][] mul(int[][] m1, int[][] m2) {
        int m1V = m1.length;
        int m1H = m1[0].length;
        int m2V = m2.length;
        int m2H = m2[0].length;
        
        int[][] result = new int[m1V][m2H];
        
        for(int v = 0; v < result.length; ++v) {
            for(int h = 0; h < result[v].length; ++h) {
                result[v][h] = 0;
                
                for(int i = 0; i < m1V; ++i) {
                    result[v][h] += m1[v][i] * m2[i][h];
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] A = new int[][] {
            new int[] {1, 2, 3, 4},
            new int[] {1, 2, 3, 4},
            new int[] {1, 2, 3, 4},
            new int[] {1, 2, 3, 4},
        };
        
        int[][] B = new int[][] {
            new int[] {1, 2, 3, 4},
            new int[] {1, 2, 3, 4},
            new int[] {1, 2, 3, 4},
            new int[] {1, 2, 3, 4},
        };
        
        int[][] C = new int[][] {
            new int[] {1, 2, 3, 4},
            new int[] {1, 2, 3, 4},
            new int[] {1, 2, 3, 4},
            new int[] {1, 2, 3, 4},
        };
        
        System.out.println("A:");
        print(A);
        System.out.println();
        
        System.out.println("B:");        
        print(B);
        System.out.println();
        
        System.out.println("C:");        
        print(C);
        System.out.println();
        
        System.out.println("C+B:");
        int[][] B_C = add(B, C);
        print(B_C);
        System.out.println();
        
        System.out.println("T(B+C):");
        int[][] TBC = transpose(B_C);
        print(TBC);
        System.out.println();
        
        System.out.println("A*(B+C):");
        int[][] AB_C = mul(A, TBC);
        print(AB_C);
        System.out.println();
    }
}