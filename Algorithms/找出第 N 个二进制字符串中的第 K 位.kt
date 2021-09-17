import kotlin.math.pow

class Solution {
    fun findKthBit(n: Int, k: Int): Char {
        when(n){
            1 -> {
                return '0'
            }
            2 -> {
                return if(k != 1) '1' else '0'
            }
            else -> {
                val index = k - 1
                val sumLength = ((2.0).pow(n).toInt()) - 1
                val nextLength = (2.0).pow(n-1).toInt() - 1
                if(index == (sumLength / 2)){
                    return '1'
                }else if(index < (sumLength / 2)){
                    return findKthBit(n-1, k)
                }else{
                    val recursionK = nextLength - (index - (sumLength / 2)) + 1
                    return if(findKthBit(n - 1,  recursionK) == '1') '0' else '1'
                }
            }
        }
    }
}