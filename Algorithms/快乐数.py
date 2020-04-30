class Solution:
    def isHappy(self, n: int) -> bool:
        has_vis = set()
        has_vis.add(n)
        while True:
            n = sum([int(_) * int(_) for _ in str(n)])
            if n == 1:
                return True
            if n in has_vis:
                return False
            has_vis.add(n)