from queue import PriorityQueue
class PriorityList:
    def __init__(self, values, indexs):
        self.values = values
        self.indexs = indexs
    def __lt__(self, other):
        return sum(self.values) < sum(other.values)

    def __repr__(self):
        return str(self.values)
    
class Solution:
    def kthSmallest(self, mat, k):
        q = PriorityQueue()
        q.put(PriorityList([_[0] for _ in mat], tuple([0 for _ in mat])))
        has_vis = set(tuple([0 for _ in mat]))
        while k > 1:
            cur_indexs = q.get().indexs
            for i, index in  enumerate(cur_indexs):
                if index == len(mat[0]) - 1:
                    continue
                next_indexs = [_ for _ in cur_indexs]
                next_indexs[i] = index + 1
                if tuple(next_indexs) in has_vis:
                    continue
                else:
                    has_vis.add(tuple(next_indexs))

                next_values = [_[next_indexs[i]] for i, _ in enumerate(mat)]
                q.put(PriorityList(next_values, next_indexs))
            k -= 1

        return sum(q.get().values)