from functools import lru_cache


class Solution:

    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        if m * k > len(bloomDay):
            return -1
        if m * k == len(bloomDay):
            return max(bloomDay)
        if m == 1 and k == 1:
            return min(bloomDay)
        

        def is_valid(has_delete, day_len, m, k):
            has_delete.sort()
            has_achieve = 0
            for i, delete in enumerate(has_delete):
                if i == 0:
                    has_achieve += (delete - 0) // k
                else:
                    has_achieve += (delete - has_delete[i-1] - 1) // k
            has_achieve += (day_len - has_delete[-1] - 1) // k
            return has_achieve >= m

        bloomDayWithIndex = []
        for i, day in enumerate(bloomDay):
            bloomDayWithIndex.append((i, day))

        bloomDayWithIndex.sort(key=lambda x:x[1], reverse=True)
        has_delete = []
        for i in range(0, len(bloomDay)):
            has_delete.append(bloomDayWithIndex[i][0])
            if not is_valid(has_delete, len(bloomDay), m, k):
                return bloomDayWithIndex[i][1]
        return -1