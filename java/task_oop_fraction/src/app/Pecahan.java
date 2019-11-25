package app;

public class Pecahan {
    private int _pembilang;
    private int _penyebut;

    public Pecahan(int pembilang, int penyebut) throws Exception {
        _pembilang = pembilang;
        _penyebut = penyebut;

        if (penyebut == 0) {
            throw new Exception("Penyebut 0");
        }
    }

    public Pecahan(int bulat, int pembilang, int penyebut) throws Exception {
        _pembilang = pembilang + bulat * penyebut;
        _penyebut = penyebut;

        if (penyebut == 0) {
            throw new Exception("Penyebut 0");
        }
    }

    public int getPembilang() {
        return _pembilang;
    }

    public int getPenyebut() {
        return _penyebut;
    }

    public Pecahan tambah(Pecahan p) throws Exception {
        int penyebutCom = getPenyebut() * p.getPenyebut();
        int resPembilang = getPembilang() * p.getPenyebut() + p.getPembilang() * getPenyebut();
        Pecahan result = new Pecahan(resPembilang, penyebutCom);
        return result;
    }

    public Pecahan kurang(Pecahan p) throws Exception {
        int penyebutCom = getPenyebut() * p.getPenyebut();
        int resPembilang = getPembilang() * p.getPenyebut() - p.getPembilang() * getPenyebut();
        Pecahan result = new Pecahan(resPembilang, penyebutCom);
        return result;
    }

    public Pecahan kali(Pecahan p) throws Exception {
        int resPembilang = getPembilang() * p.getPembilang();
        int resPenyebut = getPenyebut() * p.getPenyebut();
        return new Pecahan(resPembilang, resPenyebut);
    }

    public Pecahan bagi(Pecahan p) throws Exception {
        int resPembilang = getPembilang() * p.getPenyebut();
        int resPenyebut = getPenyebut() * p.getPembilang();
        return new Pecahan(resPembilang, resPenyebut);
    }

    private int getGCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        } else {
            return getGCD(n2, n1 % n2);
        }
    }

    private Pecahan simplify() throws Exception {
        int gcd = getGCD(getPembilang(), getPenyebut());
        Pecahan res = new Pecahan(getPembilang() / gcd, getPenyebut() / gcd);
        return res;
    }

    public String toStr() throws Exception {
        Pecahan resultP = this;
        int bulat = 1;

        if (resultP.getPembilang() >= resultP.getPenyebut()) { // Pembilang >= penyebut ?
            bulat = resultP.getPembilang() / resultP.getPenyebut(); // Hitung bilangan bulat.
            int resultPembilang = resultP.getPembilang() % resultP.getPenyebut(); // Hitung pembilang baru: sisa bagi pembilang dgn penyebut.
            resultP = new Pecahan(resultPembilang, resultP.getPenyebut()); // Penyebut tetap sama.
            resultP = resultP.simplify(); // Sederhanakan pecahan baru.
        } // else tidak ada bilangan bulat karena pembilang < penyebut.

        String result;

        if (resultP.getPembilang() == 0) { // Tidak ada pecahan?
            result = "" + bulat; // Print bilangan bulat.
        } else { // Ada pecahan.
            result = resultP.getPembilang() + "/" + resultP.getPenyebut(); // Print pecahan dulu.

            if (bulat > 1) { // Ada bilangan bulat?
                result = bulat + " " + result; // Print bilangan bulat + pecahan.
            } // else print pecahan saja.
        }

        return result; // Done.
    }
}