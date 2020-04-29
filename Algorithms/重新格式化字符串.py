class Solution:
    def reformat(self, s: str) -> str:
        num_str = ""
        char_str = ""
        for c in s:
            if c >= '0' and c <= '9':
                num_str += c
            else:
                char_str += c
        
        len_diff = len(num_str) - len(char_str)
        if len_diff > 1 or len_diff < -1:
            return ""

        if len(num_str) > len(char_str):
            first = num_str
            second = char_str
        else:
            first = char_str
            second = num_str
        result = ""
        for i in range(0, len(s)):
            if i % 2 == 0:
                result += first[int(i/2)]
            else:
                result += second[int(i/2)]
        return result