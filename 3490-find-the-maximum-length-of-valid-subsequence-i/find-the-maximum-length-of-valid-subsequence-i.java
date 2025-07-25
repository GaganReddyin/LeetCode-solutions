class Solution {
    public int maximumLength(int[] nums) {
        return List.of(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}).stream().map(
            p -> IntStream.range(0, nums.length).boxed().reduce(
                0,
                (ans, i) -> (nums[i] % 2 == p[ans % 2]) ? ans + 1 : ans,
                (x, y) -> x
            )
        ).max(Integer::compareTo).orElse(-1);
    }
}