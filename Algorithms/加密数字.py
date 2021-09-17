class Solution(object):
    def encode(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0 :
            return ""

        count, sum_num = 0, 1
        while(sum_num * 2 - 1 <= num):
            count += 1 
            sum_num *= 2

        sum_num //= 2
        num -= sum_num * 2 - 1
        res = ['0'] * count

        index = 1
        while(num > 0):
            res[-index] = str(num % 2)
            index += 1
            num //= 2

        return "".join(res)


