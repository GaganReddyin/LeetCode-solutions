class Solution {
    public int minimumTimeRequired(int[] a, int k) {
        int n = a.length;
        Arrays.sort(a);
        int l = a[n - 1], r = n * a[n - 1];
        while (l < r) {
            int m = l + r >>> 1;
            int[] b = new int[k];
            if (dfs(a, b, m, n - 1)) r = m;
            else l = m + 1;
        }
        return l;
    }

    boolean dfs(int[] a, int[] b, int m, int i) {
        if (i == -1) return true;
        int k = b.length;
        for (int j = 0; j < k; j++) {
            if (b[j] + a[i] <= m) {
                b[j] += a[i];
                if (dfs(a, b, m, i - 1)) return true;
                b[j] -= a[i];
            }
            if (b[j] == 0) return false;
        }
        return false;
    }
}