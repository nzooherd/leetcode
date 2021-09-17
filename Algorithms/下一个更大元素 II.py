class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = [] 
        result = [-1] * len(nums)
        nums += nums
        for i, num in enumerate(nums):
            while(len(stack) >= 1 and stack[-1][0] < num):
                tail = stack.pop()
                if tail[1] < len(result):
                    result[tail[1]] = num
            stack.append((num, i))
        return result