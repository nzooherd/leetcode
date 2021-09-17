class Solution:
    def isPathCrossing(self, path: str) -> bool:
        has_vis = set() 
        now = (0, 0)
        has_vis.add(now)
        for direction in path:
            x, y = now
            if direction == 'N':
                y += 1
            elif direction == 'S':
                y -= 1
            elif direction == 'E':
                x += 1
            else:
                x -= 1
            if (x, y) in has_vis:
                return True
            has_vis.add((x, y))
            now = (x, y)
        return False