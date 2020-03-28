class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if target <= 0 or len(candidates) < 1:
            return []

        num_result = [0] * (target + 1)
        list_result = [[] for i in range(target + 1)]
        num_result[0] = 1
        for i in range(1, target + 1):
            if i % candidates[0] == 0:
                num_result[i] = 1
                list_result[i].append([candidates[0]] * (i / candidates[0]))

        for i in range(1, len(candidates)):
            for j in range(1, target + 1):
                if j < candidates[i]:
                    continue
                elif num_result[j - candidates[i]]:
                    num_result[j] += num_result[j - candidates[i]]
                    temp_list = list_result[j - candidates[i]] or [[]]
                    for ll in temp_list:
                        ll = ll[:]
                        ll.append(candidates[i])
                        list_result[j].append(ll)

        return list_result[target]

                
