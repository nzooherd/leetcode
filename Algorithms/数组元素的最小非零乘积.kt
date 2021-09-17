import java.math.BigInteger

class Solution {
    fun minNonZeroProduct(p: Int): Int {
        var initValue = BigInteger.valueOf(1L)
        repeat(p) {
            initValue = initValue.multiply(BigInteger.valueOf(2L))
        }
        initValue = initValue.subtract(BigInteger.valueOf(2L))

        return initValue.modPow(initValue.divide(BigInteger.valueOf(2)), BigInteger.valueOf(1000000007))
            .multiply(initValue.add(BigInteger.valueOf(1L)))
            .mod(BigInteger.valueOf(1000000007))
            .toInt()
    }
}