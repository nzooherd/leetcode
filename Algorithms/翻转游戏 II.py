class Solution:
    def canWin(self, s: str) -> bool:
        if "++" not in s:
            return False

        result = []
        for i,c in enumerate(s):
            if i == len(s) - 1:
                continue
            if c == '+' and s[i+1] == '+':
                if not self.canWin(s[:i] + "--" + s[i+2:]):
                    return True
        return False