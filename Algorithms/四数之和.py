class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        from collections import defaultdict
        import copy

        if len(nums) < 4:
            return []
        nums.sort()
        if sum(nums[::-1][:4]) < target:
            return []

        print(sum(nums[:4]))

        results = set()
        two_sum_dict = {}
        from datetime import datetime
        print(datetime.now())
        for i in range(len(nums)-2, -1, -1):
            #cur_two_sum = copy.deepcopy(two_sum_dict.get(i+1, defaultdict(set)))
            cur_two_sum = defaultdict(set)
            if i + 1 in two_sum_dict:
                for key, value in two_sum_dict[i+1].items():
                    for item in value:
                        cur_two_sum[key].add(tuple(item))
            for j in range(i + 1, len(nums)):
                cur_two_sum[nums[i] + nums[j]].add((nums[i], nums[j]))

            two_sum_dict[i] = cur_two_sum

        print(datetime.now())
        for i in range(0, len(nums) - 3):
            for j in range(i+1, len(nums)-2):
                for x, y in two_sum_dict[j+1][target - nums[i] - nums[j]]:
                    item = (nums[i], nums[j], x, y)
                    if item not in results:
                        results.add(item)
        return [list(_) for _ in results]

