import queue

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        q = queue.Queue()
        has_vis = set()


        if not grid:
            return 0
        width, height = len(grid), len(grid[0])

        result = 0
        for i in range(0, width):
            for j in range(0, height):
                if grid[i][j] == 0:
                    continue

                if (i, j) in has_vis:
                    continue

                has_vis.add((i, j))
                cur_res = 1
                q.put((i, j))
                while(not q.empty()):
                    cur_x, cur_y = q.get()

                    for a, b in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
                        next_x = cur_x + a
                        next_y = cur_y + b

                        if next_x < 0 or next_y < 0 or next_x >= width or next_y >= height:
                            continue
                        if grid[next_x][next_y] == 0:
                            continue
                        if (next_x, next_y) in has_vis:
                            continue

                        q.put((next_x, next_y))
                        cur_res += 1
                        has_vis.add((next_x, next_y))

                if cur_res > result:
                    result = cur_res 

        return result



