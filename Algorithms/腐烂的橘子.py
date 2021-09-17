from queue import Queue

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = Queue()
        all_count = sum([sum([1 if (_ != 0) else 0 for _ in row]) for row in grid])
        has_vis = set()
        res = 0

        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == 2:
                    has_vis.add((i, j))
                    q.put((i, j, 0))

        while(not q.empty()):
            cur_x, cur_y, cur_time = q.get()
            res = max(cur_time, res)

            for a, b in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                next_x = cur_x + a
                next_y = cur_y + b

                if next_x < 0 or next_x >= len(grid) or next_y < 0 or next_y >= len(grid[0]):
                    continue
                if (next_x, next_y) in has_vis:
                    continue
                if grid[next_x][next_y] != 1:
                    continue

                grid[next_x][next_y] = 2
                has_vis.add((next_x, next_y))
                q.put((next_x, next_y, cur_time + 1))

        if len(has_vis) != all_count:
            return -1

        return res
