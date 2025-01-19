class Solution {
    private int arrayLength;
    private Integer[][] dp;
    private int[][] nextIndices;

    // Main function to compute the number of good starting indices
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer, Integer> valueToIndexMap = new TreeMap<>();
        arrayLength = arr.length;
        dp = new Integer[arrayLength][2];
        nextIndices = new int[arrayLength][2];
      
        // Preprocessing: Populate the next indices for odd and even jumps for each element
        for (int i = arrayLength - 1; i >= 0; --i) {
            // Find the smallest number greater than or equal to current number
            var higher = valueToIndexMap.ceilingEntry(arr[i]);
            // Update the next index for an odd jump
            nextIndices[i][1] = higher == null ? -1 : higher.getValue();
          
            // Find the greatest number less than or equal to the current number
            var lower = valueToIndexMap.floorEntry(arr[i]);
            // Update the next index for an even jump
            nextIndices[i][0] = lower == null ? -1 : lower.getValue();
          
            // Map the current number to its index
            valueToIndexMap.put(arr[i], i);
        }
      
        int goodStartingIndicesCount = 0;
        // Check each index as a starting point
        for (int i = 0; i < arrayLength; ++i) {
            // If the current index leads to the end by a sequence of jumps, include it in the count
            goodStartingIndicesCount += performJump(i, 1);
        }
        return goodStartingIndicesCount;
    }

    // Recursive function to determine if we can reach the end from index i
    private int performJump(int index, int jumpType) {
        // If we've reached the end, return 1 (successful jump sequence)
        if (index == arrayLength - 1) {
            return 1;
        }
        // If there is no valid next jump, return 0 (failed to reach the end)
        if (nextIndices[index][jumpType] == -1) {
            return 0;
        }
        // Use memoization to avoid recomputation
        if (dp[index][jumpType] != null) {
            return dp[index][jumpType];
        }
        // Perform the next jump with the alternating jump type (odd -> even, even -> odd)
        return dp[index][jumpType] = performJump(nextIndices[index][jumpType], jumpType ^ 1);
    }
}