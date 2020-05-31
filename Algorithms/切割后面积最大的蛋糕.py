class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        horizontalCuts.sort()        
        verticalCuts.sort()
        horizontalCuts = [0] + horizontalCuts + [h]
        verticalCuts = [0] + verticalCuts + [w]


        line_max = 0
        vert_max = 0

        for i in range(0, len(horizontalCuts) - 1):
            line_max = max(line_max, (horizontalCuts[i+1] - horizontalCuts[i]))

        for j in range(0, len(verticalCuts) - 1):
            vert_max = max(vert_max, (verticalCuts[j+1] - verticalCuts[j]))

        return line_max * vert_max % (int(10 ** 9) + 7)