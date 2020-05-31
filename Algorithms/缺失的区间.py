class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        result = []    
        if not nums:
            if upper == lower:
                result.append(str(upper))
            else:
                result.append(str(lower) + "->" + str(upper))
            return result
        if nums[0] > lower:
            if nums[0] - lower > 1:
                result.append(str(lower) + "->" +  str(nums[0] - 1))
            else:
                result.append(str(lower))

        for i in range(1, len(nums)):
            diff = nums[i] - nums[i-1]
            if diff == 0:
                continue
            if diff == 1:
                continue
            if diff == 2:
                result.append(str(nums[i-1]+1))
            else:
                result.append(str(nums[i-1]+1) + "->" + str(nums[i]-1))

        if nums[-1] < upper:
            if upper - nums[-1] == 1:
                result.append(str(upper))
            else: 
                result.append(str(nums[-1] + 1) + "->" + str(upper))

        return result
