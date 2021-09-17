class Solution(object):
    def getStrongest(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: List[int]
        """
        if k <= 0:
            return []

        arr.sort()
        mid_num = arr[(len(arr)-1) / 2]
        num = 0
        result = []
        left, right = 0, len(arr) - 1
        while(num < k):
            if arr[right] - mid_num >= mid_num - arr[left]:
                result.append(arr[right])
                right -= 1
            else:
                result.append(arr[left])
                left += 1
            num += 1
        return result
