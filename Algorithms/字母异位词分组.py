#
# @lc app=leetcode.cn id=49 lang=python
#
# [49] 字母异位词分组
#
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        result = []
        str_index_dict = {}
        for s in strs:
            sorted_s = "".join(sorted(s))      
            if sorted_s not in str_index_dict:
                result.append([s])
                str_index_dict[sorted_s] = len(result) - 1
            else:
                index = str_index_dict.get(sorted_s)
                result[index].append(s)
        return result        

