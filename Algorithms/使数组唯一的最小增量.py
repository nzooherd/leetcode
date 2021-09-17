class Solution:
    def minIncrementForUnique(self, A: List[int]) -> int:
        if not A:
            return 0
        A.sort()

        res = 0
        next_optional, next_index = A[0] + 1, 1
        while(next_index < len(A) and A[next_index] <= next_optional):
            if(next_optional == A[next_index]):
                next_optional += 1
            next_index += 1

        for i in range(1, len(A)):
            if A[i] != A[i-1]:
                continue
            
            if A[i] >= next_optional:
                next_optional = A[i] + 1
                next_index = i + 1
                while(next_index < len(A) and A[next_index] <= next_optional):
                    if(next_optional == A[next_index]):
                        next_optional += 1
                    next_index += 1
            
            while(next_index < len(A) and next_optional >= A[next_index]):
                if(next_optional == A[next_index]):
                    next_optional += 1
                next_index += 1
        
            res += (next_optional - A[i])
            next_optional += 1

        return res