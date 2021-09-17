from collections import defaultdict
import queue

class CompareObject:

    def __init__(self, capital, profit):
        self.capital = capital
        self.profit = profit

    def __lt__(self, other):
        if self.profit < other.profit:
            return False
        return True


class Solution:
    def findMaximizedCapital(self, k: int, W: int, Profits: List[int], Capital: List[int]) -> int:
        if W > max(Capital):
            Profits.sort(reverse=True)
            result = W
            for i in range(0, k):
                result += Profits[i]
            return result 

        capital2profits = defaultdict(list)
        for i in range(0, len(Profits)):
            capital2profits[Capital[i]].append(Profits[i])
        for key in capital2profits.keys():
            capital2profits[key].sort()
        capitals = list(capital2profits.keys())
        capitals.sort()
        cur_w = W
        has_k = 0
        priority_queue = queue.PriorityQueue()
        capital_index = 0

        for i, capital in enumerate(capitals):
            if capital > cur_w:
                capital_index  = i
                break
            profit = capital2profits[capital].pop()
            priority_queue.put(CompareObject(capital, profit))

        while(has_k < k):
            if priority_queue.empty():
                break
            next_item = priority_queue.get()
            capital, profit = next_item.capital, next_item.profit
            has_k += 1
            cur_w += profit
            if capital2profits[capital]:
                next_profile = capital2profits[capital].pop()
                priority_queue.put(CompareObject(capital, next_profile))
            for i in range(capital_index, len(capitals)):
                if capitals[i] > cur_w:
                    capital_index = i
                    break
                if capital2profits[capitals[i]]:
                    profit = capital2profits[capitals[i]].pop()
                    priority_queue.put(CompareObject(capitals[i], profit))

        return cur_w