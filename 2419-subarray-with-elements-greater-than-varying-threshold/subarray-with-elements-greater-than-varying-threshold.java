class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int[] prevLow = buildPrevLowestIndex(nums);
        int[] nextLow = buildNextLowestIndex(nums);

        for (int i = 0; i < nums.length; i++) {
            int minValue = nums[i];
            int totalLengthWithCurrentMinValue = nextLow[i] - prevLow[i] - 1;
            if (minValue > threshold / totalLengthWithCurrentMinValue) {
                return totalLengthWithCurrentMinValue;
            }
        }
        return -1;
    }
    
    public int[] buildPrevLowestIndex(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int index = nums.length - 1;
        int[] prevLowIndex = new int[nums.length];

        Arrays.fill(prevLowIndex, -1);
        while (index >= 0) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[index]) {
                prevLowIndex[stack.peek()] = index;
                stack.pop();
            }
            stack.push(index);
            index--;
        }
        return prevLowIndex;
    }

    public int[] buildNextLowestIndex(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nextLowestIndexes = new int[nums.length];
        Arrays.fill(nextLowestIndexes, nums.length);
        int index = 0;
        stack.push(index);
        while (index < nums.length) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[index]) {
                nextLowestIndexes[stack.peek()] = index;
                stack.pop();
            }
            stack.push(index);
            index++;
        }
        return nextLowestIndexes;
    }
}