func maxIncreaseKeepingSkyline(grid [][]int) int {
	var ret int;
	var rowMax, colMax []int
	rowMax = make([]int, len(grid))
	colMax = make([]int, len(grid[0]))	
	for i := 0; i < len(grid); i++ {
		tempMax := 0
		for j := 0; j < len(grid[0]); j++ {
			if(grid[i][j] > tempMax) {
				tempMax = grid[i][j]
			}
		}
		rowMax[i] = tempMax
	}
	for i := 0; i < len(grid[0]); i++ {
		tempMax := 0
		for j := 0; j < len(grid); j++ {
			if(grid[j][i] > tempMax) {
				tempMax = grid[j][i]
			}
		}
		colMax[i] = tempMax
	}
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if(rowMax[i] < colMax[j]) {
				ret += rowMax[i]
			} else {
				ret += colMax[j]
			}
            ret -= grid[i][j]
		}
	}
	return ret
    
}