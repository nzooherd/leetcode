class Solution {
    fun pancakeSort(A: IntArray): List<Int> {
        if(A.isEmpty()) {
            return mutableListOf()
        }
        val res = mutableListOf<Int>()
        var max = 0; var index = 0;
        A.forEachIndexed(){i, num ->
            if(num > max) {
                max = num
                index = i
            }}
        if(index != A.size - 1) {
            if(index != 0) {
                res.add(index + 1)
            }
            res.add(A.size)
        }
        val nextA = IntArray(A.size - 1); var nextAIndex = 0
        for(i in A.size-1 downTo  index + 1) {
            nextA[nextAIndex++] = A[i]
        }
        for( i in 0 until index) {
           nextA[nextAIndex++] = A[i]
        }
        res.addAll(pancakeSort(nextA))
        return res
    }
}