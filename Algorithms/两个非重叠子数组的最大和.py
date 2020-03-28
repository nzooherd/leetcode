class Solution(object):
    def maxSumTwoNoOverlap(self, A, L, M):
        """
        :type A: List[int]
        :type L: int
        :type M: int
        :rtype: int
        """
       	if not A or len(A) < (L + M) or (L < 0 and M < 0):
       		return 0 
       	if len(A) == (L + M):
       		return sum(A)

       	return max(self.process(A, L, M), self.process(A, M, L))

    def process(self, A, L, M):
       	l_sum = [0] * (L - 1)
       	l_maxs = [0] * len(A)
       	m_sum = [0] * (M - 1)
       	r_maxs = [0] * len(A)

       	pre_l_sum = sum(A[i] for i in range(0, L - 1))
       	pre_m_sum = sum(A[i] for i in range(0, M - 1))
       	for i in range(L-1, len(A)):
       		pre_l_sum += A[i]
       		if i >= L:
       			pre_l_sum -= A[i - L]
       		l_sum.append(pre_l_sum)
       	for i in range(M - 1, len(A)):
       		pre_m_sum += A[i]
       		if i >= M:
       			pre_m_sum -= A[i - M]
       		m_sum.append(pre_m_sum)


       	l_max = 0
       	for i in range(L-1, len(A) - M):
       		if l_sum[i] > l_max:
       			l_max = l_sum[i]
       		l_maxs[i] = l_max

       	r_max = 0
       	for i in range(len(A) - M - 1, L - 2, -1):
       		if m_sum[i + M] > r_max:
       			r_max = m_sum[i + M]
       		r_maxs[i] = r_max

       	result = 0
       	for i in range(0, len(A)):
       		if l_maxs[i] + r_maxs[i] > result:
       			result = l_maxs[i] + r_maxs[i]

       	return result