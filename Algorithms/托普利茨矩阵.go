func isToeplitzMatrix(matrix [][]int) bool {
	var row = len(matrix)
	var colum = len(matrix[0])
	if row == 1 || colum == 1 {
		return true
	}

	var i, j = row - 1, 0

	for i >= 0 && j < colum {
		var x, y = i, j
		for x < row-1 && y < colum-1 {
			if matrix[x][y] != matrix[x+1][y+1] {
				return false
			}
			x++
			y++
		}
		if j == 0 && i > 0 {
			i--
		} else if i == 0 && j < colum {
			j++
		}
	}
	return true
}