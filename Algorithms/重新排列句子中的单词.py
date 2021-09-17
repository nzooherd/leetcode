class Solution:
    def arrangeWords(self, text: str) -> str:
        if not text:
            return ""
        text = text.lower()
        words = text.split(" ")
        words.sort(key=len)
        text = " ".join(words)
        text = text[0].upper() + text[1:]
        return text