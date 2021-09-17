class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        result = 0
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == 'X':
                    if i == 0 and j == 0:
                        result += 1 
                    else:
                        if i == 0:
                            result += 1 if board[i][j-1] != 'X' else 0
                        elif j == 0:
                            result += 1 if board[i-1][j] != 'X' else 0
                        else:
                            result += 1 if board[i-1][j] != 'X' and board[i][j-1] != 'X' else 0  
        
        return result