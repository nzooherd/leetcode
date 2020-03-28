func findMaxAverage(nums []int, k int) float64 {
	var ret float64
	var sum int
	if len(nums) < k {
		return ret
	}
	for i := 0; i < k; i++ {
		sum += nums[i]
	}
	ret = float64(sum) / float64(k)
	for i := k; i < len(nums); i++ {
		sum -= nums[i-k]
		sum += nums[i]
		if float64(sum)/float64(k) > ret {
			ret = float64(sum) / float64(k)
		}
	}
	return ret
}