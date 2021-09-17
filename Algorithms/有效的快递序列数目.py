class Solution:
    def countOrders(self, n: int, cur_sum=1) -> int:
        if n == 1:
            return 1 * cur_sum % 1000000007
        m = 2 * n - 1
        cur_sum %= 1000000007
        return self.countOrders(n - 1, (m + 1) * m // 2 * cur_sum)
        