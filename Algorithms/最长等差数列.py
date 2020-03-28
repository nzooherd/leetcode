class Solution(object):
    def longestArithSeqLength(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        if len(A) <= 2:
            return len(A)

        equal_margin_nums_set = [{}]
        equal_margin_nums_set.append({A[1] - A[0]: 2})
        max_length = 2

        for i in range(2, len(A)):
            margin_nums_map = {}
            margin_nums_map[A[i] - A[0]]= 2
            for j in range(1, i):
                prefix_margin_map = equal_margin_nums_set[j]
                margin_value = A[i] - A[j]
                if margin_value in  prefix_margin_map:
                    margin_nums_map[A[i] - A[j]] = prefix_margin_map[margin_value] + 1
                else:
                    margin_nums_map[A[i] - A[j]] = 2
                
                if margin_nums_map[A[i] - A[j]] > max_length:
                    max_length = margin_nums_map[A[i] - A[j]]
            equal_margin_nums_set.append(margin_nums_map)
        
        return max_length
