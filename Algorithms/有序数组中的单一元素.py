class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while(left < right):
            mid = (left + right) // 2
            if nums[mid-1] != nums[mid] and nums[mid + 1] != nums[mid]:
                return nums[mid]
            if mid % 2 == 1:
                if nums[mid-1] == nums[mid]:
                    left = mid + 1
                else:
                    right = mid
            else:
                if nums[mid-1] == nums[mid]:
                    right = mid
                else:
                    left = mid + 1
        
        return nums[left]