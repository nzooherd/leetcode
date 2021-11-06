import java.util.*

class Solution {
    fun isValid(code: String): Boolean {
        val stack = Stack<String>()

        val tagStartIndexes = mutableListOf<Int>()
        for (i in code.indices) {
            if (code[i] == '<') {
                tagStartIndexes.add(i)
            }
        }

        var index = 0
        while (index != code.length) {
            if (index !in tagStartIndexes) {
                if (stack.isEmpty()) {
                    return false
                }
                index += 1
                continue
            }
            if (index == code.length - 1) {
                return false
            }
            if (code[index+1] == '/') {
                val closeIndex = findTag(code, index)
                val tagStr = code.substring(index, closeIndex + 1)
                if (!isValidTagName(tagStr)) {
                    return false
                }
                if (stack.isEmpty()) {
                    return false
                }
                val openTag = stack.pop()
                if (!matchTag(openTag, tagStr)) {
                    return false
                }
                index = closeIndex + 1
            } else if (code[index+1] == '!') {
                if (stack.isEmpty()) {
                    return false
                }
                if (index + 8 >= code.length || code.substring(index + 2, index + 9) != "[CDATA[") {
                    return false
                }
                var closeIndex = index + 9
                while (closeIndex < code.length) {
                    if (code.substring(closeIndex - 2, closeIndex + 1) == "]]>") {
                        break
                    }
                    closeIndex += 1
                }
                if (closeIndex == code.length) {
                    return false
                }
                index = closeIndex + 1
            } else {
                val closeIndex = findTag(code, index)
                val tagStr = code.substring(index, closeIndex + 1)
                if (!isValidTagName(tagStr)) {
                    return false
                }
                if (stack.isEmpty() && index != 0) {
                    return false
                }
                stack.push(tagStr)
                index = closeIndex + 1
            }

        }
        return stack.isEmpty()
    }


    fun findTag(code: String, start: Int): Int {
        var closeIndex = start + 1
        while (closeIndex != code.length) {
            if (code[closeIndex] == '>') {
                break
            }
            closeIndex += 1
        }
        if (closeIndex == code.length) {
            return -1
        }
        return closeIndex
    }

    fun matchTag(openTag: String, closeTag: String): Boolean {
        return openTag.substring(1, openTag.length - 1) == closeTag.substring(2, closeTag.length - 1)
    }


    fun isValidTagName(tagName: String): Boolean {
        if (tagName.length < 2) {
            return false
        }
        if (tagName[0] != '<' || tagName.last() != '>') {
            return false
        }
        val end = tagName.length - 2
        val start =
        if (tagName[1] != '/') {
            1
        } else {
            2
        }
        if (end < start) {
            return false
        }
        if (end - start > 8) {
            return false
        }
        for (i in start..end) {
            if (tagName[i] !in 'A'..'Z') {
                return false
            }
        }
        return true
    }

}
