class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        if len(coordinates) <= 2:
            return True
        abscissa = set()
        for coordinate in coordinates:
            abscissa.add(coordinate[0])
        if len(abscissa) != len(coordinates):
            return len(abscissa) == 1
        
        key = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0])

        for i in range(2, len(coordinates) -1):
            if (coordinates[i][1] - coordinates[0][1]) / (coordinates[i][0] - coordinates[0][0]) != key:
                return False
        return True