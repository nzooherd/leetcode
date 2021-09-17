from collections import defaultdict
class Solution(object):
    def champagneTower(self, poured, query_row, query_glass):
        """
        :type poured: int
        :type query_row: int
        :type query_glass: int
        :rtype: float
        """
        coor2Volum = defaultdict(int)
        for i in range(0, query_row + 1) :
            for j in range(0, i + 1) :
                if (i == 0 and j == 0) :
                    coor2Volum[(i, j)] = poured * 250
                    continue
                if (coor2Volum[(i - 1, j - 1)] > 250) :
                    coor2Volum[(i, j)] += ( coor2Volum[(i - 1, j - 1)] - 250 ) * 1.0 / 2
                if (coor2Volum[(i - 1, j)] > 250) :
                    coor2Volum[(i, j)] += ( coor2Volum[(i - 1, j)] - 250 ) * 1.0 / 2

        if coor2Volum[(query_row, query_glass)] > 250 :
            return 1
        return coor2Volum[(query_row, query_glass)] * 1.0 / 250

