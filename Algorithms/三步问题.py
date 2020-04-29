class Solution:
    def waysToStep(self, n: int) -> int:
        if n <= 0:
            return 0
        if n <= 3:
            return n if n != 3 else 4
        one = 1
        two = 2
        three = 4
        for i in range(3, n):
            result = (one + two  + three) % 1000000007
            one = two
            two = three
            three = result

        return result % 1000000007