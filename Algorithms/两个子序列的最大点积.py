class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        if not nums1 or not nums2:
            return 0

        dp = [[0] * len(nums2) for _ in nums1]
        result = nums1[0] * nums2[0]
        for i in range(0, len(nums1)):
            for j in range(0, len(nums2)):
                if i == 0:
                    dp[i][j] = max(dp[i][j-1], nums1[i] * nums2[j]) if j != 0 else  nums1[i] * nums2[j]
                elif j == 0:
                    dp[i][j] = max(dp[i-1][j], nums1[i] * nums2[j])                    
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j - 1] + nums1[i] * nums2[j], nums1[i] * nums2[j])

                result = max(result, dp[i][j])
        return result