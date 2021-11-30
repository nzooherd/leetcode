class Solution {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val mutableStation = stations.toMutableList()
        mutableStation.add(intArrayOf(target, 0))
        val priorityQueue = PriorityQueue { o1: Int, o2: Int -> o2.compareTo(o1) }
        var result = 0

        var curFuel = startFuel
        var curPosition = 0


        for (station in mutableStation) {
            if (station[0] - curPosition <= curFuel)  {
                priorityQueue.add(station[1])

                curFuel -= (station[0] - curPosition)
                curPosition = station[0]
            } else {
                while (priorityQueue.isNotEmpty()) {
                    curFuel += priorityQueue.poll()
                    result += 1
                    if (curFuel >= (station[0] - curPosition)) {
                        curFuel -= (station[0] - curPosition)
                        curPosition = station[0]
                        break
                    }
                }
                if (priorityQueue.isEmpty() && curPosition != station[0]) {
                    return -1
                } else {
                    priorityQueue.add(station[1])
                }
            }

        }

        return result
    }

}