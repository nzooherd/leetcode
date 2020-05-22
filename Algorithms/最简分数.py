class Solution:
    def simplifiedFractions(self, n: int) -> List[str]:
        if n == 1:
            return []

        prime_nums = set() 
        for i in range(2, n+1):
            j = 2
            while(j * j <= i):
                if i % j == 0:
                    break
                j += 1
            if j * j > i:
                prime_nums.add(i)

        num2prime_factor = {}
        for i in range(2, n+1):
            prime_factor = set()
            for prime_num in prime_nums:
                if i % prime_num == 0:
                    prime_factor.add(prime_num)

            num2prime_factor[i] = prime_factor


        result = []
        for i in range(2, n+1):
            divied_prime_factor = num2prime_factor.get(i)
            for j in range(1, i):
                divie_prime_factor = num2prime_factor.get(j, set())

                if not (divied_prime_factor & divie_prime_factor):
                    result.append(str(j) + "/" + str(i))

        return result