# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        for i in range(0, n):
            for j in range(0, n):
                if j == i:
                    continue
                if knows(i, j):
                    break
            else:
                for j in range(0, n):
                    if j == i:
                        continue
                    if not knows(j, i):
                        break
                else:
                    return i

        return -1