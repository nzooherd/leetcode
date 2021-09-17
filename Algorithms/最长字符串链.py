class Solution:
    def longestStrChain(self, words: List[str]) -> int:
           words.sort(key=lambda x: len(x)) 

           res = [1]
           for i in range(1, len(words)):
               res.append(1)
               for j in range(i-1, -1, -1):
                   if len(words[j]) == len(words[i]):
                       continue
                   if len(words[j]) < (len(words[i]) - 1):
                       break
                   if self.isPre(words[j], words[i]):
                       res[-1] = max(res[-1], 1 + res[j])

           return max(res)

    def isPre(self, str1, str2):	
           if len(str2) != len(str1) + 1:
               return False

           for i in range(0, len(str1)):
               if str1[i] == str2[i]:
                   continue
               else:
                   return str1[i:] == str2[i+1:]

           return True


