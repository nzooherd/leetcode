class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        tail_zero_counts = [] 
        for i in range(0, len(grid)):
            count = 0
            for j in range(len(grid[0]) - 1, -1, -1):
                if grid[i][j] == 0:
                    count += 1
                else:
                    break
            tail_zero_counts.append(count)

        has_used = set()
        res_index = []
        for i in range(0, len(grid) - 1):
            need_count = len(grid) - i  - 1 
            for index, count in enumerate(tail_zero_counts):
                if count >= need_count and index not in has_used:
                    has_used.add(index)
                    res_index.append(index)
                    break
            else:
                return -1
        not_used = {_ for _ in range(len(grid))}
        not_used -= has_used
        res_index.append(not_used.pop())

        if len(res_index) != len(grid):
            return -1
        
        res = 0 
        for i in range(1, len(res_index)):
            j = i - 1
            while(j >= 0 and res_index[j + 1] < res_index[j]):
                res_index[j + 1], res_index[j] = res_index[j], res_index[j + 1]
                j -= 1
                res += 1

        return res

