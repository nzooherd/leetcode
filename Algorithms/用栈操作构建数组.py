class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        results = []
        for i in range(0, len(target)):
            if i == 0:
                if target[i] == 1:
                    results.append("Push")
                else:
                    k = target[i]
                    while k > 1:
                        results.append("Push")
                        results.append("Pop")
                        k -= 1
                    results.append("Push")
            else:
                k = target[i]
                while k - target[i-1] > 1:
                    results.append("Push")
                    results.append("Pop")
                    k -= 1
                results.append("Push")
        return results