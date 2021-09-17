class Solution:
    def longestLine(self, M: List[List[int]]) -> int:
        if not M:
            return 0
        grid_res = [[0] * len(M[0]) for _ in M]
        dir_res = [0] * 4

        for i in range(0, len(M)):
            cur_res = 0
            for j in range(0, len(M[0])):
                if M[i][j] == 1:
                    cur_res += 1
                else:
                    cur_res = 0
                grid_res[i][j] = cur_res
        dir_res[0] = max([max(_) for _ in grid_res])

        for  j in range(0, len(M[0])):
            cur_res = 0
            for i in range(0, len(M)):
                if M[i][j] == 1:
                    cur_res += 1
                else:
                    cur_res = 0
                grid_res[i][j] = cur_res
        dir_res[1] = max([max(_) for _ in grid_res])

        for i in range(0, len(M)):
            for j in range(0, len(M[0])):
                if M[i][j] == 0:
                    cur_res = 0
                    continue
                cur_res = 1
                if i > 0 and j > 0:
                    cur_res += grid_res[i-1][j-1]

                grid_res[i][j] = cur_res
        dir_res[2] = max([max(_) for _ in grid_res])
        
        for i in range(0, len(M)):
            for j in range(len(M[0]) - 1, -1, -1):
                if M[i][j] == 0:
                    cur_res = 0
                    continue
                cur_res = 1
                if i > 0 and j < len(M[0]) - 1:
                    cur_res += grid_res[i-1][j+1]
                grid_res[i][j] = cur_res
        dir_res[3] = max([max(_) for _ in grid_res])
        return max(dir_res)
        
