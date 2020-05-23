import bisect

class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        fibonacci_nums = [1, 1]
        while(fibonacci_nums[-1] < k):
            fibonacci_nums.append(fibonacci_nums[-1] + fibonacci_nums[-2])

        result = 0
        while(k > 0):
            index = bisect.bisect(fibonacci_nums, k)
            k -= fibonacci_nums[index-1]
            result += 1

        return result

