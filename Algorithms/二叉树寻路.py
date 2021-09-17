import math

class Solution:
    def pathInZigZagTree(self, label: int, path=None) -> List[int]:

        if not path:
            path = []
        if label == 1:
            path.append(1)
            return path[::-1]

        path.append(label)
    
        level = int(math.log2(label))
        level += 1

        cur_level_index = 0
        if(level % 2 == 1):
            cur_level_index = label - int(pow(2, level - 1)) + 1
            father_index = (cur_level_index + 1) // 2
            father_label = int(pow(2, level - 1)) - father_index
        else:
            cur_level_index = int(pow(2, level)) - label
            father_index = (cur_level_index + 1) // 2
            father_label = int(pow(2, level - 2)) - 1 + father_index

        
        return self.pathInZigZagTree(father_label, path)

