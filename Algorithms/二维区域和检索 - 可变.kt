class BIT(val length: Int) {

    val values = IntArray(length) {0}

    fun subtract(index: Int) : Int = index and (-index)

    fun update(index: Int, value: Int) {
        var mutIndex = index
        while(mutIndex < length) {
            values[mutIndex] += value
            mutIndex += subtract(mutIndex)
        }
    }

    fun getSum(index: Int) : Int {
        var sum = 0
        var mutIndex = index
        while (mutIndex > 0) {
            sum += values[mutIndex]
            mutIndex -= subtract(mutIndex)
        }
        return sum
    }
}

class NumMatrix(val matrix: Array<IntArray>) {

    private val bits = Array<BIT>(matrix.size) {BIT(matrix[0].size + 1)}

    init {
        for (i in matrix.indices) {
            val bit = bits[i]
            for (j in matrix[0].indices) {
                bit.update(j + 1, matrix[i][j])
            }
        }
    }

    fun update(row: Int, col: Int, `val`: Int) {
        bits[row].update(col + 1, `val` - matrix[row][col])
        matrix[row][col] = `val`
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var sum = 0
        for (i in row1..row2) {
            sum += bits[i].getSum(col2+1) - bits[i].getSum(col1)
        }
        return sum
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * obj.update(row,col,`val`)
 * var param_2 = obj.sumRegion(row1,col1,row2,col2)
 */