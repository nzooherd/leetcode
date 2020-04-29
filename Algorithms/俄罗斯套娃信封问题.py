def mycmp(x, y):
    if x[0] < y[0]:
        return -1
    elif x[0] > y[0]:
        return 1
    else:
        if x[1] < y[1]:
            return 1
        if x[1] > y[1]:
            return -1
        return 0

class Solution:
    def binary_serch(self, target, longest_list):
        left, right = 0, len(longest_list)
        while(left < right):
            mid = int((left + right) / 2)
            if longest_list[mid] < target:
                left = mid + 1
            else:
                right = mid
        
        longest_list[left] = target

    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        envelopes = sorted(envelopes, key=functools.cmp_to_key(mycmp))
        height_list = [_[1] for _ in envelopes]
        longest_list = [height_list[0]]
        for i in range(1, len(height_list)):
            if height_list[i] > longest_list[-1]:
                longest_list.append(height_list[i])                
            else:
                self.binary_serch(height_list[i], longest_list)

        return len(longest_list)