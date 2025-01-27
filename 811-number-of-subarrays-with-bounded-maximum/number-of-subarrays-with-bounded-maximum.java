class Solution {

    // Taken Help
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i = 0, j = 0, res = 0, maxind = -1;
        while(j < nums.length){
            if(nums[j] >= left && nums[j] <= right){
                maxind = j;
            }
            if(nums[j] > right){
                j++;
                i = j;
                maxind = -1;
                continue;
            }
            if(maxind != -1){
                res += maxind - i + 1;
            }
            j++;
        }
        return res;
    }
}