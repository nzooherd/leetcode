func maximumSwap(num int) int {
	var bitnums []int
	var maxnums []int
	var ret int
	for num > 0 {
		bitnums = append(bitnums, num%10)
		num /= 10
	}

	for i := 0; i < len(bitnums); i++ {
		if i == 0 {
			maxnums = append(maxnums, 0)
		} else {
			if bitnums[i] > bitnums[maxnums[len(maxnums)-1]] {
				maxnums = append(maxnums, i)
			} else {
				maxnums = append(maxnums, maxnums[len(maxnums)-1])
			}
		}
	}

	for i := len(bitnums) - 1; i >= 0; i-- {
		if maxnums[i] != i && bitnums[i] < bitnums[maxnums[i]] {
			var temp = bitnums[maxnums[i]]
			bitnums[maxnums[i]] = bitnums[i]
			bitnums[i] = temp
			break
		}
	}

	for i := len(bitnums) - 1; i >= 0; i-- {
		ret += bitnums[i]
		ret *= 10
	}
	return ret/10
}    
