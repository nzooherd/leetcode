class Solution:
    def isNStraightHand(self, hand: List[int], W: int) -> bool:
        if len(hand) % W != 0:
            return False

        order_hand = list(set(hand))        
        order_hand.sort()
        num2count = defaultdict(int)

        for num in hand:
            num2count[num] += 1
        
        start = 0
        while(True):
            next_start = start
            for j in range(0, W):
                if num2count[order_hand[start] + j] <= 0:
                    return False
                num2count[order_hand[start] + j] -= 1
                if num2count[order_hand[start] + j] == 0 and next_start == start + j:
                    next_start = start + j + 1
            
            if next_start == len(order_hand):
                return True
            start = next_start