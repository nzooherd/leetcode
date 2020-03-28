#
# @lc app=leetcode.cn id=17 lang=python
#
# [17] 电话号码的字母组合
#
class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        origin = ['']
        result = []
        num2letter = {2:"abc", 3:"def", 4:"ghi", 5:"jkl",
                      6:"mno", 7:"pqrs", 8:"tuv", 9:"wxyz"}
        if digits == "":
            return []
        for digit in digits:
            try:
                digit = int(digit)
            except:
                return []
            letters = num2letter.get(digit)
            for letter in letters:
                for ss in origin:
                    ss += letter
                    result.append(ss)
            origin = result 
            result = []
        return origin


