from bisect import bisect_left

class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        result = [-1] * len(rains)
        has_full_pools = {}
        could_pull_days = []

        for i, rain in enumerate(rains):
            if rain == 0:
                could_pull_days.append(i)
                continue

            if rain in has_full_pools:
                if could_pull_days:
                    pull_day = bisect_left(could_pull_days, has_full_pools[rain])
                    if pull_day < 0 or pull_day >= len(could_pull_days):
                        return []
                    else:
                        result[could_pull_days.pop(pull_day)] = rain
                else:
                    return []
            has_full_pools[rain] = i


        while(could_pull_days):
            pull_day = could_pull_days.pop()
            result[pull_day] = 1

        return result