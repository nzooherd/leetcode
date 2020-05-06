class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = []
        for i in range(0, days[-1] + 1):
            dp.append([0, 0, 0, 0])

        set_days = set(days)
        for i in range(1, len(dp)):
            if i not in set_days:
                dp[i][0] = dp[i-1][0]
            else:
                dp[i][0] = min(dp[i-1]) + costs[0]
                for j in range(2, 31):
                    if i - j + 1 >= 1:
                        if j <= 7:
                            dp[i][0] = min(dp[i][0], dp[i - j + 1][2])
                        else:
                            dp[i][0] = min(dp[i][0], dp[i - j + 1][3])
                    else:
                        if j <= 7:
                            dp[i][0] = min(dp[i][0], costs[1])
                        else:
                            dp[i][0] = min(dp[i][0], costs[2])


            pre_day_cost = min(dp[i-1])
            dp[i][1] = pre_day_cost + costs[0] 
            dp[i][2] = pre_day_cost + costs[1] 
            dp[i][3] = pre_day_cost + costs[2] 


        return min(dp[days[-1]])