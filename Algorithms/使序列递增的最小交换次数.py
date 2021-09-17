class Solution:
    def minSwap(self, A: List[int], B: List[int]) -> int:
        if not A:
            return 0

        dp = []
        for i in range(0, len(A)):
            if i == 0:
                dp.append((0, 1))
                continue
            not_swap, swap = float('inf'), float('inf')
            pre_not_swap, pre_swap = dp[-1]

            if pre_not_swap != -1:
                if A[i] > A[i-1] and B[i] > B[i-1]:
                    not_swap = min(not_swap,  pre_not_swap)
                if A[i] > B[i-1] and B[i] > A[i-1]:
                    swap = min(swap, pre_not_swap + 1)
            if pre_swap != -1:
                if A[i] > B[i-1] and B[i] > A[i-1]:
                    not_swap = min(not_swap, pre_swap)
                if A[i] > A[i-1] and B[i] > B[i-1]:
                    swap = min(swap, pre_swap + 1)
            
            not_swap = -1 if not_swap == float('inf') else not_swap
            swap = -1 if not_swap == float('inf') else swap
            dp.append((not_swap, swap))

        return min(dp[-1])
                    

            
                

