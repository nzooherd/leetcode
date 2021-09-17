class Solution:
    def minSwaps(self, data: List[int]) -> int:
        one_count = sum(data)
        start, end = 0, one_count - 1
        cur_one_count = data[0:one_count].count(1)

        res = one_count - cur_one_count
        while(end < len(data) - 1):
            cur_one_count -= 1 if data[start] == 1 else 0
            start += 1
            end += 1
            cur_one_count += 1 if data[end] == 1 else 0

            res = min(res, one_count - cur_one_count)
        
        return res