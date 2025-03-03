class Solution:
    def pivotArray(self, nums, pivot):
        n = len(nums)
        left = 0
        right = n - 1
        result = [pivot] * n

        for i in range(n):
            j = n - 1 - i
            if nums[i] < pivot: # i set the value from left to right to maintain origin order
                result[left] = nums[i]
                left += 1
            if nums[j] > pivot: # j set the value from right to left to maintain origin order
                result[right] = nums[j]
                right -=1
        return result