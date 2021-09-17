class Solution:
    def reachNumber(self, target: int) -> int:
        if target <= 0:
            target = -target
        if target == 0:
            return 0
        
        approximate_result = int((pow(1 + 8 * target, 0.5) - 1) // 2)
        approximate_result += 0 if (approximate_result * (approximate_result + 1) // 2 == target) else 1
        return approximate_result + ((1 if approximate_result % 2 == 0 else 2) if (approximate_result * (approximate_result + 1) / 2 - target) % 2 == 1 else 0)