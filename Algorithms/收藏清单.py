from collections import defaultdict

class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        company2indexs = defaultdict(set)
        for i, companies in enumerate(favoriteCompanies):
            for companie in companies:
                company2indexs[companie].add(i)
        

        result = []
        for i, companies in enumerate(favoriteCompanies):
            if not companies:
                continue
            init_indexs = {_ for _ in company2indexs[companies[0]]}
            for j in range(1, len(companies)):
                init_indexs &= company2indexs[companies[j]]
                if len(init_indexs) <= 1:
                    break
            if len(init_indexs) <= 1:
                result.append(i)

        return result

