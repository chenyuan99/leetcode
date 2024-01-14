from typing import Collection


class Solution:
    """
    @param A: Integer array
    @param k: a integer
    @return: return is possible to partition the array satisfying the above conditions
    """
    def PartitioningArray(self, A, k):
        # write your code here
        if not A and k == 1:
            return True
        n = len(A)
        if k > n or n%k:
            return False
        groupnum = n//k
        cnt = Collection.Counter(A)
        if groupnum < max(cnt.values()):
            return False
        return True
            
            
       