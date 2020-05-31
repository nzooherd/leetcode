class Solution:
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        if not s:
            return s
        def reverse(start, end):
            for i in range(0, (end - start + 1) // 2):
                s[start + i], s[end - i] = s[end - i], s[start + i]

        start, end = 0, 0
        for i in range(0, len(s)):
            if s[i] == " ":
                end = i - 1
                reverse(start, end)
                start = i + 1
        reverse(start, len(s) - 1)

        reverse(0, len(s) - 1)