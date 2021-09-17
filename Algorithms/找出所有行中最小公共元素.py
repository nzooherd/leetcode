class Solution:
    def smallestCommonElement(self, mat: List[List[int]]) -> int:

        num2count = {}
        for i in range(0, len(mat)):
            for j in range(0, len(mat[0])):
                if mat[i][j] not in num2count:
                    num2count[mat[i][j]] = 0
                num2count[mat[i][j]] += 1

        for i in  range(1, 10001):
            if num2count.get(i, 0) == len(mat):
                return i

        return -1



