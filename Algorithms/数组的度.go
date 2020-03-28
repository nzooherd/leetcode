func findShortestSubArray(nums []int) int {
    var startMap, numMap map[int]int
    startMap, numMap = make(map[int]int), make(map[int]int)
    var maxCount, ret int = 0, 0x80000000
    for i, num := range nums{
        _, exists := startMap[num]
        if(!exists) {
            startMap[num] = i
        }
        numMap[num]++;
        if(numMap[num] >= maxCount){
            if(numMap[num] > maxCount) {
                ret = i - startMap[num] + 1
            } else{
                if(ret > i - startMap[num] + 1){
                    ret = i - startMap[num] + 1
                }
            }
            maxCount = numMap[num]
        }

    }
    return ret
    
}