from queue import PriorityQueue

class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort()

        que = PriorityQueue()  # 长度, Priority

        res = [-1] * len(queries)
        order_queries = [(queries[i], i) for i in range(0, len(queries))]
        order_queries.sort()
        pos = 0

        for i in range(0, len(order_queries)):
            query = order_queries[i][0]
            index = order_queries[i][1]

            while pos < len(intervals) and intervals[pos][0] <= query:
                que.put((intervals[pos][1] - intervals[pos][0] + 1, intervals[pos][1]))
                pos += 1
            
            while not que.empty():
                if que.queue[0][1] < query:
                    que.get()
                else:
                    res[index] = que.queue[0][0] 
                    break
        
        return res
