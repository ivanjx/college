import java.time.Duration;
import java.time.Instant;

public class Main 
{
    static double pangkat(double a, int n) {
        double hasil = 1;
        
        for (int i = 1; i <= n; ++i) {
            hasil = hasil * a;
        }

        return hasil;
    }

    static void tesPangkat() {
        System.out.println("Pangkat...");
        Instant before = Instant.now();
        double r = pangkat(10, 10);
        Instant after = Instant.now();
        Duration d = Duration.between(before, after);
        System.out.println("Durasi: " + d.toMillis() + " ms");
        System.out.println("Hasil: " + r);
    }

    static double faktorial(int n) {
        double fak = 1;

        for (int i = 1; i <= n; ++i) {
            fak = fak * i;
        }

        return fak;
    }

    static void tesFaktorial() {
        System.out.println("Faktorial...");
        Instant before = Instant.now();
        double r = faktorial(10);
        Instant after = Instant.now();
        Duration d = Duration.between(before, after);
        System.out.println("Durasi: " + d.toMillis() + " ms");
        System.out.println("Hasil: " + r);
    }

    static void perkalianMatriks(int[][] A, int[][] B, int n, int[][] C)
    {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                C[i][j] = 0;
                
                for (int k = 0; k < n; ++k) {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
    }

    static void tesPerkalianMatriks() {
        System.out.println("Perkalian matriks...");

        int[][] A = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[][] B = {
            { 9, 8, 7 },
            { 6, 5, 4 },
            { 3, 2, 1 }
        };
        int n = 3;
        int[][] C = new int[n][n];

        Instant before = Instant.now();
        perkalianMatriks(A, B, n, C);
        Instant after = Instant.now();
        
        Duration d = Duration.between(before, after);
        System.out.println("Durasi: " + d.toMillis() + " ms");
        System.out.println("Hasil:");

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void cariFaktor(int n) {
        int k = 1;
        for (; k <= n - 1; ++k) {
            if (n % k == 0) {
                System.out.println(k);
            }
        }
    }

    static void tesCariFaktor() {
        System.out.println("Cari faktor...");
        Instant before = Instant.now();
        cariFaktor(10000);
        Instant after = Instant.now();

        Duration d = Duration.between(before, after);
        System.out.println("Durasi: " + d.toMillis() + " ms");
    }

    static int cariElemenTerbesar(int[] a) {
        int maks = a[0];
        for (int i = 1; i < a.length; ++i) {
            if (a[i] > maks) {
                maks = a[i];
            }
        }

        return maks;
    }

    static void tesCariElemenTerbesar() {
        System.out.println("Cari elemen terbesar...");
        int[] a = {
            1,2,3,4,5,6,7,8,12,32,2,13,2,321,12,43,1,6,8,9,2,3,0,4,2,1,221,321,3
        };
        
        Instant before = Instant.now();
        int r = cariElemenTerbesar(a);
        Instant after = Instant.now();

        Duration d = Duration.between(before, after);
        System.out.println("Durasi: " + d.toMillis() + " ms");
        System.out.println("Hasil: " + r);
    }

    static int pencarianBeruntun(int[] a, int x) {
        int k = 0;
        while (k < a.length && a[k] != x) {
            k = k + 1;
        }
        
        if (a[k] == x) {
            return k + 1;
        }
        
        return 0;
    }

    static void tesPencarianBeruntun() {
        System.out.println("Pencarian beruntun...");
        int[] a = {
            1,2,3,4,5,6,7,8,12,32,2,13,2,321,12,43,1,6,8,9,2,3,0,4,2,1,221,431,3
        };

        Instant before = Instant.now();
        int r = pencarianBeruntun(a, 431);
        Instant after = Instant.now();

        Duration d = Duration.between(before, after);
        System.out.println("Durasi: " + d.toMillis() + " ms");
        System.out.println("Hasil: " + r);
    }

    static void bubbleSort(int[] L, int n) {
        for (int i = 1; i <= n - 1; ++i) {
            for (int k = n; k >= i + 1; --k) {
                if (L[k-1] < L[k-2]) {
                    int temp = L[k-1];
                    L[k-1] = L[k-2];
                    L[k-2] = temp;
                }
            }
        }
    }

    static void tesBubbleSort() {
        System.out.println("Bubble sort...");
        int[] a = {
            4311,2,3,4,5,6,7,8,12,32,2,13,2,-321,12,43,1,6,8,9,2,3,0,4,2,1,221,321,3
        };

        Instant before = Instant.now();
        bubbleSort(a, a.length);
        Instant after = Instant.now();
        
        Duration d = Duration.between(before, after);
        System.out.println("Durasi: " + d.toMillis() + " ms");
        System.out.println("Hasil:");

        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    static boolean prima(long x) {
        if (x < 2) {
            return false;
        }

        if (x == 2) {
            return true;
        }

        double y = Math.sqrt(x);
        boolean test = true;
        while (test && y >= 2) {
            if (x % y == 0) {
                test = false;
            } else {
                y = y - 1;
            }
        }

        return test;
    }

    static void tesPrima() {
        System.out.println("Prima...");

        Instant before = Instant.now();
        boolean r = prima(100000015333L);
        Instant after = Instant.now();

        Duration d = Duration.between(before, after);
        System.out.println("Durasi: " + d.toMillis() + " ms");
        System.out.println("Hasil: " + r);
    }

    public static void main(String[] args) {
        tesPangkat();
        System.out.println();

        tesFaktorial();
        System.out.println();

        tesPerkalianMatriks();
        System.out.println();

        tesCariFaktor();
        System.out.println();

        tesCariElemenTerbesar();
        System.out.println();

        tesPencarianBeruntun();
        System.out.println();

        tesBubbleSort();
        System.out.println();

        tesPrima();
        System.out.println();
    }
}