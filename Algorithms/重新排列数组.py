class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        result = []
        i, j = 0, n
        while(j < 2 * n):
            result.append(nums[i])
            result.append(nums[j])
            i += 1
            j += 1
        return result