func isMonotonic(A []int) bool {
	if len(A) == 0 || len(A) == 1 {
		return true
	}
	var flag = 0
	for i := 1; i < len(A); i++ {
		if A[i] == A[i-1] {
			continue
		}
		if A[i] > A[i-1] {
			if flag == -1 {
				return false
			}
			if flag == 0 {
				flag = 1
			}
		}

		if A[i] < A[i-1] {
			if flag == 1 {
				return false
			}
			if flag == 0 {
				flag = -1
			}
		}

	}
	return true
}