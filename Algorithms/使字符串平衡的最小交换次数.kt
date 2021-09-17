class Solution {
    fun minSwaps(s: String): Int {
        var left = -1; var right = s.length
        var leftAccumulator = 0
        var rightAccumulator = 0
        var result = 0
        while (left < right) {
            while(leftAccumulator >= 0 && left < right && left < s.length - 1) {
                left += 1
                if (s[left] == '[') {
                    leftAccumulator += 1
                } else {
                    leftAccumulator -= 1
                }
            }
            while(rightAccumulator >= 0 && left < right && right > 0) {
                right -= 1
                if (s[right] == ']') {
                    rightAccumulator += 1
                } else {
                    rightAccumulator -= 1
                }
            }
            if (left >= right) {
                break
            }
            leftAccumulator = 1
            rightAccumulator = 1
            result += 1
        }
        return result
    }
}