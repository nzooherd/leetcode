class Solution:
    def fib(self, N: int) -> int:
        result = [0, 1]
        if N <= 1:
            return result[N]
        
        while N > 1:
            result = [result[1], result[0] + result[1]]
            N -= 1
        return result[-1]