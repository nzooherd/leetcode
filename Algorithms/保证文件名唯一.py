class Solution:

    def getFolderNames(self, names: List[str]) -> List[str]:
        str2count = {}
        result = []
        has_name = set()
        for name in names:
            if name not in has_name:
                result.append(name)
                has_name.add(name)
                continue
            index = str2count.get(name, 1)
            while(True):
                next_name = name + "(" + str(index) + ")" 
                if next_name not in has_name:
                    has_name.add(next_name)
                    result.append(next_name)
                    str2count[name] = index + 1
                    break
                index += 1


        return result