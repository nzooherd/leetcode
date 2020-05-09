class Solution:
    def parseTernary(self, expression: str) -> str:
        if not expression:
            return -1
        if len(expression) == 1:
            return expression

        latest_split_index = expression.rfind("?")
        if expression[latest_split_index-1] == "T":
            return self.parseTernary(
                (expression[:latest_split_index-1] if latest_split_index > 1 else "") + 
                expression[latest_split_index + 1] + expression[latest_split_index + 4:])
        else:
            return self.parseTernary(
                (expression[:latest_split_index-1] if latest_split_index > 1 else "") + 
                expression[latest_split_index + 3] + expression[latest_split_index + 4:])