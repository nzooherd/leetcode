class Solution(object):
    def removeOuterParentheses(self, S):
        """
        :type S: str
        :rtype: str
        """
        brackets = []
        start = 0
        num = 0
        for i in range(len(S)):
            if S[i] == '(':
                num += 1
            if S[i] == ')':
                num -= 1
            if num == 0:
                brackets.append(S[start:i+1])
                start = i+1
        ret = ''
        for bracket in brackets:
            ret += bracket[1:-1]
        return ret
            