# """
# This is MountainArray's API interface.
# You should not implement it, or speculate about its implementation
# """
#class MountainArray:
#    def get(self, index: int) -> int:
#    def length(self) -> int:

class Solution:
    def find_top_index(self, mountain_arr):
        left, right = 0, mountain_arr.length()-1
        while(left < right):
            mid = int((left + right) / 2)
            if mountain_arr.get(mid + 1) > mountain_arr.get(mid):
                left = mid + 1
            else:
                right = mid 
        return left

    def dichotomy_search(self, target, mountain_arr, start, end, reverse=False):
        while(start < end):
            mid = int((start + end) / 2)
            value = mountain_arr.get(mid)
            if value > target:
                if not reverse:
                    end = mid - 1
                else:
                    start = mid + 1
            elif value < target:
                if not reverse:
                    start = mid + 1
                else:
                    end = mid - 1
            else:
                return mid
        if mountain_arr.get(start) == target:
            return start
        return -1



    def findInMountainArray(self, target, mountain_arr):
        top_index = self.find_top_index(mountain_arr)
        if mountain_arr.get(top_index) == target:
            return top_index
        left_result = self.dichotomy_search(target, mountain_arr, 0, top_index)
        if left_result != -1:
            return left_result
        return self.dichotomy_search(target, mountain_arr, top_index, mountain_arr.length()-1, reverse=True)
    