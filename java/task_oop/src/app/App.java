package app;

public class App {
    public static void main(String[] args) throws Exception {
        Pecahan p1 = new Pecahan(4, 2);
        Pecahan p2 = new Pecahan(4, 2);
        Pecahan p3 = p1.bagi(p2);
        System.out.println(p3.toStr());
    }
}