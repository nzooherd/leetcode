class Solution:
    def numSplits(self, s: str) -> int:
        if not s:
            return 0
        left_char, right_char = set(), set()
        right_char2count, left_char2count = {}, {}
        for char in s:
            if char not in right_char2count:
                right_char2count[char] = 0 
            right_char2count[char] += 1
        left_char2count = {key:val for key, val in right_char2count.items()}


        left, right = 0, len(s) - 1
        for left in range(0, len(s) - 1):
            left_char.add(s[left])

            right_char2count[s[left]] -= 1
            if not right_char2count[s[left]]:
                del right_char2count[s[left]]
            if len(right_char2count.keys()) == len(left_char):
                break

        for right in range(len(s) - 1, 0, -1):
            right_char.add(s[right])
            left_char2count[s[right]] -= 1
            if not left_char2count[s[right]]:
                del left_char2count[s[right]]
            if len(left_char2count.keys()) == len(right_char):
                break

        return max(right - left, 0)