class Solution:
    def expressiveWords(self, S: str, words: List[str]) -> int:
        def is_valid(S, word):
            if not word:
                return False
            i, j = 0, 0
            while(i < len(S) and j < len(word)):
                if S[i] != word[j]:
                    return False
                i += 1
                i_num = 1
                while(i < len(S) and S[i] == S[i-1]):
                    i_num += 1
                    i += 1

                j += 1
                j_num = 1
                while(j < len(word) and word[j] == word[j-1]):
                    j_num += 1
                    j += 1

                if i_num < j_num:
                    return False
                if i_num >= 3:
                    continue
                if i_num < 3 and i_num != j_num:
                    return False
            return True if (i >= len(S) and j >= len(word)) else False

        if not S:
            return 0
        result = sum([1 if is_valid(S, _) else 0 for _ in words])
        return result