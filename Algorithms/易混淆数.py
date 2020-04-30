class Solution:
    def confusingNumber(self, N: int) -> bool:
        confus_nums = {"0": "0", "1": "1", "6": "9", "9": "6", "8": "8"}
        result = ''
        for c in str(N):
            if c not in confus_nums:
                return False
            result += confus_nums[c]
        return result[::-1] != str(N)