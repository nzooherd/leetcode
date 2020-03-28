#
# @lc app=leetcode.cn id=321 lang=python
#
# [321] 拼接最大数
#
# https://leetcode-cn.com/problems/create-maximum-number/description/
#
# algorithms
# Hard (23.45%)
# Total Accepted:    370
# Total Submissions: 1.6K
# Testcase Example:  '[3,4,6,5]\n[9,1,2,5,8,3]\n5'
#
# 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n)
# 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
# 
# 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
# 
# 说明: 请尽可能地优化你算法的时间和空间复杂度。
# 
# 示例 1:
# 
# 输入:
# nums1 = [3, 4, 6, 5]
# nums2 = [9, 1, 2, 5, 8, 3]
# k = 5
# 输出:
# [9, 8, 6, 5, 3]
# 
# 示例 2:
# 
# 输入:
# nums1 = [6, 7]
# nums2 = [6, 0, 4]
# k = 5
# 输出:
# [6, 7, 6, 0, 4]
# 
# 示例 3:
# 
# 输入:
# nums1 = [3, 9]
# nums2 = [8, 9]
# k = 3
# 输出:
# [9, 8, 9]
# 
#
class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        if k > len(nums1) + len(nums2):
            return []
        
        max_list = []
        for i in range(max(k - len(nums2) , 0), min(len(nums1) + 1, k + 1)):
            j = k - i
            num_list1 = self.max_list(nums1, 0, i)
            num_list2 = self.max_list(nums2, 0, j) 
            num_list = self.package_list(num_list1, num_list2)
            max_list= self.compare(max_list, num_list)

        return max_list

    def package_list(self, num_list1, num_list2):
        num_list = []
        i = 0
        j = 0
        while i < len(num_list1) and j < len(num_list2):
            if num_list1[i] > num_list2[j]:
                num_list.append(num_list1[i])
                i += 1
            elif num_list1[i] < num_list2[j]:
                num_list.append(num_list2[j])
                j += 1
            else:
                temp_i = i + 1
                temp_j = j + 1
                while temp_i < len(num_list1) and temp_j < len(num_list2) and num_list1[temp_i] == num_list2[temp_j]:
                    temp_i += 1
                    temp_j += 1
                if temp_i == len(num_list1):
                    num_list.append(num_list2[j])
                    j += 1
                elif temp_j == len(num_list2):
                    num_list.append(num_list1[i])
                    i += 1
                elif num_list1[temp_i] > num_list2[temp_j]:
                    num_list.append(num_list1[i])
                    i += 1
                else:
                    num_list.append(num_list2[j])
                    j += 1

                

        
        if i >= len(num_list1):
            num_list += num_list2[j:]
        else:
            num_list += num_list1[i:]
        
        return num_list

    def max_list(self, num_list, start, n):
        length = len(num_list)
        if start + n > length or n <= 0:
            return []
        
        max_num = 0
        for i in range(start, length - n + 1):
            if num_list[i] > max_num:
                max_num = num_list[i]
                start = i
        
        return [max_num] + self.max_list(num_list, start + 1, n - 1)

    def compare(self, num_list1, num_list2):
        if not num_list1:
            return num_list2
        
        for i in range(min(len(num_list1), len(num_list2))):
            if num_list1[i] == num_list2[i]:
                continue
            return num_list1 if num_list1[i] > num_list2[i] else num_list2
        return num_list1
     
