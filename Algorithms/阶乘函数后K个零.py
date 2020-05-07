class Solution:
    def cal_0_by_first_layer(self, x):
        result = x
        while (x >= 5):
            x //= 5
            result += x

        return result

    def preimageSizeFZF(self, K: int) -> int:
        if K < 5:
            return 5 

        left, right = 1, K
        while(left < right):
            mid = (left + right) // 2
            cur_result = self.cal_0_by_first_layer(mid)
            if cur_result == K:
                return 5
            elif cur_result > K:
                right = mid
            else:
                left = mid + 1
        if left == right:
            return 5 if self.cal_0_by_first_layer(left) == K else 0
