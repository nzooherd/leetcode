func transpose(A [][]int) [][]int {
	var ret [][]int
	for i := 0; i < len(A[0]); i++ {
        row := make([]int, len(A))
		for j := 0; j < len(A); j++ {
			row[j] = A[j][i]
		}
		ret = append(ret, row)
	}
	return ret
}