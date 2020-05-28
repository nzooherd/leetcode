class Solution:
    def verifyPreorder(self, preorder) -> bool:
        if not preorder or len(preorder) == 1:
            return True

        stack = []
        cur_max = -float("inf")
        for num in preorder:
            if not stack:
                stack.append(num)
                continue
            if num == stack[-1]:
                return False
            if num < cur_max:
                return False
            while len(stack) > 0 and num > stack[-1]:
                cur_max = stack.pop(-1)
            stack.append(num)

        return True