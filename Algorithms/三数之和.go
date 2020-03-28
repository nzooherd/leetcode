func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	var ret [][]int
	ret = make([][]int, 0)
	if len(nums) < 3 {
		return ret
	}

	for i := 0; i < len(nums)-2; {
		j := i + 1
		k := len(nums) - 1
		for j < len(nums) && k > j {
			if nums[i]+nums[j]+nums[k] < 0 {
				j++
			} else if nums[i]+nums[j]+nums[k] > 0 {
				k--
			} else {
				oneRet := []int{nums[i], nums[j], nums[k]}
				ret = append(ret, oneRet)
				j++
				for j < len(nums) && nums[j] == nums[j-1] {
					j++
				}
				k--
				for k > i && nums[k] == nums[k+1] {
					k--
				}
			}
		}
		i++
		for i < len(nums)-2 && nums[i] == nums[i-1] {
			i++
		}
	}
	return ret
}