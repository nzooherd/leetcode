class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        cost_days = [0] * 366

        index_days = 0
        for i in range(1, 366):
            if index_days >= len(days):
                break
            if i != days[index_days]:
                cost_days[i] = cost_days[i - 1]
                continue
            
            index_days += 1
            cost_7 = (cost_days[i - 7]  if i >= 7 else 0) + costs[1]
            cost_30 = (cost_days[i - 30] if i >= 30 else 0) + costs[2]
            cost_days[i] = min(cost_days[i - 1] + costs[0], min(cost_7, cost_30))
        
        return cost_days[days[-1]]