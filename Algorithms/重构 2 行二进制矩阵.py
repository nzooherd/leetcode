class Solution(object):
    def reconstructMatrix(self, upper, lower, colsum):
        """
        :type upper: int
        :type lower: int
        :type colsum: List[int]
        :rtype: List[List[int]]
        """
        if upper + lower != sum(colsum):
            return []

        res = [[0] * len(colsum), [0] * len(colsum)]
        upper_sum = 0

        for i, col_single_sum in enumerate(colsum):
            if col_single_sum != 2:
                continue

            res[0][i] = 1
            res[1][i] = 1
            upper_sum += 1

        for i, col_single_sum in enumerate(colsum):
            if col_single_sum != 1:
                continue

            if upper_sum < upper:
                res[0][i] = 1
                upper_sum += 1
            else:
                res[1][i] = 1

        if upper_sum != upper:
            return []
        return res
