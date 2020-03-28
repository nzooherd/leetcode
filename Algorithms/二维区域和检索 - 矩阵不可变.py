#
# @lc app=leetcode.cn id=304 lang=python
#
# [304] 二维区域和检索 - 矩阵不可变
#
class NumMatrix(object):

    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        self.sum_matrix = [[] for _ in range(0, len(matrix))]
        for i in range(0, len(self.sum_matrix)):
            row_sum = 0
            for j in range(0, len(matrix[i])):
                row_sum += matrix[i][j]
                self.sum_matrix[i].append(row_sum)
        
    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        sum_value = 0
        for i in range(row1, row2 + 1):
            sum_value += self.sum_matrix[i][col2] - (0 if col1 == 0 else self.sum_matrix[i][col1-1])
        
        return sum_value
        


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)

