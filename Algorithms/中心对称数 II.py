class Solution:
    def findStrobogrammatic(self, n: int) -> List[str]:
        self_reverse = {"1": "1", "8": "8", "0": "0"}
        not_self_reverse = {"6": "9", "9": "6"}
        if n == 0:
            return []
        if n == 1:
            return ["1", "8", "0"]

        result_pre = [""]
        result_suf = []

        for i in range(0, int(n / 2), 1):
            for s in result_pre:
                for c in (list(self_reverse.keys()) + list(not_self_reverse.keys())):
                    if i == 0 and c == '0':
                        continue
                    result_suf.append(s + c)
            result_pre = result_suf
            result_suf = []

        if n % 2 != 0:
            for s in result_pre:
                for c in self_reverse.keys():
                    result_suf.append(s + c)
            result_pre = result_suf

        for i, s in enumerate(result_pre):
            final_s = s
            for c in s[::-1] if n % 2 == 0 else s[0:-1][::-1]:
                reverse_c = self_reverse.get(c) or not_self_reverse.get(c)
                final_s += reverse_c
            result_pre[i] = final_s

        return result_pre