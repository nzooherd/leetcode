class Solution(object):
    def mostVisited(self, n, rounds):
        """
        :type n: int
        :type rounds: List[int]
        :rtype: List[int]
        """
        regin2count = {_:0 for _ in range(1, n + 1)}

        for index in range(len(rounds) - 1):
            start = rounds[index]
            while(start != rounds[index+1]):
                regin2count[start] += 1
                start += 1

                start = (start - 1) % n
                start += 1
        
        regin2count[rounds[-1]] += 1
        region2count_items = [(x, y) for x, y in regin2count.items()]
        region2count_items.sort(key = lambda x: x[1], reverse=True)
        result = []
        for item in region2count_items:
            if item[1] == region2count_items[0][1]:
                result.append(item[0])
        result.sort()
        return result