class Solution {
    private int arrayLength; // The length of the given array
    private int[] nums; // The given array

    // Method to check if the array contains a cycle that meets certain conditions
    public boolean circularArrayLoop(int[] nums) {
        arrayLength = nums.length; // Initialize the arrayLength with the length of nums
        this.nums = nums; // Assign the nums array to the instance variable
        // Loop through each element in the array
        for (int i = 0; i < arrayLength; ++i) {
            // Skip if the current element is 0 as it's already considered non-cyclic
            if (nums[i] == 0) {
                continue;
            }
            // Use a slow and fast pointers approach to find a cycle
            int slow = i;
            int fast = getNextIndex(i);
            // Continue to advance the pointers until the product of the adjacent elements is positive,
            // which indicates they move in the same direction
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[getNextIndex(fast)] > 0) {
                if (slow == fast) {
                    // If both pointers meet, check if the cycle length is greater than 1
                    if (slow != getNextIndex(slow)) {
                        return true; // A cycle that meets the conditions is found
                    }
                    break; // The cycle length is 1, so break out of the loop
                }
                // Move the slow pointer by one and the fast pointer by two
                slow = getNextIndex(slow);
                fast = getNextIndex(getNextIndex(fast));
            }
            // Reset all elements in the detected cycle to 0 to mark them non-cyclic
            int j = i;
            while (nums[j] * nums[getNextIndex(j)] > 0) {
                nums[j] = 0;
                j = getNextIndex(j);
            }
        }
        // No valid cycle found, return false
        return false;
    }

    // Helper method to get the next array index taking into account wrapping of the array
    // and the current item value (handles negative indices as well)
    private int getNextIndex(int i) {
        // Calculate the next index based on the current index and its value in the array.
        // The result is wrapped to stay within array bounds
        return (i + nums[i] % arrayLength + arrayLength) % arrayLength;
    }
}