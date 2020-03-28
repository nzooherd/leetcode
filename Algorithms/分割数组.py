class Solution(object):
    def partitionDisjoint(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        if not A or len(A) <= 1:
            return 0

        max_from_left = [A[0]] 
        min_from_right = [A[-1]]

        for i in range(1, len(A)):
            if A[i] > max_from_left[i-1]:
                max_from_left.append(A[i])
            else:
                max_from_left.append(max_from_left[i-1])
        for i in range(len(A)-2, -1, -1):
            if A[i] < min_from_right[len(A) - i - 2]:
                min_from_right.append(A[i])
            else:
                min_from_right.append(min_from_right[len(A) - i - 2])
        min_from_right.reverse()
        
        for i in range(0, len(A) - 1):
            if max_from_left[i] <= min_from_right[i + 1]:
                return i + 1
        
        return 0
