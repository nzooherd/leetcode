class Solution:
    def reorderedPowerOf2(self, N: int) -> bool:
        valid_nums = [1]
        for i in range(0, 30):
            valid_nums.append(valid_nums[-1] * 2)

        valid_str_set = set()
        for valid_num in valid_nums:
            valid_str = list(str(valid_num))
            valid_str.sort()
            valid_str_set.add("".join(valid_str))


        str_n = list(str(N))
        str_n.sort()
        return "".join(str_n) in valid_str_set

