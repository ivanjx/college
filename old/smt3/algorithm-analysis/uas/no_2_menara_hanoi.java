import java.util.Scanner;

public class no_2_menara_hanoi {

    static void menaraHanoi(int J, char A, char C, char B, int L) {
        if (J == 1) {
            L++;
            System.out.print("Langkah : " + L + " ");
            System.out.println("Pindahkan piringan 1 dari menara " + A + " ke menara " + C);
        }
        else {
            menaraHanoi(J - 1, A, B, C, L);
            L++;
            System.out.print("Langkah : " + L + " ");
            System.out.println("Pindahkan piringan " + J + " dari menara " + A + " ke menara " + C);
            menaraHanoi(J - 1, B, C, A, L);
        }
    }

    public static void main(String[] args) {
        System.out.print("Jumlah piringan? ");
        Scanner scanner = new Scanner(System.in);
        int J = scanner.nextInt();
        menaraHanoi(J, 'A', 'C', 'B', 0);
        scanner.close();
    }
}
