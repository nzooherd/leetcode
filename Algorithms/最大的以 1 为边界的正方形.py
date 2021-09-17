class Solution:
    def largest1BorderedSquare(self, grid) -> int:
        if not grid:
            return 0

        grid_res = [[0] * len(grid[0]) for _ in grid]
        continue_one_grid = [([[0, 0] for _ in grid[0]]) for _ in grid]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                continue_one_grid[i][j] = [0, 0]

        for i in range(len(grid)):
            continue_one_count = 0
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    continue_one_count += 1
                else:
                    continue_one_count = 0
                continue_one_grid[i][j][0] = continue_one_count

        for j in range(len(grid[0])):
            continue_one_count = 0
            for i in range(len(grid)):
                if grid[i][j] == 1:
                    continue_one_count += 1
                else:
                    continue_one_count = 0
                continue_one_grid[i][j][1] = continue_one_count

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                max_continue_one_count = min(continue_one_grid[i][j])
                for k in range(0, max_continue_one_count):
                    if continue_one_grid[i][j-k][1] <= k: 
                        continue
                    if continue_one_grid[i-k][j][0] <= k: 
                        continue
                    grid_res[i][j] = (k + 1) * (k + 1)

        return max([max(_) for _ in grid_res])