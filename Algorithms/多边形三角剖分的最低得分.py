class Solution:
    def minScoreTriangulation(self, A: List[int]) -> int:
        if len(A) == 3:
            return A[0] * A[1] * A[2]

        dp = []
        for i in range(0, len(A)):
            dp.append([0] * len(A))

        for length in range(3, len(A) + 1):
            for left in range(0, len(A)):
                right = (left + length - 1) % len(A)
                indexs = [_%len(A) for _ in range(left, left + length)]
                if length == 3:
                    dp[left][right] = A[indexs[0]] * A[indexs[1]] * A[indexs[2]]
                else:
                    min_value = 0xFEEEEEEE
                    for i in range(1, len(indexs) - 1):
                        index = indexs[i]
                        current_value = A[left] * A[right] * A[index]
                        if i == 1:
                            current_value += dp[index][right]
                        elif i == len(indexs) - 2:
                            current_value += dp[left][index]
                        else:
                            current_value += dp[left][index] + dp[index][right]
                        min_value = min(min_value, current_value)
                    dp[left][right] = min_value 


        return dp[0][len(A)- 1]