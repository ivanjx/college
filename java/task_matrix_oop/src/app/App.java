package app;

public class App {
    public static void main(String[] args) throws Exception {
        /*
        1 2 3
        4 5 6
        7 8 9
        */
        Matrix m1 = new Matrix(3, 3);
        m1.setElem(0, 0, 1);
        m1.setElem(0, 1, 2);
        m1.setElem(0, 2, 3);
        
        m1.setElem(1, 0, 4);
        m1.setElem(1, 1, 5);
        m1.setElem(1, 2, 6);
        
        m1.setElem(2, 0, 7);
        m1.setElem(2, 1, 8);
        m1.setElem(2, 2, 9);

        System.out.println(m1.toStr());
        System.out.println();

        /*
        9 8 7
        6 5 4
        3 2 1
        */
        Matrix m2 = new Matrix(3, 3);
        m2.setElem(0, 0, 9);
        m2.setElem(0, 1, 8);
        m2.setElem(0, 2, 7);

        m2.setElem(1, 0, 6);
        m2.setElem(1, 1, 5);
        m2.setElem(1, 2, 4);
        
        m2.setElem(2, 0, 3);
        m2.setElem(2, 1, 2);
        m2.setElem(2, 2, 1);

        m2 = m2.transpose();
        
        System.out.println(m2.toStr());
        System.out.println();

        Matrix m3 = m1.multiply(m2);
        System.out.println(m3.toStr());
    }
}