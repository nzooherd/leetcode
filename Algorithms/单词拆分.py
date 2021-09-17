from functools import lru_cache
class Solution:
    @lru_cache(None)
    def wordBreakDo(self, s):
        if not s:
            return True
        for word in self.wordDict:
            if s.startswith(word):
                if self.wordBreakDo(s[len(word):]):
                    return True
        return False

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.wordDict = wordDict
        return self.wordBreakDo(s)
