class Solution(object):
    def numWaterBottles(self, numBottles, numExchange):
        """
        :type numBottles: int
        :type numExchange: int
        :rtype: int
        """
        res = 0
        numVets = 0
        while((numBottles + numVets) >= numExchange):
            res += numBottles
            numVets += numBottles
            numBottles = numVets // numExchange
            numVets = numVets % numExchange

        res += numBottles
        return res


