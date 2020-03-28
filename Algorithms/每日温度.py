class Solution:
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        ret = [1] * len(temperatures)
        stack = []
        
        for i in range(len(temperatures)):
            if(len(stack) == 0):
                stack.append(i)
            else:
                temp = temperatures[i]
                while(len(stack) != 0 and temperatures[stack[len(stack) - 1]] < temp):
                    days = stack[len(stack) - 1] * (-1) + i
                    ret[stack[len(stack) -1]] = days
                    stack.pop()

                stack.append(i)

        while(len(stack) != 0):
            ret[stack[len(stack) - 1]] = 0
            stack.pop()

        return ret