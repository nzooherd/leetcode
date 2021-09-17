class Solution(object):
    def maxNumOfSubstrings(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        res = []
        char2info = {}

        can_start = [False] * len(s)
        can_end = [False] * len(s)

        s_infos = [-1] * len(s)

        for i, char in enumerate(s):
            if char not in char2info:
                char2info[char] = [i, i]
            else:
                char2info[char][-1] = i

        for value in char2info.values():
            start, end = value
            can_start[start] = True


        for i in range(0, len(can_start)):
            if not can_start[i]:
                continue

            cur_start = i
            cur_end = char2info[s[i]][1]
            first_end = cur_end
            j = i + 1
            while( j <= cur_end and cur_end < len(can_start)):
                if(char2info[s[j]][0] < cur_start):
                    break

                next_end = char2info[s[j]][1]
                if next_end > first_end and char2info[s[j]][0] < first_end:
                    can_start[j] = False
                if next_end > cur_end:
                    cur_end = next_end
                j += 1
                if(char2info[s[cur_end]][0] < cur_start):
                    break
            else:
                s_infos[i] = cur_end


        cur_start, cur_end = None, None
        for i, char in enumerate(s):
            if cur_end is not None and i >= cur_end:
                res.append(s[cur_start: cur_end + 1])
                cur_start, cur_end = None, None

            if s_infos[i] == -1:
                continue

            if cur_end is None:
                cur_end = s_infos[i]
                cur_start = i
                continue
            if s_infos[i] < cur_end:
                cur_end = s_infos[i]
                cur_start = i

        if cur_start is not None and cur_end is not None:
            res.append(s[cur_start: cur_end + 1])

        return res