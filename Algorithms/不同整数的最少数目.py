class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        num2count = {}
        for num in arr:
            if num not in num2count:
                num2count[num] = 1
            else:
                num2count[num] += 1

        sum_keys = len(list(num2count.keys()))
        counts = list(num2count.values())
        counts.sort()
        print(counts)
        for count in counts:
            if k >= count:
                sum_keys -= 1
                k -= count
            else:
                break
        return sum_keys