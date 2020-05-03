class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        all_citys = set()
        start_citys = set()
        for path in paths:
            all_citys.add(path[1])
            start_citys.add(path[0])

        end_citys = all_citys - start_citys
        return list(end_citys)[0]