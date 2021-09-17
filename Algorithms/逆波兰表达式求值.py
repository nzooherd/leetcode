class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operators = {"+", "-", "*", "/"}
        stack = []
        cur_index = 0
        for token in tokens:
            if token not in operators:
                if cur_index == len(stack):
                    stack.append(token)
                else:
                    stack[cur_index] = token
                cur_index += 1
            else:
                oper_token = int(stack[cur_index - 2])
                opered_token = int(stack[cur_index - 1])
                cur_index -= 2
                cur_token = None
                if token == "+":
                    cur_token = oper_token + opered_token
                elif token == "-":
                    cur_token = oper_token - opered_token
                elif token == "*":
                    cur_token = oper_token * opered_token
                else:
                    cur_token = int(oper_token / opered_token)
                stack[cur_index] = cur_token
                cur_index += 1
        return int(stack[0])