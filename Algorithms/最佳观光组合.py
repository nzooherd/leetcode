class Solution(object):
    def maxScoreSightseeingPair(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        left_max = A[0] 
        left_index = 0
        max_value = 0
        for i in range(1, len(A)):
            if A[i] + left_max - (i - left_index) > max_value:
                max_value = A[i] + left_max - (i - left_index)
            if A[i] + i > left_max + left_index:
                left_max = A[i]
                left_index = i
        return max_value