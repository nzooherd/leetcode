class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        if not s or k > len(s) or k < 0:
            return -1

        vowels = {"a", "e", "i", "o", "u"}
        result, left, right = 0, 0, 0
        while(right < k and right < len(s)):
            if s[right] in vowels:
                result += 1
            right += 1

        pre_result = result
        while(right < len(s)):
            if s[right] in vowels:
                pre_result += 1
            if s[left] in vowels:
                pre_result -= 1
            result = max(result, pre_result)
            left += 1
            right += 1

        return result