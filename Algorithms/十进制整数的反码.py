class Solution(object):
    def bitwiseComplement(self, N):
        """
        :type N: int
        :rtype: int
        """
        bins = bin(N)[2:]
        ret_bins = ''
        for i in range(len(bins)):
            ret_bins += str(1 - int(bins[i]))

        return int(ret_bins, 2)