from collections import defaultdict
class Solution:
    def generatePalindromes(self, s: str):
        ch2num = defaultdict(int)
        for ch in s:
            ch2num[ch] += 1

        odd_count = sum([1 if value % 2 == 1 else 0 for value in ch2num.values()])
        if odd_count > 1:
            return []
        need_fill = None
        if odd_count == 1:
            for key, value in ch2num.items():
                if value % 2 == 1:
                    need_fill = key

        results = []
        optional_chars = [key * (value // 2) for key, value in ch2num.items()]
        optional_chars.sort()
        last_str = "".join(sorted(optional_chars, reverse=True))
        first_str = "".join(optional_chars)
        results.append(first_str)
        while(results[-1] != last_str):
            cur_str = results[-1]
            index, first_big = len(cur_str) - 1, len(cur_str) - 1
            for index in range(len(cur_str) - 1, 0, -1):
                if cur_str[index-1] < cur_str[index]:
                    break   

            while(cur_str[first_big] <= cur_str[index-1]):
                first_big -= 1

            cur_str = cur_str[0:index-1] + cur_str[first_big] + cur_str[index:first_big] + cur_str[index-1] + cur_str[first_big+1:] 
            cur_str
            next_str = cur_str[0:index] + cur_str[index:][::-1]
            results.append(next_str)

        for i, result in enumerate(results):
            if need_fill:
                result += need_fill + result[::-1]
            else:
                result += result[::-1]
            results[i] = result

        return results