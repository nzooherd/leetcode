func sortArrayByParity(A []int) []int {
	var l, r = 0, len(A) - 1
	var flag = A[0]
	for l < r {
		for l < r && A[r]%2 == 1 {
			r--
		}
		A[l] = A[r]
		for l < r && A[l]%2 == 0 {
			l++
		}
		A[r] = A[l]
	}
	A[l] = flag
	return A  
}