class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int total = 0;
        int count = 0;

        // Calculate the total sum of the array
        for(int i = 0; i < n; i++){
            total += nums[i];    
        }

        int left = 0;
        int right = total;

        // Iterate through the array to count valid partitions
        for(int j = 0; j < n-1; j++){
            left += nums[j];
            right -= nums[j];

            // Check if the difference is even
            if((left - right) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}