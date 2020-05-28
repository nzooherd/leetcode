class Solution:
    def assemble(self, nums):
        firsts = set()
        if len(nums) == 0:
            return [()]
        if len(nums) == 1:
            return [tuple(nums)]
        results = []
        for i in range(1, 1 << len(nums)):
            first = 1
            other_nums = [] 
            for j in range(len(nums)):
                if i & (1 << j) != 0: 
                    first *= nums[j]
                else:
                    other_nums.append(nums[j])
            if first not in firsts:
                firsts.add(first)
                for result in self.assemble(other_nums):
                    result = list(result)
                    result.append(first)
                    result.sort()
                    cur_result = tuple(result)
                    if (cur_result not in results):
                        results.append(cur_result)
        return results

    def getFactors(self, n: int):
        factors = []
        is_prime = [True] * (n + 1)
        prime_nums = []
        result = []
        for i in range(2, int(n ** 0.5) + 1):
            if is_prime[i] == True:
                for j in range(i * i, n + 1, i):
                    is_prime[j] = False
        for i in range(2, n):
            if is_prime[i]:
                prime_nums.append(i)
        for prime_num in prime_nums:
            while(n % prime_num == 0):
                factors.append(prime_num)
                n //= prime_num
        if not factors:
            return []

        return [list(_) for _ in self.assemble(factors)[:-1]]
