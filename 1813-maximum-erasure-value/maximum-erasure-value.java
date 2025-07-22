class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, sum = 0, max = 0;

        while (r < nums.length) {
            sum += nums[r];
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // Handle duplicate by shrinking from the left
            while (map.get(nums[r]) > 1) {
                sum -= nums[l];
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            max = Math.max(max, sum);
            r++;
        }

        return max;
    }
}