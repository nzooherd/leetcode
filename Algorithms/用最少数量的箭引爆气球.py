class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        if not points:
            return 0
        def sort_cmp(x, y):
			if x[0] == y[0]:
				if x[1] > y[1]:
					return 1
				if x[1] == y[1]:
					return 0
				return -1
			return 1 if x[0] > y[0] else -1

        points.sort(cmp=sort_cmp)
        result = 1
        end = points[0][1]
        for i in range(1, len(points)):
        	if points[i][0] <= end:
        		end = min(end, points[i][1])
        		continue
        	else:
        		end = points[i][1]
        		result += 1
        return result
