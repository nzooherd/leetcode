import Queue
class Solution(object):
    def numEnclaves(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        can_move_num = 0
        sum_num = sum(sum(row) for row in A)
        vis_set = set()

        queue = Queue.Queue()
        for i in 0, len(A) - 1:
            for j in range(len(A[i])):
                if A[i][j] == 1:
                    can_move_num += 1
                    A[i][j] = True
                    vis_set.add((i, j))
                    queue.put((i, j))
        for i in range(1, len(A) - 1):
            for j in 0, len(A[i]) - 1:
                if A[i][j] == 1:
                    can_move_num += 1
                    A[i][j] = True
                    vis_set.add((i, j))
                    queue.put((i, j))


        while not queue.empty():
            x, y = queue.get()
            for i, j in (1, 0), (-1, 0), (0, 1), (0, -1):
                row = x + i
                column = y + j
                if 0 <= row < len(A) and 0 <= column < len(A[0]) and A[row][column] == 1 and (row, column) not in vis_set:
                    can_move_num += 1
                    vis_set.add((row, column))
                    queue.put((row, column))
        
        return sum_num - can_move_num