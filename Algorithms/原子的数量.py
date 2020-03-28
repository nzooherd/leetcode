class Solution(object):
    def countOfAtoms(self, formula):
        """
        :type formula: str
        :rtype: str
        """
        
        dic, coeff, stack, elem, cnt, i = collections.defaultdict(int), 1, [], '', 0, 0
        for c in formula[::-1]:
            if c.isdigit():
                cnt += int(c) * (10 ** i)  # 获取当前数子
                i += 1  # 当前数字的位数
            elif c == ')':  # 当前数字入栈，并更新当前原子的系数
                stack.append(cnt)
                coeff *= cnt
                i = cnt = 0
            elif c == '(':  # 出栈，并更新当前系数（相除哦）
                coeff //= stack.pop()
                i = cnt = 0
            elif c.isupper():  # 原子写入字典，
                elem = c + elem
                dic[elem] += (cnt or 1) * coeff  # 当前数字 * 当前的系数 + 之前已经存在的个数。
                elem = ''
                i = cnt = 0
            elif c.islower():  # 拼接，保留到 elem 中
                elem = c + elem

        return ''.join(k + str(v > 1 and v or '') for k, v in sorted(dic.items()))
