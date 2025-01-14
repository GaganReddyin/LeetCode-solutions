import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[nums.length];

        // Simulate circular array by traversing twice
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            // Maintain a decreasing stack
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            // If stack is empty, no greater element exists
            res[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current element to the stack
            stack.push(nums[i % nums.length]);
        }

        return res;
    }
}