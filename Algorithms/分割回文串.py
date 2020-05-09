class Solution:
    @lru_cache(maxsize=200)
    def do_by_cache(self, s):
        results = []
        if not s:
            return [[]]
        for i in range(0, len(s)):
            cur_str = s[:i+1]
            if cur_str == cur_str[::-1]:
                next_results = self.do_by_cache(s[i+1:]) 
                for next_result in next_results:
                    results.append([cur_str] + next_result)

        return results


    def partition(self, s: str):
        return self.do_by_cache(s)