class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        zeros=0
        i=0
        while(i<(len(nums)-1)):
            if(nums[i]==nums[i+1]):
                nums[i]*=2
                nums[i+1]=0
                i+=1
            i+=1
        zeros=nums.count(0)
        nums = [i for i in nums if i != 0]
        return nums+([0]*zeros)