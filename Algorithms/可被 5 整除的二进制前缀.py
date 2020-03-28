class Solution(object):
    def prefixesDivBy5(self, A):
        """
        :type A: List[int]
        :rtype: List[bool]
        """
        num = 0
        result = []
        for i in A:
            num *= 2
            num += i
            if num % 5 == 0:
                result.append(True)
            else:
                result.append(False)
            num = num % 5

        return result        