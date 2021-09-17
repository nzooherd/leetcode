class Solution:

    def maxDistance(self, position: List[int], m: int) -> int:
        def check(position, dis, target):
            count, last_index = 1, 0
            for i in range(1, len(position)):
                if position[i] - position[last_index] >= dis:
                    count += 1
                    last_index = i
            return count >= target

        position.sort()
        if m == 2:
            return position[-1] - position[0]
        
        left, right = 1, (position[-1] - position[0]) // (m - 1)

        while(left <= right):
            mid = (left + right) // 2
            if check(position, mid, m):
                left = mid + 1
            else:
                right = mid - 1
        
        return left - 1