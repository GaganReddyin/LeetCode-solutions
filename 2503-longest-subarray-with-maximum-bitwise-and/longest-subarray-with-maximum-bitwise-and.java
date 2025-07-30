class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0, count = 0, maxVal = -1;
        for (int num : nums){
            if (num > maxVal){
                maxVal = num;
                count = res = 1;
            }
            else if (num == maxVal)
                res = Math.max(res, ++count);
            else
                count = 0;
        }
        return res;
    }
}