class Solution:
    def isReflected(self, points: List[List[int]]) -> bool:
        ver2hors = defaultdict(list)
        for point in points:
            ver2hors[point[1]].append(point[0])

        split_ver = None
        for ver, hors in ver2hors.items():
            hors.sort()
            for i in range(0, len(hors) // 2):
                if not split_ver:
                    split_ver = (hors[i] + hors[len(hors) - 1 - i]) / 2
                else:
                    if split_ver != (hors[i] + hors[len(hors) - 1 - i]) / 2:
                        return False

            if len(hors) % 2 ==  1:
                if not split_ver:
                    split_ver = hors[len(hors) // 2]
                else:
                    if split_ver != hors[len(hors) // 2]:
                        return False

        return True
