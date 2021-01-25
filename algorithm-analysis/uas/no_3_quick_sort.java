import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class no_3_quick_sort {
    static void quick(int[] x, int kiri, int kanan) {
        int i,j,t;
        i = kiri;
        j = kanan;
        int pivot = x[kiri];

        do {
            while (x[i] < pivot) i++;
            while (x[j] > pivot) j--;

            if (i <= j)
            {
                t = x[i]; 
                x[i] = x[j]; 
                x[j] = t;
                i++; 
                j--;
            }
        } while (i <= j);

        if (kiri < j) quick(x, kiri, j);
        if (i < kanan) quick(x, i, kanan);
    }

    static int[] input() {
        System.out.print("Masukkan deret angka (delimiter spasi) ? ");
        List<Integer> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ", 100);

        for (int i = 0; i < strs.length; ++i) {
            int d = Integer.parseInt(strs[i]);
            data.add(d);
        }

        scanner.close();
        return Arrays
            .stream(data.toArray(new Integer[0]))
            .mapToInt(Integer::intValue)
            .toArray();
    }

    static void print(int[] hasil) {
        System.out.print("Hasil quick sort : ");

        for (int i = 0; i < hasil.length; ++i) {
            System.out.print(hasil[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] x = input();
        quick(x, 0, x.length - 1);
        print(x);
    }
}
