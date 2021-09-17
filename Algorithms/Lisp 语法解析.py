class Solution(object):
    def evaluate(self, expression, identify2value=None):
        """
        :type expression: str
        :rtype: int
        """
        if "(" not in expression:
            try:
                return int(expression)
            except:
                return identify2value.get(expression)
        if not identify2value:
            identify2value = {}
        else:
            identify2value = {key:value for key, value in identify2value.items()}

        tokens = []
        start, end, bracket = 1, 1, 0
        while(end < len(expression) - 1):
            if(expression[end] == ' ' and bracket == 0):
                tokens.append(expression[start:end])
                start = end + 1 
            if(expression[end] == '('): 
                bracket += 1
            if(expression[end] == ')'):
                bracket -= 1
            end += 1
        tokens.append(expression[start:end])


        if tokens[0] == 'mult':
            res = self.evaluate(tokens[1], identify2value) * self.evaluate(tokens[2], identify2value)
            return res

        if tokens[0] == 'add':
            res = self.evaluate(tokens[1], identify2value) + self.evaluate(tokens[2], identify2value)
            return res

        for i in range(1, len(tokens) - 1, 2):
            identify2value[tokens[i]] = self.evaluate(tokens[i+1], identify2value)

        res = self.evaluate(tokens[-1], identify2value)
        return res