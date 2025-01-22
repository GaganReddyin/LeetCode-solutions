import java.util.*;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort intervals by the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Priority queue to act as a min-heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Result map for storing answers for each query
        Map<Integer, Integer> res = new HashMap<>();
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);

        int i = 0;
        for (int q : sortedQueries) {
            // Add all intervals that start before or at the query
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }

            // Remove intervals that end before the query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            // Store the result for the current query
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        // Prepare the result array for the original queries
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }

        return result;
    }
}