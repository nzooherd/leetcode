import java.util.*
import kotlin.math.abs

class Solution {
    fun makeGood(s: String): String {
        val stack = LinkedList<Char>()
        for((index, char) in s.withIndex()){
            if(stack.isEmpty() ){
                stack.addLast(char)
                continue
            }
            if(abs(char - stack.peekLast()) == ('z' - 'Z')){
                stack.pollLast()
            }else{
                stack.addLast(char)
            }
        }
        var res = ""
        for(char in stack){
            res += char
        }
        return res
    }
}