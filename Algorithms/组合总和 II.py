#
# @lc app=leetcode.cn id=40 lang=python
#
# [40] 组合总和 II
#
class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        num_result = [0] * (target + 1)
        num_result[0] = 1
        list_result = [set() for _ in range(0, target + 1)]
        list_result[0].add(())
        print list_result
        for i in range(0, len(candidates)):
            for j in range(target, -1, -1):
                if j < candidates[i]:
                    continue
                if num_result[j - candidates[i]]:
                    num_result[j] += num_result[j - candidates[i]]
                    temp_list = list_result[j - candidates[i]]
                    for ll in temp_list:
                        temp_ll = list(ll)
                        temp_ll.append(candidates[i])
                        list_result[j].add(tuple(sorted(temp_ll)))
                    
            print list_result
        return [list(_) for _ in list_result[target]]


