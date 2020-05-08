class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        if not s:
            return False if not t else len(t) == 1
        if not t:
            return len(s) == 1

        if abs(len(s) - len(t)) > 1:
            return False
        if len(s) < len(t):
            s, t = t, s
        for i in range(0, len(t)):
            if s[i] != t[i]:
                return s[i+1:] == t[i+1:] if len(s) == len(t) else s[i+1:] == t[i:]
        return len(s) > len(t)