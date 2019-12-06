package app;

public class App {
    public static void main(String[] args) throws Exception {
        Statistic s = new Statistic();
        s.addNumber(4);
        s.addNumber(2);
        s.addNumber(3);
        s.addNumber(4);
        s.addNumber(5);
        System.out.println(s.getMedian());
    }
}