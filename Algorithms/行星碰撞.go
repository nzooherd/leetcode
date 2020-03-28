func asteroidCollision(asteroids []int) []int {
    var stack [1000]int
	var index int = 0

	for i := 0; i < len(asteroids); i++ {
		if index != 0 {
			if asteroids[i] <= 0 {
				var flag = 0
				for index > 0 && stack[index-1] > 0 {
					if asteroids[i]+stack[index-1] > 0 {
						flag = 1
						break
					} else if asteroids[i]+stack[index-1] == 0 {
                        index--
						flag = 1
						break
					}
					index--
				}
				if flag == 1 {
					continue
				}
				if index == -1 {
					index++
				}
                fmt.Println(index)
				stack[index] = asteroids[i]
				index++
			} else {
				stack[index] = asteroids[i]
				index++
			}
		} else {
			stack[index] = asteroids[i]
			index++
		}
	}

	return stack[0:index]
}