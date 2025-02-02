class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int[] memoi = new int[intervals.length];
        Arrays.fill(memoi, -1);
        return intervals.length - dp(intervals, 0, memoi);
    }

    private int dp(int[][] intervals, int curr, int[] memoi) {
        // base case
        if (curr == intervals.length) {
            return 1;
        }

        if (memoi[curr] != -1) {
            return memoi[curr];
        }

        // evaluate dp[curr + 1]
        int max = dp(intervals, curr + 1, memoi);

        // take curr into count and find the next valid interval j for 1 + dp[j]
        int left = curr + 1, right = intervals.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isOverlapped(intervals[curr], intervals[mid])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // check if the next j is valid or not
        if (right != intervals.length) {
            max = Math.max(max, 1 + dp(intervals, right, memoi));
        }

        return memoi[curr] = max;
    }

    private boolean isOverlapped(int[] i1, int[] i2) {
        return i1[0] < i2[1] && i1[1] > i2[0];
    }
}