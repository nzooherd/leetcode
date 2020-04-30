class Solution:
    def maxKilledEnemies(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0
        result = []
        for i in range(0, len(grid)):
            result.append([0] * len(grid[0]))

        for i in range(0, len(grid)):
            # left to right
            enemy_num = 0
            for j in range(0, len(grid[0])):
                if grid[i][j] == '0':
                    result[i][j] += enemy_num
                if grid[i][j] == 'W':
                    enemy_num = 0
                if grid[i][j] == 'E':
                    enemy_num += 1
            enemy_num = 0
            for j in range(len(grid[0])-1, -1, -1):
                if grid[i][j] == '0':
                    result[i][j] += enemy_num
                if grid[i][j] == 'W':
                    enemy_num = 0
                if grid[i][j] == 'E':
                    enemy_num += 1

        for j in range(0, len(grid[0])):
            # left to right
            enemy_num = 0
            for i in range(0, len(grid)):
                if grid[i][j] == '0':
                    result[i][j] += enemy_num
                if grid[i][j] == 'W':
                    enemy_num = 0
                if grid[i][j] == 'E':
                    enemy_num += 1
            enemy_num = 0
            for i in range(len(grid)-1, -1, -1):
                if grid[i][j] == '0':
                    result[i][j] += enemy_num
                if grid[i][j] == 'W':
                    enemy_num = 0
                if grid[i][j] == 'E':
                    enemy_num += 1

        return max([max(_) for _ in result])