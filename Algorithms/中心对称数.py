class Solution:
    def isStrobogrammatic(self, num: str) -> bool:
        can_reverse_str = {'6': '9', '9': '6', '8': '8', '0': '0', '1': '1'}
        reversed_num = ''
        for c in num:
            if c in can_reverse_str:
                reversed_num += can_reverse_str[c]
            else:
                return False
        return reversed_num == num[::-1]