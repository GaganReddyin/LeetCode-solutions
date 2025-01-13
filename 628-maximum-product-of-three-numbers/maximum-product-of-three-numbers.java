class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        long mul = 1;
        if (nums[1] > 0 || nums.length == 3){
            for (int i = 0;i<3;i++){
                mul *= nums[nums.length-1-i];
            }
        }else{
            for (int i = 0;i<3;i++){
                mul *= nums[nums.length-1-i];
            }
            long newMul = nums[0]*nums[1]*nums[nums.length-1];
            mul = Math.max(mul,newMul);
        }

        return (int)mul;
    }
}