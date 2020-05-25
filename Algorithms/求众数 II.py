class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        a, b = False, False
        a_count, b_count = 0, 0
        for num in nums:
            if a is not False and num == a:
                a_count += 1
                continue
            if b is not False and num == b:
                b_count += 1
                continue
            
            if a_count == 0:
                a = num
                a_count += 1
            elif not num is a and b_count == 0:
                b = num
                b_count += 1
            else:
                    a_count -= 1
                    b_count -= 1
                
        print(a, b)
        a_count, b_count = 0, 0
        for num in nums:
            if num == a:
                a_count += 1
        for num in nums:
            if num == b:
                b_count += 1

        print(a_count, b_count)
        result = []
        if a_count > (len(nums) // 3):
            result.append(a)
        if b_count > (len(nums) // 3) and b != a:
            result.append(b)
        return result
