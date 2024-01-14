# https://leetcode.com/discuss/interview-question/406652/Twitter-or-OA-2019-or-Anagram-Difference
import collections
def anagram(a,b):
    count = 0
    if len(a) != len(b):
        return -1

    dic = collections.Counter(a)

    for i in b:
        if i in dic:
            if dic[i]:
                dic[i] -= 1
            else:
                count += 1
        else:
            count += 1
    return count

a = 'abc'
b = 'def'

print(anagram(a,b))