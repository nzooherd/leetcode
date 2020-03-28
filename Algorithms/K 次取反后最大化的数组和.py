class Solution(object):
    def largestSumAfterKNegations(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        A = sorted(A)
        for i in range(len(A)):
            if K <= 0 or A[i] >= 0:
                break
            A[i] = -A[i]
            K -= 1
        A = sorted(A)
        if K %2 != 0:
            A[0] = -A[0]

        return sum(A)
