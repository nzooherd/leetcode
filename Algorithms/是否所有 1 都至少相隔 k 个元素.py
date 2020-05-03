class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        if k == 0:
            return True
        pre = False
        interval = 0
        for i in range(0, len(nums)):
            if not pre and nums[i] == 1:
                pre = True
                continue
            if pre:
                if nums[i] == 0:
                    interval += 1
                if nums[i] == 1:
                    if interval < k:
                        return False
                    interval = 0
        return True