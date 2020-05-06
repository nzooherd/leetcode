class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        point2island = {}
        island2area = {}
        has_visit = set()
        import queue
        queue = queue.Queue()
        island_index = 0
        
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if (i, j) not in has_visit and grid[i][j] == 1:
                    island_index += 1
                    area = 1
                    queue.put((i, j))
                    has_visit.add((i, j))
                    point2island[(i, j)] = island_index
                    while not queue.empty():
                        v, h = queue.get()
                        for a, b in [(1, 0), (-1, 0), (0, -1), (0, 1)]:
                            x = v + a
                            y = h + b
                            if x >= 0 and x < len(grid) and y >= 0 and y < len(grid[0]) and \
                                (x, y) not in has_visit and grid[x][y] == 1:
                                area += 1
                                queue.put((x, y))                                
                                point2island[(x, y)] = island_index
                            has_visit.add((x, y))
                    island2area[island_index] = area


        result = max(island2area.values() or [0])
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == 1:
                    continue

                area = 1
                union_sets = set()
                for a, b in [(1, 0), (-1, 0), (0, -1), (0, 1)]:
                    x = i + a
                    y = j + b
                    if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] != 1:
                        continue

                    union_sets.add(point2island[(x, y)])

                for island in union_sets:
                    area += island2area[island]

                result = max(result, area)

        return result