class Solution:
    def __init__(self):
        self.syme_nums = {"6": "9", "9": "6", "0": "0", "1": "1", "8": "8"}

    def count(self, str_num):
        result = 0
        if not str_num:
            return 1
        if len(str_num) == 1:
            for key in ["0", "1", "8"]:
                if key <= str_num:
                    result += 1
            return result

        if str_num.count("0") != len(str_num) - 1:
            if str_num[0] in self.syme_nums:
                if str_num[-1] >= self.syme_nums[str_num[0]]:
                    result += self.countZero(str_num[1:-1])
                else:
                    result += self.countZero(str_num[1:-1], True)

            str_num = str_num[0] + "0" * (len(str_num) - 1)

        for key in self.syme_nums.keys():
            if key == "0":
                continue
            if key >= str_num[0]:
                continue
            result += 5 ** ((len(str_num) - 2) // 2) * (3 ** (len(str_num) % 2))

        for digit in range(1, len(str_num)):
            if digit == 1:
                result += 3
            else:
                result += 4 * (5 ** ((digit-2) // 2)) * (3 ** (digit % 2))

        return result

    def countZero(self, str_num, need_small=False):
        if not str_num:
            return 1 if not need_small else 0
        result = 0
        if need_small and self.isVaild(str_num):
            result -= 1

        if len(str_num) == 1:
            for key in ["0", "1", "8"]:
                if key <= str_num:
                    result += 1
            return result

        for key in ["0", "1", "6", "8", "9"]:
            if key == str_num[0] and str_num[-1] >= self.syme_nums[key]:
                if key == str_num[0]:
                    result += self.countZero(str_num[1:-1])
            if key < str_num[0]:
                digit = len(str_num) - 2
                result += 5 ** (digit // 2) * (3 ** (digit % 2))

        return result

    def strobogrammaticInRange(self, low: str, high: str) -> int:
        result = self.count(high) - self.count(low)
        result += 1 if self.isVaild(low) else 0
        return result if result > 0 else 0

    def isVaild(self, str_num):
        for i in range(len(str_num) // 2):
            if str_num[i] not in self.syme_nums or str_num[len(str_num) - i - 1] != self.syme_nums[str_num[i]]:
                break 
        else:
            if (len(str_num) % 2 == 1 and str_num[len(str_num) // 2] in self.syme_nums) or len(str_num) % 2 == 0:
                return True
        return False