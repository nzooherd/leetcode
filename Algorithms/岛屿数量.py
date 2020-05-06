class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        import queue
        has_visit = set() 
        queue = queue.Queue() 
        result = 0
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] != '1' or (i, j) in has_visit:
                    continue

                result += 1
                queue.put((i, j))
                has_visit.add((i, j))
                while not queue.empty():
                    v, h = queue.get()
                    for a, b in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                        x = v + a
                        y = h + b
                        if (x, y) not in has_visit and x >= 0 and x < len(grid) and y >=0 and y < len(grid[0]):
                            has_visit.add((x, y))
                            if grid[x][y] == '1':
                                queue.put((x, y))
        return result