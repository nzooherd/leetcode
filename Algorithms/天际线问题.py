class Solution:

    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        if not buildings:
            return []

        if len(buildings) == 1:
            return [[buildings[0][0], buildings[0][2]], [buildings[0][1], 0]]


        mid = (0 + len(buildings) - 1) // 2
        left_result = self.getSkyline(buildings[0:mid+1])
        right_result = self.getSkyline(buildings[mid+1:])

        result = []
        if right_result[0][0] > left_result[-1][0]:
            return left_result + right_result

        left_height, right_height, cur_height = 0, 0, 0
        i, j, position = 0, 0, 0
        while(i < len(left_result) and j < len(right_result)):
            if left_result[i][0] > right_result[j][0]:
                right_height = right_result[j][1] 
                position = right_result[j][0]
                j += 1
            elif left_result[i][0] < right_result[j][0]:
                left_height = left_result[i][1]
                position = left_result[i][0]
                i += 1
            else:
                left_height = left_result[i][1]
                right_height = right_result[j][1]
                position = left_result[i][0]
                i += 1
                j += 1

            if max(left_height, right_height) != cur_height:
                cur_height = max(left_height, right_height)
                result.append([position, cur_height])

        while(i < len(left_result)):
            left_height = left_result[i][1]
            if max(left_height, right_height) != cur_height:
                cur_height = max(left_height, right_height)
                result.append([left_result[i][0], cur_height])
            i += 1
        while(j < len(right_result)):
            right_height = right_result[j][1]
            if max(left_height, right_height) != cur_height:
                cur_height = max(left_height, right_height)
                result.append([right_result[j][0], cur_height])
            j += 1


        return result

