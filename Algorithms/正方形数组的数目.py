class Solution(object):
    def numSquarefulPerms(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        leave_num = {}
        sum_is_square = {}

        for num in A:
            if num not in leave_num:
                leave_num[num] = 1
            else:
                leave_num[num] += 1
        for i in range(len(A)):
            for j in range(len(A)):
                if i == j:
                    continue
                if pow(A[i] + A[j], 0.5) == int(pow(A[i] + A[j], 0.5)):
                    if A[i] not in sum_is_square:
                        sum_is_square[A[i]] = {A[j]}
                    else:
                        sum_is_square[A[i]].add(A[j])
        init_set = set(A) 
        return self.rec_caculate(leave_num, sum_is_square, init_set, 0, len(A))
    
    def rec_caculate(self, leave_num, sum_is_square, init_set, degree, target):
        ret = 0
        for num in init_set:
            if not leave_num[num]:
                continue
            leave_num[num] -= 1
            next_init_set = sum_is_square.get(num)
            if not next_init_set:
                continue
            degree += 1
            if degree == target:
                ret += 1
            else:
                ret += self.rec_caculate(leave_num, sum_is_square, next_init_set, degree, target)
            leave_num[num] += 1
            degree -= 1
        return ret
    