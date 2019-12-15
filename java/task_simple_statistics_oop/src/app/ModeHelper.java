package app;

public class ModeHelper {
    public ModeCount[] m_c;

    public ModeHelper(int[] arr) {
        m_c = new ModeCount[0];

        for(int i = 0; i < arr.length; ++i) {
            increase(arr[i]);
        }
    }

    private void add(int val) {
        ModeCount[] narr = new ModeCount[m_c.length + 1];
        int i = 0;

        for(; i < m_c.length; ++i) {
            narr[i] = m_c[i];
        }

        narr[i] = new ModeCount(val, 1);
        m_c = narr;
    }

    private void increase(int val) {
        for (int i = 0; i < m_c.length; ++i) {
            if (m_c[i].val == val) {
                ++m_c[i].count;
                return;
            }
        }

        add(val);
    }

    int[] addNumber(int[] arr, int num) {
        int[] narr = new int[arr.length + 1];
        int i = 0;

        for (; i < arr.length; ++i) {
            narr[i] = arr[i];
        }

        narr[i] = num;
        return narr;
    }

    public int[] getHighest() {
        int maxCount = 0;

        for (int i = 0; i < m_c.length; ++i) {
            if(m_c[i].count > maxCount) {
                maxCount = m_c[i].count;
            }
        }

        int[] vals = new int[0];
        
        for(int i = 0; i < m_c.length; ++i) {
            if(m_c[i].count == maxCount) {
                vals = addNumber(vals, m_c[i].val);
            }
        }

        return vals;
    }
}