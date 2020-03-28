class Solution(object):
    def clumsy(self, N):
        """
        :type N: int
        :rtype: int
        """
        result = 0
        result += self.process_subtracting(N)
        N -= 3
        while N > 0:
            result += N
            N -= 1
            result -= self.process_subtracting(N)
            N -= 3
        return result

    def process_subtracting(self, n):
        if n >= 3:
            return n * (n-1) / (n - 2)
        elif n == 2:
            return 2
        else:
            return n