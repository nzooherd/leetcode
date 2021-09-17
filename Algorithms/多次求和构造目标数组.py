class Solution:
    def isPossible(self, target) -> bool:
        cur_sum = sum(target)
        target_sum = len(target)

        if(len(target) == 1):
            return target[0] == 1

        max_top_heap = [_ for _ in target]
        for i in range(len(max_top_heap) // 2, -1, -1):
            j = i
            while((j * 2 + 1 < len(max_top_heap) and max_top_heap[j] < max_top_heap[j * 2 + 1]) 
                or (j * 2 + 2 < len(max_top_heap) and max_top_heap[j] < max_top_heap[j * 2 + 2])):

                if(j * 2 + 2 >= len(max_top_heap) or max_top_heap[j * 2 + 1] > max_top_heap[j * 2 + 2]):
                    next_j = j * 2 + 1
                else:
                    next_j = j * 2 + 2

                max_top_heap[j], max_top_heap[next_j] = max_top_heap[next_j], max_top_heap[j]
                j = next_j

        one_count = target.count(1)
        print(max_top_heap)
        while(cur_sum > target_sum):
            if(one_count == len(target) - 1):
                return (max_top_heap[0] - 1) % one_count == 0

            if(max_top_heap[0] <= (cur_sum - max_top_heap[0])):
                return False

            second_max_num = 0
            if(len(target) == 2 or max_top_heap[1] < max_top_heap[2]):
                second_max_num = max_top_heap[1]
            else:
                second_max_num = max_top_heap[2]

            diff = (cur_sum - max_top_heap[0])
            count = (max_top_heap[0] - second_max_num) // diff
            max_top_heap[0] -= diff * count
            cur_sum -= diff * count
            
            if max_top_heap[0] > second_max_num and max_top_heap[0] > diff:
                max_top_heap[0] -= diff
                cur_sum -= diff

            if max_top_heap[0] == 1:
                one_count += 1

            i = 0
            while((i * 2 + 1 < len(max_top_heap) and max_top_heap[i] < max_top_heap[i * 2 + 1]) 
                or (i * 2 + 2 < len(max_top_heap) and max_top_heap[i] < max_top_heap[i * 2 + 2])):

                if(i * 2 + 2 >= len(max_top_heap) or max_top_heap[i * 2 + 1] > max_top_heap[i * 2 + 2]):
                    next_i = i * 2 + 1
                else:
                    next_i = i * 2 + 2

                max_top_heap[i], max_top_heap[next_i] = max_top_heap[next_i], max_top_heap[i]
                i = next_i
            print(max_top_heap)

        return True