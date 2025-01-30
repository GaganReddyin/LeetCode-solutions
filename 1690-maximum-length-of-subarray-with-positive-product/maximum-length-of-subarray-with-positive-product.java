class Solution {
    public int getMaxLen(int[] A) {
        int max = 0, pos = 0, neg = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                pos = pos + 1;
                neg = (neg > 0) ? neg + 1 : 0;
            } else if (A[i] < 0) {
                int tmp = pos;
                pos = (neg > 0) ? neg + 1 : 0;
                neg = (tmp > 0) ? tmp + 1 : 1;
            } else {
                pos = 0;
                neg = 0;
            }
            max = Math.max(max, pos);
        }
        return max;
    }
}