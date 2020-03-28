func getRow(rowIndex int) []int {
	var ret []int
	ret = make([]int, rowIndex+1)
	ret[0] = 1
	for i := 2; i <= rowIndex; i++ {
		ret[0] = 1
		pre := ret[0]
		for j := 1; j <= (i+1)/2-1; j++ {
			temp := ret[j]
			ret[j] += pre
			pre = temp
		}
		if i%2 == 0 {
			ret[i/2] = pre * 2
		}
	}
	start := rowIndex/2 + 1
	for i := start; i <= rowIndex; i++ {
		ret[i] = ret[rowIndex-i]
	}
	return ret  
}