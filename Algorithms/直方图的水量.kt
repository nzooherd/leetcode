class Solution {
	fun trap(height: IntArray): Int {
		val leftHighest = mutableListOf<Int>()
		val rightHighest = mutableListOf<Int>()

		var highest = 0
		for (i in height.indices) {
		    highest = highest.coerceAtLeast(height[i])
			leftHighest.add(highest)
		}
		highest = 0
		for (i in height.size - 1 downTo 0) {
			highest = highest.coerceAtLeast(height[i])
			rightHighest.add(highest)
		}
        rightHighest.reverse()

		var result = 0
		for (i in height.indices) {
			result += leftHighest[i].coerceAtMost(rightHighest[i]) - height[i]
		}
		return result
	}
}


