class Solution {
    private int fun(List<int[]> c) {
        // Sort points by x and then by y (reverse order for y)
        Collections.sort(c, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        List<Integer> dp = new ArrayList<>();
        for (int[] p : c) {
            int y = p[1];
            int left = Collections.binarySearch(dp, y);
            if (left < 0) left = -(left + 1);  // Get insertion point
            if (left == dp.size()) dp.add(y); 
            else dp.set(left, y);
        }
        return dp.size();
    }

    public int maxPathLength(int[][] c, int k) {
        int[] p = c[k];
        int n = c.length;
        List<int[]> c1 = new ArrayList<>(), c2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (c[i][0] < p[0] && c[i][1] < p[1]) c1.add(c[i]);
            if (c[i][0] > p[0] && c[i][1] > p[1]) c2.add(c[i]);
        }

        int l1 = c1.size() > 0 ? fun(c1) : 0;
        int l2 = c2.size() > 0 ? fun(c2) : 0;

        return l1 + l2 + 1;
    }
}