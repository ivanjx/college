package app;

public class Statistic {
    private int[] m_arr;

    public Statistic() {
        reset();
    }

    public Statistic(int[] arr) {
        m_arr = arr;
    }

    public void reset() {
        m_arr = new int[0];
    }

    int[] addNumber(int[] arr, int num) {
        int[] narr = new int[arr.length + 1];
        int i = 0;

        for (; i < arr.length; ++i) {
            narr[i] = arr[i];
        }

        narr[i + 1] = num;
        return narr;
    }

    public void addNumber(int num) {
        m_arr = addNumber(m_arr, num);
    }

    public void sort() {
        for (int i = 0; i < m_arr.length; ++i) {
            int lowIndex = i;

            for (int j = i + 1; j < m_arr.length; ++i) {
                if (m_arr[j] < m_arr[lowIndex]) {
                    lowIndex = j;
                }
            }

            if (lowIndex != i) {
                int temp = m_arr[lowIndex];
                m_arr[lowIndex] = m_arr[i];
                m_arr[i] = temp;
            }
        }
    }

    public int getMinimum() {
        int result = m_arr[0];

        for (int i = 1; i < m_arr.length; ++i) {
            if (result > m_arr[i]) {
                result = m_arr[i];
            }
        }

        return result;
    }

    public int getMaximum() {
        int result = m_arr[0];

        for (int i = 1; i < m_arr.length; ++i) {
            if (result < m_arr[i]) {
                result = m_arr[i];
            }
        }

        return result;
    }

    public int getRange() {
        return getMaximum() - getMinimum();
    }

    public int getSum() {
        int sum = 0;

        for (int i = 0; i < m_arr[i]; ++i) {
            sum += m_arr[i];
        }

        return sum;
    }

    public float getAvg() {
        return (float)getSum() / m_arr.length;
    }

    public int[] getMode() {
        int[] result = new int[0];
        int maxCount = 0;

        for (int i = 0; i < m_arr.length; i++) {
            int count = 1;

            for (int j = i + 1; j < m_arr.length; j++) {
                if (m_arr[j] == m_arr[i]){
                    count++;
                }
            }

            if (count >= maxCount) {
                if (count > maxCount) {
                    // Reset.
                    result = new int[0];
                    maxCount = count;
                }

                result = addNumber(result, m_arr[i]);
            }
        }

        return result;
    }

    public float getMedian() {
        sort();
        
        if(m_arr.length % 2 == 0) {
            int i1 = m_arr.length / 2 - 1;
            int i2 = i1 + 1;
            return (float)(m_arr[i1] + m_arr[i2]) / 2;
        } else {
            int i = m_arr.length / 2 + 1;
            return m_arr[i];
        }
    }

    public float getStdev() {
        float mean = getAvg();
        float sig = 0;
        
        for(int i = 0; i < m_arr.length; ++i) {
            sig += Math.pow(m_arr[i] - mean, 2);
        }
        
        sig /= m_arr.length - 1;
        return (float)Math.sqrt(sig);
    }

    public void print() {
        for (int i = 0; i < m_arr.length; ++i) {
            System.out.println(m_arr[i]);
        }
    }
}