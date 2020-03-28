#
# @lc app=leetcode.cn id=125 lang=python
#
# [125] 验证回文串
#
class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        left, right = 0, len(s) - 1
        while(left < right):
            while not self.valid(s[left]):
                left += 1
                if left >= right:
                    return True
            left_ch = s[left]

            while not self.valid(s[right]):
                right -= 1
                if left >= right:
                    return True
            right_ch = s[right]
            if left_ch.lower() != right_ch.lower():
                return False
            left += 1
            right -= 1
        return True
    
    def valid(self, ch):
        return (ch >= '0' and ch <='9') or (ch >= 'a' and ch <= 'z') or (ch >= 'A' and ch <= 'Z')
        

