class Solution:
    def do(self, edges, hasApple, start_node, parent2child):
        if start_node not in parent2child:
            return 0 if start_node in hasApple else -1

        result = 0
        values = []
        for node in parent2child[start_node]:
            value = self.do(edges, hasApple, node[1], parent2child)
            values.append(value)
            result += value
        if result == (-1) * len(parent2child[start_node]) and start_node not in hasApple:
            return -1
        return sum([_ + 2 if _ != -1 else 0 for _ in values])

    def minTime(self, n, edges, hasApple) -> int:
        if True not in hasApple:
            return 0
        import collections
        parent2child = collections.defaultdict(list)
        for edge in edges:
            parent2child[edge[0]].append(edge)

        has_apple = set()
        for i in range(0, len(hasApple)):
            if hasApple[i]:
                has_apple.add(i)
        return self.do(edges, has_apple, 0, parent2child) 