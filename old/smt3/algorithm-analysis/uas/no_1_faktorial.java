import java.util.Scanner;

public class no_1_faktorial {

    public static int faktorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * faktorial(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.print("Berapa faktorial? : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n + " faktorial adalah " + faktorial(n));
        scanner.close();
    }
}