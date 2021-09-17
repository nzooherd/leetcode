class Solution:
    def getMinSwaps(self, num: str, k: int) -> int:
        next_k_num = self.find_max_k_num([c for c in str(num)], k)
        
        def diff_between_str_num(str_num1, str_num2):
            if str_num1 == str_num2:
                return 0

            start_diff_index = -1
            for i in range(0, len(str_num1)):
                if str_num1[i] != str_num2[i]:
                    start_diff_index = i
                    break
            
            for i in range(start_diff_index, len(str_num1)):
                if str_num1[i] == str_num2[start_diff_index]:
                    return i - start_diff_index + diff_between_str_num(str_num1[start_diff_index:i] + str_num1[i+1:], str_num2[start_diff_index + 1:])

        return diff_between_str_num([c for c in str(num)], next_k_num)
    
    def find_max_k_num(self, str_num, k):
        def find_next_max(str_num):
            start_index = 0
            for i in range(len(str_num)-1, -1, -1):
                if str_num[i] > str_num[i-1]:
                    start_index = i - 1
                    break
        
            swap_index = 0
            for j in range(len(str_num) - 1, i-1, -1):
                if str_num[j] > str_num[start_index]:
                    swap_index = j
                    break
        
            temp_num = str_num[swap_index]
            str_num[swap_index] = str_num[start_index] 
            str_num[start_index] = temp_num

            for i in range(start_index + 1, len(str_num)):
                end_index = len(str_num) - 1 - (i - start_index - 1)
                if end_index <= i:
                    break
                temp = str_num[end_index]
                str_num[end_index] = str_num[i]
                str_num[i] = temp
        
        while k > 0:
            find_next_max(str_num)
            k -= 1
        return str_num
