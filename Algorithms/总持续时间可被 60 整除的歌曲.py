class Solution(object):
    def numPairsDivisibleBy60(self, time):
        """
        :type time: List[int]
        :rtype: int
        """
        for i in range(len(time)):
            time[i] = time[i] % 60
        time_map = {time[-1]: 1}
        ret = 0
        for i in range(len(time) - 2, -1, -1):
            margin_time = (60 - time[i]) % 60
            ret += time_map.get(margin_time, 0)
            if time[i] not in time_map:
                time_map[time[i]] = 1
            else:
                time_map[time[i]] += 1
        return ret 