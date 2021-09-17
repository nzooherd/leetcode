class TreeAncestor:

    def __init__(self, n: int, parent: List[int]):
        self.index_parents = [[] for _ in range(0, 16)]
        for i in range(0, 16):
            for j in range(0, len(parent)):
                if i == 0:
                    self.index_parents[i].append(parent[j])
                    continue

                i_1_parent = self.index_parents[i-1][j]
                if i_1_parent == -1:
                    self.index_parents[i].append(-1)
                else:
                    self.index_parents[i].append(self.index_parents[i-1][i_1_parent])
        
    def getKthAncestor(self, node: int, k: int) -> int:
        if node == -1 or k == 0:
            return node

        index = 0
        while(k > 0):
            if(k & 1):
                node = self.index_parents[index][node]
            if node == -1:
                return node

            k >>= 1
            index += 1

        return node