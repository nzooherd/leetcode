func maxDistToClosest(seats []int) int {
	var ret, pre int = 0, -1
	if len(seats) == 0 {
		return ret
	}
	for i, v := range seats {
		if v == 1 {
            if ( (pre == -1 && (i-pre-1) > ret) || (pre != -1 && (i - pre)/ 2 > ret) ){
                if(pre == -1) {
                    ret = i - pre - 1
                } else {
                    ret = (i - pre)/2
                }
			}
			pre = i
		}
	}
	if len(seats)-pre-1> ret {
		ret = len(seats) - pre - 1
	}
	return ret
}