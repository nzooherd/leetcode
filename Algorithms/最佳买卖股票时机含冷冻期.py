class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = [] #(a, b, c) a-当天买入 b-当天卖出 c-冷冻
        result = 0
        for i, price in enumerate(prices):
            if i == 0:
                dp.append((0, 0, 0))
                continue
            a, b, c = 0, 0, 0
            for j in range(0, i):
                if j < i-1:
                    a = max(a, dp[j][1])
                b = max(b, dp[j][0] + price - prices[j])
                c = max(c, dp[j][1])
            result = max(a, b, c)
            dp.append((a, b, c))

        return result

