class Solution:
    def generatePossibleNextMoves(self, s: str) -> List[str]:
        result = []
        for i,c in enumerate(s):
            if i == len(s) - 1:
                continue
            if c == '+' and s[i+1] == '+':
                result.append(s[:i] + "--" + s[i+2:])
        
        return result