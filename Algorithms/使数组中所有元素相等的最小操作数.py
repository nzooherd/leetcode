class Solution:
    def minOperations(self, n: int) -> int:
        return sum([n - (2 * num + 1) for num in range(n // 2)])