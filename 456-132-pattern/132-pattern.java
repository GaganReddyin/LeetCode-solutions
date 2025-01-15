class Solution {
    public boolean find132pattern(int[] nums) {
        // Initialize vk with the smallest possible integer value using bitwise shift
        int potentialMidVal = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>(); // Create a stack to store the elements

        // Iterate from the end to the start of the array
        for (int i = nums.length - 1; i >= 0; --i) {
            // If the current element is less than the potential middle value of the 132 pattern,
            // this means we have found a 132 pattern.
            if (nums[i] < potentialMidVal) {
                return true;
            }
            // While the stack is not empty and the top element is less than the current number,
            // update the potential middle value to be the new top of the stack
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                potentialMidVal = stack.pop();
            }
            // Push the current number onto the stack
            stack.push(nums[i]);
        }
        // If the loop completes without finding a 132 pattern, return false
        return false;
    }
}