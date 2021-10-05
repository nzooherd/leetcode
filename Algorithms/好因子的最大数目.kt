import java.math.BigInteger
import kotlin.math.pow

class Solution {
    fun maxNiceDivisors(primeFactors: Int): Int {
        if (primeFactors == 1) {
            return 1
        }
        var treeNum = 0; var twoNum = 0;
        if (primeFactors % 3 == 0) {
            treeNum = primeFactors / 3
        } else if (primeFactors % 3 == 2) {
            treeNum = primeFactors / 3
            twoNum = 1
        } else {
            treeNum = primeFactors / 3 - 1
            twoNum = 2
        }
        return ((BigInteger.valueOf(3).modPow(
            BigInteger.valueOf(treeNum.toLong()), BigInteger.valueOf(1000000007L)))
            .toLong() * (if (twoNum == 0) 1 else (2 * twoNum)) % 1000000007).toInt()

    }
}