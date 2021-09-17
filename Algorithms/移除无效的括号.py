class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        left_bracket, right_bracket = 0, 0
        left_result = ""
        result = ""
        for char in s:
            if char != '(' and char != ')':
                left_result += char
                continue
            if char == '(':
                left_bracket += 1
            else:
                left_bracket -= 1

            if left_bracket >= 0:
                left_result += char
            else:
                left_bracket = 0

        for i in range(len(left_result) - 1, -1, -1):
            char = left_result[i]
            if char != '(' and char != ')':
                result += char
                continue

            if char == '(':
                right_bracket -= 1
            else:
                right_bracket += 1

            if right_bracket >= 0:
                result += char
            else:
                right_bracket = 0

        return result[::-1]

