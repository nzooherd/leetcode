class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        if k < 1 or k > 9:
            return 0
        if k == 1:
            return [[n]] if n <= 9 else [] 
        if k == 9:
            return [[_ for _ in range(1, 10)]] if n == 45 else []

        valid_nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        reverse = False
        if k >= 5:
            reverse = True 
            k = 9 - k
            n = 45 - n

        results = self.find_sum(valid_nums, n, k)
        if reverse:
            for i, result in enumerate(results):
                results[i] = list(set(valid_nums) - set(result))

        return results
    def find_sum(self, valid_nums, sum_num, k):
        if k == 1:
            return [] if sum_num not in valid_nums else [[sum_num]]

        results = []
        for i in range(0, len(valid_nums)):
            next_results = self.find_sum(valid_nums[i+1:], sum_num - valid_nums[i], k - 1)
            for next_result in next_results:
                results.append([valid_nums[i]] + next_result)

        return results