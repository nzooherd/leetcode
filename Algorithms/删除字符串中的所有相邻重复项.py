class Solution:
    def removeDuplicates(self, S: str) -> str:
        if not S:
            return ""

        res = [c for c in S]
        index = 1
        for i in range(1, len(S)):
            if index > 0 and S[i] == res[index - 1]:
                index -= 1
            else:
                res[index] = S[i]
                index += 1
        
        return "".join(res[0:index])
        

