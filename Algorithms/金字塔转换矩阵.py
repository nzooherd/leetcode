from collections import defaultdict

class Solution:

    def generateNextLayer(self, bottom, allow2letters):
        if len(bottom) == 1:
            return [[]]

        first_letters = allow2letters[(bottom[0], bottom[1])]
        result = []
        next_results = self.generateNextLayer(bottom[1:], allow2letters)
        for first_letter in first_letters:
            for next_result in next_results:
                result.append([first_letter] + next_result)
        return result

    def is_valid(self, bottom, allow2letters):
        if len(bottom) == 1:
            return True

        for next_layer in self.generateNextLayer(bottom, allow2letters):
            if self.is_valid(next_layer, allow2letters):
                return True

        return False

    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        if not bottom:
            return False
        allow2letters = defaultdict(list)
        for allow in allowed:
            allow2letters[(allow[0], allow[1])].append(allow[2])
        return self.is_valid(bottom, allow2letters)