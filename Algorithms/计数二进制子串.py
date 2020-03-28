class Solution:
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        nums = []
        ret = 0
        
        if (len(s) <= 1):
            return ret
        
        num = 1
        for i in range(1, len(s)):
            if(s[i] == s[i-1]):
                num = num + 1
            else:
                nums.append(num)
                num = 1
        nums.append(num)
        
        for i in range(len(nums) - 1):
            ret += min(nums[i], nums[i+1])
        
        return ret
            
            