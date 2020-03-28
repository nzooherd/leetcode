import Queue
class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        o_set = set()                
        vis_set = set()
        queue = Queue.Queue()
        for i in range(0, len(board)):
            if i == 0 or i == len(board) - 1:
                for j in range(0, len(board[i])):
                    if board[i][j] == 'O':
                        queue.put((i, j)) 
                        o_set.add((i, j))
                        vis_set.add((i, j))
            else:
                if board[i][0] == 'O':
                    queue.put((i, 0))
                    o_set.add((i, 0))
                    vis_set.add((i, 0))
                if board[i][len(board[i]) - 1] == 'O':
                    queue.put((i, len(board[i]) - 1))
                    o_set.add((i, len(board[i]) - 1))
                    vis_set.add((i, len(board[i]) - 1))
    
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while not queue.empty():
            x, y = queue.get()
            for i, j in dirs:
                x_t = x + i
                y_t = y + j
                if x_t >= 0 and x_t < len(board) and y_t >= 0 and y_t < len(board[0]):
                    if (x_t, y_t) not in vis_set:
                        vis_set.add((x_t, y_t))
                        if board[x_t][y_t] == 'O':
                            o_set.add((x_t, y_t))
                            queue.put((x_t, y_t))
        
        for i in range(0, len(board)):
            for j in range(0, len(board[i])):
                if (i, j) not in o_set:
                    board[i][j] = 'X'