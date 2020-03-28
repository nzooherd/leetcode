class Solution(object):
    def divisorGame(self, N):
        """
        :type N: int
        :rtype: bool
        """
        result = [False, True, False]
        if N <= 3:
            return result[N - 1]
        for i in range(3, N):
            num = i + 1
            j = 1
            while j * j <= num:
                if num % j != 0:
                    j += 1
                    continue
                if not result[num - j - 1]:
                    result.append(True)
                    break
                j += 1
            if j * j > num:
                result.append(False)
        return result[-1]