class Solution:
    def closestToTarget(self, arr: List[int], target: int) -> int:
        prev_res = set()
        prev_res.add(arr[0])
        res = abs(arr[0] - target)

        for i in range(1, len(arr)):
            temp_res = {arr[i]}
            res = min(res, abs((arr[i]) - target))
            for prev in prev_res:
                temp_res.add(prev & arr[i])
                res = min(res, abs((prev & arr[i]) - target))
            if res == 0:
                return 0
            prev_res = temp_res

        return res

        