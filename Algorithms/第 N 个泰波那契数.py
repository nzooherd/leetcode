class Solution:
    def tribonacci(self, n: int) -> int:
        factors = [0, 1, 1]
        if n < 3:
            return factors[n]
        
        while n >= 3:
            factors = [factors[1], factors[2], sum(factors)]
            n -= 1
        return factors[-1]