package app;

public class Matrix {
    private int[][] _matrix;
    private int _col;
    private int _row;

    public Matrix(int row, int col) {
        _matrix = new int[row][col];
        _col = col;
        _row = row;
    }

    public int getElem(int row, int col) {
        return _matrix[row][col];
    }

    public void setElem(int row, int col, int val) {
        _matrix[row][col] = val;
    }

    public boolean isOrdEq(Matrix m2) {
        return _col == m2._col && _row == m2._row;
    }

    public boolean isOrdEqMul(Matrix m2) {
        return _row == m2._col && _col == m2._row; // Untuk perkalian.
    }

    public Matrix add(Matrix m2) throws Exception {
        if (!isOrdEq(m2)) {
            throw new Exception("Ordo tidak sama");
        }

        Matrix result = new Matrix(_row, _col);

        for (int v = 0; v < _row; ++v) {
            for (int h = 0; h < _col; ++h) {
                int m1Elem = getElem(v, h);
                int m2Elem = m2.getElem(v, h);
                result.setElem(v, h, m1Elem + m2Elem);
            }
        }

        return result;
    }

    public Matrix subtract(Matrix m2) throws Exception {
        if (!isOrdEq(m2)) {
            throw new Exception("Ordo tidak sama");
        }

        Matrix result = new Matrix(_row, _col);

        for (int v = 0; v < _row; ++v) {
            for (int h = 0; h < _col; ++h) {
                int m1Elem = getElem(v, h);
                int m2Elem = m2.getElem(v, h);
                result.setElem(v, h, m1Elem - m2Elem);
            }
        }

        return result;
    }

    public Matrix transpose() throws Exception {
        Matrix result = new Matrix(_col, _row); // Kolom dan baris dibalik.
        
        for (int v = 0; v < _row; ++v) {
            for (int h = 0; h < _col; ++h) {
                int val = getElem(v, h);
                result.setElem(h, v, val);
            }
        }

        return result;
    }

    public Matrix multiply(Matrix m2) throws Exception {
        if (!isOrdEqMul(m2)) {
            throw new Exception("Ordo salah");
        }

        Matrix result = new Matrix(_row, m2._col); // Col = m1 row; Row = m2 col;

        // Loop satu2 elemen matrix hasil.
        for (int v = 0; v < result._row; ++v) {
            for (int h = 0; h < result._col; ++h) {
                // Inisialisasi elemen matrix hasil.
                result.setElem(v, h, 0);

                for (int i = 0; i < result._row; ++i) {
                    // Kolom x baris.
                    int m1Elem = getElem(v, i); // Loop kolom m1.
                    int m2Elem = m2.getElem(i, h); // Loop baris m2.

                    int val = result.getElem(v, h);
                    val += m1Elem * m2Elem; // Kalikan dan tambahkan.
                    result.setElem(v, h, val);
                }
            }
        }

        return result;
    }

    public String toStr() {
        String result = "";

        for (int v = 0; v < _row; ++v) {
            for (int h = 0; h < _col; ++h) {
                result += getElem(v, h) + " ";
            }

            result += "\n";
        }

        return result;
    }
}