class Solution:
    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
        n = len(str1)
        m = len(str2)

        dp = [[0 for i in range(m+1)] for j in range(n+1)]
        for i in range(n+1):
            dp[i][0] = 0
        for j in range(m+1):
            dp[0][j] = 0
        for ind1 in range(1,n+1):
            for ind2 in range(1,m+1):
                if str1[ind1-1] == str2[ind2-1]:
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1]
                else:
                    dp[ind1][ind2] = 0 + max(dp[ind1-1][ind2], dp[ind1][ind2-1])
        
        i = n
        j = m
        ans = ""
        while i>0 and j>0:
            if str1[i-1] == str2[j-1]:
                ans+=str1[i-1]
                i -=1
                j -=1
            elif dp[i-1][j] > dp[i][j-1]:# up
                ans+=str1[i-1]
                i-=1
            else:
                ans+=str2[j-1]
                j-=1
        while i > 0:
            ans += str1[i - 1]
            i -= 1
        while j > 0:
            ans += str2[j - 1]
            j -= 1

        
        return ans[::-1]
            

        