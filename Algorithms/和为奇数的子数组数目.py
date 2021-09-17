class Solution:
    def numOfSubarrays(self, arr) -> int:
        res = 0
        odd_count, even_count = 0, 0
        cur_sum = 0

        for num in arr:
            cur_sum += num
            if cur_sum % 2 == 0:
                res += odd_count
                even_count += 1
            else:
                res += even_count
                res += 1
                odd_count += 1

            res %= 1000000007
        return res
