class Solution:
    def minFlips(self, target: str) -> int:
        count = 1
        first_one_index = target.find("1")
        if first_one_index < 0:
            return 0

        for i in range(first_one_index + 1, len(target)):
            if target[i] != target[i-1]:
                count += 1

        return count
