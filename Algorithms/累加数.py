class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        for i in range(2, len(num)):
            for j in range(1, i):
                str1 = num[0:j]
                str2 = num[j:i]
                if str1.startswith("0") and str1 != "0":
                    continue
                if str2.startswith("0") and str2 != "0":
                    continue
                if self.check_is_vaild(num, str1, str2, 0):
                    return True
        return False


    def check_is_vaild(self, num, str1, str2, start_index):
        add_result = self.str_add(str1, str2)
        if start_index + len(str1) + len(str2) + len(add_result) > len(num):
            return False
        for i in range(0, len(add_result)):
            if num[start_index + len(str1) + len(str2) + i] != add_result[i]:
                break
        else:
            if start_index + len(str1) + len(str2) + len(add_result) == len(num):
                return True
            return self.check_is_vaild(num, str2, add_result, start_index + len(str1))
        return False


    def str_add(self, str1, str2):
        result = ""
        str1 = str1[::-1]
        str2 = str2[::-1]
        i, j, flag = 0, 0, 0
        while(i < len(str1) or j < len(str2)):
            bit1 = int(str1[i]) if i < len(str1) else 0
            bit2 = int(str2[j]) if j < len(str2) else 0
            bit = bit1 + bit2 + flag
            flag = bit // 10
            bit = bit % 10
            result += str(bit)

            i += 1
            j += 1

        if flag:
            result += "1"

        return result[::-1]