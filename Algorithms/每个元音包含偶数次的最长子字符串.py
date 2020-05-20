class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        vowel_chars = {'a', 'e', 'i', 'o', 'u'}

        index2vowel_num = {-1:{'a': 0, 'e': 0, 'i': 0, 'o': 0, 'u': 0}}
        vowel_index = [-1]

        for i, c in  enumerate(s):
            cur_num_dict = dict()
            cur_num_dict.update(index2vowel_num[vowel_index[-1]])
            if c not in vowel_chars:
                index2vowel_num[i] = cur_num_dict
                continue
            else:
                cur_num_dict[c] += 1
                index2vowel_num[i] = cur_num_dict
                vowel_index.append(i)

        result = 0
        set_vowel_index = set(vowel_index)
        for i in range(len(s) - 1, -1, -1):
            if i + 1 not in set_vowel_index and i not in set_vowel_index and i != len(s) - 1:
                continue

            if i < result:
                break

            cur_vowel_num = index2vowel_num[i]
            for index in vowel_index:
                if index >= i:
                    break

                index_vowel_num = index2vowel_num[index]
                for vowel_char in vowel_chars:
                    if (cur_vowel_num[vowel_char] - index_vowel_num[vowel_char]) % 2 != 0:
                        break
                else:
                    result = max(result, i - index)
                    break

        return result