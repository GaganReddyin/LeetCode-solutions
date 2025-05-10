class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long[] sumAndZeroes1 = getSumAndZeroes(nums1);
        long[] sumAndZeroes2 = getSumAndZeroes(nums2);
        if (sumAndZeroes1[0] + sumAndZeroes1[1] == sumAndZeroes2[0] + sumAndZeroes2[1]) {
            return sumAndZeroes1[0] + sumAndZeroes1[1];
        }
        long[] minSum = sumAndZeroes1[0] + sumAndZeroes1[1] < sumAndZeroes2[0] + sumAndZeroes2[1] ? sumAndZeroes1 : sumAndZeroes2;
        long[] maxSum = (minSum == sumAndZeroes1 ? sumAndZeroes2 : sumAndZeroes1);
        return minSum[1] == 0 ? -1 : maxSum[0] + maxSum[1];
    }

    private long[] getSumAndZeroes(int[] nums) {
        long[] sumAndZeroes = {0,0};
        for (int num : nums) {
            if (num == 0) {
                sumAndZeroes[1]++;
            }
            sumAndZeroes[0] += num;
        }
        return sumAndZeroes;
    }
}