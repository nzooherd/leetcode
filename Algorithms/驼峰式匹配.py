class Solution(object):
    def camelMatch(self, queries, pattern):
        """
        :type queries: List[str]
        :type pattern: str
        :rtype: List[bool]
        """
        ret = []
        for s in queries:
            ret.append(self.is_patter(s, pattern))
        return ret

    def is_patter(self, s, pattern):
        pattern_index = 0
        for i in range(0, len(s)):
            if s[i] >= 'A' and s[i] <= 'Z' and (pattern_index == len(pattern) or s[i] != pattern[pattern_index]):
                return False
            if pattern_index < len(pattern) and s[i] == pattern[pattern_index]:
                pattern_index += 1
                continue
        return pattern_index == len(pattern)