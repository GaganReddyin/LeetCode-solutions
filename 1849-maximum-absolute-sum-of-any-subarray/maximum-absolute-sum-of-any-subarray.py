class Solution:
    def maxAbsoluteSum(self, A):
        return max(accumulate(A, initial=0)) - min(accumulate(A, initial=0))