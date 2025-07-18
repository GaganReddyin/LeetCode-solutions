class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        long[] left = new long[len];
        long[] right = new long[len];

        // Max-heap for left side (keep n smallest values)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftSum = 0;
        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];

            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll(); // remove largest
            }

            if (maxHeap.size() == n) {
                left[i] = leftSum;
            }
        }

        // Min-heap for right side (keep n largest values)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;
        for (int i = len - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];

            if (minHeap.size() > n) {
                rightSum -= minHeap.poll(); // remove smallest
            }

            if (minHeap.size() == n) {
                right[i] = rightSum;
            }
        }

        // Find the minimum difference
        long minDiff = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            long l = left[i];
            long r = right[i + 1]; // non-overlapping
            if (r != 0) {
                minDiff = Math.min(minDiff, l - r);
            }
        }

        return minDiff;
    }
}