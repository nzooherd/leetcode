import itertools


class Solution:

    def countCombine(self, m, n):
        count = 1
        for i in range(0, n):
            count *= m - i
        for i in range(1, n + 1):
            count /= i
        return int(count)

    def countLeastOne(self, nums, count):
        if len(nums) == 1:
            if count >= nums[0]:
                return 0
            if count <= 0:
                return 0
            return self.countCombine(nums[0], count)

        ball_sum_num = sum(nums)
        if count < len(nums):
            return 0
        if count > ball_sum_num - len(nums):
            return 0

        result = 0
        for i in range(1, nums[0]):
            result += self.countCombine(nums[0], i) * self.countLeastOne(nums[1:], count-i)

        return result

    def getProbability(self, balls) -> float:
        ball_nums = sum(balls)
        color_splits = []
        color_nums = len(balls)
        color_iters = [_ for _ in range(color_nums)]
        if color_nums % 2 == 1:
            for i in range(1, color_nums + 2, 2):
                color_splits.append(((color_nums - i) // 2, i, (color_nums - i) // 2 ))
        else:
            for i in range(0, color_nums + 2, 2):
                color_splits.append(((color_nums - i) // 2, i, (color_nums - i) // 2 ))

        valid_nums = 0  
        for color_split in color_splits:
            one_pri_num, share_num, two_pri_num = color_split
            for one_private in itertools.combinations(color_iters, one_pri_num):
                half_nums = ball_nums // 2
                share_balls_indexs = set(color_iters)
                for index in one_private:
                    half_nums -= balls[index]
                    share_balls_indexs.remove(index)
                    if half_nums < share_num:
                        break
                if half_nums == 0 and share_num == 0:
                    valid_nums += 1
                    continue
                if share_num == 0:
                    continue
                for share_indexs in itertools.combinations(list(share_balls_indexs), share_num):
                    share_ball_nums = [balls[_] for _ in share_indexs]
                    valid_nums += self.countLeastOne(share_ball_nums, half_nums)

        return valid_nums / self.countCombine(ball_nums, ball_nums // 2)