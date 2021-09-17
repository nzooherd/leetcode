import bisect

class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        sum_value2count = {0:1}
        order_sum_value = [0]

        result = 0
        cur_sum = 0
        for i, num in enumerate(nums):
            cur_sum += num
            need_val_max = cur_sum - lower
            need_val_min = cur_sum - upper

            need_val_max_index = bisect.bisect_right(order_sum_value, need_val_max)
            need_val_min_index = bisect.bisect_left(order_sum_value, need_val_min)
        
            for i in range(need_val_min_index, need_val_max_index):
                if i < 0:
                    break
                if i > len(order_sum_value):
                    break
                result += sum_value2count[order_sum_value[i]]
                
            if cur_sum in sum_value2count:
                sum_value2count[cur_sum] += 1
            else:
                sum_value2count[cur_sum] = 1
                bisect.insort(order_sum_value, cur_sum)


        return result


