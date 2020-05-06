class Solution:
    def find(self, a, union_set):
        p = union_set[a]
        if p == a:
            return a
        union_set[a] = self.find(p, union_set)
        return union_set[a]

    def union(self, a, b, union_set):
        x = self.find(a, union_set)
        y = self.find(b, union_set)
        if x == y:
            return
        union_set[x] = y

    def equationsPossible(self, equations):
        format_equation = {"e": [], "ne": []}
        union_set = {}
        for str_equation in equations:
            union_set[str_equation[0]] = str_equation[0]
            union_set[str_equation[-1]] = str_equation[-1]
            if str_equation[1] == '=':
                format_equation["e"].append((str_equation[0], str_equation[-1]))
            else:
                if str_equation[0] == str_equation[-1]:
                    return False
                format_equation["ne"].append((str_equation[0], str_equation[-1]))
        for x, y in format_equation["e"]:
            self.union(x, y, union_set)

        for x, y in format_equation["ne"]:
            if self.find(x, union_set) == self.find(y, union_set):
                return False
        return True