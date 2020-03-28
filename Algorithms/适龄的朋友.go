func numFriendRequests(ages []int) int {
	var ret = 0
	sort.Ints(ages)

	for i := 0; i < len(ages); i++ {
		k := 0
		k = ages[i]/2 + 8
		if k > ages[i] {
			continue
		}
		if index := searchFirstLess(ages, k); index != -1 {
			ret += (i - index)
		}
		for j := i + 1; j < len(ages) && ages[j] == ages[i]; j++ {
			ret++
		}
	}
	return ret
}

func searchFirstLess(ages []int, k int) int {
	var left, right int = 0, len(ages) - 1
	for left <= right {
		medium := (left + right) / 2
		if ages[medium] == k {
			for medium >= 0 && ages[medium] == k {
				medium--
			}
			return medium + 1
		} else if ages[medium] < k {
			if medium == len(ages)-1 {
				return -1
			}
			if ages[medium+1] >= k {
				return medium + 1
			} else {
				left = medium + 1
			}
		} else if ages[medium] > k {
			if medium == 0 {
				return 0
			}
			if ages[medium-1] < k {
				return medium
			} else if ages[medium-1] == k {
				medium--
				for medium >= 0 && ages[medium] == k {
					medium--
				}
				return medium + 1
			} else {
				right = medium - 1
			}
		}
	}
	return -1
}
