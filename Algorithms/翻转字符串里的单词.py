class Solution:
    def reverseWords(self, s: str) -> str:
        s.strip()
        words = s.split(" ")
        words = words[::-1]
        words = filter(lambda x:x, words)
        return " ".join(words)