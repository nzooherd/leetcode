class Solution:
    def closestDivisors(self, num: int) -> List[int]:
        num1 = num + 1
        num2 = num + 2

        res = [0, num1]
        import math
        for item in [num1, num2]:
            factor = int(math.sqrt(item))
            while(item % factor != 0):
                factor -= 1
            if(item // factor - factor) < res[1] - res[0]:
                res[0], res[1] = factor, item // factor
        
        return res