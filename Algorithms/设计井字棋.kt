
/**
 * @author shiwenhao <shiwenhao@kuaishou.com>
 * Created on 2021/9/3
 */
class TicTacToe(val size: Int) {

    /** Initialize your data structure here. */
    private val player1 : MutableSet<Pair<Int, Int>> = mutableSetOf()
    private val player2 : MutableSet<Pair<Int, Int>> = mutableSetOf()

    /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
    0: No one wins.
    1: Player 1 wins.
    2: Player 2 wins. */
    fun move(row: Int, col: Int, player: Int): Int {
        if (player == 1) {
            player1.add(Pair(row, col))
            if (checkWin(row, col, player)) {
                return 1
            }
        }
        if (player == 2) {
            player2.add(Pair(row, col))
            if (checkWin(row, col, player)) {
                return 2
            }
        }
        return 0
    }

    private fun checkWin(row: Int, col: Int, player: Int): Boolean {
        val p = if (player == 1) player1 else player2
        var index = 0
        while (p.contains(Pair(index, col))) {
            index += 1
        }
        if (index == size) {
            return true
        }

        index = 0
        while (p.contains(Pair(row, index))) {
            index += 1
        }
        if (index == size) {
            return true
        }

        if (row == col || (col + row == size - 1)) {
            index = 0
            while (p.contains(Pair(index, index))) {
                index += 1
            }
            if (index == size) {
                return true
            }

            index = 0
            while (p.contains(Pair(size - index - 1, index))) {
                index += 1
            }
            if (index == size) {
                return true
            }
        }
        return false
    }
}
/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */
