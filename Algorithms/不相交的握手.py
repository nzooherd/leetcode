class Solution:
    def numberOfWays(self, num_people: int) -> int:
        if not num_people:
            return 0

        dp = [1, -1, 1]
        if num_people <= 2:
            return dp[num_people]

        for i in range(3, num_people + 1):
            if i % 2 == 1:
                dp.append(-1)
                continue
            cur_res = 0
            for j in range(2, i + 1):
                left_res = dp[j - 2]
                right_res = dp[i - j]
                if left_res == -1 or right_res == -1:
                    continue
                cur_res += left_res * right_res
            dp.append(cur_res % 1000000007)

        return dp[-1]
