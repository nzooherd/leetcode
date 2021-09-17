class Solution(object):
    def find132pattern(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) < 3:
            return False

        farset_smaller_indexs = [-1]
        small_stack = [(nums[0], 0)]
        for i in range(1, len(nums)):
            if nums[i] <= small_stack[-1][0]:
                farset_smaller_indexs.append(-1)
                small_stack.append((nums[i], i))
                continue
            for j in range(0, len(small_stack)):
                if small_stack[j][0] < nums[i]:
                    farset_smaller_indexs.append(small_stack[j][1])
                    break


        print(farset_smaller_indexs)
        small_stack = [(nums[0], 0)]
        for i in range(1, len(nums)):
            while(small_stack and small_stack[-1][0] <= nums[i]):
                small_stack.pop()

            for j in range(0, len(small_stack)):
                if farset_smaller_indexs[i] == -1:
                    continue
                if farset_smaller_indexs[i] < small_stack[j][1]:
                    return True
            small_stack.append((nums[i], i))
            
        return False