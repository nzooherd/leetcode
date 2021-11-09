class Solution {
    fun employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
        val intervals = schedule.flatten()
        val sortIntervals = intervals.sortedWith(object: Comparator<Interval> {
			override fun compare(o1: Interval, o2: Interval): Int =
			    o1.start.compareTo(o2.start).let {
			    	when {
			    		it != 0 -> it
						else -> o1.end.compareTo(o2.end)
			    	}
				}
		})

        val result = mutableListOf<Interval>()
		if (intervals.isEmpty()) {
			return ArrayList(result)
		}
		var end = sortIntervals[0].end
		for (interval in sortIntervals) {
			if (interval.start > end) {
				result.add(Interval(end, interval.start))
			}
			end = end.coerceAtLeast(interval.end)
		}
		return ArrayList(result)

    }
}