class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        if not arr or len(arr) < 2:
            return 0

        diff_or = {}
        or_sum = 0
        for i in range(0, len(arr)):
            or_sum ^= arr[i]
            diff_or[i] = or_sum
        
        results = 0
        for i in range(0, len(arr) - 1):
            for j in range(i + 1, len(arr)):
                for k in range(j, len(arr)):
                    if diff_or[j-1] ^ (diff_or[i-1] if i >= 1 else 0) == diff_or[k] ^ diff_or[j-1]:
                        results += 1
        
        return results