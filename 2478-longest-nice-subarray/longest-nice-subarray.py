class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        left, right = 0, 1
        
        usedBits = nums[0]
        longestNice = 1
        while right < n:
            while right < n and usedBits & nums[right] == 0: # while there is no bit overlap keep making longer to the right
                usedBits |= nums[right]  # turn on bits from right num
                right += 1
            longestNice = max(longestNice, right - left)
            usedBits ^= nums[left]  # turn off bits from left num
            left += 1
                
        return longestNice