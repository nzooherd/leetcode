class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        queue = deque([0])

        start2ends = defaultdict(list)
        end2starts = defaultdict(list)
        visit = {0}
        for connection in connections:
            if connection[1] == 0:
                queue.append(connection[0])
                visit.add(connection[0])
            start2ends[connection[0]].append(connection[1])
            end2starts[connection[1]].append(connection[0])


        result = 0
        while(len(queue) > 0):
            cur_node = queue.popleft()
            for start in end2starts[cur_node]:
                if start in visit:
                    continue
                queue.append(start)
                visit.add(start)

            for end in start2ends[cur_node]:
                if end in visit:
                    continue
                result += 1
                queue.append(end)
                visit.add(end)


        return result