from queue import Queue

class Solution:

    def closedIsland(self, grid: List[List[int]]) -> int:
        q = Queue()
        has_visit = set()
        result = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != 0 or (i, j) in has_visit:
                    continue

                q.put((i, j))
                has_visit.add((i, j))
                valid = True
                if i == 0 or i == len(grid) - 1 or j == 0 or j == len(grid[0]) - 1:
                    valid = False

                while(not q.empty()):
                    cur_row, cur_col = q.get()
                    for x, y in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                        next_row = cur_row + x
                        next_col = cur_col + y

                        if next_row < 0 or next_row >= len(grid) or next_col < 0 or next_col >= len(grid[0]):
                            continue

                        if (next_row, next_col) in has_visit:
                            continue
                        has_visit.add((next_row, next_col))
                        if grid[next_row][next_col] != 0:
                            continue

                        q.put((next_row, next_col))
                        if next_row == 0 or next_row == len(grid) - 1 or next_col == 0 or next_col == len(grid[0]) - 1:
                            valid = False

                result += 1 if valid else 0

        return result