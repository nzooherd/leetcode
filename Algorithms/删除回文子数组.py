class Solution:
    def minimumMoves(self, arr: List[int]) -> int:
        if len(arr) <= 1:
            return len(arr)

        dp = []
        for i in range(0, len(arr)):
            dp.append([0] * len(arr))
        for i in range(0, len(arr)):
            dp[i][i] = 1

        for length in range(2, len(arr)+1):
            for left in range(0, len(arr) - length + 1):
                right = left + length - 1
                if length == 2:
                    dp[left][right] = 1 if arr[left] == arr[right] else 2
                    continue

                if arr[left] == arr[right]:
                    dp[left][right] = dp[left+1][right-1]
                else:
                    dp[left][right] = 101
                for mid in range(left, right):
                    dp[left][right] = min(dp[left][right], dp[left][mid] + dp[mid+1][right])

        return dp[0][len(arr)-1]