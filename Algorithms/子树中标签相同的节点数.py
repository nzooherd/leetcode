import collections    
class Node:
    def __init__(self, label, num):
        self.label = label
        self.num = num
        self.childers = []


class Solution(object):
    def rebuildTree(self, n, edges, labels):
        num2node = [Node(labels[i], i) for i in range(n)]
        is_child = set()
        is_child.add(0)

        for edge in edges:
            parent, child = edge
            if child in is_child:
                parent, child = child, parent

            num2node[parent].childers.append(num2node[child])
            is_child.add(child)

        return num2node[0]


    def countTree(self, root, res):
        label2count =  collections.defaultdict(int)
        label2count[root.label] += 1

        for child in root.childers:
            child_label2count = self.countTree(child, res)
            for key, value in child_label2count.items():
                label2count[key] += value
 
        res[root.num] = label2count.get(root.label)
        return label2count

    def countSubTrees(self, n, edges, labels):
        """
        :type n: int
        :type edges: List[List[int]]
        :type labels: str
        :rtype: List[int]
        """
        root = self.rebuildTree(n, edges, labels)
        res = {}
        self.countTree(root, res) 
        return_res = []
        for i in range(n):
            return_res.append(res.get(i))

        return return_res



