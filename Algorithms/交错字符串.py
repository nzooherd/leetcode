#
# @lc app=leetcode.cn id=97 lang=python
#
# [97] 交错字符串
#
class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if not s1:
            return s3 == s2
        if not s2:
            return s3 == s1
        if not s3:
            return not s1 and not s2
        
        if len(s3) != len(s1) + len(s2):
            return False 
        dp = [None] * (len(s1) + 1)
        for i in range(0, len(dp)):
            dp[i] = [None] * (len(s2) + 1)
        
        for i in range(len(dp)):
            for j in range(len(dp[i])):
                dp[i][j] = False
        
        dp[0][0] = True
        for i in range(0, len(s1)):
            dp[i+1][0] = (s1[0:i+1] == s3[0:i+1])
        for j in range(0, len(s2)):
            dp[0][j+1] = (s2[0:j+1] == s3[0:j+1]) 
        


        for i in range(1, len(s1) + 1):
            for j in range(1, len(s2) + 1):
                ret1 = False
                ret2 = False
                if s1[i-1] == s3[i + j - 1]:
                    ret1 = dp[i-1][j]
                if s2[j-1] == s3[i + j - 1]:
                    ret2 = dp[i][j-1]
                dp[i][j] = ret1 or ret2
        
        
        return dp[len(s1)][len(s2)]


