class Solution:
    def sortTransformedArray(self, nums: List[int], a: int, b: int, c: int) -> List[int]:
        if a == 0:
            nums = sorted(nums, reverse=True if b < 0 else False)
        else:
            mid = (-1 * b) / (2 * a)
            nums = sorted(nums, key=lambda x: abs(x - mid), reverse=True if a < 0 else False)
        result = [int(_ * _ * a + _ * b + c) for _ in nums]
        return result