class Solution:
    def nextClosestTime(self, time: str) -> str:
        order_nums = set()
        num_indexs = [0, 1, 3, 4]
        for index in [0, 1, 3, 4]:
            order_nums.add(int(time[index]))
        order_nums = list(order_nums)
        order_nums.sort()

        for cur_index in num_indexs[::-1]:
            num = int(time[cur_index])

            for order_num in order_nums:
                if order_num <= num:
                    continue
                if cur_index == 4:
                    return time[0:4] + str(order_num)
                if cur_index == 3 and order_num <= 5:
                    return time[0:3] + str(order_num) + str(order_nums[0])
                if cur_index == 1:
                    if (time[0] == '2' and order_num <= 3) or time[0] != '2':
                        return time[0:1] + str(order_num) + ":" + str(order_nums[0]) * 2
                if cur_index == 0:
                    if order_num < 3:
                        return str(order_num) + str(order_nums[0]) + ":" + str(order_nums[0]) * 2

        return str(order_nums[0]) * 2 + ":" + str(order_nums[0]) * 2