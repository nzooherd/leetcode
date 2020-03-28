class Solution(object):
    def commonChars(self, A):
        """
        :type A: List[str]
        :rtype: List[str]
        """
        num_map = {}        
        for s in A:
            temp_num_map = {}
            for c in s:
                key = c
                if c not in temp_num_map:
                    key += '1'
                    temp_num_map[c] = 1
                else:
                    key += str(temp_num_map[c] + 1)
                temp_num_map[c] += 1
                if key not in num_map:
                    num_map[key] = 1 
                else:
                    num_map[key] += 1

        ret = []
        for key, value in num_map.items():
            if value == len(A):
                ret.append(key[0])
        return ret