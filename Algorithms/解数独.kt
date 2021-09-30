import java.awt.Point

class Solution {
    val rowsPoint = Array<MutableSet<Pair<Int, Int>>>(9) { mutableSetOf() }
    val columnsPoint = Array<MutableSet<Pair<Int, Int>>>(9) { mutableSetOf() }
    val blocksPoint = Array<MutableSet<Pair<Int, Int>>>(9) { mutableSetOf() }

    val pointOptionalMap = mutableMapOf<Pair<Int, Int>, MutableSet<Char>>()

    fun init(board: Array<CharArray>) {
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == '.') {
                    pointOptionalMap[Pair(i, j)] = mutableSetOf('1', '2', '3', '4', '5', '6', '7', '8', '9')
                    rowsPoint[i].add(Pair(i, j))
                    columnsPoint[j].add(Pair(i, j))
                    blocksPoint[i / 3 * 3 + j / 3].add(Pair(i, j))
                }
            }
        }
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == '.') {
                    continue
                }
                for (points in relatedPoints(i, j)) {
                    points.forEach { point -> pointOptionalMap[point]!!.remove(board[i][j])}
                }
            }
        }

    }

    fun solveSudoku(board: Array<CharArray>): Unit {
        init(board)
        solveSudoKuDo(board)
        return
    }

    fun solveSudoKuDo(board: Array<CharArray>): Boolean {
        if (pointOptionalMap.isEmpty()) {
            return true
        }
        val modifyPoint = firstPoint()
        val i = modifyPoint.first; val j = modifyPoint.second;

        // remove point
        rowsPoint[i].remove(modifyPoint)
        columnsPoint[j].remove(modifyPoint)
        blocksPoint[i / 3 * 3 + j / 3].remove(modifyPoint)
        val values = pointOptionalMap[modifyPoint]!!
        pointOptionalMap.remove(modifyPoint)

        for (value in values) {
            board[i][j] = value
            // modify
            val mutablePoints = mutableSetOf<Pair<Int, Int>>()
                for (points in relatedPoints(i, j)) {
                    points.forEach {
                        if (pointOptionalMap[it]!!.contains(value)) {
                            mutablePoints.add(it)
                            pointOptionalMap[it]!!.remove(value)
                        }
                    }
                }
            
            if (solveSudoKuDo(board)) {
                return true
            }

            // reset
            for (point in mutablePoints) {
                pointOptionalMap[point]!!.add(value)
            }
        }

        // add point
        rowsPoint[i].add(modifyPoint)
        columnsPoint[j].add(modifyPoint)
        blocksPoint[i / 3 * 3 + j / 3].add(modifyPoint)
        pointOptionalMap[modifyPoint] = values
        return false
    }

    private fun firstPoint(): Pair<Int, Int> {
        for (i in 0 until 9) {
            if (rowsPoint[i].isNotEmpty()) {
                return rowsPoint[i].first()
            }
        }
        return Pair(-1, -1)
    }
    
    private fun relatedPoints(row: Int, column: Int): Array<MutableSet<Pair<Int, Int>>>{
        return arrayOf(rowsPoint[row], columnsPoint[column], blocksPoint[row / 3 * 3 + column / 3])
    }
}