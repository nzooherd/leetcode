class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        if not strs:
            return 0
        if len(strs) == 1:
            return len(strs[0])
        str2count = {}
        for item in strs:
            if item not in str2count:
                str2count[item] = 0
            str2count[item] += 1
        
        strs.sort(key=len, reverse=True)
        for i in range(0, len(strs)):
            if str2count[strs[i]] > 1:
                continue
            for j in range(i-1, -1, -1):
                if self.is_sub(strs[j], strs[i]):
                    break
            else:
                return len(strs[i])

        return -1
    
    def is_sub(self, str1, str2):
        if str1 == str2:
            return True
        if len(str2) > len(str1):
            str1, str2 = str2, str1
        i, j = 0, 0
        while(i < len(str1)):
            if str1[i] == str2[j]:
                j += 1
                if j == len(str2):
                    return True
            i += 1
        return False