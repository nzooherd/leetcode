class Solution(object):
    def sumEvenAfterQueries(self, A, queries):
        """
        :type A: List[int]
        :type queries: List[List[int]]
        :rtype: List[int]
        """
        even_sum = 0
        for num in A:
            if num % 2 == 0:
                even_sum += num

        ret = []
        for val, index in queries:
            if A[index] % 2 == 0:
                even_sum += val if val % 2 == 0 else (-A[index])
            else:
                even_sum += (val + A[index]) if val % 2 == 1 else 0
            A[index] += val
            ret.append(even_sum)
        return ret
