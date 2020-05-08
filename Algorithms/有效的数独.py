class Solution:
    def judge_single_sudoku(self, board, row, column, length, unique=True):
        # horizonal
        all_num = set()
        for i in range(row, row + length):
            num_set = set()
            for j in range(column, column + length):
                if board[i][j] == '.':
                    continue
                if board[i][j] < '1' or board[i][j] > '9':
                    return False  
                if board[i][j] in num_set:
                    return False
                if unique and board[i][j] in all_num:
                    return False
                num_set.add(board[i][j])
                all_num.add(board[i][j])

        for j in range(column, column + length):
            num_set = set()
            for i in range(row, row + length):
                if board[i][j] == '.':
                    continue
                if board[i][j] < '1' or board[i][j] > '9':
                    return False
                if board[i][j] in num_set:
                    return False
                num_set.add(board[i][j])
        return True

    def isValidSudoku(self, board):
        for row in [0, 3, 6]:
            for column in [0, 3, 6]:
                if not self.judge_single_sudoku(board, row, column, 3):
                    return False
        return self.judge_single_sudoku(board, 0, 0, 9, False)