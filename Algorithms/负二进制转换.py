class Solution(object):
    def baseNeg2(self, N):
        """
        :type N: int
        :rtype: str
        """
        if N == 0:
            return "0"
        nums = []
        while N != 0:
            if N % 2 == 0:
                nums.append(0)
                N /= -2
            else:
                N -= 1
                N /= -2
                nums.append(1)
        result = ""
        for num in reversed(nums):
            result += str(num) 
        return result