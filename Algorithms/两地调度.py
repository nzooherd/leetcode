class Solution(object):
    def twoCitySchedCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        destination_flag = []
        a_num = 0
        b_num = 0
        sum_cost = 0
        for cost in costs:
            if cost[0] < cost[1]:
                destination_flag.append('A')
                a_num += 1
                sum_cost += cost[0]
            else:
                destination_flag.append('B')
                b_num += 1
                sum_cost += cost[1]

        if a_num == b_num:
            return sum_cost 

        if a_num > b_num:
            city = 'A'
            index = 1
            balance_num = (a_num - b_num) / 2
        else:
            city = 'B'	
            index = 0
            balance_num = (b_num - a_num) / 2

        change_cost = []
        for i in range(len(costs)):
            if destination_flag[i] == city:
                change_cost.append(costs[i])

        change_cost = sorted(change_cost, cmp=lambda x,y:cmp(x[index] - x[1-index], y[index] - y[1 - index]))


        for i in range(balance_num):
            sum_cost -= change_cost[i][1 - index]			        
            sum_cost += change_cost[i][index]			        

        return sum_cost