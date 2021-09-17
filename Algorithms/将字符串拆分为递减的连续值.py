class Solution:
    def splitString(self, s: str) -> bool:
        if not s or len(s) < 2:
            return False
        for i in range(0, len(s)-1):
            num = int(s[0:i+1])
            if self.can_split(s[i+1:], num - 1):
                return True
        return False
    
    def can_split(self, s, target) -> bool:
        if not s:
            return True
        for i in range(0, len(s)):
            if int(s[0:i+1]) == target:
                if self.can_split(s[i+1:], target-1) :
                    return True
        return False
