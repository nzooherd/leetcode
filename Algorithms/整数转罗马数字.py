#
# @lc app=leetcode.cn id=12 lang=python
#
# [12] 整数转罗马数字
#
class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        rome_num_map = {1: "I", 4:"IV", 5: "V",  9:"IX", 10:"X", 40: "XL", \
                                50: "L", 90:"XC", 100:"C", 400:"CD", 500:"D", 900:"CM", 1000:"M"}
        can_show_list = rome_num_map.keys()
        can_show_list = sorted(can_show_list, reverse=True)
        result = ""
        index = 0
        while num > 0:
            value = can_show_list[index]
            multipy = num / value
            num -= multipy * value
            index += 1
            result += rome_num_map.get(value) * multipy

        return result

