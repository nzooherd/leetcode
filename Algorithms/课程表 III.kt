class Solution {
    fun scheduleCourse(courses: Array<IntArray>): Int {
        courses.sortWith( Comparator { o1, o2 ->  o1[1].compareTo(o2[1]).let {
            when (it) {
                0 -> o1[0].compareTo(o2[0])
                else -> it
            }
        } } )


        val nums: PriorityQueue<Int> = PriorityQueue {v1: Int, v2: Int -> v2.compareTo(v1) }
        var curTime = 0
        for (item in courses) {
            if (curTime + item[0] <= item[1]) {
                curTime += item[0]
                nums.add(item[0])
            } else {
                if (!nums.isEmpty() && item[0] < nums.peek()) {
                    curTime -= nums.peek()
                    curTime += item[0]
                    nums.remove()
                    nums.add(item[0])
                }
            }
        }

        return nums.size
    }
}
