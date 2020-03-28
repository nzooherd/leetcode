class Solution(object):
    def strWithout3a3b(self, A, B):
        """
        :type A: int
        :type B: int
        :rtype: str
        """
        ret = ""
        flag = False
        if A < B:
            A, B = B, A
            flag = True
        if A >= B:
            if A >= 2 * B:
                ret += "aab" * B + "a" * (A - 2 * B)
            else:
                ret += "aab" * (A - B) + "ab" * (2 * B - A)
        if not flag:
            return ret
        ret_1 = ''
        for s in ret:
            if s == 'a':
                ret_1 += 'b'
            else:
                ret_1 += 'a'
        return ret_1