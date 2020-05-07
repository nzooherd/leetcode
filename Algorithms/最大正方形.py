class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0

        result = 0 
        dp, line_continue_matrix = [], []
        for i in range(0, len(matrix) + 1):
            dp.append([0] * (len(matrix[0]) + 1))
            line_continue_matrix.append([0] * (len(matrix[0]) + 1))

        for i in range(0, len(matrix)):
            continue1_num = 0
            for j in range(0, len(matrix[0])):
                if matrix[i][j] == '1':
                    continue1_num += 1
                else:
                    continue1_num = 0
                line_continue_matrix[i+1][j+1] = continue1_num

        for i in range(1, len(matrix) + 1):
            for j in range(1, len(matrix[0]) + 1):
                if line_continue_matrix[i][j] <= dp[i-1][j]:
                    dp[i][j] = line_continue_matrix[i][j]
                else:
                    k = dp[i-1][j] 
                    for m in range(0, k):
                        if line_continue_matrix[i - 1 - m][j] <= k:
                            dp[i][j] = k
                            break
                    else:
                        dp[i][j] = k + 1
                result = max(result, dp[i][j] * dp[i][j])

        return result