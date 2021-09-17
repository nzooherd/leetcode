from queue import Queue
from collections import defaultdict


class Solution:
    def longestIncreasingPath(self, matrix) -> int:
        num2deps = defaultdict(set)
        dep2nums = defaultdict(set)
        num2res = {}
        if not matrix:
            return 0

        for i in range(0, len(matrix)):
            for j in range(0, len(matrix[0])):
                for a, b in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    x = i + a
                    y = j + b

                    if x < 0 or x >= len(matrix) or y < 0 or y >= len(matrix[0]):
                        continue

                    if matrix[x][y] > matrix[i][j]:
                        num2deps[(x, y)].add((i, j))
                        dep2nums[(i, j)].add((x, y))

        q = Queue()
        for i in range(0, len(matrix)):
            for j in range(0, len(matrix[0])):
                if not num2deps[(i, j)]:
                    q.put((i, j))
                    num2res[(i, j)] = 1

        while(not q.empty()):
            cur_x, cur_y = q.get()
            #print(cur_x, cur_y, num2res[(cur_x, cur_y)])
            for num in dep2nums[(cur_x, cur_y)]:
                num2deps[num].remove((cur_x, cur_y))
                if not num2deps[num]:
                    q.put(num)
                    num2res[num] = max(num2res.get(num,0), num2res[(cur_x, cur_y)] + 1)

        return max(list(num2res.values()))
