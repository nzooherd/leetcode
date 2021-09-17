
class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        nodes = {_ for _ in leftChild}
        for child in rightChild:
            nodes.add(child)
        if len(nodes) != n:
            return False
        
        roots = { _ for _ in range(n)} - nodes
        if -1  in roots:
            roots.remove(-1)
        root = list(roots)[0]
        if leftChild[root] == -1 and rightChild[root] == -1 and n != 1:
            return False
        
        children = set()
        for i in range(n):
            if leftChild[i] in children:
                return False
            if rightChild[i] in children:
                return False
            if leftChild[i] != -1:
                children.add(leftChild[i])
            if rightChild[i] != -1:
                children.add(rightChild[i])

        return True
            
        