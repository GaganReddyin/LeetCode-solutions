import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
       
        Arrays.sort(nums);
        
        
        int median = nums[nums.length / 2];
        
        
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        
        return moves;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        
        int[] nums1 = {1, 2, 3};
        System.out.println(solution.minMoves2(nums1)); 

        int[] nums2 = {1, 10, 2, 9};
        System.out.println(solution.minMoves2(nums2));
    }
}