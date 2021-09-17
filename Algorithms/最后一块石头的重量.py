class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        if (len(stones) == 0):
            return 0 
        if (len(stones) == 1):
            return stones[0]

        max1, max2 = 0,  1
        if (stones[0] < stones[1]):
            max1, max2 = 1, 0

        for index in range(2, len(stones)):
            if (stones[index] > stones[max1]) :
                max2 = max1
                max1 = index
            elif (stones[index] > stones[max2]):
                max2 = index
        
        next_stones = list(map(lambda index: stones[index], 
                          filter(lambda index:  index != max1 and index != max2, 
                                 range(0, len(stones)))))
        if (stones[max1] != stones[max2]) :
            next_stones.append(abs(stones[max1] - stones[max2]))
        return self.lastStoneWeight(next_stones)

        