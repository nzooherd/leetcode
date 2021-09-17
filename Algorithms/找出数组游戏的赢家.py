class Solution:
    def getWinner(self, arr, k: int) -> int:
        if k >= len(arr) - 1:
            return max(arr)

        i, j = 0, 1
        count = 0
        max_num = max(arr)
        while(j < len(arr)):
            if count >= k:
                return arr[i]
            if arr[i] == max_num:
                return arr[i]
            if arr[j] == max_num:
                return arr[j]

            if arr[i] > arr[j]:
                count += 1
                if count >= k:
                    return arr[i]
                j += 1
                continue

            count = 1
            i, j = j, j + 1