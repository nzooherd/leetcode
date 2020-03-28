class Solution(object):
    def canThreePartsEqualSum(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        sum_value = sum(A)
        if sum_value % 3 != 0:
            return False
        need_value = sum_value / 3
        left_sum, right_sum = 0, 0
        left_index, right_index = len(A) - 1, 0

        for i in range(0, len(A)):
            left_sum += A[i]
            if left_sum == need_value:
                left_index = i
                break
        for i in range(len(A) - 1, -1, -1):
            right_sum += A[i]
            if right_sum == need_value:
                right_index = i
                break
        if left_index < right_index:
            return True
        return False