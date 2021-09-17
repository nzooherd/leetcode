class Solution:
    def expend(self, s, left, right):
        while(left >= 0 and right < len(s)):
            if s[left] != s[right]:
                break
            left -= 1
            right += 1
        return left + 1, right - 1

    def shortestPalindrome(self, s: str) -> str:
        new_s = '#' + '#'.join(list(s)) + '#'
        arm_lens = []
        max_right, max_right_index, max_arm_len = -1, -1, -1
        for i in range(len(new_s)):
            if i >= max_right:
                left, right = self.expend(new_s, i, i)
            else:
                arm_len = min(arm_lens[2 * max_right_index - i], max_right - i)
                left, right = self.expend(new_s, i - arm_len, i + arm_len)
            
            cur_arm_len = (right - left) // 2
            arm_lens.append(cur_arm_len)

            if right > max_right:
                max_right, max_right_index, max_arm_len = right, i, cur_arm_len


        max_len_start_with_head = 0
        end = 0
        for i in range(1, len(new_s)):
            if arm_lens[i] != i:
                continue
            if arm_lens[i] > max_len_start_with_head:
                max_len_start_with_head = arm_lens[i]
                end = arm_lens[i]- 1

        return s[end+1:][::-1] + s

