class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        if len(nums) == 2:
            return nums[0]

        slow, quick = 0, 0
        while(slow != quick or slow == 0):
            slow = nums[slow]
            quick = nums[quick]
            quick = nums[quick]

        slow = 0
        while(slow != quick):
            slow = nums[slow]
            quick = nums[quick]

        return slow