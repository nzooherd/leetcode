class Solution(object):
    def numMovesStones(self, a, b, c):
        """
        :type a: int
        :type b: int
        :type c: int
        :rtype: List[int]
        """
        x, y, z = a, b, c
        a = min(x, min(y, z))
        c = max(x, max(y, z))
        b = x + y + z - a - c

        if b == a + 1 and c == b + 1:
            return [0, 0]

        max_value = c - a - 2
        if b <= a + 2 or c <= b + 2:
            min_value = 1
        else:
            min_value = 2
        return [min_value, max_value]