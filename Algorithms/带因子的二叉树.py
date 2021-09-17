from collections import defaultdict

class Solution:
    def numFactoredBinaryTrees(self, A: List[int]) -> int:
        num2factors = defaultdict(list)
        num2index = {}
        A.sort()
        set_nums = set(A)
        for i in range(0, len(A)):
            for j in range(i, len(A)):
                if A[i] * A[j] > A[-1]:
                    break
                if A[i] * A[j] in set_nums:
                    num2factors[A[i] * A[j]].append((A[i], A[j]))

        dp = [0] * len(A)
        for i, num in enumerate(A):
            num2index[num] = i
            dp[i] += 1
            for factor in num2factors[num]:
                factor1, factor2 = factor
                dp[i] += dp[num2index[factor1]] * dp[num2index[factor2]] * (2 if factor1 != factor2 else 1)
                dp[i] %= 10 ** 9 + 7

        return sum(dp) % (10 ** 9 + 7)