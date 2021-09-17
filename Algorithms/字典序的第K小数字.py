class Solution:
    def findKthZeor(self, str_num, k, can_zeor=False):
        if k == 1:
            return '' if can_zeor else '1'

        if len(str_num) <= 1:
            if can_zeor:
                return '' if k == 1 else str(k-2)
            else:
                return str(k)

        k -= 1 if can_zeor else 0

        for i in (range(0, 10) if can_zeor else range(1, 10)):
            cur_count = 0
            for j in range(1, len(str_num) + 1):
                if str(i) < str_num[0] or j < len(str_num):
                    cur_count += 10 ** (j - 1)
                else:
                    if str(i) == str_num[0]:
                        cur_count += int(str_num[1:]) + 1

            if k <= cur_count:
                return str(i) + self.findKthZeor('9' * (len(str_num) - (1 if str(i) < str_num[0] else 2)) if \
                        (str(i) != str_num[0]) else str_num[1:], k, can_zeor=True)
            else:
                k -= cur_count



    def findKthNumber(self, n: int, k: int) -> int:
        result = self.findKthZeor(str(n), k)
        return result
