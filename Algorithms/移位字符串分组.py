from collections import defaultdict

class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        pos2group = defaultdict(list)
        for string in strings:
            pos = [] if string else [-1]
            for i in range(0, len(string) - 1):
                pos.append((ord(string[i+1]) - ord(string[i])) % 26)

            pos2group[tuple(pos)].append(string)

        return list(pos2group.values())